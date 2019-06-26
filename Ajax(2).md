### Ajax



- chart 생성하기 - ([https://www.highcharts.com]여기서 라이브러리 받아오기 (제공되는 샘플) , JSON 데이터를 임의로 설정하여 char에 보내주기)

  $ Servlet(HchartServlet -> hcahrt로 html Ajax url를 받아서와서)

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
 * Servlet implementation class HchartServlet
 */
@WebServlet({ "/HchartServlet", "/hchart" })//html url 받아오기
public class HchartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*[{
	        name: 'Tokyo',
	        data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
	    }, {
	        name: 'London',
	        data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
	    }]*/
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		JSONArray ja = new JSONArray();
		
		JSONObject jo = new JSONObject();
		Random r = new Random();
		
		String datas[] = {"Seoul","Busan","Daegu"};
		
		for(int i =0; i <3;i++) {
			
			JSONObject jso = new JSONObject();	
			jso.put("name", datas[i]);
			JSONArray js = new JSONArray();//배열 안에 배열 선언!
			for(int j = 0; j<12;j++) {
			js.add(r.nextInt(10)+1);//12개의 데이터 값 가져오기 .
			}
			jso.put("data", js);
		
			
			
			ja.add(jso);
			
		}
		out.print(ja.toJSONString());
		
		out.close();
	}

}

```

​      $html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.highcharts.com/highcharts.js"></script><!--제공되는 라이브러리-->
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
function makeChart(data){
Highcharts.chart('container', {
    chart: {
        type: 'line'
    },
    title: {
        text: 'Seoul Monthly Average Temperature'
    },
    subtitle: {
        text: ''
    },
    xAxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
    },
    yAxis: {
        title: {
            text: 'Temperature (°C)'
        }
    },
    plotOptions: {
        line: {
            dataLabels: {
                enabled: true
            },
            enableMouseTracking: false
        }
    },
	series:data //서버에서 받아온 data
	
	/*[{//배열안에 object(고정된 데이터)
        name: 'Seoul',
        data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]//JSON
    }, {
        name: 'Busan',
        data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
    },{
		name: 'Daegu',
        data: [5.9, 5.2, 6.7, 7.5, 13.9, 16.2, 20.0, 18.6, 15.2, 13.3, 8.6, 5.8]
	}]*/
});
};//end makeChart
function getData(){
	$.ajax({
		url:'hchart', //서버에서 hchart 데이터를 받아옴 
		success:function(data){
			makeChart(eval(data));//String을 eval해서 object로 
		}
	});
};
$(document).ready(function(){
	getData();//서버에서 JSON 데이터를 가져와서 활용 
	//makeChart(); // 기존에 고정된 정보 그냥 가져와서 활용
	setInterval(getData,5000);//5초에 한번씩 
});
</script>
</head>
<body>
<h1>My Charts</h1>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>
</html>
```

- XML을 생성하여 값을 가져와서 char 찍기

  $XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<temps>
<temp>
	<name>Seoul</name>
	<data1>10</data1>
	<data2>20</data2>
	<data3>30</data3>

	
	
</temp>

<temp>
	<name>Busan</name>
	<data1>90</data1>
	<data2>50</data2>
	<data3>40</data3>
	
	
	
</temp>
</temps>
```

 $html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.highcharts.com/highcharts.js"></script><!--제공되는 라이브러리-->
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
function Temp(n,d1,d2,d3){//object 생성
	this.name = n;
	this.data = [d1,d2,d3];
};
function parsing(data){
		var ts = $(data).find('temp'); //temp의 여러개를 가져옴, find : 테그를 읽어드리는것 !
		//alert(ts.length);
		var datas = [];
		ts.each(function(index,item){
			var name = $(this).find('name').text();
			var data1 = $(this).find('data1').text();
			var data2 = $(this).find('data2').text();
			var data3 = $(this).find('data3').text();
			var obj =new Temp(name,Number(data1),Number(data2),Number(data3));//string을 정수로
			datas.push(obj); // object을 생성 하여 배열에 넣어준다.
		}); //item에 첫번째는 Seoul temp, 두번째는 Busan temp
		makeChart(datas);//최종 배열 값을넣어준다.
	};
function makeChart(data){
Highcharts.chart('container', {
    chart: {
        type: 'line'
    },
    title: {
        text: 'Seoul Monthly Average Temperature'
    },
    subtitle: {
        text: ''
    },
    xAxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
    },
    yAxis: {
        title: {
            text: 'Temperature (°C)'
        }
    },
    plotOptions: {
        line: {
            dataLabels: {
                enabled: true
            },
            enableMouseTracking: false
        }
    },
	series:data //서버에서 받아온 data
	
	/*[{//배열안에 object(고정된 데이터)
        name: 'Seoul',
        data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]//JSON
    }, {
        name: 'Busan',
        data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
    },{
		name: 'Daegu',
        data: [5.9, 5.2, 6.7, 7.5, 13.9, 16.2, 20.0, 18.6, 15.2, 13.3, 8.6, 5.8]
	}]*/
});
};//end makeChart
function getData(){
	$.ajax({
		url:'temp.xml', //서버에서 hchart 데이터를 받아옴 
		success:function(data){
			//alert(data);
			parsing(data);
			//makeChart(eval(data));//String을 eval해서 object로 
		}
	});
};
$(document).ready(function(){
	getData();
	//makeChart();
	//setInterval(getData,5000);//5초에 한번씩 
});
</script>
</head>
<body>
<h1>My Charts</h1>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>
</html>
```

