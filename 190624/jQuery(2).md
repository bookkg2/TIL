### jQuery

- textarea 범위 설정하고 카운트 하기 

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
	$('textarea').keyup(function(){//keyup는 마우스를 누르고 뗐을 때
		var str = $(this).val();//this : textarea
		$('h1').text(str.length);
		if(str.length >= 50){
			alert('max 50 character');
			$('h1').css('color', 'red');
		}
	});
});
</script>
</head>
<body>
<h1></h1>
<textarea cols = "50" rows= "10"></textarea><!--행열 크기 설정-->
</body>
</html>
```

- 스크롤 기능 내리면서 계속해서 이미지 나오게 하기

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
div{
	width:600px;
	border:3px solid red;
}
img{
	display: block; /*이미지 속성을 block으로*/
	margin: 10px 0;
	}

</style>
<script>
function getData(){
	for(var i =0;i<10;i++){
		var img = '<img src = "sp.jpg">';
		$('div').append(img);
	}
	$(window).scroll(function(){
		var scTop = $(window).scrollTop();//스크롤 위의 높이
		var docH = $(document).height();//문서 전체높이
	    var winH = $(window).height();//해당 img 높이
		console.log(docH + ' ' +winH+' ' + scTop);
		if(docH <= winH+scTop+30){//이미지 높이 + 스크롤 위의 높이 한것이 문서 높이와 비슷할 떄쯤 
			getData();
		}
	});
	var docH = $(document).height();//문서 전체높이
	var winH = $(window).height();//해당 img 높이
	console.log(docH + '' +winH);
	
};

$(document).ready(function(){
	getData();
});
</script>
</head>
<body>
<div></div>
</body>
</html>
```

