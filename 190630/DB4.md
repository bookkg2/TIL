### 집약 함수

- 집합함수의 결과는 하나다.

- COUNT

  - ```SQL
    SELECT COUNT(*) FROM EMP;			-- 카운트 (NULL 값을 포함함)
    SELECT COUNT(ENAME) AS CNT FROM EMP;
    SELECT COUNT(COMM) AS CNT FROM EMP;  --NULL을 제외하고 계산 하게됨.
    SELECT COUNT(NVL(COMM,0)) AS CNT FROM EMP; -- NULL값을 포함하고자 한다면 NVL이용
    ```

    

- SUM

  - ```SQL
    SELECT SUM(SAL) AS CNT FROM EMP;
    SELECT SUM(SAL), SUM(DISTINCT SAL) FROM EMP; -- DISTINCT 는 중복 배제.
    ```

  - 

- AVG

  - ```SQL
    SELECT ROUND(AVG(NVL(COMM,0)),2) AS CNT FROM EMP;
    ```

  - 

- MAX

  - MAX/MIN 은  날짜에 사용 가능하다.

- MIN

  - ```SQL
    SELECT MIN(HIREDATE) FROM EMP; 	-- 날짜의 비교는 가능.
    SELECT SUM(HIREDATE) FROM EMP;  -- 날짜의 계산은 불가능
    ```

  - 

```SQL
SELECT MIN(SAL), MAX(SAL), SUM(SAL), ROUND(AVG(SAL),2) FROM EMP;  
SELECT ENAME, SUM(SAL) AS CNT FROM EMP;  -- 이건 안됨!! 
```

- GROUP BY

  - 그룹함수는, 집합함수랑 같이 사용한다.

  - GROUPING 이 먼저되고 그 그룹내에서 집합함수 사용( SUM, AVG, MIN,MAX)하여 하나의 값을 도출

  - 무엇을 기준으로  GROUPING을 할지가 중요할 듯.

  - ```SQL
    SELECT JOB FROM EMP GROUP BY JOB;			--가능
    SELECT JOB ,SAL FROM EMP GROUP BY JOB;		--불가능
    SELECT JOB, SUM(SAL) FROM EMP GROUP BY JOB;	--가능.
    
    SELECT DEPTNO, JOB, FROM EMP GROUP BY DEPTNO,JOB ORDER BY DEPTNO; --GROUPING을 여러번 할 수 있다.
    
    SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO,JOB HAVING DEPTNO IN(10,20) AND JOB LIKE '%E%' ORDER BY DEPTNO;  -- WHERE 대신 HAVING 을 쓰고,, AND도 가능.
    SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO,JOB HAVING DEPTNO IN(10,20) AND JOB IN ('MANAGER', 'CLERK') ORDER BY DEPTNO;  -- 라던지.
    ```

- HAVING

```SQL
 SELECT JOB, AVG(SAL) FROM EMP WHERE DEPTNO IN (10,30) GROUP BY JOB ;  --가능
 SELECT JOB, AVG(SAL) FROM EMP GROUP BY JOB HAVING DEPTNO IN (10,30);	--불가능
SELECT JOB, AVG(SAL) FROM EMP GROUP BY JOB HAVING JOB IN ('MANAGER', 'CLERK'); --가능
```

- 결론 : HAVING절에는 GROUPING 된것만 들어갈 수 있다.

  - WHERE 절에는 그룹함수가 못들어간다.

  - JOB 별 중에서 E 가 들어간 JOB만 조회 하시오.

  - ```SQL
    SELECT JOB, AVG(SAL) FROM EMP GROUP BY JOB HAVING JOB LIKE '%E%';
    ```

  - JOB별 월금의 평균을 구하시오. 단, DEPTNO가 10,20인 직우너들을 대상으로 하시오

  - ```SQL 
    SELECT JOB, AVG(SAL) FROM EMP  WHERE DEPTNO IN (10,20) GROUP BY JOB 
    ```

- EXAMPLES

  - ```SQL 
    -- 년도별 입사자의 평균을 구하시오
    SELECT TO_CHAR(HIREDATE,'YYYY') AS YEAR, AVG(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE,'YYYY')
    
    --년도별 입사 매니저의 평균을 구하시오
    SELECT TO_CHAR(HIREDATE,'YYYY') AS YEAR, ROUND(AVG(SAL),2) FROM EMP WHERE JOB IN('MANAGER') GROUP BY TO_CHAR(HIREDATE,'YYYY')
    ```

    