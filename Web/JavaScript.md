### JavaScript

1. 기존의 정적인 웹페이지를 동적 웹페이지로 작동하기 위해서 사용한다.(프로그래밍 언어)

2. 웹의 표준 프로그래밍 언어이고 브라우저에서 도는 것이다.

   

   자바 vs 자바스크립트

   | 특징      | 자바언어                                        | 자바스크립트                                                 |
   | --------- | ----------------------------------------------- | ------------------------------------------------------------ |
   | 언어 종류 | 소스 파일을 컴파일하여 실행하는 컴파일언어이다. | 브라우저가 소스 코드를 직접 해석하여 실행하는 인터프리터 언어이다 |
   | 실행 방식 | 자바 가상 기계 위에서 실행한다.                 | 브라우저 위에서 실행된다.                                    |
   | 작성위치  | 별도의 소스 파일에 작성                         | HTML 파일 안에 삽입 기능                                     |
   | 변수 선언 | 변수의 타입을 반드시 선언                       | 변수의 타입을 선언하지 않아도 사용가능                       |

3. 역사 : 넷스케이프의 브렌든 아이크(Brendan Eich)가 개발한 것으로 처음에는 라이브스크립트(LiveScript)라는 이름에서 시작

4. ECMA(European Computer Manufacturer's Association)이 ECMAScript라는 이름으로 표준을 제정하였다.





- 내부 자바스크립트- head 안에 만들기

  ```javascript
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  <style></style>
  
  <script>
  alert('1');// 페이지 들어가자마자 나오는 alert 창 
  alert('2');
  alert('3');
  
  setInterval(function(){
  	var now = new Date();
  	document.write(now); //body와 body 사이에 뿌려라(현재 날짜) 
  	
  },1000); //이름없는 함수 -어나미머스  , 1초에 한번씩 함수를 동작하여라
  </script>
  </head>
  <body>
  		<h1>JavaScript Test</h1>
  </body>
  </html>
  ```

  

- 외부 자바 스크립트 - 다른 JS 파일을 만들고 가져와서 동작
  - j1.js

```javascript
/**
 * 2019.06.18
 */

alert('1'); 페이지 들어가자마자 나오는 alert 창 
alert('2');
alert('3');

setInterval(function(){
	var now = new Date();
	document.write(now); //body와 body 사이에 뿌려라(현재 날짜) 
	
},1000); //이름없는 함수 -어나미머스  , 1초에 한번씩 함수를 동작하여라
```

​         - j1.html

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script src ="j1.js"></script> 
<script> </script>
</head>
<body>
		<h1>JavaScript Test</h1>
</body>
</html>
```

- 내부 자바 스크립트- body와 body 사이에서

  ```javascript
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  <style></style>
  
  <script> </script>
  </head>
  <body>
  		<h1 onclick="alert('ok');">JavaScript Test</h1>
  </body>
  </html>
  ```

  

- 해당 변수의 타입을 알고 싶을 때

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script>
//1.number
var v1 =10;
var v2 =10.1;
//2.boolean
var v3= true;
//3.string
var v4 ='abc';
var v5 ="abc";
var v6 ='"abc"'; // "abc" 가 String이다. "'abc'" 도 가능 

//4.object
var v7 = {};//변수와 함수로 되어있는 object

//5.function
var v8= function(){};

//6.array-object으로 나옴
var v9 = [1,2,3,'a'];


//7.undifined
var v10;

//8.null -object으로 나옴 
var v11 = null;


alert(typeof(v11)); //파일의 타입을 알고 싶을 때, 정수,실수 구분 X - number
</script>
</head>
<body>

</body>
</html>
```

- 자바스크립트 object 생성

```javascript
//Javascript object
//JSON(Javascript Object Notation)
var v7 = {
		name :'k1',size:1000,go:function(){}, stop:function(){}
		
		
};
```

- 연산자 (String과 number 계산할 때 주의)

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script>
var a =10;
var b = '20';

alert(a+b);//string이 있으니 출력 = 1020으로나옴
alert(a*b);//더하기 이외의 연산은 가능 출력=200으로 나옴
</script>
</head>
<body>

</body>
</html>
```

- 숫자와 문자열 사이의 변환
  - parseInt() - 문자열을 숫자로 변환
  - String() - 숫자를 문자열로 변환한다.

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script>
var a =10;
var b = '20';

alert(a+b);//string이 있으니 출력 = 1020으로나옴
alert(a*b);//더하기 이외의 연산은 가능 출력=200으로 나옴
alert(a+parseInt(b));
alert(String(a));
</script>
</head>
<body>

</body>
</html>
```

- prompt() 함수 -사용자에게 어떤 사항을 알려주고 사용자가 답변을 입력 할 수 있는 윈도우를 화면에 띄운다. 사용자가 입력한 내용을 문자열로 반환한다.

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script>
var p1 = prompt('Input Nuber1..?');//모든 프로그램에서 입력한 값은 String
var p2 = prompt('Input Nuber2..?');
var result = parseInt(p1) + parseInt(p2);//var result = Number(p1) + Number(p2); 도 가능
console.log(result); //콘솔창(F12)에 결과값 보고 싶을 때 사용자 한테는 안보임 !!
/* alert(result); */

</script>
</head>
<body>
<h1> Result:</h1>

</body>
</html>
```

- 값을 받아와서 계산 하고 출력 하는 방법

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>


</style>
<script>
function calc(){
	var num1 = document.getElementById('n1').value; /* value은 값을 가져온다. */
    var num2 = document.getElementById('n2').value;
    var sum = Number(num1) + Number(num2);/*  타입을 NUMBER로 해서 계산 */
    var r= document.getElementById('result');
    var rr= document.getElementById('rr');
    r.style.color = 'red'; /* 결과의 색을 바꾸고 싶을 때 */
    r.innerHTML=  sum ; /* 페이지에 결과 출력 */
    rr.value = sum; /* rr 안에 결과 출력 */
    
};
</script>
</head>
<body>
<form>
NUMBER1<input type = "number" id ="n1"><br><!-- name은 서버로 전송하기 위하여 씀,id는 script로 전송 -->
NUMBER2<input type = "number" id ="n2"><br>
<!-- Result<input type = "number" id="rr"><br> -->
Result<input readonly = "readonly" type = "number" id="rr"><br> <!-- readonly결과값 수정 X -->
<input type ="button" value="Calc" onclick="calc();"> <!--  누르면 calc라는 자바스크립트를 호출하여라 -->

</form>
<h1 id="result"></h1>


</body>
</html>
```

- 결과 값이 NaN 이면 0으로 찍어라

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>


</style>
<script>
function calc(){
	var num1 = document.getElementById('n1').value; /* value은 값을 가져온다. */
    var num2 = document.getElementById('n2').value;
    var sum = Number(num1) + Number(num2);/*  타입을 NUMBER로 해서 계산 */
    var r= document.getElementById('result');
    var rr= document.getElementById('rr');
    r.style.color = 'red'; /* 결과의 색을 바꾸고 싶을 때 */
    if(isNaN(sum)){
    	 r.innerHTML= 0 ; /* 페이지에 결과 출력 */
   	
   }else{
	   r.innerHTML=  sum ; /* 페이지에 결과 출력 */
	   
   }
   
    rr.value = sum; /* rr 안에 결과 출력 */
   
   
    
};
</script>
</head>
<body>
<form>
NUMBER1<input type = "text" id ="n1"><br><!-- name은 서버로 전송하기 위하여 씀,id는 script로 전송 -->
NUMBER2<input type = "text" id ="n2"><br>
<!-- Result<input type = "number" id="rr"><br> -->
Result<input readonly = "readonly" type = "number" id="rr"><br> <!-- readonly결과값 수정 X -->
<input type ="button" value="Calc" onclick="calc();"> <!--  누르면 calc라는 자바스크립트를 호출하여라 -->

</form>
<h1 id="result"></h1>


</body>
</html>
```

- 아이디랑 비밀번호 text 에다가 값이 없을 때의 속성 주는 법

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
input[type="text"]:focus{ /* select를 attribyte로 가져올 때는 [] */
 background: gray;/* 아이디 배경색 Gray */

}

</style>
<script>
function login(f){/* f:form 을 받아옴  */
	var id = f.id.value;
	var pwd = f.pwd.value;
	
	
	if(id == '' || id == null){//없으면 끝이니 else 쓸 필요 없음 
		alert('Madatory field !');//실행은 되나 밑으로 내려감 
		f.id.focus();// 해당 위치로 이동, id.focus();- 이건 값에다 focus
		return;//더 이상 밑으로 진행 X
	}
	if(pwd == '' || pwd == null){//없으면 끝이니 else 쓸 필요 없음 
		alert('Madatory field !');
	    f.pwd.focus();
		return;
	}
	//PWD가 4자리 이상이어야 함 
	if(pwd.length < 4){
		
		alert('Input 4 character');
		f.pwd.focus();
		return;
	}
	
	
	var c = confirm('Are you Login ?');
	if(c == true){
		
		f.submit();//로그인 한다고 승락하면 서버로 보낸다.
	}
	
};
</script>
</head>
<body>
<form action="Login" method="get"><!-- 서버Login에  get 방식으로 전송 -->
ID<input type="text" name= "id"><br>
PWD<input type="text" name= "pwd"><br><!--name: 서버에 전송 -->
<!-- <input type="submit" value="Login"> submit: 서버에 전송 -->
 <input onclick ="login(this.form);" type="button" value="Login"> 


</form>
</body>
</html>
```

- 조건 검사 프로젝트 (각각의 mandantory : 값이없을때는 경고 메세지, 비밀번호 확인 체크)

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
input[name="pwd2"]:focus{ /* select를 attribyte로 가져올 때는 [] */
 background: red;/* 아이디 배경색 Gray */

}
div {
	display: inline;
}

#h {
	font-size: 15px;
	color: red;
}

#h2 {
	font-size: 15px;
	color: blue;
}

#h3 {
	font-size: 15px;
	color: blue;
}
</style>
<script>
	function login(f) {

		var id = f.id.value;
		var pwd = f.pwd.value;
		var pwd2 = f.pwd2.value;
		var hint = f.hint.value;
		var train = f.train.value;
		var age = f.age.value;
		var h = document.getElementById('h');
		var h2 = document.getElementById('h2');
		var h3 = document.getElementById('h3');
	
		var h4 = document.getElementById('h4');
		var h5 = document.getElementById('h5');
		var h6 = document.getElementById('h6');

		if (id == '' || id == null) {

			h.innerHTML = "ID is Mandatory";
			return;

		}

		if (pwd == '' || pwd == null) {

			h2.innerHTML = "PWD is Mandatory";
			return;

		}

		if (pwd2 == '' || pwd2 == null) {

			h3.innerHTML = "PWD is Mandatory";
			return;

		}else if(pwd != pwd2){
			f.pwd2.focus();
			h3.innerHTML = "Check your password!";
			
			return;
		}
		

		if (hint == "") {

			h4.innerHTML = "HINT is Mandatory";
			return;
		}

		if (train == "") {

			h5.innerHTML = "RADIO is Mandatory";
			return;
		}

		if (age == "") {

			h6.innerHTML = "AGE is Mandatory";
			return;
		}

	}
</script>
</head>
<body>
	<form name="insertform" action="Login" method="get">
		ID &nbsp<input type="text" name="id">
		<div id="h"></div>
		<br> PWD &nbsp<input type="text" name="pwd">
		<div id="h2"></div>
		<br> PWD &nbsp<input type="text" name="pwd2">
		<div id="h3"></div>
		<br> HINT &nbsp<select name="hint">
			<option value="">hint</option>
			<option value="love">첫사랑</option>
			<option value="father">아버지</option>
			<option value="mother">어머니</option>
			<option value="friend">친구</option>

		</select>
		<div id="h4"></div>
		<br> HOBBY TRAIN &nbsp<input type="radio" name="train"
			value="TRAIN"> STUDY<input type="radio" name="train"
			value="STUDY"> MUSIC<input type="radio" name="train"
			value="MUSIC">
		<div id="h5"></div>
		<br> AGE &nbsp<input type="number" name="age">
		<div id="h6"></div>
		<br> <input onclick="login(this.form);" type="button"
			value="Login">
	</form>



</body>
</html>
```

- 숫자 맞추기 게임

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
h1{
 font-size: 50px;
}
h2{
 font-size: 20px;
 text-shadow: 10px 10px 10px black;	
}
.suc{ /* select를 attribyte로 가져올 때는 [] */
 background-image: url('sssss.JPG');

}


</style>
<script>
var num = Math.floor(Math.random() * 100) + 1;
var count = 0;
function guess(){

var result = "";
var number = document.getElementById("number").value;
count++;


 if(num == number){
	var timeset = "sssss.JPG";
	
	result = "성공입니다.";
	document.getElementById("event").setAttribute("src",timeset);
	
 }else if(num < number){
	 result = "낮습니다.";
 }else 
	 result = "높습니다.";
	 
 document.getElementById("hint").value = result;
 document.getElementById("count").value = count;
 return true;	 
	 
}
</script>
</head>
<body>
<h1>숫자 맞추기 게임</h1>
<h2>이 게임은 컴퓨터가 생성한 숫자를 맞추는 게임입니다. 숫자는 1부터 100 사이에 있습니다.</h2>
숫자 : &nbsp<input type= "number" id="number"> &nbsp <input onclick="guess();" type = "button" id="button1" value = "확인"><br>
추측횟수 : &nbsp<input type= "text" id="count"> 힌트 : &nbsp<input type= "text" id="hint"><br>
<img src ="" id="event"/>



</body>
</html>
```

