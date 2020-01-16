## HADOOP (Linux 공간) - project

##### - Hive로 어플리케이션과 Hadoop 연동하기 

- Hive 란 ? 하둡에 저장된 데이터를 쉽게 처리할 수 있는 데이터웨어하우스 패키지이며, 페이스북은 2009년에 자사의 데이터웨어하우스에 하이브를 이요하고 있다고 발표하였다. 오픈소스로 동개돼 있으면, 현재는 아파치의 정식 프로젝트로 등록되어있다.

  - 하이브의 클라이언트는 커맨드 라인 인터페이스(CLI), 하이브 서버, 웹 인터페이스로 구성된다. 

  - 하이브 서버의 경우 JDBC, ODBC, 쓰리프트로 개발된 클라이언트가 하이브 서비스를 이용할 수 있게 쓰리프트 서비스를 제공한다. 

  - 하이브는 메타스토어라는 저장소를 만들어 하둡에서 처리된 메타데이터의 구조를 메타스토어에 저장한다. 

    > 메타데이터 : 어떠한 목적을 가지고 만들어진 데이터, 즉 데이터에 관한 구조화된 데이터로, 다른 데이터를 설명해 주는 데이터이다. 예를 들어 디지털 카메라로 사진을 찍으면 나오는 당시의 시간, 노출 등

![hive structure](https://user-images.githubusercontent.com/50862260/62857956-f309d380-bd33-11e9-8a3c-599564cfea2f.PNG)

- 실행 순서 )

  - 1. 테이블 생성 

       - 하둡은 HDFS에 저장된 파일에 직접 접근해서 처리하지만 하이브는 메타스토어에 저장된 테이블을 분석한다. 데이터를 조회하기 전에 먼저 테이블을 생성해야 합니다.

         ```bash
         CREATE TABLE PRODUCT_VISIT(year INT,month INT,day INT,hh INT,mm INT,ss INT,customerid STRING,productno STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' STORED AS TEXTFILE;
         ```

         > ROW FORMAT 절은 해당 테이블 내의 데이터가 어떠한 형식으로 저장되는지 설정한다. 즉 필드를 콤마 기준으로 구분한다. (ex ) LINES TERMINATED BY '\n' : 행과 행은 \n 값으로 구분한다.
         >
         > SROERD AS 절은 데이터 저장 파일 폼을 의미합니다. 하이브는 텍스트 파일을 위한 TEXTFILE과 시퀀스 파일을 저장하기 위한 SEQUENCEFILE을 지원합니다.
         >
         > :alarm_clock:그 외 PARTITIONED BY (delayYear INT) 절은 테이블의 파티션을 설정하는 부분입니다. 하이브는 쿼리문의 수행 속도를 향상 시키기 위해 파티션을 설정할 수 있다. 파티션을 설정하면 해당 테이블의 파티션별로 디렉터리를 생성해서 저장하게 됩니다. (ex) select 할 때 where 절을 이용 , WHERE delayYear = 2008; 

         

  - 2. hive --service hiveserver2 를 통해 application에서 hive로 통하는 것을 설정한다.

       ```bash
        [root@orangehive --service hiveserver2
       ```

       > hiveserver2 : 클라이언트가 Hive에 대해 쿼리를 실행할 수 있게 해주는 서비스

​        

​          ○    3. war 파일을 webapps에 넣는다. 그런다음 tomcat을 실행하면 war파일이 풀린다.

​          ○    4. 해당 log 파일을 담을 디렉터리를 생성한다. 

​          ○    5. LOAD 를 사용하여 DATA를 로그 파일을 로딩한다. 

          
LOAD DATA LOCAL INPATH '/root/glogs/product.log' OVERWRITE INTO TABLE PRODUCT_VISIT;
                 

> '/root/glogs/product.log'  : 로그가 저장된 텍스트 파일 경로
>
> OVERWRITE INTO 절은 중복된 데이터가 있어도 무시하고 입력한다는 의미입니다.