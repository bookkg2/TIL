## Day6

- jango에서 MVC 는 MVY
  - controller = views.py
  - view = template

- 카카오 API 사용시 주의점

  - 지금까지는 정식적으로 API화가 되어있지 않은 사이트를 크롤링해와서 우리 데이터로 사용(잘못 크롤링하거나, 사용하시면 불법이 될 수도 있습니다.) 오늘은 정식적으로 제공하는 카카로 API와 네이버 API를 활용

  - [카카오 개발자 페이지 가입해서 앱만들기]

  - API key를 받을건데, 이러한 중요한 Key들을 절!대!로! 깃헙,AWS,Credential key 가 공개될 경우 요금 폭탄 맞을 수 있다. 

  - 주소 검색하기(gps_x,gps_y 좌표 받기 위해서)

  - 키워드로 장소 검색하기 

  - 공식 API문서를 볼 때 주의할 점 

    - 요청 방식과 요청을 보내야 할  주소 (End-point)

      가 어떻게 되는지

    - 필수적인 파라미터가 있는지

    - 인증키를 어떠한 방식으로 보내야 하는지 
  
  
  
  ### 카카오 API 사용해보기
  
  - 정식으로 제공하는 카카오 API와 네이버 API를 활용하기
  - 카카오 개발자 페이지 가입해서 앱 만들기
  - API Key 공개하지않기
  - 주소 검색하기(gps_x, gps_y 좌표 받기 위해서)
  - 키워드로 장소 검색하기
  
  > 앱키를 헤더에 담아 GET방식으로 요청 <https://developers.kakao.com/docs/restapi/local>
  
  - 공식 API 문서를 볼 때 주의할 점
    - 요청 방식과 요청을 보내야 할 주소(End-point)가 어떻게 되는지
    - 필수적인 파라미터가 있는지
    - 인증키가 있는지
  
  ```
  > django-admin startproject apitest
  > cd apitest
  > python manage.py startapp kakao_api
  > python manage.py runserver
  http://localhost:8000/
  # settings.py
  INSTALLED_APPS = [
      'kakao_api'
  ]
  
  # urls.py
  from kakao_api import views as kakao_views
  
  urlpatterns = [
      path('admin/', admin.site.urls),
      # 주소 검색하는 페이지
      path('kakao/', kakao_views.main),
      # 주소 검색 결과 + 키워드 입력
      path('kakao/address/', kakao_views.find_address),
      # 키워드 검색 결과
      path('kakao/result/', kakao_views.keyword_result)
  ]
  # views.py
  from django.shortcuts import render
  import requests
  import json
  
  # Create your views here.
  def main(request):
      # 주소를 검색하는 페이지
      return render(request, 'kakao_main.html')
  
  def find_address(request):
      # main에서 검색한 검색어를 카카오 로컬 검색으로 검색한 결과를 보여주는 페이지
      # + 키워드 입력하는 페이지
      url = f'https://dapi.kakao.com/v2/local/search/address.json'
      key = 'REST API 키'
      q = request.GET['address']
      param = {
          'query': q,
          'size': 30
      }
      headers = {
          'Authorization': f'KakaoAK {key}'
      }
      response = requests.get(url, params=param, headers=headers) # 응답 내용은 JSON
      address_data = json.loads(response.text)
      context = {
          'result' : address_data["documents"]
      }
  
      return render(request, 'kakao_address.html', context)
  
  def keyword_result(request):
      # 키워드를 입력하는 곳에서 입력한 키워드와 position(x,y) 좌표를 추출해서
      # kakao api의 키워드 검색 api에 요청을 보낸다.
      keyword = request.GET['keyword']
      position = request.GET['position']
      gps_x = position.split(',')[0] # , 나누기
      gps_y = position.split(',')[1]
      url = 'https://dapi.kakao.com/v2/local/search/keyword.json'
      key = 'REST API 키'
      params = {
          'query': keyword,
          'x': gps_x,
          'y': gps_y
      }
      headers = {
          'Authorization': f'KakaoAK {key}'
      }
      response = requests.get(url, params=params, headers=headers) 
      context = {
          'result': json.loads(response.text)["documents"]
      }
      # context = {
      #     'keyword': keyword,
      #     'position': position,
      #     'x': gps_x,
      #     'y': gps_y
      # }
  
      return render(request, 'kakao_keyword_result.html', context)
  <!-- kakao_main.html -->
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Document</title>
  </head>
  <body>
      <h1>검색어를 입력해주세요.</h1>
      <form action="/kakao/address">
          <input type="text" name="address">
          <input type="submit" value="검색하기">
      </form>
  </body>
  </html>
  
  <!-- kakao_address.html -->
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Document</title>
  </head>
  <body>
      <h1>원하는 위치를 선택하세요.</h1>
      <form action="/kakao/result">
          <p>검색 키워드를 입력하세요</p>
          <input type="text" name="keyword">
          <input type="submit" value="키워드 검색">
          <br>
          {% for position in result %}
              <label>{{position.address_name}}
                  <input type="radio" name="position" value="{{position.x}},{{position.y}}"><br>
              </label>
          {% endfor%}
      </form>
  </body>
  </html>
  
  <!-- kakao_keyword_result.html -->
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Document</title>
  </head>
  <body>
      {% for site in result %}
          <p>상호명: {{site.place_name}}</p>
          <p>주소(도로명 주소): {{site.address_name}}(도로명 주소: {{site.road_address_name}})</p>
          <br/>
          <a href= "{{site.place_url}}" target="_blank">상세정보 보기</a>
          <br/><br/>
      {% endfor %}
  </body>
  </html>
  ```