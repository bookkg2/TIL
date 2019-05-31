### SELECT 문의 기본

- 테이블에서 데이터를 선택하기 위해 사용 ('질의' , '쿼리')
- 열에는 표시용 별명을 붙일 수 있다.
- SELECT 구에는 상수나 식을 쓸 수 있다.
- DISTINCT 키워드를 지정하면 중복된 행을 제거할  수 있다.
- SQL 문 안에 메모를 남기기 위해서 '주석'을 작성할 수 있다.
- WHERE 구를 사용해서 검색 조건을 부합하는 행을 테이블에서 선택할 수 있다.

`테이블을 RELATION 하는 이유는 유지보수 면에서 편리하다.`



### SELECT문 사용(Oracle)

- 모든데이터 가져오기 

  

  ```sql
  SELECT * FROM EMP;
  ```

- 특정한 `colume` 부분 가져오기

  ```sql
  SELECT ENAME,SAL FROM EMP;
  
  ```

  

- 출력 `colume` 명칭 바꿔서 가지고 오기(AS)- `해당 명만 바꿀 수 있음 즉 WHERE에서 바뀐 명으로 조건으로 가져 올 수 없다 . `

```sql
SELECT ENAME,SAL,DEPTNO AS DNO FROM EMP;--DEPTNO가 DNO로 바뀐다.

SELECT ENAME,SAL,SAL *12 AS ASAL, DEPTNO AS DNO FROM EMP; -- 값을 받아올 때 그명을 바꾸고 싶을 때

SELECT ENAME,SAL,SAL *12 "ANN ASAL", DEPTNO AS DNO FROM EMP;-- 명칭을 띄고 사용하고 싶을 때
```

- 두개 문장을 하나로(||)

  ```sql
  SELECT ENAME || JOB AS ENAMEANDJOB FROM EMP;--ENAME과 JOB이 붙어서 나옴
  SELECT DISTINCT(JOB), ENAME FROM EMP;
  ```

  

- 문자 사이를 띄우고 싶을 때

```sql
SELECT ENAME || ' ' || JOB AS ENAMEANDJOB FROM EMP;-- ' '
```

- 중복제거 (DISTINCT)

```sql
SELECT DISTINCT(JOB) FROM EMP;

SELECT DISTINCT(JOB), ENAME FROM EMP;--이럴경우 ENAME도 출력해야하니 중복이 의미가 없어진다.
```

- WHERE

```sql
SELECT * FROM EMP WHERE JOB = 'MANAGER';--문자는 ' ' 로 사용 , MANAGER인 사람만 출력
```

``(TIP)TYPE이 NUMBER 는 데이터 출력 할 때 ' '로 해서 문자도 가능 하고 숫자로도 가능``

- AND

```sql
SELECT * FROM EMP WHERE JOB = 'MANAGER'
AND SAL > 2500; -- MANAGER 이면서 SAL이 2500 보다 큰 사람


SELECT * FROM EMP WHERE JOB = 'MANAGER'
AND SAL > 2500
AND HIREDATE > '04/15/1981';--날짜 값도 가능 
```

- 특정 문자를 가진것을 출력 (LIKE)

```sql
SELECT * FROM EMP WHERE JOB = 'MANAGER'
AND ENAME LIKE '%A%';

SELECT * FROM EMP WHERE JOB = 'MANAGER'
AND ENAME LIKE 'C%'; -- C로 시작하는 문자 가져오기

```

- 주석 처리 

```sql

SELECT * FROM EMP 
-- where statement. --한줄 주석
/*
MULTI COMMENT ... -- 여러 문장 주석
*/
WHERE JOB = 'MANAGER'
AND ENAME LIKE '%A%';
```

- 세금 계산

```sql
SELECT ENAME,SAL,
-- 연봉을 계산 하시오 단, SAL의 세금은 13%, COMM에 세금은 12%

((SAL * 12) * 0.87) + ((NVL(COMM,0) * 12) * 0.88) AS ANSALE 
-- NVL : NULL값을 0으로 수령 

 FROM EMP;
 
 SELECT ENAME,SAL,
-- 연봉을 계산 하시오 단, SAL의 세금은 13%, COMM에 세금은 12%

((SAL * 12) * 0.87) + ((NVL(COMM,0) * 12) * 0.88) AS ANSALE 
-- NVL : NULL값을 0으로 수령 

 FROM EMP;
 WHERE ANSALE > 30000 -- (불가) AS는 해당 명만 바꿔줄 뿐, 즉 계산에서는 사용 불가
 WHERE ((SAL * 12) * 0.87) + ((NVL(COMM,0) * 12) * 0.88) > 30000 -- 이렇게 해야함
```

- 비교 연산자 NOT (Oracle 에서 != , 다른 곳은 <>)

```sql

SELECT ENAME,SAL,
-- 연봉을 계산 하시오 단, sal의 세금은 13%, COMM에 세금은 12%

((SAL * 12) * 0.87) + ((NVL(COMM,0) * 12) * 0.88) AS ANSALE 

	
FROM EMP
WHERE ((SAL * 12) * 0.87) + ((NVL(COMM,0) * 12) * 0.88) != 52200;-- 다른 곳은 <>
```

- NULL , NOT NULL 값을 찾고 싶을 때(IS)

```sql
SELECT * FROM EMP WHERE COMM IS NULL;
```

- 비교 연산자 WHERE NOT 

```sql
SELECT * FROM EMP WHERE NOT (SAL >= 2000);
```

- 논리 연산자 

```sql
SELECT * FROM EMP WHERE NOT (SAL >= 2000) AND DEPTNO = 30; -- 둘다 TRUE(~이고), 교집합

SELECT * FROM EMP WHERE NOT (SAL >= 2000) OR DEPTNO = 30; -- 둘장 한곳만 TRUE여도 됨(~이거나), 합집합

SELECT * FROM EMP WHERE NOT (SAL >= 2000) AND DEPTNO = 30 OR ENAME LIKE '%A%'; -- AND 조건을 먼저 하고 OR를 더한다.
```

- ( ) 차이

```sql
SELECT * FROM EMP WHERE JOB = 'CLERK' AND (DEPTNO = 10 OR DEPTNO = 20);--CLERK 이면서 DEPTNO 10,20인 사람이 나옴

SELECT * FROM EMP WHERE JOB = 'CLERK' AND DEPTNO = 10 OR DEPTNO = 20; -- 앞에 엔드가 실행 되고 OR이 실행되서 DEPTNO가 20인 모든 JOB이 다 더해진다.


SELECT * FROM EMP WHERE JOB = 'CLERK' AND NOT (DEPTNO = 10 OR DEPTNO = 20); -- JOB이 CLERK에서 DEPTNO 10과 20이 아닌 사람이 출력됨
```

`` 즉, 괄호 전체가 ANE 앞 조건이랑 비교가 됨 , AND는 OR보다 강하며 OR 우선순위를 높이려면 괄       호를 사용한다``

- 정렬(ORDER BY)

```sql
SELECT ENAME,SAL FROM EMP
ORDER BY SAL ASC; -- 아무것도 안쓰면 ASC 즉, 값이 작은것부터 나열
SELECT ENAME,SAL FROM EMP
ORDER BY 2 ASC; -- 가능 두번째 기준으로 즉 SAL
SELECT ENAME,SAL FROM EMP
ORDER BY 1 ASC; --첫번째 기준으로 즉 ENAME을 기준으로

SELECT ENAME,SAL FROM EMP
ORDER BY SAL DESC; -- 값이 큰 것 부터 나열 



SELECT ENAME,SAL FROM EMP
WHERE SAL > 1000 AND DEPTNO = 20
ORDER BY 2 DESC; --ORDER BY 는 조건이 끝나고 항상 마지막에 

SELECT ENAME,SAL,SAL*12 AS ASAL FROM EMP
WHERE SAL > 1000
AND DEPTNO = 20
ORDER BY ASAL; -- AS 는 지칭은 가능 

SELECT * FROM EMP
WHERE MGR IS NOT NULL
ORDER BY MGR,ENAME; -- 2개 이상도 정렬 가능 , MGR로 하고 그 다음 ENAME으로 정렬

SELECT * FROM EMP
WHERE COMM IS NOT NULL -- 널 값을 제외가고 정렬
ORDER BY COMM DESC ; 
```

