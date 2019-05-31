### 다양한 함수

- 함수에는 크게 나누어 산술 함수, 문자열 함수, 날짜 함수, 변환 함수, 집약 함수가 있다.
- 함수 종류가 많기 때문에 모든 것을 기억할 필요는 없다. 자주 사용하는 대표저인 것만 기억해 두었다가 그 이외의 것은 필요한 시점에 찾아 보도록 한다.

### 산술 함수 (Oracle)

- 절대값 (ABS)

```sql
SELECT ENAME, ABS(SAL) FROM EMP;
```

- 나머지(MOD)

```sql
SELECT ENAME, MOD(SAL,3) FROM EMP;
```

- 반올림(ROUND)

```sql
SELECT ENAME, SAL,ROUND(SAL/7,3) FROM EMP; -- ROUND(SAL/7,3) 에서 ,3 은 몇자리 ?
```

### 문자열 함수



- 연결 (||) 

```sql
SELECT ENAME || ' ' || JOB FROM EMP; -- ' ': 스페이스
```

`` SQL server 나 Mysql 에서는 '+' 로 사용``

- 소문자화 (LOWER) , 대문자는(UPPER)

```sql
SELECT LOWER(ENAME) || ' ' || JOB FROM EMP;
```

- 문자열 길이(LENGTH)

```sql
SELECT LENGTH(ENAME) FROM EMP;
```

- 문자열 잘라내기(SUBSTR)

```sql
SELECT ENAME, SUBSTR(ENAME,1,3) FROM EMP --(해당 COLOUM명,어디에서 부터,어디까지)
```

``SUBSTR(대상문자열,잘라내기 시작 위치 ,잘라낼 문자수 )``

- 문자열 치환(REPLACE)

```sql
SELECT REPLACE(ENAME,SUBSTR(ENAME,1,3), 'AAA') FROM EMP;--'AAA' 무엇으로 바꾸겠는가
-- 즉 ENAME의 1~3까지를 AAA로 바꾸어라
```

 `` REPLACE(대상 문자열, 치환 전 문자열, 치환 후 문자열)``

- 문제 -  첫문자만 대문자로 만들어서 가져와라

```sql

SELECT REPLACE(ENAME,SUBSTR(ENAME,2,LENGTH(ENAME)), LOWER(SUBSTR(ENAME,2,LENGTH(ENAME)))) FROM EMP;
```

- OR의 다른 표현 법★

```sql
SELECT ENAME,SAL FROM EMP
WHERE DEPTNO IN (20,30); -- 20과 30이 있는 (OR)
```

### 날짜 함수



- 날짜 사용

```sql
SELECT ENAME, HIREDATE,CURRENT_DATE FROM EMP;--1

SELECT ENAME, HIREDATE,SYSDATE FROM EMP;--2

SELECT ENAME, HIREDATE,CURRENT_TIMESTAMP FROM EMP; --CURRENT_TIMESTAMP : 시간
```

- 시간과 날짜

  ```sql
  SELECT ENAME, HIREDATE,TO_CHAR(CURRENT_TIMESTAMP,'YYYY:HH:MM:SS') FROM EMP;
  
  SELECT ENAME, HIREDATE,TO_CHAR(CURRENT_TIMESTAMP,'YYYY:MM:DD:HH:MM:SS') FROM EMP;
  ```



- TO_CHAR - 날짜를 원하는 문자로 바꾸고 싶을 때  , TO_DATE 다시 날짜 형태로 바꾸고 싶을 때

  ```sql
  SELECT ENAME, HIREDATE,TO_CHAR(HIREDATE,'YYYY/MM/DD') FROM EMP;
  
  INSERT INTO T_PRODUCT VALUES('id98','pants',10000,TO_DATE('2010/10/11','YY:MM:DD')); -- 문자열을 DATE type 형태로 !
  
  ```



- NULL 값에 값 처리(NVL. NVL2)

```sql
SELECT ENAME,NVL(COMM,'0') FROM EMP; -- 해당COMM의 NULL 값을 0으로 처리

SELECT ENAME,NVL2(COMM,'0','1') FROM EMP; -- NULL이면 0으로 표시 아니면 1로 표시
```





- 두 날짜 사이의 간격

```sql
SELECT ENAME,HIREDATE,SYSDATE - HIREDATE,-- SYSDATE - HIREDATE : 두 현재와 해당 날짜의 '일수' 차이
MONTHS_BETWEEN(SYSDATE,HIREDATE)-- 두 현재와 해당 날짜의 '월' 차이
FROM EMP;
```

### 술어

- LIKE

```sql
SELECT ENAME,SAL FROM EMP
WHERE SAL LIKE '5%';
```

- BETWEEN

```sql
SELECT ENAME,SAL FROM EMP
WHERE SAL BETWEEN 2000 AND 5000 -- 단 BETWEEN은 양쪽 값을 포함한다.(초과, 미만은 안됨)
```

- IN(OR의 다른 표현 법★)

```
SELECT ENAME,SAL FROM EMP
WHERE DEPTNO IN (20,30); -- 20과 30이 있는 (OR)
```



### CASE 식

```sql
SELECT ENAME,
CASE WHEN JOB ='PRESIDEMT'
     THEN '왕'
     WHEN JOB ='MANAGER'
     THEN '관리자'
     ELSE '직원'-- 둘다 아니면
END -- 끝나면 항상 !!!
FROM EMP;

SELECT ENAME,
CASE WHEN SAL >= 5000
     THEN '왕'
     WHEN SAL >= 3000 AND SAL < 5000
     THEN '관리자'
     ELSE '직원'
END
FROM EMP;

SELECT ENAME,SAL,
CASE WHEN SAL >= 5000
     THEN '왕'
     WHEN SAL >= 3000 AND SAL < 5000
     THEN '관리자'
     ELSE '직원'
END AS GRADE -- AS를 써서 이름을 깔끔하게 바꿔준다.
FROM EMP;

```





#### 주의

- ORACLE 에서 한글 하나는 3Byte 차지!!!

  ```sql
  
  INSERT INTO T_USER VALUES('id78','pwd78','가나다라마바'); -- '가' : 3byte
  ```

  

- SUBSTR에서 값이 숫자 이면 문자를 숫자로 가져와서 계산이 가능하고 문자가 들어가면 안된다.

```sql
SELECT ENAME,SUBSTR(SAL,1,2)*10 FROM EMP; - 가능

SELECT ENAME,SUBSTR(ENAME,1,2)*10 FROM EMP; - 불가능 : ENAME에 문자가 들어가서
```

- 객체들 끼리는 가능 연산 가능 하지만 TO_CHAR 끼리는 불가능 

```sql
SELECT ENAME, 
TO_CHAR(CURRENT_TIMESTAMP,'YYYY:MM:DD:HH:MM:SS'),
TO_CHAR(HIREDATE,'YYYY/MM/DD'),SYSDATE,SYSDATE - HIREDATE FROM EMP; -- 가능

TO_CHAR(SYSDATE,'YYY/MM') - TO_CHAR(HIREDATE,'YYYY/MM') -- 불가능




```

