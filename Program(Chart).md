### Project

- [https://www.data.go.kr] 에서  지역별 성범죄자 통계를 Chart로 나타내어라 (파싱)

  ​	$Xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<Result>
<Code>00</Code>
<City>
<city-name>강원도</city-name>
<city-count>132</city-count>
</City>
<City>
<city-name>경기도</city-name>
<city-count>925</city-count>
</City>
<City>
<city-name>경상남도</city-name>
<city-count>278</city-count>
</City>
<City>
<city-name>경상북도</city-name>
<city-count>269</city-count>
</City>
<City>
<city-name>광주광역시</city-name>
<city-count>108</city-count>
</City>
<City>
<city-name>대구광역시</city-name>
<city-count>202</city-count>
</City>
<City>
<city-name>대전광역시</city-name>
<city-count>97</city-count>
</City>
<City>
<city-name>부산광역시</city-name>
<city-count>239</city-count>
</City>
<City>
<city-name>서울특별시</city-name>
<city-count>587</city-count>
</City>
<City>
<city-name>세종특별자치시</city-name>
<city-count>11</city-count>
</City>
<City>
<city-name>울산광역시</city-name>
<city-count>77</city-count>
</City>
<City>
<city-name>인천광역시</city-name>
<city-count>253</city-count>
</City>
<City>
<city-name>전라남도</city-name>
<city-count>194</city-count>
</City>
<City>
<city-name>전라북도</city-name>
<city-count>195</city-count>
</City>
<City>
<city-name>제주특별자치도</city-name>
<city-count>59</city-count>
</City>
<City>
<city-name>충청남도</city-name>
<city-count>208</city-count>
</City>
<City>
<city-name>충청북도</city-name>
<city-count>123</city-count>
</City>
</Result>
```

​       $html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<style>


</style>

<script>


function Temp(n,d1){ 
	this.name = n;
	this.data = d1;
};
function parsing(data){
		var ts = $(data).find('City'); 
	
		var datas = [];
		ts.each(function(index,item){
	    	var name = $(this).find('city-name').text();
			var d = parseInt($(this).find('city-count').text());

			var obj = [name,d];
			datas.push(obj); 	
			//console.log(obj);	
			
		    // name.each(function(index,item){
			// 	 n2.push(String($(item).text()));
			//  });
		});
		

		// ts.each(function(index,item){
		// 		var d = $(this).find('city-count');			
				
		// 		d.each(function(index,item){
		// 			ds.push(Number($(item).text()));
		// 		});
		// }); 

		// for(var i = 0; i < n2.length; i++){
		// 	var obj = [n2[i],ds[i]];
		// 	datas.push(obj); 
		// }
		Charts(datas);//최종 배열 값을넣어준다.
};


function Charts(data){
Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'World\'s largest cities per 2017'
    },
    subtitle: {
        text: 'Source: <a href="http://en.wikipedia.org/wiki/List_of_cities_proper_by_population">Wikipedia</a>'
    },
    xAxis: {
		
        type: 'category',
        labels: {
            rotation: -45,
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Population (millions)'
        }
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: 'Population in 2017: <b>{point.y:.1f} millions</b>'
    },
    series:[{
		name: 'Population',
		
        data:data,
        dataLabels: {
            enabled: true,
            rotation: -90,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y:.1f}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});

};

function getData(){
	$.ajax({
		url:'ws.xml', //서버에서 hchart 데이터를 받아옴 
		success:function(data){
			//alert(data);
			parsing(data);
			//makeChart(eval(data));//String을 eval해서 object로 
		}
	});
};
$(document).ready(function(){
	getData();
	//Charts();
});

 
</script>
</head>
<body>
<!-- HTML -->
<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
</body>
</html>
```

