##  브라우저

- 기존의 view -> controller -> model 에서 요즘에는 view -> view model -> model로 변화되는 추세다. 

- Wappalyzer : 웹 동작 상태 정보 제공

- 웹 <head> 태그 : Title 말고는 눈에 보이지는 않는다. 

- Seo 에 최적화 하기 위해 "og" 테그를 사용 한다 . 즉 검색엔진에 최적화 

  ```html
  <meta property="og:title" content="" />
  	<meta property="og:image" content="http://static.naver.com/m/comic/im/og_tag_v2.png" />
  	<meta property="og:description" content="" />
  	<meta property="og:type" content="article" />
  	<meta property="og:url" content="" />
  	<meta property="og:article:author" content="" />
  	<meta property="og:article:author:url" content="" />
  ```

- body 테그 밑에 Dom 트리들이 그려지기 시작한다.

- SQL 은 데이터 베이스 시스템에 데이터를 효율적으로 가져오는 것 (Back end)

- GQL은 웹 클라이언트가 데이터를 서버로 부터 효율적으로 가져오는것 (Front end)

- 현재는 서버에서 데이터를  JSON,XML 형식으로 받아서 구성한다. (옛날에는 각각의 App, web 별도의 서버로 두고 서비스 했음, 즉 html에 다 넣어서 구현)

- 응답코드

  - 200 - 정상
  - 300 - 리디렉션
  - 400 - 클라이언트 오류 (사용자 잘못)
    - 403 : forbidden
  - 500 - 서버오류 (개발자 잘못)

- 크롤링

  ```python
  #1. 요청을 
  import requests
  #2.url에 주소를 저장한다.
  url = "원하는 URL"
  #3.요청을 보내고 응답을 변수에 저장
  response = requests.get(url)
  #4.응답을 출력한다.
  print(response.text)
  ```

  ```python
  #1.요청을 보내기 위한 requests 모듈을 import 한다.
  import requests
  #2.Url에 주소를 저장한다.
  url = "원하는 URL"
  #3.요청을 보내고 응답을 변수에 저장
  headers = {
     'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36'
  }
  #4.변수에 저장된 내용을 출력한다.
  response = requests.get(url,headers=headers)
  #(추가사항) 5. newl 공연, 2019 전국투어,뮤지컬&연
  #각 부분을 출력해보기
  print(response.text)
  #[parameter 부분을 잘 확인할 것 !!] 
  ```

  

