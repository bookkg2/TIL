### JAVASCRIPT(2)

- 함수 사용 -FUNCTION  함수명(){}; (1)일반함수 (2)return (3)전역변수

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
	
function a(c,d){//var c 하게 되면 var 까지고 argument로 인식 그래서 var빼고 c 

	alert(c+d);

};
var b = function(){
 alert('b');


};
/*function a(){

	alert('aaa');

};*/
a(10,100);
</script>
</head>
<body>
<button onclick="a('A','B');">Click</button><!--방법 2-->
</body>
</html>
```

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
	
function a(c,d){//var c 하게 되면 var 까지고 argument로 인식 그래서 var빼고 c 

	alert(c+d);

};
var b = function(){
 return 100;


};
/*function a(){

	alert('aaa');

};*/
var num = b();//return값 호출
alert(num);
</script>
</head>
<body>
<button onclick="a('A','B');">Click</button><!--방법 2-->
</body>
</html>
```

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
	var g =200;//전역 변수
function a(c,d){//var c 하게 되면 var 까지고 argument로 인식 그래서 var빼고 c 

	alert(c+d);

};
var b = function(){
	var i = 100;//local 변수
 return g * i;


};
/*function a(){

	alert('aaa');

};*/
var num = b();
alert(num);
</script>
</head>
<body>
<button onclick="a('A','B');">Click</button><!--방법 2-->
</body>
</html>
```

- 함수 (2) - 함수안에 함수 argument, Inteval

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
function a(i){
return 10*i;
};

function b(){
alert('hi');
return 20;
};

function c(i,j){
	var result = i(2) + j();
	return result;

};

//var data = c(a,b);함수를 넣을 때는 변수로,즉 함수에 argument를 넣고 싶으면c에들어가서 해당 a에 넣는다.
var data = c(a,function(){

  return 500;

});//이렇게도가능(어나미머스 함수를 넣어서 리턴하고 계산 가능)
//alert(data);

//setInterval(b,3000);

var f1 = function(){//함수는 함수를 return 할 수 있다.
	return function(i){
		return 100 *i;

	};


};

var f2 = f1();//f2는 함수가 된다.
var result = f2(2);
alert(result);
</script>
</head>
<body>

</body>
</html>
```

- prompt ()

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
var c = prompt('Input your name ...', 'James')//James는 default 값 
</script>
</head>
<body>

</body>
</html>
```

- 현재 시간을 출력 하고 싶을 때

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
var t =function(){
	var time = document.getElementById('time');


	var result = '';
	var date = new Date();
	result = date.toLocaleTimeString();
	time.innerHTML = result;
};
setInterval(t,1000);

</script>
</head>
<body>
<h1 id ="time"></h1>
</body>
</html>
```

- 에러 검출 (try -catch)

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>

var c = null;
try{
c = new Daate();
}catch(error){

  alert('Network Error...');
}

alert(c);
</script>
</head>
<body>
<h1>Exception</h1>
</body>
</html>
```

- DOM(Document Object Model) - 문서 객체 모델 (html, xml,word,hwp 등)
- BOM(Browser Object Model)- 브라우저에 사용 되는 다양한 객체
- 값을 받아오고 다시 그값을 뿌려준다.(id를 가지고)

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
function c1(){
	var h1=document.getElementById('h1').innerText;//text값을 가져온다. 보낼 때도 같다.

	document.getElementById('h1').innerText = h1 + 'ADD TEXT';
	
	var id= document.getElementById('id').value;
	
	document.getElementById('id').value = id+'ADD ID';
};
</script>
</head>
<body>
<h1 id="h1">Header</h1>
ID<input id="id" type="text" name="id">
<button onclick="c1();">Click1</button><!-- 클릭하면 c1의 함수 호-->
</body>
</html>
```

- form 에서 값을 가져 오는 방법

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
function add(){
	var id = document.myform.id.value;
};
</script>
</head>
<body>
	<form name = "myform">
		ID<input type="text" name = "id"><br>

		<input type="button" value="ADD" onclick="add();">


	</form>

</body>
</html>
```

- checkbox 선택 알려 주기 (checked)

```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style></style>
	<script>
		function add() {
			var checked = 0;
			var id = document.myform.id.value;
			var prt = "";

			var hobby = document.myform.hobby;
			for (var i = 0; i < hobby.length; i++) {
				if (hobby[i].checked == true) {
					prt = prt + hobby[i].value;

					checked++;

				} else if (checked == 0) {
				alert("선택 해주세요!!");
				return;
				
			     }
				
			}
			alert(prt);
		
			


		};
	</script>
</head>

<body>
	<form name="myform">
		ID<input type="text" name="id"><br>
		STUDY
		<input type="checkbox" name="hobby" value="s">
		MUSIC
		<input type="checkbox" name="hobby" value="m">
		TRAINING
		<input type="checkbox" name="hobby" value="t">
		<br>
		<input type="button" value="ADD" onclick="add();">


	</form>

</body>

</html>
```

