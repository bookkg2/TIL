### 리눅스

- 메킨토시 - 리눅스 환경으로 되어있다. (해당 HW에 최적화로 OS 구성을 했다.)

- 가상머신 - WIndow를 그대로 사용하면서도 여러대의 리눅스 서버를 운영할 수 있다.  즉 가상으로 존재하는 컴퓨터를 말한다. (가상의 하드웨어와 가상의 OS(리눅스)를 만든다. (또한, 가상의 게이트웨이(라우터)도 생성한다.))
- Virtual Machine 
  - Vmware
  - Virtual Box

#### 설치

1) INSTALL VMware

2)하드디스크 설치(가상 머신) - CentOS 64bit

3) Edit virtual machine settings 클릭 - > 가상 컴퓨터 생성

> window + Pause 하면 해당 메모리 용량 확인 가능 

4)Edit virtual machine settings 클릭 -> CD/DVD ->User ISO Image file 클릭 하여 가상의 CD를 넣는다. (CentOS 시디) 

> Tip) Use physical drive : 진짜 물리적인 CD 



#### 탄생

- IBM 유닉스 - 비싸고 아무나 사용 못한다. (단 가장 안정적인 OS이다.) 

- 유닉스를 바탕으로 1991년 8월 리누스 토르발스가 리눅스를 개발하였다.-

- 리눅스가 결국 현재 멕킨토시와 윈도우의 기반이 된다.

- 이것이 커져서 안드로이드 등이 등장한다.

  > 현재 빅데이터,클라우드 기반에 리눅스를 많이 사용한다.(많은 컴퓨터가 요구되고 무료여서!)

#### PLAY

- 소프트웨어 선택 들어가서 

  > CTRL +ALRT 누르면 해당 리눅스 환경을 나올 수 있다. 

- swap : 마운트 지점에 가상 하드디스크 메모리를 가상으로 만든다.(접속이 느림)

- /  :  나머지 공간을 잡는다.

- 마운트란 ? 리눅스에서 여러가지 하드웨어 장치들을 사용하기 위해 리눅스라는 운영체제에 인식시켜야 하는데 이를 가능하게 해주는 것이 마운트 작업이다.

  - 마운트 포인트 ? 특정 디렉토리를 뜻한다. 이것을 연결하는 것이 마운트 작업니다.

  > 현재 윈도우 운영체제는 PnP(Plug and Play ) 라는 기능에 의해 대부분 자동으로 인식하기 때문에 사용자가 직접 마운트 작업을 하는 경우가 없다. 물론 리눅스에서도 PnP 기능을 사용하지만, 하드디스크 추가작업이나 DVD, CD-ROM 과 같은 장치들은 시스템 부팅 후 수동으로 마운트 작업을 이용해 사용해야 하는 경우가 종종 있다. 그리고 DVD, CD-ROM 등의 경우에는 사용후 반드시 마운트해제를 해줘야 한다. 

