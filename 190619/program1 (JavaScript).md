### 계산기 프로그램(JAVASCRIPT)

```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		h1 {
			font-size: 11px;
		}

		div {
			width: 500px;
			border: 1px solid black;
		}

		.button1 {
			width: 162px;
			height: 30pt;
			border-radius: 10px;
			background: #81F7F3;
		}

		.button2 {
			width: 37px;
			height: 30pt;
			border-radius: 10px;
			background: #81F7F3;
		}

		.button3 {
			width: 37px;
			height: 30pt;
			border-radius: 10px;
			background: #FE2E2E;
		}

		.button4 {
			width: 37px;
			height: 70pt;
			border-radius: 10px;
			background: #FE2E2E;
		}
	</style>
	<script>
		function getnum(value) {
			this.value = document.getElementById('num').value;
			display.innerHTML += value;

		};

		function getplus(i) {
			var result = eval(display.innerHTML);
			display.innerHTML = result;


		};
		
		function getreset(){
			
			display.innerHTML = " ";
		}

	

	</script>
</head>

<body>


	<div>



		<table>

			<tr>
				<td colspan="4">
					<h1 id="display"></h1>
				</td>
			</tr>

			<tr>
				<td colspan="4"><input onclick="getreset();" class="button1" type="button" value="C"></td>
			</tr>

			<tr>
				<td>

					<input onclick="getnum(this.value)" id = "num" class="button2" type="button" value="+">
				</td>
				<td>
					<input onclick="getnum(this.value)" id = "num" class="button2" type="button" value="-">

				</td>
				<td>
					<input onclick="getnum(this.value)" id = "num" class="button2" type="button" value="x">

				</td>
				<td>
					<input onclick="getnum(this.value)" id = "num" class="button2" type="button" value="/">
				</td>


			</tr>

			<tr>
				<td>

					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="1">
				</td>
				<td>
					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="2">

				</td>
				<td>
					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="3">

				</td>
				<td>
					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="0">
				</td>


			</tr>

			<tr>
				<td>

					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="4">
				</td>
				<td>
					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="5">

				</td>
				<td>
					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="6">

				</td>
				<td rowspan="2">
					<input onclick="getplus(this.value);" class="button4" type="button" value="=">

				</td>



			</tr>

			</tr>

			<tr>
				<td>

					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="7">
				</td>
				<td>
					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="8">

				</td>
				<td>
					<input onclick="getnum(this.value);" id="num" class="button3" type="button" value="9">

				</td>



			</tr>

		</table>

	</div>









</body>

</html>
```

- 자판기 프로그램(JAVASCRIPT)

```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		h1 {
			display: inline;
			font-size: 20px;
		}

		#button1 {

			margin: auto;

			width: 50%;
		}
	</style>
	<script>
		  var checked = 0;
		
		  var prt = "";
		  var money="";
	
			
		function result(){
			var bvg = document.myform.bvg;
			var money = document.myform.money.value;
			for(var i = 0; i < bvg.length;i++){
			if (bvg[i].checked == true) {
					prt = prt + bvg[i].value;

					checked++;

				} else if (checked == 0) {
				alert("선택 해주세요!!");
				return;
				
				 }

			

				 
		  displayy.innerHTML = prt;
		  displaya.innerHTML = money; 
		}
		};

		

		
		
	</script>
</head>

<body>
	<form name="myform">
		<table>
			<tr>
				<td>
					포카리 <input type="checkbox" name="bvg" value="포카리">
					게토레이 <input type="checkbox" name="bvg" value="게토레이">
					2% <input type="checkbox" name="bvg" value="2%">

				</td>
			</tr>
			<tr>

				<td>
					<h1>지불방법</h1>
					<select name="money">

						<option value="">결제방법</option>
						<option value="card">카드</option>
						<option value="cash">현금</option>

					</select>

				</td>
			</tr>

			<tr>
				<td>
					<input onclick ="result();" id="button1" type="button" value="선택">
				</td>


			</tr>
			<tr>
				<td>
					<h1 id = "displayy"></h1>

				</td>
			</tr>

			<tr>
				<td>
					<h1 id = "displaya"></h1>

				</td>
			</tr>







		</table>



	</form>
</body>

</html>
```

