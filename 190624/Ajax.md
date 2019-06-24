### Ajax

- 서버와 데이터를 교환하는 기술의 하나이다.

- 비동기적으로 HTML 페이지를 업데이트할 수 있다.(Ex 실시간 검색 순위, 구글 맵 등)

- 즉 전체 페이지를 다시 적재하지 않고 웹 페이지의 일부를 업데이트 할 수 있다는 것을 의미한다.(새로 페이지를 로딩 할 필요없이 그 페이지 그대로 유지 된 상태로 데이터를 가져온다.(Asynchronous)
- 빠르고 동적인 대화형 웹페이지를 만드는 데 유용하다. 

$ 기존 방식-서버에서 form 데이터를 보내서 다시 html 파일을 받는다. 

   - 서버 측 프로그램 구축은 java Resources에 src(se) 에서 생성

     ```java
     package com.sds;
     
     import java.io.IOException;
     import javax.servlet.ServletException;
     import javax.servlet.annotation.WebServlet;
     import javax.servlet.http.HttpServlet;
     import javax.servlet.http.HttpServletRequest;
     import javax.servlet.http.HttpServletResponse;
     
     /**
      * Servlet implementation class LoginServlet
      */
     @WebServlet({ "/LoginServlet", "/login" })
     //만약 이 부분이 오류가 나면 project-> property -> java build path에서 라이브러리들 추가
     public class LoginServlet extends HttpServlet {
     	private static final long serialVersionUID = 1L;
     
     	
     	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     		//html에서submit 하면 자동으로 실행되는 부분
     		
     		System.out.println("LoginServlet Called..");
     		
     		String id = request.getParameter("id"); //html에서 name 이 id 인것을 가져와라
     		String pwd = request.getParameter("pwd"); //html에서 name 이 pwd 인것을 가져와라
     		
     		if(id.equals("aaa") && pwd.equals("111")) {//아이디랑 비번을 임의로 설정
     			response.sendRedirect("loginok.html");//loginok html 을 보냄(직접 구현 할 것!!)
     		}else {
     			response.sendRedirect("loginfail.html");
     		}
     		
     	}
     
     }
     
     ```

     

     -    html 코드 

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

	$('input[type = "button"]').click(function(){
		$('#login_form').attr('method','get');
		$('#login_form').attr('action','login');//login : 서버 프로그램 이름
		$('#login_form').submit();
	});
});
</script>
</head>
<body>
<h1>LOGIN</h1>
<form id = "login_form">
	ID<input type = "text" name ="id"><br>
	PWD<input type="password" name = "pwd"><br>
	<input type="button" value ="LOGIN">
</form>

</body>
</html>
```

- 유형 2 - 서버에 html 생성 하고 보내기

  - 서버 servlet 부분

  ```java
  package com.sds;
  
  import java.io.IOException;
  import java.io.Writer;
  
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  /**
   * Servlet implementation class Calc1Servlet
   */
  @WebServlet({ "/Calc1Servlet", "/calc1" })
  public class Calc1Servlet extends HttpServlet {
  	private static final long serialVersionUID = 1L;
  
  	
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String num1 = request.getParameter("num1");
  		String num2 = request.getParameter("num2");
  		int n1 = Integer.parseInt(num1);
  		int n2 = Integer.parseInt(num2);
  		int result = n1 + n2;//서버에서 계산
  		Writer out = response.getWriter();
  		out.write("<h1>" + result + "</h1>");//html을 서버에서 만들어서 보냄 
  		out.close();
  	
  	}
  
  }
  
  ```

  - html 부분

```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<style></style>
	<script>
		$(document).ready(function () {
			$('button').click(function () {
				
				$('#cf').attr('method','GET');
				$('#cf').attr('action','calc1');
				$('#cf').submit();

			});
		});
	</script>
</head>

<body>
	<form id="cf">
		NUM1<input type="number" name="num1"><br>
		NUM2<input type="number" name="num2"><br>
		<button>Calc</button>
	</form>
</body>

</html>
```



$ jQuery를 활용한 Ajax

- servlet(서버)

```java
package com.sds;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc1Servlet
 */
@WebServlet({ "/Calc1Servlet", "/calc1" })
public class Calc1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int result = n1 + n2;//서버에서 계산
		
		Writer out = resp.getWriter();
		out.write(result+"");//html이 아닌 값만 보내면 된다.
		out.close();
		super.doPost(req, resp);
	}
	
	

}
	
```

- html 부분 

```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<style></style>
	<script>
		function display(data){
			$('h1').text(data);//h1에 나타냄 (비동기화 : html없이바로 해당부분에 나타남 )
		};

		function sendData(n1,n2){
			var sur1 = 'calc1';
			$.ajax({
				url :sur1,
				method:"post", //post로 서버로 보냄 ,default 값은 get방식
				data:{"num1":n1,"num2":n2}, //데이터는 객체 
				success:function(result){
					//alert('[' +result+']');
					display(result);
				} //서버에서 받은 데이터 확인
			});//ajax : select가 필요 없는 함수 
		};

		$(document).ready(function () {
			$('button').click(function () {
				var num1 = $('input[name = "num1"]').val();

				var num2 = $('input[name = "num2"]').val();
				sendData(num1,num2); // 함수를 만들어서 서버로 전송


			});
		});
	</script>
</head>

<body>
	<h1></h1><!--서버의 결과를 받아서 나타내어 줄 부분-->
	
	NUM1<input type="number" name="num1"><br>
	NUM2<input type="number" name="num2"><br>
	<button>Calc</button>
	
</body>

</html>
```

- Ajax를 이용한 회원가입(feat.임의의 아이디를 주고 중복체크)
  - servlet(서버)

```java
package com.sds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//ID Check
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String result= "1";
		if(id.equals("aaaa")) {//가상의 있는 아이디 제공
			result = "0"; // 서버와 html 연결 되는 데이터는 String
		}
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		
	}

	//회원가입 부분
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		System.out.println(id + " " + pwd +" " + name);
		response.sendRedirect("registerok.html"); // 회원가입한 html을 보냄 (form 방식)
		
	}

}

```

​         -  html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
	function display(result){
		if(result == '1'){
			$('span').text('사용가능합니다.');
		}else{
			$('span').text('사용중입니다.');
		}


	}
	function checkId(id){
		$.ajax({
			url:'register', 
			data:{'id' :id},
			method:'get',
			success : function(result){
				//alert(result);
				display(result);
			}
		});
	};

$(document).ready(function(){

	$('input[type = "button"]').click(function(){
		//검증 가능
		$('#login_form').attr('method','post');
		$('#login_form').attr('action','register');//login : 서버 프로그램 이름
		$('#login_form').submit();//1바이트씩 내용을 가져오니 한글은 깨짐 
	});
	$('input[name = "id"]').keyup(function(){//입력할 때마나 서버에 보냄 (transaction)
		var id = $(this).val();
		checkId(id);
	});
});
</script>
</head>
<body>
<h1>LOGIN</h1>
<form id = "login_form">
	ID<input type = "text" name ="id"><span></span><br>
	PWD<input type="password" name = "pwd"><br>
	NAME<input type="text" name = "name"><br>
	<input type="button" value ="LOGIN">
</form>

</body>
</html>
```

- JSON 객체를 데이터를 받아와서 임의로 실시간 차트 만들기 (INTEVAL)

 -Servlet

```java
package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ChartServlet
 */
@WebServlet({ "/ChartServlet", "/chart" })
public class ChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//한글 안깨지게 
		PrintWriter out = response.getWriter();
		Random r = new Random();
		
		//make json data(jsom-simple-1,1,1.jar JSON 라이브러리 다운 받고 ->web 밑에 WEB-INF 밑에 lib에 넣기)
		JSONArray ja = new JSONArray();
		for(int i =0; i <10;i++) {
			int temp = r.nextInt(10)+1;
			JSONObject jo = new JSONObject();
			jo.put("rank", i+1);
			jo.put("keyword", "김서겸"+temp);
			if(temp%2 == 0) {
				jo.put("type", "up");
			}else {
				jo.put("type", "down");
			}
			
			
			jo.put("cnt", temp);
			ja.add(jo);
		}
		
		//and response client
		out.print(ja.toJSONString());
		out.close();
	}

}

```

-html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
div{
	
	width : 300px;
	border:2px solid red;
}
img{
	display: inline;
	width: 10px;
	height: 10px;
}
</style>
<script>
	/*서버에서 올 데이터 형태 (가상) - type : object
	[
		{"rank":1,"keyword":"김서겸", "type":"up","cnt":100},
		{"rank":2,"keyword":"java", "type":"down","cnt":1},
		{"rank":3,"keyword":"Ajax", "type":"down","cnt":2},
		{"rank":4,"keyword":"임지훈 잠", "type":"up","cnt":20},
		{"rank":5,"keyword":"승엽이 술", "type":"up","cnt":30}
	]
	*/
function display(data){
	$('div').empty();//비우고 다시
	$(data).each(function(index,item){
		var str = '';
		str += '<h3>';
		str += item.rank +" "+ item.keyword+" " + item.cnt;
		if(item.type=='up'){
			str += '<img src = "up.jpg">';
		}else
		{
			str += '<img src = "down.jpg">';
		}
		str += '</h3>';	
		
		$('div').append(str);
	});//jQuery에서 for 문
};
function getData(){
	$.ajax({
		url:'chart',
		success:function(result){
			//alert(typeof(eval(result)));//eval로 서버에서 온 String 타입을 object로 받아옴 
			display(eval(result));
		}
	});
};
$(document).ready(function(){
	getData();
	setInterval(getData,3000);//3초에한번씩 호출하라!!
});
</script>
</head>
<body>
<h1>Keyword Chart</h1>
<div></div>
</body>
</html>
```

