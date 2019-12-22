## html (ID,CLASS)

- ID는 특정 부분을 속성 주고 싶을 때

- CLASS는 여러개를 묶어서 속성을 주고 싶을 때
- 많이 사용되는 속성들

| 속성             | 설명                             |
| ---------------- | -------------------------------- |
| color            | 텍스트 색상                      |
| font-weight      | 볼드체 설정                      |
| padding          | 요소의 가장자리와 내용 간의 간격 |
| font-size        | 폰트의 크기                      |
| background-color | 배경색                           |
| border           | 요소를 감싸는 경계선             |
| font-style       | 이탤릭체 설정                    |
| background-image | 배경 이미지                      |
| text-align       | 텍스트 정렬                      |
| list-style       | 리스트 스타일                    |

-html 부분

```html
<!DOCTYPE html>
<html>
<head>
<!-- 환경설정 -->
<meta charset="EUC-KR">

<link type="text/css" rel="stylesheet" href="c1.css"><!-- css 가져올 때-->
<title>Insert title here</title>
</head>
<body>
	ID
	<input type="text" name="id">
	<br> PWD
	<input type="password" name="pwd">
	<br>



	<h1>Header1</h1>
	<h1 id="h1">Header1</h1>
	<!-- 이 부분만 주고 싶을 때는 id ATTRIBUTE -->
	<h1 class="cc">Header1</h1>
	<!-- 여러개를 묶어서 주고 싶을 때는 class -->
	<h2 class="cc">Header2</h2>
	<h2>Header2</h2>
	<p class="cc">Paragraph</p>
	<p>Paragraph</p>
	<p>Paragraph</p>
</body>
</html>
```

-CSS 부분

```css
@charset "EUC-KR";

* { /* 전체를 줄 때는*/
	/* border : 3px solid black; */
	
}

/*CSS Comments*/
h1 { /*h1은 SELECTOR*/
	color: red;
	background: black;
}

#h1 {/*ID속성가져올때*/
	color: pink;
	background: blue;
}

.cc {/*속성가져올때*/
	color: red;
	background: gray;
}

input[type="text"] {/*input속성 가져올때*/
	background: yellow;
}
```

