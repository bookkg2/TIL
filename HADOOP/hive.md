## 하이브



### HDFS

#### HDFS 명령어 (난중에 정리 p 80쪽)

Hadoop fs -cmd [args] 치면 다나옴 쳐서 보셈.

HDFS에 폴더 생성 및 조회

```bash
hadoop fs -mkdir mydir 폴더 생성
hadoop fs -ls  현재 디렉토리 파일 리스트
hadoop fs -ls <PATH> PATH에 있는 파일 리스트 
hadoop fs -lsr 현재 디렉토리의 하위 디렉토리까지 풀어서 보여줌
```

파일 용량 확인

```bash
hadoop fs -du <path>  지정한 디렉터리나 파일의 사용량을 확인 (바이트단위)
hadoop fs -dus <path> -du는 파일별 용량 -dus는 디렉터리 용량합계
```

파일 내용보기

```bash
hadoop fs -cat <파일> 파일의 내용출력
hadoop fs -text <파일> -cat은 텍스트 파일만 가능하지만 -text는 zip파일도 가능
```

파일 복사 

```bash
hadoop fs -put / -get / -getmerge / -cp / -copyFromLocal / -copyToLocal
-put : 지정한 로컬 파일 시스템의 파일 및 디렉터리를 목적지 경로로 복사
-copyFromLocal : -put이랑 동일한 기능
-get : HDFS에 저장된 파일을 로컬 파일시스템으로 복사
-getmerge : 지정한 경로에 있는 모든 파일의 내용을 합친 후 로컬 파일 시스템에 하나의 파일로 복사
```



파일삭제

```bash
hadoop fs -rmr /mydir
```



휴지통 비우기 

```bash
hadoop fs -expunge 
```





#### 맵 리듀스 (Map Reduce)

Map + Reduce

구성 : 클라이언트 + 잡트래커 + 태스크트래커 





### 하이브

#### 사전준비 (Mysql)

1. Mysql 설치 및 root 아디 만들기 (LINUX 참고)

2. root로 로그인해서 기본환경 세팅

   ```bash
   mysqladmin -u root password '111111'
   mysql -u root -p mysql
   
   grant all privileges on *.* to 'hive'@'localhost' identified by '111111';
   flush privileges;
   
   create database hive_db;
   grant all privileges on hive_db.* to 'hive'@'%' identified by '111111' with grant option;
   grant all privileges on hive_db.* to 'hive'@'localhost' identified by '111111' with grant option;
   grant all privileges on hive_db.* to 'hive'@'%' identified by '111111' with grant option;
   flush privileges;
   commit;
   ```

   

3. 하둡 1이면 버전 1.0.1  / 하둡 2면 최신 ( 2.0.0 )

#### 설치

```bash
wget http://archive.apache.org/dist/hive/apache-hive-1.0.1-bin.tar
```

이거 안되면 웹에서 다운로드 후 가져오기

- 압축 풀고 이름 hive로 바꿔서 /etc 밑에 넣기 

- /etc/profile에 경로 설정

  - ```bash
    export HIVE_HOME=/usr/local/hive
    export HADOOP_HOME=/usr/local/hadoop
    PATH=$PATH:$HOME/bin:$HADOOP_HOME/bin:$HIVE_HOME/bin:
    ```

    

- /etc/hive/conf 에 hive-site.xml 만들기

  ```bash
  <?xml version="1.0"?>
  <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
  <configuration>
      <property>
          <name>hive.metastore.local</name>
          <value>true</value>
          <description>controls whether to connect to remove metastore server or open a new metastore server in Hive Client JVM</description>
      </property>
      <property>
          <name>javax.jdo.option.ConnectionURL</name>
          <value>jdbc:mariadb://localhost:3306/hive_db?createDatabaseIfNotExist=true</value>
          <description>JDBC connect string for a JDBC metastore</description>
      </property>
      <property>
          <name>javax.jdo.option.ConnectionDriverName</name>
          <value>org.mariadb.jdbc.Driver</value>
          <description>Driver class name for a JDBC metastore</description>
      </property>
        <property>
          <name>hive.cli.print.header</name>
          <value>true</value>
      </property>
      <property>
          <name>javax.jdo.option.ConnectionUserName</name>
          <value>hive</value>
          <description>username to use against metastore database</description>
      </property>
      <property>
          <name>javax.jdo.option.ConnectionPassword</name>
          <value>111111</value>
          <description>password to use against metastore database</description>
      </property>
  </configuration>
  
  ```



#### 하이브랑 MariaDB 연동하기 

하이브에 Maria JDBC lib 넣기.

```bash
cp mariadb-java-client-1.3.5-jar /etc/hive/lib
```

주의할 점 : MariaDB java Client 버전이 다르면 동작이 안할 수 있음 !!. (1.3.5 사용 할 것)

#### HDFS에 하이브가 사용할 파일 만들어 놓기  및 권한 부여 

1. 하이브 실행하기전에 HDFS 키고 MaraDB 준비 

2. 하이브가 사용할 폴더를 만들거임 tmp

   ```bash
   hadoop dfs -mkdir /tmp
   hadoop dfs -mkdir /user/hive/warehouse
   hadoop dfs -chmod g+w /tmp
   hadoop dfs -chmod g+w /user/hive/warehouse
   ```

   

3. Hive 실행

   ```bash
   hive
   ```

   - 명령어를 실행하면 한번 에러나면서 /tmp 밑에 hive 폴더가 생김 (권한이 없어서 Hive 실행이 안되는거임)
   - 하둡 제어창에서 확인(50070)

   

4. tmp/hive폴더에 권한 부여 후 하이브 재실행 하면 동작됨

   ```bash
   hadoop dfs -chmod 777 /tmp/hive
   
   hive
   ```

##### Hive에 데이터 테이블 작성 및 파일 업로드

- hdi.txt 파일 준비 (data)

- hive에서 hdi.txt 파일에 있는 데이터 형식 mysql에 테이블로 정의하기 (create table HDI)

  ```bash
  hive> CREATE TABLE HDI(id INT, country STRING, hdi FLOAT, lifeex INT, mysch INT, 
  
  eysch INT, gni INT) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' STORED AS 
  
  TEXTFILE;
  ```

- 하이브에서 hid.txt 를 HDFS 에 올리기 (load)

  ```bash
  hive>load data local inpath '/root/hdi.txt' into table HDI;
  ```

- 확인

  ```bash
  hive> select * from hdi limit 5;
  ```



### 하이브QL

http://stat-computing.org/dataexpo/2009





### 하이브 자바 연동

- 라이브러리 파일 준비

  - hivelibs.zip

- 하이브 서버 java app응답 대기

  ```bash
  hive --service hiveserver2
  ```

  이렇게 대기상태를 만들어 놔야지 java application에서 돌아감

- Java App준비하기

  - java project 만들고 add External jar file 해서 준비했던 library 넣기

  ```java
  import java.sql.*;
  
  public class Hive {
  	public static void main(String[] args) throws Exception {
  
  	Class.forName("org.apache.hive.jdbc.HiveDriver");
  
  	Connection conn = DriverManager.getConnection("jdbc:hive2://70.12.114.222:10000/default", "root", "111111");   //root 랑 111111 은 비워둬도 됨
        
  	Statement stmt = conn.createStatement();
  
  	ResultSet rs = stmt.executeQuery("SELECT * FROM hdi");
  
  	while (rs.next()) {
  		System.out.println(rs.getString(1));
  	}
  	conn.close();
       System.out.println("Success....");
  	}
  }
  ```

  







### 문제 발생시  대처

1. 하둡이 실행이 되지 않을 때
   - /etc/hadoop-1.2.1
   - name /data /tmp 삭제 후  format 및 실행
2. 윈도우에서 Hadoop관리창이 안열릴 경우
   - c\Windows\System32\drivers\etc 에 들어가서  hosts파일 수정 ( 하둡서버 호스트네임 추가)
3. 하둡 분산 설치시 host name에는 특수문자 넣지 말 것.
4. 하이브 연동 java App이 작동안할 경우 hive --service hiveserver2 준비 되어 있는지 확인