## 빅 데이터

- 개요 - 기존 데이터베이스 관리도구로 데이터를 수집,저장,관리,분석할 수 있는 역량을 넘어서는 대량의 정형 또는 비정형 데이터 집합로부터 가치를 추출하고 결과를 분석하는 기술

- 정의 - 정보 자산을 효율적으로 이용하기 위한 기술들을 포괄하여 아우르는 말

  ​        - 비정형데이터를 분석하여 활용가능한 정보를 추출하는 것 

> 비저형 데이터 : 비구조화 데이터, 비구조적 데이터는 미리 정의된 데이터 모델이 없거나 미리 정의된 방식으로 정리되지 않은 정보를 말한다. 

##### 3V 모델

:star: Volume(양) - 대용향 데이터(수만 테라바이트), 데이터의 양이 증가하고 있어서 문제를 극복하려면 확장 가능한 방식으로 데이터를 저장하고 분석하는 분산 컴퓨터 기법으로 접급해야 한다. 현재 분산 컴퓨터 솔루션으로는 구글의 GFS와 아파치의 하둡이 있고, 대용향 병렬 처리 데이터베이스로는 EMC의 GreenPlum, HP의 Verica, IBM의 Netezza,테라데이터의 Kickfire 등이 있다. 

:star: Velocity(입출력 속도) - 큰 용량의 데이터를 빨리 처리해야 함, 통계학과 전산학에서 사용되던 데이터 마이닝, 기계 학습, 자연어 처리, 패턴 인식 등이 이러한 분석 기법에 해당한다.

:star: Variety(다양성)  - 계량화 및 수치화가 어려운 비정형적 데이터를 포함함, 정형 데이터는 고정된 필드에 저장되는 데이터를 의미합니다.예를 들어, 온라인 쇼핑몰에서 제품을 주문할 때 이름,주소,연락처,배송주소,결제정보 등을 입력한 후 주문을 하면 데이터베이스에 미리 생성돼 있는 테이블에 저장됩니다. 이때 테이블은 고정된 필드로 구성되는데, 이처럼 일정한 형식을 갖추고 저장되는 데이터를 정형 데이터라고 합니다. 기존의 솔루션을 이용해 비교적 쉽게 보관,분석,처리 작업을 진행할 수 있다. 반정형 데이터는 고정된 필드로 저장돼 있지는 않지만 XML, HTML 같이 메타데이터나 스키마 등을 포함하는 데이터를 의미한다. (JSON) 비정형 데이터란 고정된 필드에 저장돼 있지 않은 데이터를 의미한다. 유튜브에서 업로드하는 동영상 데이터, 페이스북이나 트위터 같은 SNS나 블로그에서 저장하는 사진과 오디오 데이터, 메신처로 주고받은 대화 내용 등 빅데이터는 이러한 비정형 데이터도 처리할 수 있는 능력을 갖춰야 한다.   

 Varacity(정확성) - 분석에서 목적에 맞는 데이터를 선별하고 수집하는 것이 분석 결과의 정확성에 영향을 미침, 

Value(가치) - 빅데이터를 통해 어떤 문제를 해결할 수 있는가



##### 하둡이란 ?

- 대용량 데이터를 분산 처리할 수 있는 자바 기반의 오픈소스 프레임워크
- 구글이 논문으로 발표한 GFS(Google File System) 와 맵리듀스를 2005년에 더그 커팅이 구현한 결과물이다. 
- 분산 파일 시스템인 HDFS에 데이터를 저장하고, 분산 처리 시스템인 맵리듀스를 이용해 데이터를 처리한다. 

- x86 CPU에 리눅스 서버면 얼마든지 하둡을 설치해서 운영할 수 있다. (RDBMS에 저장하기에는 데이터 크기가 크로 고가의 장비다. ) , 유닉스는 안된다.
- 서브 프로젝트가 상용화되면서 하둡 에코시스텝이 구성되었다.  

##### 하둡의 과제

- 고가용성 지원 
- 파일 네임스페이스 제한
- 데이터 수정 불가
- POSIX 명령어 미지원
- 전문 업체 부족  

##### 하둡 개발 준비

- 실행 모드 결정 
  - 독립 실행 모드 - 하둡의 시본 실행 모드, 분산 환경을 고려한 테스트는 불가능 
  - 가상 분산 모드 - 하나의 장비에 모든 하둡 환경설정을 하고 , 하둡 서비스도 이 장비에서만 제공하는 방식
  - 완전 분산 모드 - 여러 대의 장비에 하둡이 설치된 경우 

- 리눅스 서버 준비
  - CPU : 듀얼 코어 2.93GHz
  - 램 : 2.0GB
  - 하드디스크:100GB
  - 운영체제:CentOS6.4(64비트)

- 하둡 다운로드  : 

  1.필요 파일 다운 로드

  1) java

  2) hadoop

  3) eclipse

  4) tomcat

  5) mysql

  > mysql  설치 ) 1. 파일에 MariaDB RPM 파일(mariadb-java-client-2.4.2까지)을 가져다 놓는다. 
  >
  > cd  다운로드/	->다운로드 디렉터리로 이동
  >
  > pwd	->다운로드 디렉터리 위치 확인
  >
  > yum -y remove mariadb-libs	->충돌나는 패키지 삭제
  >
  > ls	->다운로드한 패키지 패일 확인
  >
  > yum -y localinstall Maria* 	-> 다운로드 받은 rpm 패키지 파일 설치 
  >
  > systemctl restart mysql
  >
  > systemctl status mysql
  >
  > chkconfig mysql on 	->서비스 상시 가동  (MariaDB의 서비스 이름은 'mysql')
  >
  > (firewall-config 명령어를 입력해서 [방화벽 설정] 을 실행한다. [설정] 에서 [영구적]을 선택한 후 [영역]에서 [public] 이 선택된 상태에서 오른쪽 [서비스] 탭 [mysql]의 체크를 켜서 MariaDB 서버를 열어두자.메뉴의 [옵션] - [Firewall 다시 불러오기])
  >
  > :station:각 서버의 포트 번호는 /etc/service 파일에 설정되어 있다. mysql의 포트는 3306이다. 
  >
  > mysql ->실행하여 확인 , 나올 때는 exit
  >
  > <MariaDB에 root 관리자 설정>
  >
  > mysqladmin -u root password '111111' 를 입력해 관리자 root의 비밀번호 '111111' 설정
  >
  > 이제부터는 mysql로 접속할 수 없다. 
  >
  > 'mysql -u root -p' 를 입력해 비밀번호를 입력해서 접근 가능 !!
  >
  > use mysql 입력해서 'select user,host from user' 입력해서 접근권한 확인

  

  - 하둡은 전체적인 네트워크를 묶으면 포트 없이 사용 함으로 firewall을 해제한다.

  ```
  systemctl disable firewalld
  ```

  

  1-1)하둡 해당 링크로 가서 tar 파일 받아오기!

  - wget <https://archive.apache.org/dist/hadoop/common/hadoop-1.2.1/>[hadoop-1.2.1.tar.gz](http://apache.mirror.cdnetworks.com/hadoop/core/hadoop-1.2.1/hadoop-1.2.1.tar.gz)

  - 해당 tar 파일을 디렉터리로 가져와서 압축을 푼다. ('tar xvf hadoop-1.2.1')

  - /etc 밑으로 복사 (cp -r hadoop1.2.1 /etc/)

    

  2. etc/hosts
     - 해당 hosts 경로 및 이름 설정

  

    3.etc/hostname

  ```bash
  hostnamectl set-hostname hadoopserver2(원하는 이름)
  ```

  

  ​       

  

  4. etc/sysconfig/network-scripts

  TYPE="Ethernet"

  BOOTPROTO=none

  IPADDR=70.12.116.50

  NETMASK=255.255.255.0

  GATEWAY=70.12.116.2

  DNS1=70.12.116.2

  

  5. etc/profile

  JAVA_HOME=/etc/jdk1.8 

  HADOOP_HOME=/etc/hadoop-1.2.1

  export PATH=$HADOOP_HOME/bin:$JAVA_HOME/bin:$HADOOP_HOME/bin:$PATH

  export JAVA_HOME TOMCAT_HOME HADOOP_HOME

  CLASSPATH=$CLASSPATH:JAVA_HOME/lib

  export CLASSPATH

  > . ./etc/profile 로 초기화 시켜둔다. 

  

  6. ssh

  

  - $ ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa 

  - $ cat ~/.ssh/id_dsa.pub >> ~/.ssh/authorized_keys 

  

  7. hadoop conf

     

  8. conf/core-site.xml 

     ```bash
     <configuration>
     
     <property>
     
       <name>fs.default.name</name>
     
       <value>hdfs://localhost:9000</value>
     
     </property>
     
     <property>
     
       <name>hadoop.tmp.dir</name>
     
       <value>/etc/hadoop-1.2.1/tmp</value>
     
     </property>
     
     </configuration>
     ```

     

   

     9.conf/hdfs-site.xml

   ```bash
  <configuration>
  
  <property>
  
    <name>dfs.replication</name>
  
    <value>1</value>
  
  </property>
  
  <property>
  
    <name>dfs.name.dir</name>
  
    <value>/etc/hadoop-1.2.1/name</value>
  
  </property>
  
  <property>
  
    <name>dfs.data.dir</name>
  
    <value>/etc/hadoop-1.2.1/data</value>
  
  </property>
  
  <property>
  
    <name>dfs.webhdfs.enabled</name>
  
    <value>true</value>
  
  </property>
  
  </configuration>
   ```

  

   

  10. conf/mapred-site.xml

   ```bash
  <configuration>
  
  <property>
  
    <name>mapred.job.tracker</name>
  
    <value>localhost:9001</value>
  
  </property>
  
  </configuration>
   ```

  

  

  

  

  11.conf/hadoop-env.sh (set nu 5번 라인에 JAVA_HOME 주석 풀고)

  - export JAVA_HOME=/etc/jdk1.8
  - export HADOOP_HOME_WARN_SUPPRESS="TRUE"      ->  (발생되는 Warn을 다 넘긴다.)

  /etc/bashrc (실행 될 때 마다 자동으로 실행되도록 설정)

  - 맨 밑에  '.  /etc/hadoop-1.2.1/conf/hadoop-env.sh' 입력   

  

  

  12.format (reboot 한번 하고 실행) - hadoop-1.2.1 에 ls 해보면 'name' 디렉터리가 생성된다.

  - 'hadoop namenode -format'

  

  13.   start-all.sh (하둡 실행) - hadoop-1.2.1 에 ls 해보면 'data' 디렉터리가 생성된다. (data : 실질적으로 담기는 곳 ) 

      

  14. jps 로 확인 (Jps , JobTracker , DataNode, SecondaryNameNode,NameNode 있는지 확인)

  15. 컴퓨터를 끌때는 stop-all.sh 하고 끌것!!!!!!!

  

> ssh : network 이동 , password 입력 , 나오고 싶으면 exit 
>
> <이동시 비밀번호 물어보는거 없애기>
>
> ssh-keygen -t dsa -P '' -f  ~/.ssh/id_dsa
>
> id_dsa  : PRIVATE KEY , id_dsa.pub : PUBLIC KEY
>
> cd .ssh 가서 ls로 확인
>
> cat id_dsa.pub >> authorized_keys
>
> ls 로 확인
>
> 그 다음 부터 ssh 하면 비밀번호 없이 이동 가능 (EX ssh hadoopserver1)
>
> - 사내망에서 서로 왔다갔다 할 때 사용한다.
>
> :car:만약 문제가 발생하면 .ssh 폴더를 없애고 다시 작업을 해야 한다. 





