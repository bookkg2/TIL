## www

​      

- 네이버에는 어떻게담기는 가 ?

  ![1560242700384](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1560242700384.png)

- HTML(Hyper Text Markup Language)은 웹 페이지를 기술하기 위한 언어이다. HTML은 마크업(markup) 언어의 일종이다. 마크업 언어는 텍스트에붙여서 텍스트가 문서의 어디에  해당하는지를 기술한것이다. 

- Html5 의 장점
  - 완전한 CSS3지원
  - 비디오와 오디오 지원
  - 2D/3D 그래픽 지원
  - 로컬 저장소 지원
  - 로컬 SQL 데이터베이스 지원
  - 웹 애플리케이션 지원
  - 위치도 알 수 있음

​       

#### HTML

- 전세계가 공통적으로 사용하는 Tag 언어
- XHTML1.0
- 2012 HTML5 등장
  - 웹에서 GPU를 건들일 수 있음.
  - 아직 모든브라우저가 지원하지는 않음.
    - 아직 대부분의 컴퓨터가 사양이 딸려서...

### <http://tomcat.apache.org/>

- 오픈소스 기반 소프트웨어를 커뮤니티 애들끼리 develop 시킴.
- tomcat 9
  - 64bit windows.zip
  - c 밑에 넣으셈.
- 

HTML TEST

```html
http://70.12.50.220:80/day01/a1.html
```

- 자동으로 80은 없어짐.. NAVER같은데서 기본으로 80포트를 쓰기때문.

[www.w3schools.com](http://www.w3schools.com/)

- 여기보고 HTML 공부하시오.. 이 책 만으로는 부족함.
- HTML , CSS, JavaScript
- Try it yourself 활용해보기

```html
<body>
<h1><a href="http://www.naver.com">HTML TEST</a></h1>   <!-- 주석 만들기  --> 
<img src = "img01.jpg"> 
<img src = "img/img02.jpg">   <!--  에러메시지 안뜨니까 직접가서 확인해봐야함 ,src는 attribute -->
</body>
단락주기
<p>" "  
</p>

<body>
<p>안녕하세요 </p>
<p>HTML입니다.</p>
<p>엔터               입니다.</p>
</body>
```

- 화면 맞추기

```html
<br>
<body>
<p>안녕하세요안녕하세요안녕하세요안녕하세요 </p>
<p>안녕하세요안녕하세요안녕하세요안녕하세요 </p>
<p>안녕하세요<br>안녕하세요<br>안녕하세요<br>안녕하세요 </p>
</body>
```

- 강제 띄우기

```
&nbsp;
<p>안녕하세요&nbsp;안녕하세요안녕하세요안녕하세요 </p>
```

- 띄우기 인식 (그러나 해상도에 따라서 짤릴 수도 있음)

```
<pre>엔터 입니다.
엔터   입니다.
</pre>
```

- 문서의 헤드라인 (폰트 사이즈 조정)

```html
<h1>Header</h1>
<h2>Header</h2>
<h3>Header</h3>
<h6>Header</h6>
```

HTML에서 여러개를 묶을수 있는 기능이 한개인데

### 리스트

- 여러개를 한번에 관리함.. 한번에 색을주거나 폰트를 키우거나..(집합)

```html
<ul> 
<li>List1</li>
<li>List1</li>
<li>List1</li>
</ul>

<ol>
    <li>List1</li>
    <li>List1</li>
    <li>List1</li>
</ol>
```

- 참고

  - <P> , <h>는 BLOCK(자신의 수평선 영역 다 차지
    <img></img> 는INLINE(자신영역만)
    주석키는 CTRL + SHIFT + ?
    <br>은 화면이 커지면 자동으로 범위지정X 그래서 잘 안씀

 