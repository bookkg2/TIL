### 딥러닝과 스마트카 개발



영상처리 로그분석 자율주행..

현업에서 일하는 개발자 



www.linkedin.com/in/heewon-kim-95531724/



#### 신경망과 인공신경망

- 훈련과 훈련을 거듭한 신경망
- Input Layer  // Hidden Layer // Output Layer





### 딥러닝

Input Layer  // Hidden Layer // Output Layer

- Input Layer
  - 시스템 외부로부터 입력자료를 받아들여 Hidden Layer로 전달
- Hidden Layer
  - 연산 
- Output Layer
  - 결과값 도출



#### 딥러닝 신경망 구조

- 어떻게 하면 효과적으로 학습을 시킬까? 연구..
- 사람을 가르치는것과 비슷..
- 신경망 하나 하나에서 조건 지정 가능, 효율 상승.



#### Convolutional Nueral Network



#### 딥러닝

##### 여러가지 기법 (영상처리 분야 ..)

영상처리학에서도 사용했지만 딥러닝을 통하여 더욱 발전시켜 작은 이미지도 인식가능.

- Classification
- Classification + Localization
- Object Dectection
- Insatnce Segmentation
- Object Detection (Face) - 얼굴인식
- Object Detection (YOLO) - 자동차 형상화 



#### 영상처리 기법 응용사례

- 보통 보안 또는 물류, 유통분야에서 많이 사용
  - Object Detection (Pedestrian)
  - Object Detection (Vehicles)
- 현실적으로 학습에 많은 비용이 소모됨.(전처리 과정)
  - 환경 별 (통제된 환경 )
    - 영상처리 기법으로도 충분...



- Segmentation
  - 도로, 보행자 잘라내기 (자율주행 차를 만드는데 꼭 필요한 기술.)
  - 자율주행차를 인공지능으로만 만들라면 할게 엄청 많음
- Super Resolution 
  - 썸네일 같은 작은 사진을 확대할때 이미지 손실을 최소화. 주변 색을 분석하여 채워넣음
- Style Transfer
  - 필터 같은거..
  - 풍경의 Style Transfer는 인공지능 카를 훈련하는데 유용하게 쓰일 수 있음.( 어두울때, 비올때. 석양질때 등등..)
- SLAM and Deep learning



#### 영상인식 상용화 적용 분야 

#### 딥러닝 기반 차량번호 인식 사례

- Supervised Learning 
- 도로공사..
- Deep-learing + Machine vision 
- 사업성도 따져봐야함... ( 그냥 눈으로 보고 번호판 치는게 나을지 사진으로 전송하고 받는게 나을지..) 



#### 항만 차량출입 관리 시스템 개발 계획

- RF ID를 가지고 왔다갔다 하는걸 개선.
- 카메라 달아서 번호판 읽고 GPU서버에 전송해서 인공지능으로 분석후 vms 관제 콜솔에 보내고  기존 RF 시스템이랑 비교 ..



#### AI 응용 : 실내 공기 질 통합 관리

- 지능형 환경센서 
- Real Time IoT 플랫폼
- 빅데이터 AI 알고리즘
  - 미세먼지 유해가스 분석/예측
  - 효율적인 공기정화 운영 제시
- 데이터 수집 - 데이터 전달 - 데이터 취합 및 분석 - 자율 운전 및 시스템 운영정보 제공..
- 센서 및 카메라 - IoT미들웨어- IOT 분석 플랫폼 - 공조설비 & 기타 설비 자율 구동



#### AI 응용  : 서버 로그 분석

#### AI 응용 : SoC  칩 개발 

#### 딥러닝의 어려움

- 데이터 자체가 매우 중요함
- 필수지식

#### 자율주행차

- 정의 
  - 자율주행은 자동차 스스로 주변환경을 인식, 위험을 판단, 차량 거동을 조작하여 운전자 주행조작을 최소화 하여 스스로 안전주행 및 커넥티드 서비스 제공이 가능한 인간친화적 자동차.
- 소프트웨어  구조
  - APOLLO PROJECT..
  - 자동차 회사도 오픈 하드웨어 오픈소스 로 차를 만든다..
- 관제 시스템 프로토 타입 개념도 
  - WEB/APP
    - Android /HTML5, JavaScript
  - DB
    - Oracle 11g
  - Server
    - Spring MVC  // Mybatis
  - Car
    - CAN
- 1. 제어신호를 패드에서 웹서버로 전송
  2. 차량으로 신호전송
  3. 태블릿에서MCU로 신호전송
  4. CAN통신
  5. CAN 신호를 태블릿(서버)으로 전송
  6. 태블릿(클라이언트)에서 웹으로 데이터 전송

### ROS 기반 소프트웨어 구조 

