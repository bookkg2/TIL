### JAVASCRIPT

- 객체 생성 및 사용

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
var Car = {//Car는 object
	name:'k1',
	size:1000,
	go:function(){

		return this.name + 'Go';//this 객체 안에서 사용 
	},
	stop:function(){
		return this.name + 'Stop';//this 객체 안에서 사용 
	}

};//;무조건 찍으시오.
</script>
</head>
<body>

</body>
</html>
```

- 각각의 객체를 만들어서 가져오기(함수 이름이 같을 때 )

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script>
var Sk = {
	data:10,
	a:function(){alert('sk');}
};
var Hb = {
		data:20,
		a:function(){alert('sk');}
};

Sk.a();

</script>
</head>
<body>

</body>
</html>
```

