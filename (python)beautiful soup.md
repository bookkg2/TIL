## beautiful soup

- find     
  - find : 하나만 찾는다.
  - find_all : 다 찾는다. (배열 형식)
- select
  - 특정 부분을 -> 오른쪽 마우스 -> copy -> copy selector

```python
from bs4 import BeautifulSoup
import requests
# query ={
#     'all' : {
#         'name' : 'cat_cd',
#         '웹개발 전체' : '404'
#     },
#     'position' : {
#         'name' : 'cat_key',
#         'IOS' : '40701'
#     }
# }

#url = f"http://www.saramin.co.kr/zf_user/jobs/list/job-category?{query['all']['name']} = {query['all']['웹개발 전체']}&panel_type=&search_optional_item=n&search_done=y&panel_count=y"

url = 'http://www.saramin.co.kr/zf_user/jobs/list/job-category?cat_cd=404&panel_type=&search_optional_item=n&search_done=y&panel_count=y'

response = requests.get(url)

# BeautifulSoup 이 Html을 한번 읽는다. 
html = BeautifulSoup(response.text,'html.parser')
#banner_list > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > div.part_top > h3

#회사 이름만 추출
#company_names = html.select('.company_name')
#회사 부가 정보 추출
#recruit_names = html.select('.recruit_name')
#자격 요건 추출
#recruit_conditions = html.select('.list_recruit_condition')

#list 형식은 반복문으로 나타낼 수 있다. 
#zip 은 두개를 엮어서 표현하고 싶을 때
#for company_name ,recruit_name,condition in zip(company_names,recruit_names,recruit_conditions):
    #html 테그는 없애고 텍스트만 출력 
#    print(f'{company_name.text} - {recruit_name.text}')
#    print(condition.text)

#회사 부가 정보 추출
#for recruit_name in recruit_names:
#   print(recruit_name.text)



#print(len(company_names))
#print(len(recruit_names))

# Div 영역을 잡고 있는 것을 추출
#배열 중 하나만 출력 하기 위해서는 select_one (list 형식을 text로 찍고 싶을 때 문제해결)
# company = html.select('.part_top')
# for com in company:
#     print(f'{com.select_one(".company_name").text} - {com.select_one(".recruit_name").text}')
#     print(com.select_one('.list_recruit_condition').text)
    
#     break

#ul 중에 Product list를 찾고 그중에 li를 찾는다. 
company_list = html.select('ul.product_list li')

for com in company_list:
    #사람이은 특정 지역별로 ajax 로 표현 하였기 때문에 ajax 데이터에 접근해서 가져와야 한다. 
    idx = com.select_one('a')['href'].split('=')[-1]
    company_info_url = 'http://www.saramin.co.kr/zf_user/jobs/relay/view-ajax'
    company_info_params = { 'rec_idx' : idx}
    company_response = requests.post(company_info_url, params = company_info_params)
    print(company_response)
    #html에 접근
    company_html = BeautifulSoup(company_response.text,'html.parser')
    #하나만 출력
    company_title = company_html.select_one('a.company').text
    #strip()은 앞에를 잘라낸다.
    print(company_title.strip())
    #속성명 끄집어 내기
    # print(com.select_one('a')['href'])
    # #a 태그 속성으로 url 생성 
    # company_info_url = f"http://www.saramin.co.kr{com.select_one('a')['href']}"
    # company_response = requests.get(company_info_url)
    # #print(company_response.text)
    # company_html = BeautifulSoup(company_response.text,'html.parser')
    # company_summary = company_html.select_one('div.jv_summary')
    # print(company_summary)


    break
print(len(company_list))

```

(html)

```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
   <!-- <ul>
        <li><a href="/daum_webtoon/mon">월요일</a></li>
        <li><a href="/daum_webtoon/tue">화요일</a></li>
        <li><a href="/daum_webtoon/wed">수요일</a></li>
        <li><a href="/daum_webtoon/thu">목요일</a></li>
        <li><a href="/daum_webtoon/fri">금요일</a></li>
        <li><a href="/daum_webtoon/sat">토요일</a></li>
        <li><a href="/daum_webtoon/sun">일요일</a></li>
    </ul> -->

    {% for day in days %} 
        <a href="/daum_webtoon/{{ day }}" >{{ day }}</a>
    {% endfor %}
</body>
</html>
```

