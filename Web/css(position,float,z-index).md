### ID 속성(position,float,z-index)

```html
<!DOCTYPE html>
<html>
<head>

<meta charset="EUC-KR">
<style>
#out{

 border:1px solid black;
 width:200px;
 height:200px;
 /*overflow: hidden; 오버플로우가나면 없애라 !*/
 /*overflow: scroll; 오버플로우가나면 스크롤 기능으로  !*/
  overflow: auto; /*오버플로우가나면 위아래를 알아서 처리 기능으로  !*/
 

}

#d1,#d2,#d3{
   
	width:100px;
	height:100px;
	/* float: left; 좌정렬 float : 무언가를 정렬 시킬 때 */
	opacity: 0.8; /*화면의 투명도 0이면 안보임:0에서 10까지 (예-영화결제할때 0이였다가 결제 하면 1로 바뀐다.)*/
}

#d1{
/* position: absolute; */
background: red; /* static positioning(정적 위치 설정)-디폴트 속성 */
z-index:100; /* 화면의위치 바꿈 - 숫자는 의미 없다.(높은 숫자가 우선순위로 위로나타남)*/

}

#d2{

background: blue;
/* position: absolute; */
/*  position: relative;  relative positioning(상대위치 설정),위에 있는 것을 기준으로 ~~ */ 
/* position: absolute; absolute positioning(절대 위치 설정) -자신을 포함하는 body 가 기준 */
/* position: fixed; /* fixed positioning(고정 위치 설정) - 어느 한 지점에 고정 */
/*left:50px; 상대 왼쪽 위치 설정 */
/*top:50px;  상대 위 위치 설정 */ 
/* left :30px;
top: 30px; */
z-index:10;


}

#d3{
background: green;
/* position: absolute; */
left:60px;
top:60px;
}

</style>
<title>Insert title here</title>
</head>
<body>
<div id="out">
<div id= "d1">div1</div><!-- div은 h랑 다르게 바깥쪽 여백이 없다.-->
<div id= "d2">div2</div>
<div id= "d3">div3</div>
</div>
<img src="bg.jpg">
</body>
</html>
```

### 

