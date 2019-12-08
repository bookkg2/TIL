## 리눅스(2)

#### 기존 가상머신 복제하는 법(clone  하는 법)

> 가상머신의 이름을 바꾸고 싶을 때는 : Edit를 클릭하고 -> General에 들어가서 변경을 한다. 

1) 기존 가상머신 디렉토리를 간다.

2) 새로운 디렉토리를 생성하고 그곳에 똑같은  티렉토리를 복제한다. 

3) 그리고 displayName을 변경한다.

4) 나타난 해당 SERVER에 Edit virtual machine settings를 선택 한다. (MAC Address 와 해당 localIP를 변경한다.)

5) MAC Address 변경 : Edit virtual machine settings -> Network Adapter -> Advanced -> MAC Address Generate 클릭(자동완성)

6)  play를 진행 하여서 root를 클릭 하여 '알림'을 끈다.

7)  root -> 설정 -> 디스플레이 들어가서 해상도를 변경한다.

8) 왼쪽 상단의 [프로그램]을 클릭하고 [시스템 도구] -> [소프트웨어] 를 클릭한다.

9) 상단의 소프트웨어 선택 최신 패키지만 사용 OFF

10)  상단의 소프트웨어 선택 소프트웨어 공급원 선택하여 업테이트 확인 -> 하지 않기로 변경

- 1. 먼저 /etc/yum.repos.d 로 이동
  2.  getdit CentOS-Base. repo 명령어를 통해 Upgrade 부분 삭제
  3.  getdit CentOS-Sources. repo 명령어를 통해 Upgrade 부분 삭제
  4.  mv CentOS-Base.repo  CentOS-Base.repo.bak (기존 저장소 백업)
  5. wget http://download.hanbit.co.kr/centos/7/CentOS-Base.repo (새 저장소 다운로드)
  6. chmod 644 * (권한 변경)
  7. rm -f *.repo (필요없는 파일 삭제) 
  8. yum clean all (저장소를 초기화)

> 업그레이드 된 최신 파일을 받아오게 되면 해당 버전 OS 와 맞지 않는 소프트웨어는 문제가 발생 할 수 있으니 모든 업데이트를 차단하겠다.

11) YUM 명령을 사용할 때도 업데이트괸 소프트웨어가 설치되지 않고, CentIOS 7의 출시 시점의 소프트웨어가 설치 되도록 하기 

> 'YUM' : CentOS의 소프트웨어를 설치할 때 사용하는 명령어

- 가상머신을 복사 해서 사용 할 경우에는 I moved it 을 선택한다 !!!

> 서버를 위한 OS가 리눅스 여서 함부로 끄면 다시 깔아야 한다.

- 가상 머신을 생성시 자동으로 IP ADDRESS를 할당 - DHCP
- 가상머신 내의 각각의 OS는 네트워크로 공유가 가능하다.

- 중요) 



#### 가상머신에 IP ADDRESS 세팅

- IP는 보통 마지막자리에 255까지 가능, 즉 255개 까지 같은 아이피로 할당 가능  

> 현재 네트워크 1위는 화웨이  

- 192.168.111.1 - > 호스트 OS
- 192.168.111.2 -> 게이크웨이 겸 DNS 서버 

- CMD에서 -> rundll32 "C:\Program Files (x86)\VMware\VMware Player\vmnetui.dll" VMNetUI_ShowStandalone ->  VMnet8 -> Subnet IP 변경 EX)192.168.111.0
- 터미널에서   cd  /etc/sysconfig/network-scripts/ (네트워크 설정 파일이 저장된 디렉토리로 이동)
- ls로 확인을 한다. (ifcfg-xxxx) 파일 확인 (ifcfg-lo 파일은 제외)
- 명령어에 getdit ifcfg-xxxx로 수정한다.
  - HWADDR -> 설정한 MAC ADREESS로 설정 , BOOTPROTO는 none으로 (IP  고정, dhcp는 자동 완성 IP여서)
  - 추가) IPADDER= 192.168.111.100
  - 추가) NETMASK=255.255.255.0 (IP 범위)
  - 추가) GATEWAY = 192.168.111.2
  - 추가) DNS1 = 192.168.111.2 (도메인)
  - systemctl restart network (네트워크 재시작)
  - ifconfig 하면 IP 주소가 변경되어서 고정되어 있을 것이다. 
  - hostname 으로 이름 확인 (local로 되어있을 것이다.)
  - hostname set-hostname 이름 으로 hostname 변경 Ex) server2
  - gedit /etc/hosts 실행 
  - 각각의 IPAddress 와 네트워크 이름 설정해 둔다 Ex) 192.168.111.200 server2
  - ping을 찍어서 해당 OS에 네트워크가 연결되는지 확인

>   명령어) poweroff : 컴퓨터 끄기 , reboot : 다시 시작, pwd : 현대 디렉토리 확인

- 보안이 설정된 SELinux 기능 끄기
  - gedit /etc/sysconfig/selinux (파일 편집)
  -  SELINUX=disabled로 변경 
  - root 설정으로 가서 [전원] 클릭하고 끄기 , [사생활 보호] 클릭하여 끄기