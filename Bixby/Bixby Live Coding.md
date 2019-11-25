# Bixby Live Coding

## I. Model Setting (비즈니스 로직 생성)

- capsule.bxb
  - Country.model
    - New > Model
    - Type : Text
    - fileName : Country
  - Result.model
    - 하나 더 생성 : fileName : Result
  - SearchCapital.model
    - New > Model
    - Type : Action
    - fileName : SearchCapital
      - INPUT TYPE : country
      - TYPE : Country
      - OUTPUT : Result

## II. Action Setting

- Code > New > Action JavaScript

## III. Target Setting

- Resource > New > ko-KR
  - capsule.bxb > New > Training

## IV. End-Point Setting

- Resouce > endpoints.bxb

  ```
  action-endpoint (SearchCapital) {
  	accepted-inputs (country)
  	local-endpoint (searchCapital.js)
  }
  ```

## V. View Setting

- Resource > view > New
  - SearchResult.view.bxb

## VI . Sample Bixby in Github

- github.com/bixbydevelopers

## VII. crawling

- 이미지 파일 받기
- html 파일 받기

## VIII. Templates

- Facts Templates
  - 언어 선택
  - Fact 이미지 및 텍스트 입력?
  - 경로 지정

## X. Open API 연동

- [www.data.go.kr](http://www.data.go.kr/)
- [www.apistore.co.kr](http://www.apistore.co.kr/)

## XI. DB 연동

- restdb.io
- noSQL 기반
- https://restdb.io/

## XII. Debug

- capsule.bxb
  - id
  - targets
  - capsule-imports : 필요한 라이브러리 import
- FindMovie.model.bxb
  - input 의 형태에 따라서 다른 행동을 취함
- all.endpoints.bxb
  - model 과 end-point 를 연결
- code > FindMovie.js
  - lib > TMDB.js
    - CRUD
  - parser.js
- 디버그 시작
  - Debug 벌레 버튼 클릭
  - 플랜 그래프 실행 화면
    - 어디서 오류가 났는지 확인 가능
  - import console
    - console.log
  - 발생한 view 오류 시, 추적 가능
  - System Generated 시,
    - Costomize 가능

## XIII. Story 기반 자동화

- 자동화 테스트 > Story
- all.hints.bxb 에 있는 기능은 100% 기능이 되어야 한다.
- Simulator 에서
  - Selection Learning 해제
  - export story
    - Run
    - Run Live : API 까지 호출하는 방식
  - Assertion
    - 어떤 경우가 맞는 경우인지 판별
    - 만약 error 가 뜨면 학습이 제대로 되지 않은 거임
- 학습?
  - Simulator Debug 모드에서 Conversation 탭
  - training 에서 추가적으로 패턴을 넣으면 됨

## XX. On-Device 테스트

- Submission > Private Submission
  - 받을 수 있는 Report 를 이용해서 품질을 향상 시킬 수 있다!!
- 빅스비 버전을 5번 치면 개발자 옵션 접근 가능하다.
- 과정
  - private submission
  - revision id
  - 개발자 옵션
  - revision id 입력
  - 테스트 실행