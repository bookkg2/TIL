- SCOTT이 소속된 부서의 직원 정보를 조회 하시오.

```sql
SELECT * FROM EMP e1, DEPT d
WHERE e1.DEPTNO = d.DEPTNO
AND e1.DEPTNO IN(
SELECT DEPTNO FROM EMP
WHERE ENAME = 'SCOTT')
```

- DALLAS 에 있는 직원의 정보를 조회 하시오

```sql
SELECT * FROM EMP e1, DEPT d
WHERE e1.DEPTNO = d.DEPTNO
AND e1.DEPTNO IN(
SELECT DEPTNO FROM DEPT
WHERE LOC = 'DALLAS'
)
```



- EXISTS 술어 
  - 어떤 조건에 일치하는 레코드가 존재하는지 여부 , 레코드가 존재하면 TRUE를 그렇지 않으면 FALSE를 반환한다.
  - DALLAS 에 있는 직원의 정보를 조회 하시오

```sql
SELECT * FROM EMP e1, DEPT d
WHERE e1.DEPTNO = d.DEPTNO
AND EXISTS(
SELECT d2.DEPTNO FROM DEPT d2, EMP e2
WHERE d2.DEPTNO = e2.DEPTNO
AND LOC ='DALLAS'
AND e1.DEPTNO = e2.DEPTNO
)
```



- JONES 가 속한 JOB의 직원을 조회하시오

```sql
SELECT ENAME, JOB FROM EMP e1 
WHERE EXISTS(-- TRUE ?
SELECT JOB  FROM EMP e2
WHERE ENAME = 'JONES' 
AND e1.JOB = e2.JOB
)

--단 직원의 부서명과 지역을 출력하시오.
SELECT d1.DNAME, d1.LOC FROM EMP e1, DEPT d1
WHERE e1.DEPTNO = d1.DEPTNO
AND EXISTS(
SELECT JOB  FROM EMP e2
WHERE ENAME = 'JONES' 
AND e1.JOB = e2.JOB
)

```



### 집합 연산 (Oreacle) - 레코드 집합 OR 뷰나 쿼리의 실행 결과

주의 사항 1 - 연산 대상이 되는 레코드의 열 수가 같을 것

주의 사항 2 -덧셈 대상이 되는 레코드의 열이 같은 데이터형일 것

주의 사항 3 - SELECT 문은 어떤 것이든 지정할 수 있다. 단 ORDER BY 구는 마지막에 하나만 가능

- 테이블 덧셈 - UNION(중복을 제거) - 합집합

- MANAGER와 SALES 직원들의 이름과 JOB을 조회 하시오

```sql
SELECT ENAME, JOB FROM EMP
WHERE JOB = 'MANAGER'
UNION
SELECT ENAME, JOB FROM EMP
WHERE JOB = 'SALESMAN'
ORDER BY JOB -- 전체를 ORDER BY
```

- INTERSECT - 중복 즉 교집합 출력
- 레코드 뺄셈 - EXCEPT

 ### 결합(Oracle)

- 다른 테이블의 열을 가지고 와서 열을 늘리는 집합 연산이다.
- UNION이 테이블 간 행 지향(가로 지향)으로 연결하는 것에 반해 , 결합은 열 지향(세로 지향)으로 연결한다.
- 기본 결합에는 내부결합과 외부결합

- 결합 연산의 옛날 구문이나 개별 구문은 사용하지 말고 반드기 표준 SQL 구문을 사용할 것 . 단 옛날 구문이나 개별 구문을 보고서 이해 할 수는 있어야 한다.

##### 내부 결합 - INNER JOIN

```sql
SELECT e.ENAME,d.LOC FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO -- 그전에(Oracle만 가능)

SELECT e.ENAME,d.LOC FROM EMP e INNER JOIN DEPT d
ON e.DEPTNO = d.DEPTNO -- INNER ON으로(ANSI 표준)

SELECT e.ENAME,d.LOC FROM
EMP e INNER JOIN DEPT d
USING (DEPTNO) --ANSI 표준의 다른 방법


--*둘다 알아 놓을 것 !!!*

SELECT e.ENAME,d.LOC FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO
AND e.JOB = 'MANAGER' 
AND d.LOC = 'CHICAGO'-- 조건을 넣는 부분

SELECT e.ENAME,d.LOC FROM EMP e INNER JOIN DEPT d
ON e.DEPTNO = d.DEPTNO
WHERE e.JOB = 'MANAGER' 
AND d.LOC = 'CHICAGO'-- ANSI 표준

--*둘다 알아 놓을 것 !!!*
```

VIEW 생성

```sql
CREATE VIEW T_EMP(ENO,ENM,SAL,DNO)
AS (
  SELECT EMPNO,ENAME,SAL,DEPTNO FROM EMP
)

CREATE VIEW T_DEPT(DNO,DNM,LOC)
AS (
SELECT DEPTNO,DNAME, LOC FROM DEPT
)


CREATE VIEW T_SAL(ENO,ASAL)
AS (
SELECT EMPNO,(SAL * 12) + (NVL(COMM,0) * 12) FROM EMP
)
```

- 직원 정보를 조회 하시오. (ENO,ENM,SAL,ASAL,DNM,LOC)

  ```sql
  SELECT e.ENO, e.ENM, e.SAL,s.ASAL,d.DNM,d.LOC FROM T_EMP e, T_DEPT d, T_SAL s
  WHERE e.DNO = d.DNO
  AND e.ENO = s.ENO -- 이것을 
  
  SELECT e.ENO, e.ENM, e.SAL,s.ASAL,d.DNM,d.LOC FROM T_EMP e INNER JOIN T_DEPT d 
  ON e.DNO = d.DNO
  INNER JOIN T_SAL s
  ON e.ENO = s.ENO -- ANSI 표준
  
  --*둘다 알아 놓을 것 !!!*
  ```



- JONES 속한 부서원만 조회 하시오. (즉 DNM이 RESEARCH인 원들)

```sql
SELECT e.ENO, e.ENM, e.SAL,s.ASAL,d.DNM,d.LOC FROM T_EMP e, T_DEPT d, T_SAL s
WHERE e.DNO = d.DNO
AND e.ENO = s.ENO
AND e.DNO IN (
SELECT DNO FROM T_EMP WHERE ENM = 'JONES'
)
```

- 부서 별 연봉의 평균 보다 많이 받는 직원을 조회

```sql
SELECT e.ENO, e.ENM, e.SAL,s.ASAL,d.DNM,d.LOC FROM T_EMP e, T_DEPT d, T_SAL s
WHERE e.DNO = d.DNO
AND e.ENO = s.ENO
AND s.ASAL >= (
SELECT AVG(s1.ASAL)
FROM T_EMP e1, T_SAL s1
WHERE e1.ENO = s1.ENO
AND e.DNO = e1.DNO--위에 사람이 속한 부서의 평균을 나타내기 위하여
GROUP BY (e1.DNO)
)
```

- 직원의 정보를 출력하시오 EMPNO, ENAME,MNAME 을 출력하시오-SELF JOIN(같은 테이블 끼리)

```sql

SELECT e1.EMPNO AS EMPNO,e1.ENAME AS ENAME,e2.ENAME AS MNAME FROM EMP e1,EMP e2
WHERE e1.MGR = e2.EMPNO
```

##### 외부 결합 - OUTER JOIN- 반대쪽에 없는 것들이 나온다.

```sql
SELECT e.ENAME,e.JOB,d.DNAME,d.LOC FROM EMP e, DEPT d
WHERE e.DEPTNO(+) = d.DEPTNO

SELECT e.ENAME,e.JOB,d.DNAME,d.LOC FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO(+)

SELECT e.ENAME,e.JOB,d.DNAME,d.LOC FROM EMP e LEFT OUTER JOIN DEPT d USING(DEPTNO) -- ANSI 표준

SELECT e.ENAME,e.JOB,d.DNAME,d.LOC FROM EMP e RIGHT OUTER JOIN DEPT d USING(DEPTNO)--ANSI 표준

SELECT e.ENAME,e.JOB,d.DNAME,d.LOC FROM EMP e FULL OUTER JOIN DEPT d USING(DEPTNO) -- 둘다 없는 것들이 나타나게 하고 싶을 때
```







