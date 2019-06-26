### HTML5 웹 스토리지

- 웹 페이지를 요즘은 웹앱이라고 한다. 즉 웹페이지를 애플리케이션처럼 사용할 수 있다는 것이다. 애플리케이션은 클라이언트  컴퓨터에  무엇인가를저장할 필요가 가끔은 있다. 이전에는 쿠키로 해결하였다. 하지만 HTML5는 스토리지를 제공한다.(쿠키보다 안전하고 속도가 빠르다. 쿠니는 서버로 요청할 때마다 매전 HTTP 요청 헤더에 붙여서 전송)
- localStorage :  만료 날짜가 없는 데이터를 저장한다. 브라우저가 닫힐 때, 삭제되지 않으면 1년동안이라도 사용할 수 있다.
- sessionStorage : 각 세션마다 데이터가 별도로 저장한다. 해당 세션이 종료 되면 데이터가 사라진다.

>   팁 : 브라우저에서 -> F12 누르고 -> Application 에서 ->localStorage, sessionStorage  확인 

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
	$('button').eq(0).click(function(){
		sessionStorage.m = 'sid01';//sessionStorage에 id01로 저장(입력 출력 둘다 똑같이)
	});
	$('button').eq(1).click(function(){
		localStorage.m = 'lid01';
	});
});
</script>
</head>
<body>
<button>Session Storage</button>
<button>Local Storage</button>
</body>
</html>
```



### 웹 소켓

- 원래 웹은 클라이언트에서 데이터를 전송하라고 요청하시만 '웹 소켓'은 서버에서 클라이언트에서 실시간으로 변동된 데이터를 보낸다. Ex) 주식, 메일알림 등등

```html
var Socket = new WebSocket(url,[protocal]);
```



### 이미지 Drop해서 담고 빼기 

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
div{
	width:300px;
	height:80px;
	border: 1px solid red;
}
img{
	width: 50px;
	height: 50px;
}
</style>
<script>
function cartdrop(e){
	var count = 0 ;
	e.preventDefault();
	var src = e.dataTransfer.getData('m');//m 의 값을가져온다.
	//e.target.appendChild(document.getElementById(src)); //방법 1(javascript)
	$(e.target).append($('#'+src));//방법 2 (jquery)
	for(var i =0 ; i < src.length;i++){
		
		
		count++;
	}
	
	$('h4').text(count);
};
function mydrop(e){
	e.preventDefault();
	var src = e.dataTransfer.getData('m');//m 의 값을가져온다.
	//e.target.appendChild(document.getElementById(src)); //방법 1(javascript)
	$(e.target).append($('#'+src));//방법 2 (jquery)
};
function allowdrop(e){
	e.preventDefault();//잠시 막아둠
};
function mydrag(e){
	e.dataTransfer.effectAllowed = 'move';
	e.dataTransfer.setData('m',e.target.id);//m 이라는 이름으로 해당 아이디를 저장하겠다.
};
</script>
</head>
<body>
<h1>Drag and Drop</h1>
<h3>Item</h3>
<div ondrop="mydrop(event)" ondragover="allowdrop(event)"><!--div은 drop을 허용 mydrop 이벤트가 발생한다.,ondragover 발생하면 allowdrop 이벤트 발생-->
	<img src="1.jpg" id="m1" draggable="true" ondragstart="mydrag(event)"><!--이미지는 drag를 할 수 있다.-->
	<img src="2.jpg" id="m1" draggable="true" ondragstart="mydrag(event)">
<img src="3.jpg" id="m1" draggable="true" ondragstart="mydrag(event)">
<img src="4.jpg" id="m1" draggable="true" ondragstart="mydrag(event)">
<img src="7.jpg" id="m1" draggable="true" ondragstart="mydrag(event)">

</div>
<h3>Cart</h3>
<div ondrop="cartdrop(event)" ondragover="allowdrop(event)">

</div>

<h4></h4>
</body>
</html>
```

- DROP 해서 담긴 이미지 개수 표시 

```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<style>
		div {
			width: 300px;
			height: 80px;
			border: 1px solid red;
		}

		img {
			width: 50px;
			height: 50px;
		}
	</style>
	<script>
		sessionStorage.cnt = 0;
		function itemdrop(e) {
			var src = e.dataTransfer.getData('m'); // 현재 드래그한 정보를 가져온다., src 에 m1이 들어옴(즉 밑에 imgdrag 아이디를 받아옴) 
			$('#item').append($('#' + src));
		};
		function itemleave(e) { };
var cnt = 0;
		function cartdrop(e) {
			var src = e.dataTransfer.getData('m'); // 현재 드래그한 정보를 가져온다., src 에 m1이 들어옴(즉 밑에 imgdrag 아이디를 받아옴) 
			$('#cart').append($('#' + src));
			if(sessionStorage.cnt == null || sessionStorage.cnt == 0){
				sessionStorage.cnt = 1;
				cnt ++;
				$('span').text(sessionStorage.cnt);
			}else{
				var cnt = ++sessionStorage.cnt;
				$('span').text(cnt);
			};
		};
		function cartleave(e) { };

		function imgdrag(e) {
			e.dataTransfer.effectAllowed = 'move';
			e.dataTransfer.setData('m', e.target.id);// 드래그 하는 순간 ID가 m으로 셋팅
		};

		function allowdrop(e) {
			e.preventDefault();//잠시 막아둠
		};
	</script>
</head>

<body>
	<h1>ITEM</h1>
	<div id="item" ondrop="itemdrop(event)" ondragleave="itemleave(event)" ondragover="allowdrop(event)">
		
		<img src="1.jpg" id="m1" draggable="true" ondragstart="imgdrag(event)">
		<!-- draggable : 이 이미지는 drag가 가능  ondragstart: 드래그가 시작하면 해당이벤트 발생-->
		<img src="2.jpg" id="m2" draggable="true" ondragstart="imgdrag(event)">
		<img src="3.jpg" id="m3" draggable="true" ondragstart="imgdrag(event)">
		<img src="4.jpg" id="m4" draggable="true" ondragstart="imgdrag(event)">
		<img src="7.jpg" id="m5" draggable="true" ondragstart="imgdrag(event)">
	</div>
	<!--ondrop : 이영역 안으로는 무언가가들어 올것이다. ondragleave : 이영역에서 나갈거에요-->

	<h1>CART</h1>
	<span></span>
	<div id="cart" ondrop="cartdrop(event)" ondragover="allowdrop(event)"></div>
	<!--ondragover : 써야 drop을 허용-->
</body>

</html>
```

### 다음 맵 API 가져와서 위치 표시

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c05e9aad8060ae069964ae20f9805bd1"></script>
<style>
#map{
	width:300px;
	height:300px;
	border: 1px solid red;
}
</style>
<script>
$(document).ready(function(){
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new daum.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
});
</script>
</head>
<body>
	<button>Italia</button>
<div id ="map"></div><!--지도를 뿌리려면 id와 width 와 height가 존재해야함-->
</body>
</html>
```

- 다음 맵 API 가져와서 위치(경도,위도) 잡고 클리시 다른 곳으로 이동

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c05e9aad8060ae069964ae20f9805bd1"></script>
<style>
#map{
	width:300px;
	height:300px;
	border: 1px solid red;
}
</style>
<script>
$(document).ready(function(){
	var center = new daum.maps.LatLng(34.852936, 128.432139);
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	
	var options = { //지도를 생성할 때 필요한 기본 옵션
	center: center, //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴

$('button').click(function(){
	var center = new daum.maps.LatLng(37.543337, 127.099687);
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	
	var options = { //지도를 생성할 때 필요한 기본 옵션
	center: center, //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
});

 
});
</script>
</head>
<body>
	<button>myhome</button>
<div id ="map"></div><!--지도를 뿌리려면 id와 width 와 height가 존재해야함-->
</body>
</html>
```

