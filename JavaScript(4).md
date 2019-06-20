### JAVASCRIPT

- setInteval , setTimeout- window.onload 사용(body 끝나고 자동으로 등장)

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
window.onload = function(){//body가 다 출력이 되면 자동으로 호출된다. 즉 바로 스트립트가 작동한다.(window)
	var h1 = document.getElementById('h1');
	var h2 = document.getElementById('h2');
	var h3 = document.getElementById('h3');

	var s1= setInterval(function(){
			var txt = h1.innerText;//text를 가져옴
			h1.innerText += txt + '*';
	},200);

	var s2= setInterval(function(){
			var txt = h2.innerText;//text를 가져옴
			h2.innerText += txt + '*';
	},500);
	var s3= setInterval(function(){
			var txt = h3.innerText;//text를 가져옴
			h3.innerText += txt + '*';
	},400);

	setTimeout(function(){//5초뒤 INTERVAL 종료
		clearInterval(s1);
		clearInterval(s2);
		clearInterval(s3);
	},5000);
};
</script>
</head>
<body>
<h1>Interval Test</h1>
<h1 id ="h1"></h1>
<h1 id ="h2"></h1>
<h1 id ="h3"></h1>
</body>
</html>
```

> window 객체 - window 객체는 BOM에서 최상위 객체로서 웹 브라우저 윈도우를 나타내고 있다. 모든 전역 자바스크립트 객체, 함수, 변수는 자동적으로 window 객체의 맴버가 된다. 즉 alert("Hello World!") ; 는 window.alert("Hello World!");와 동일하다.
>
> 형식> window.open(URL, name, specs,replace);
>
> URL - 오픈할 페이지의 URL
>
> name - 타겟을 지정하거나 윈도우의 이름 (_blank, _parent, _self, _top,name)
>
> specs - 여러 가지 속성 (height, width,left,top,menubar,resizable,scrollbars,titlebar)
>
> replace - 히스토리 리스트에서 새로운 엔트리인지 아니면 현재 엔트리를 대체하는 여부 (true, false)

 

- 클릭시 새로운 창 띄우기

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
function go(){
	var url = 'j1.html';
	var newWindow = window.open(url,'',resize=1,scrollbar = 1,status=1);//브라우저 띄우
	newWindow.moveTo(0,0);//전체 화면으로 설정 (1)
	newWindow.resizeTo(screen.availWidth,screen.availHeight);//전체 화면으로 설정 (2)
};

function go2(){
   var c = confirm('Are you Go to..?');//확인 문자
   if(c ==true){// ok 하면
	   location.href = 'j1.html';//j1.html 이동
   }

};

</script>
</head>
<body>
<a href="#" onclick="go();">Click</a>
<a href="#" onclick="go2();">Click</a>
</body>
</html>
```

> screen 객체

| 속성        | 설명                                                   |
| ----------- | ------------------------------------------------------ |
| availHeight | 화면의 높이를 반환(윈도우에서 태스크 바를 제외한 영역) |
| availWidth  | 화면의 너비를 반환(윈도우에서 테스크 바를 제외한 영역) |
| colorDepth  | 컬러 팔레트의 비트 깊이를 반환                         |
| height      | 화면의 전체 높이를 반환                                |
| pixelDepth  | 화면의 컬러 해상도(bits per pixel)를 반환              |
| width       | 화면의 전체 너비를 반환                                |

