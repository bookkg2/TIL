### SQL

- data를 조작하고 어떻게 연동하는가 ..? 에 대해 공부
- WebApp에서 작성하여 RDMS에 전달 !
- DDL(데이터 정의), DML(데이터 조작), DCL(데이터 제어)로 나뉜다.

### 데이터베이스란 ?

- 대량의 정보를 컴퓨터가 효율적으로 접근할 수 있도록 가공 및 저장한 것을 말한다.

- 데이터베이스를 관리하기 위한 컴퓨터 시스템을 "데이터베이스 관리 시스템(DBMS)" 이라고 한다.

### DBMS 가 필요한 이유?

- 다수의 사람이 데이터 공유
- 대량의 데이터를 다루기 위해
- 읽기/쓰기를 자동화하기 위해
- 만일에 사고에 대응하기 위해 
- 즉, 텍시트 파일이나 엑셀같은 표 계산 소프트웨어의 단점을 극복 !!



### RDBMS(관계형 데이터 베이스 관리 시스템)

- 점점 사회가 복잡해 지면서 단순하게 저장되는 평면이 아닌 여러 데이터 들이 KEY값을 통해 서로 연결 되어있다. 이를 해결하기 위해 등장 (Ex Oracle ,SQL Server, MySQL 등) 

- DBMS의 심플한 방식에서 시작으로 발전되어왔다. 즉 관계없이 평면적인 데이터베이스 저장으로 시작하였다. 

- RDBMS가 등장하면서 ERP시스템이 가능해졌다. 
- 웹을 통해서 브라우저를 통하여 업무를 볼 수 있게되었다. -> 앱으로 발전하였다. 

- 기존의 계층형 데이터베이스에서 발전된 시스템

### 키- 밸류형 데이터 스토어

- 검색에 사용하는 키(key)와 값(value)을 조합해서 단순한 형태로 데이터를 저장하는 데이터베이스이다. 프로그래밍 언어에서 '연상 배열' , '해시' 와 비슷한 구조라고 생각하면 이해가 쉽다.
- 구글 등 대량의 데이터를 초고속으로 검색해야 하는 웹 서비스 등에서 사용되면서 주목을 받고 있다.

### SQL 종류 

- DDL
  - CREATE : 데이터베이스나 테이블 등을 작성한다.
  - DROP : 데이터베이스나 테이블 등을 삭제한다.
  - ALTER : 데이터베이스나 테이블 등의 구성을 변경한다.

- DML
  - SELECT : 테이블에서 행을 검색한다.
  - INSERT : 테이블에서 신규 행을 등록한다.
  - DELETE : 테이블에서 행을 삭제한다.

- DCL
  - COMMIT : 데이버베이스 변경 내용을 확정한다.
  - ROLLBACK : 데이버베이스 변경 내용을 취소한다.
  - GRANT : 사용자에게 처리 권한을 부여한다.
  - REVOKE : 사용자 처리 권한을 제거한다.

### SQL의 기본적인 작성 규칙

- 마지막에 세미콜론(;)을 붙인다. ( Script에 속한 -> 즉 한줄씩 읽어서 실행 된다.)
- 대문자, 소문자 구분이 없다. 
  - 테이블명은 첫 문자만 대문자

- 문자열은 반드시 작은따옴표(')로  사용
- 단어는 공백 문자나 줄바꿈 문자로 구분한다.

### DDL 사용(Oracle  기준)

1) CREATE-``T_USER 테이블``

```sql
CREATE TABLE T_USER(//테이블 생성 이고 이름은 "T_USER"
 ID VARCHAR2(10), //문자열 Type의 ID를 10자리 사이즈로
 PWD VARCHAR2(10),
 NAME VARCHAR2(20)
);
```

- `데이터베이스나 테이블, 열 등의 이름에 사용할 문자는 영문자, 숫자, 언더바(_)만 가능하다.`
- `이름의 첫 글자는 반드시 영문이어야 한다.`
- `이름은 중복해서 사용해서는 안 된다.`



2) DESC(테이블 확인)-``T_USER 테이블``

```sql
DESC T_USER;
```



3)  DROP (테이블 삭제 (주의) 데이터도 다 날라감!!!)-``T_USER``

```sql

DROP TABLE T_USER;
```

4) ALTER (제약조건 변경 , 컬럼 추가)-``T_PRODUCT 테이블``

```sql
ALTER TABLE T_PRODUCT ADD (REGDATE DATE);//컬럼추가 , DATE - Type,REGDATE-변수이름
ALTER TABLE T_PRODUCT DROP (REGDATE);//컬럼삭제
ALTER TABLE T_PRODUCT ADD PRIMARY KEY(ID);//ID에 PRIMARY KEY 설정
ALTER TABLE T_PRODUCT MODIFY(NAME CHAR(10)); // Type을 변경
ALTER TABLE T_PRODUCT MODIFY(NAME NOT NULL);//NOT NULL로 설정 
ALTER TABLE T_PRODUCT RENAME COLUMN NAME TO UNAME; // 변수 이름 변경
ALTER TABLE T_PRODUCT RENAME TO PRODUCT;// 테이블 이름 변경
ALTER TABLE T_PRODUCT MODIFY (NAME UNIQUE);// 그 값을 중복이 안되도록 !!
ALTER TABLE T_PRODUCT MODIFY (PRICE DEFAULT 1000);//디폴트 값 주기
```



### DML

1) INSERT(테이블에 값을 넣는다.)-``T_USER``

```sql

INSERT INTO T_USER VALUES('id02','pwd01','이말숙');// 값넣기 (1)
INSERT INTO T_USER(ID,PWD,NAME) VALUES('P03','pants3','이말숙');//값넣기 (2)
INSERT INTO T_USER VALUES('id06','pwd06',''); //NULL 값을 넣고 싶을 때(1)
INSERT INTO T_USER VALUES('id06','pwd06',NULL); //NULL 값을 넣고 싶을 때(2)


```

```sql
INSERT INTO T_PRODUCT VALUES('P07','pants7',100.36,SYSDATE);//(type을 소수점으로 했을때) 소수점 자리 나타내고 싶을때
```

```sql
INSERT INTO T_PRODUCT (ID,NAME,REGDATE) VALUES('P01','pants3', SYSDATE);//날짜(data type) 했을 때 넣을 때 SYSDATE 사용
```



2) SELECT(테이블 데이터 정보 불러오기)-``T_USER``

```sql
SELECT * FROM T_USER;
```

3) DELETE(테이블 데이터 삭제)-``T_USER``

```sql
DELETE FROM T_USER; // 테이블을 삭제
DELETE FROM T_USER WHERE ID='id05';//where는 무엇을 삭제하는 지 
TRUNCATE <테이블명 > //테이블의 모든 데이터를 삭제
```

4) UPDATE(데이터 수정)

```sql
UPDATE T_USER SET PWD='111',NAME='공말숙'//공말숙인 사람 모두 PWD를 111로 변경
UPDATE T_USER SET PWD='111',NAME='공말숙' WHERE ID ='id03'//공말숙 중 id03 인 부분만 PWD를 111로 변경
```



### DCL

1) ROLLBACK (데이터베이스 변경 내용을 취소한다.)

```sql
ROLLBACK;
```

2) COMMIT (데이터베이스 변경 내용을 확정한다.)

```sql
COMMIT; // 변경 불가 
```

