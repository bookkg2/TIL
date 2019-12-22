### jQuery

- 일종의 자바스크립트 라이브러리 -  존 레식(John Resig)가 BarCamp NYC에서 발표하였다.
- 특징
  - HTML 문서에서 특정 요소를 쉽게 찾을 수 있다.
  - HTML 콘텐츠를 쉽게 변경할 수 있다.
  - 이벤트를 쉽게처리할 수 있다.
  - 페이지 상의 콘테츠를 쉽게 애니메이트할 수 있다.
  - 네트워크를 통하여 새로운 콘테츠를 쉽게 가져올 수 있다.(Ajax,JSON)
  - 브라우저의 종류나 브라우저의 버전을 따질 필요가 없다. 모든 차이점은 jQuery안에서 해결한다. 

- import 방법(1) - 네트워크를 통한 google cdn 방식

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>

</script>
</head>
<body>

</body>
</html>
```

- import 방법(2) - 자체 서버에 다운 받고 가져오는 방식

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src ="jquery/jquery.min.js"><!--파일을 해당 exploer에 설차하고-->

</script> 



<style></style>
<script>
window.onload =function(){//페이지가 로딩되자 마자 스크립트실행
	$('h1').text('ok');//h1을 가져다가 ok 쓸거야 
};
</script>
</head>
<body>
<h1>Header1</h1>
</body>
</html>
```

- jquery 의 selector

````html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
$(document).ready(function(){
	 $('h1').text('-----');//$(selector).action();,h1 text를 가져와라
	 $('#hh').html('<a href="">Click</a>');
	 $('.ch').text('Class');
	 $('input[type = "text"]').css('background','gray');
	 $('input[name = "pwd"]').css(
		 {'color' : 'red', 'background' : 'blue'}
	 );//여러개를 넣을 때는 jSON object 사용

	 
});//문서가 준비 되면 실행해라
</script>
</head>
<body>
<h1>Header1</h1>
<h1 id = "hh">Header1</h1>
<h1>Header1</h1>
<h1 class = "ch">Header1</h1>
<input type = "text" name = "id"><br>
<input type = "password" name = "pwd"><br>
</body>
</html>
````

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
$(document).ready(function(){//문서가 준비되면 함수 호출
	//$('h1').eq(0).css('color','red');//첫번째 만 해당 되도록
	//$('h1:eq(0)').css('color','red');//첫번째 만 해당 되도록
	$('h1:not(h1:eq(3))').css('color','red');//나빼고 다
	//$('h1:first').css('color','red');//첫번째 만 해당 되도록
	//$('h1:first-child()').css('color','red');//첫번째 자식 만 해당 되도록
	//$('h1:nth-child(2n)').css('color','red');//짝수번째 자식들만
})
</script>
</head>
<body>
<h1>Header1</h1>
<h1>Header2</h1>
<h1>Header3</h1>
<h1>Header4</h1>
<h1>Header5</h1>

</body>
</html>
```

- table 꾸미기(Selector)

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
$(document).ready(function(){
	$('table>thead').css('color','red');
	$('table').css(
	{width :400, border:'1px solid black'}

	);

	$('table >tbody').css(
		'text-align' , 'center'
	);

	$("table>tbody>tr:even").css("background-color", "yellow");
	$("table>thead>tr").css('background', 'blue'
	
	);
});
</script>
</head>
<body>
	<h1>Table</h1>
<table>
	<thead>
		<tr><th>ID</th><th>NAME</th></tr>

	</thead>
	<tbody>
		<tr><td>id01</td><td>James</td></tr>
		<tr><td>id02</td><td>James</td></tr>
		<tr><td>id03</td><td>James</td></tr>
		<tr><td>id04</td><td>James</td></tr>
		<tr><td>id05</td><td>James</td></tr>

	</tbody>

</table>

</body>
</html>
```

- Click 및 마우스 이벤트 

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
$(document).ready(function(){
	$('a:first').click(function(){//a에 클릭이 일어나면 함수 실행
		$('button').hide();
	});

	$('a:last').click(function(){//a에 클릭이 일어나면 함수 실행
		$('button').show();
	});
	//$('a').mouseenter(); //a에 마우스가 들어오면,mouseleave :마우스가 나가면 - 둘을 합친것이 hover
	$('a').hover(function(){//마우스가 들어오면
		$('h1').text('Mouse Enter');
	},function(){//마우스가 나가면
		$('h1').text('Mouse Leave');
	});
});
</script>
</head>
<body>
<h1></h1>
<a href="#">Hide</a><br>
<a href="#">Show</a><br>

<button>Click</button>
<button>Click</button>
<button>Click</button>
<button>Click</button>

</body>
</html>
```

- INPUT 이벤트

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
$(document).ready(function(){
	$('a:first').click(function(){//a에 클릭이 일어나면 함수 실행
		$('button').hide();
	});

	$('a:last').click(function(){//a에 클릭이 일어나면 함수 실행
		$('button').show();
	});
	//$('a').mouseenter(); //a에 마우스가 들어오면,mouseleave :마우스가 나가면 - 둘을 합친것이 hover
	$('a').hover(function(){//마우스가 들어오면
		$('h1').text('Mouse Enter');
	},function(){//마우스가 나가면
		$('h1').text('Mouse Leave');
	});

	//Input 이벤트
	$('input').on(//여러개의 함수를 넣고 싶을 때는 object 사용(on)
		{
			focus:function(){
				$(this).css('background','gray')//this :input
			},
			keyup:function(){
				alert($(this).val());//입력한 값을 alert으로 뛰운다
			},
			blur:function(){//나갈 때
				$(this).css('background','white');
			}
		}
	);
});
</script>
</head>
<body>
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
<h1></h1>
<a href="#">Hide</a><br>
<a href="#">Show</a><br>

<button>Click</button>
<button>Click</button>
<button>Click</button>
<button>Click</button>

</body>
</html>
```

- 간단한 회원가입 기능 form 활용(ID에 속성 및 조건, 다른 속성들 효과, a : submit 기능 )

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
$(document).ready(function(){
	$('a').click(function(){
		var id = $('#rf>input[name="id"]').val();
		var pwd = $('#rf>input[name="pwd"]').val();
		var name = $('#rf>input[name="name"]').val();
		var c =confirm('Are you ok?');
		if(c == true){
			$('#rf').attr('method','get');//GET 방식으로 보냄
			$('#rf').attr('action','a.jsp');
			$('#rf').submit();//submit은 그냥 날리는 거(스크립에 alert창을 안띄우고 보)
		}

		//alert(id + pwd + name);
	});

	//아이디 영역에 조건(3보다 작으면 alert 창)
	$('#rf >input[name = "id"]').blur(function(){
		var id = $('#rf>input[name="id"]').val();
		if(id.length < 3){
			alert("아이디 길이가 너무 작습니다.");
		}

	}//blur은 입력하고 나갈때 조건
		
	);
});//end onload
</script>
</head>
<body>
<h1>Register</h1>
<form id="rf"><!--전체 form을 잡아준다.-->
	ID<input type="text" name="id"><br>
	PWD<input type="password" name="pwd"><br>
	NAME<input type="text" name="name"><br>
	<a href="#">REGISTER</a>

</form>

</body>
</html>
```

- 이미지 이벤트 

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
$(document).ready(function(){
	//$('img').css('display','none'); // 화면에 숨김
	$('img').css('position','relative');
	$('button').click(function(){//Input이 아닌 단순 button 사용
		$('img').animate({
			left : '300px',//왼쪽으로 
			opacity:'0.5', //뿌려지게
			width:'100px'//작아지게
		});
	});
	/*$('button').click(function(){
		//$('img').show('slow');//button이 클릭되면 천천히 등장
		$('img').toggle();//button이 클릭되면 천천히 등장 하고 다시누르면 사라짐.
	});*/
});
</script>
</head>
<body>
<button>Click</button><br>
<img src="img01.jpg">
</body>
</html>
```

