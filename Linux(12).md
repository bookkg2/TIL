## 리눅스

- /etc/Profile 이란 ? 리눅스 전체 OS를 나타낸다.  즉 전역변수를 설정할 수 있다.  



- envset.sh (쉘스크립트를 생성)

1.jdk 설치 

​	/etc/jdk1.8

​	/usr/bin/java softlink



2.tomcat 설치

​	/etc/tomcat

​	/usr/bin/startcat softlink

​	/usr/bin/stopcat softlink



3. eclipse 설치

   /etc/eclipse

   /usr/bin/eclipse softlink

:blue_car:문제 ) 메뉴를 구성 사여 설치를 진행한다. 단 설치가 되어 있을 경우 삭제 후 설치를 진행 한다. 중간에 사용자에게 물어 보면서 진행



​	

# 1. Network Setting

- 주의할 점
- 맨 처음부터 브릿지 설정 후에 하면 안됨
- NAT 설정으로 시작해야됨

```
vi /etc/sysconfig/network-scripts/ifcfg-ens33
----------------------------------------------
BOOTPROTO="dhcp"  -> BOOTPROTO="none" //수정
// 아래 코드는 새로 추가
// 아래 코드는 브릿지 설정
IPADDR=70.12.114.218
NETMASK=255.255.255.0
GATEWAY=70.12.114.1
DNS1=168.126.63.1
-----------------------------------------------
```



hostname

/etc/hosts

# 2. /etc/yum.repos.d



# 3. /etc/sysconfig/selinux



# 4. Program install



# 5. Profile Setting

## 1)  JAVA_HOME

## 2) CLASSPATH

## 3) PATH

## 4) TOMCAT_HOME



# 6. firewall-config



# 7. clone