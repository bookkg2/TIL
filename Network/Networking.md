## 네트워킹 (HTTP 프로토콜 & TCP/IP 프로토콜 )

- Http를 활용하여 Server에서 data 가져오기 (Http connection)

```java
package Http;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;



public class Http2 {

	public static void main(String[] args)throws Exception {
		String urlstr = "http://IP주소/test/oracle.zip";
		URL url = new URL(urlstr);
		InputStream is = url.openStream();//URL openconnection 하고 바로 스트림 만드는 것 !!
		BufferedInputStream bis = new BufferedInputStream(is,1024);
		int data = 0;
		while((data = bis.read()) != -1) {
			System.out.print("*" + data);
		}
		System.out.println("Finish...");
		is.close();

	}

}

```

- ID, PWD 를 서버로 보내서 확인 하기

```java
package Http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http3 {

	public static void main(String[] args) throws Exception{
		String urlstr = "http://IP주소/test/login.jsp";
		String id = "aa";
		String pwd = "11";
		urlstr += "?id="+id+"&pwd="+pwd;
		URL url = new URL(urlstr);//URL 객체 완성
		//InputStream is = url.openStream(); //(방법 1)
		
	
		 HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		 conn.setRequestMethod("GET"); 
		 conn.setConnectTimeout(5000);//답이 없으면 Exception
		 InputStream is = conn.getInputStream(); //is는 2byte 식으로 읽어 온다. 
		 InputStreamReader isr = new InputStreamReader(is);
		 BufferedReader br = new BufferedReader(isr);// INT로 받아온 데이터를 String으로 변환하기 편하고, 빠르게 불러오기 위하여
		 
		 if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {//HTTP 서버 문제 처리
			 String result = null;
			 while((result =br.readLine())!= null) {
				 System.out.println(result);
			 }
		 }else {
			 System.out.println("Server Down..");
		 }
	
		//conn.disconnect();

	}

}

```

- TCP/IP
  - 소켓 : 프로세스간의 통신에 사용되는 양쪽 끝단을 의미한다. 
  - TCP : 1 대 1 통신
  - UDP : 1 대 N 통신 (데이터 유실 위험이 있다. 보내기만 하고 확인을 안한다.)
  - TCP 소켓 프로그래밍