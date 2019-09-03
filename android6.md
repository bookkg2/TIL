## WEBVIEW

(MainActivity.java)

```java
package com.example.p458;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView; // 일정 영역의 웹이 뿌려짐
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // 자바스트립트 성능을 사용하기 위해
        webView.loadUrl("http://m.naver.com");//permission 을 넣어 줘어야함 (Internet)
    }
    public void clickBt(View view){
         if(view.getId() == R.id.button){
             webView.loadUrl("http://www.daum.net");//permission 을 넣어 줘어야함 (Internet)
         }else if(view.getId() == R.id.button2){
             webView.loadUrl("http://www.auction.com");
         }else if(view.getId() == R.id.button3){
             webView.loadUrl("http://www.gmarket.com");
         }
    }
}
```

(xml)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity" >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />

        <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />

        <Button
            android:id="@+id/button3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />
    </LinearLayout>

    <WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```

- 나의 html과 연동하고 조작하기 (Manifest에 Internet Permission을 해줘야함)

  (index.html)

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
function s(data){
	document.getElementById('id02').innerHTML = 'Web view Event'+data;
}
</script>
</head>
<body>
<h1>Web View Test</h1>
<h2 id = "id02" >Sample Data</h2>
<button onclick = "window.js.webclick('web')"> Click </button>
</body>
</html>
```

 (MainActivity.java)

```java
package com.example.p458;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView webView; // 일정 영역의 웹이 뿌려짐
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        textView = findViewById(R.id.textView);
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new JS(),"js"); // 등록
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // 자바스트립트 성능을 사용하기 위해
        webView.loadUrl("http://m.naver.com");//permission 을 넣어 줘어야함 (Internet)
    }
    final class JS{
        JS(){}
        @android.webkit.JavascriptInterface //이곳은 JavaScript에서 들어온다.
        public void webclick(String str){
            textView.setText(str);

        }
    }
    public void clickBt(View view){
         if(view.getId() == R.id.button){
             webView.loadUrl("http://www.daum.net");//permission 을 넣어 줘어야함 (Internet)
         }else if(view.getId() == R.id.button2){
             webView.loadUrl("로컬주소");
         }else if(view.getId() == R.id.button3){
             webView.loadUrl("javascript:s('호랑나비비')"); //특정 수 실행
         }
    }
}

```

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity" >

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />

        <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />

        <Button
            android:id="@+id/button3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />
    </LinearLayout>

    <WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```



- seekbar로 화면 밝기 조절

  (MainActivity.java)

```java
package com.example.p462;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("SeekBar Value"+i);
                setBright(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"start",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"stop",Toast.LENGTH_LONG).show();
            }
        });//seekbar 이벤트 처리
    }
    public void setBright(int value){
        if(value < 10){
            value = 10;

        }
       WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float)value/10;
        getWindow().setAttributes(params);
    }

}

```

 (xml)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <SeekBar
        android:id="@+id/seekBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Name" />

</LinearLayout>
```

## 스레드와 핸들러 이해하기

- 프로세스 : 실제로 프로그램이 동작하는 것 
- 서비스 : 뒤에서 즉 데몬에서 동작, PID로 죽일 수 있다. 
- 스레드란 하나의 프로세스 안에서 공유하는 것 (메모리 절약을 할 수 있다.즉 하나의 메모리를 공유), 동시에 사용하다보면 데드 LOCK이 걸릴 수 있다. 즉 프로세스가 여러개 있는 것보다 스레드가 여러개 있는 것이 빠르다. 
  - 스레드 안에서는 변경될 수 없으니 Final로 지정한다.
  - 스레드는 클래스 runnable은 인터페이스 
  - 즉 스레드는 동작중에 다른 동작을 작동하게 해준다. 
  - :star: 메인 스레드를 서브 스레드가 제어할 수 없다. (중요)
    - 그래서 runOnUiThred 사용

(MainActivity.java)

```java
package com.example.p474;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView2;
    Button button1,button2;
    boolean flag1= true, flag2= true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//MainThread
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
    }

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i=11; i<=20;i++){
                    try {
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("[T]","************" +i);
                    final int temp = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(temp + "");
                        }
                    });


//                    final int temp = i;
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                        }
//                    });

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button1.setEnabled(true);
                    }
                });

            }
        };


    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=11; i<=20;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("[T]","************" +i);
                final int temp = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView2.setText(temp + "");
                        }
                    });
            }
        }
    });
    public void clickB1(View view){
        Thread t1 = new Thread(r1);
        t1.start(); //run 이라는 함수가 동작 된다.
        button1.setEnabled(false);
    }
    public void clickB2(View view){
        t2.start();
    }
}

```

(xml)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickB1"
        android:text="Button" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickB2"
        android:text="Button" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />
</LinearLayout>
```

- 핸들러 :  서브 값을 main에  해당 정보를 보내기, (중요) 즉 메인 스래드를 제어 할 수 있다.

  (MainActivity.java)

```java
package com.example.p478;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    CountHandler countHandler;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);
        countHandler = new CountHandler();
    }
    Runnable r = new Runnable() {

        @Override
        public void run() {
            for(int i=11; i<=20;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("[T]","************" +i);
                Message message = countHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("cnt",i);
                message.setData(bundle);
                countHandler.sendMessage(message);// 서브에서 메인으로 메세지 전달, 즉 서브에서 메인으로 정보를 전달하고 싶을 때


            }
            //for문이 끝나고 값을 보내서 리셋 시키기 
            Message message = countHandler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("cmd",1);
            message.setData(bundle);
            countHandler.sendMessage(message);

        }
    };
    class CountHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {// 메세지가 들어오는 곳

            Bundle bundle = msg.getData();
            int value = bundle.getInt("cnt");
            textView.setText(value + ""); //settext는 문자로
            int cmd = bundle.getInt("cmd");
            if(cmd == 1 ) {//다시 실행
                button.setEnabled(true);
            }




        }
    }
    public void clicBt(View view){
        Thread t= new Thread(r);
        t.start();
        button.setEnabled(false);
    }
}

```

 (xml)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clicBt"
        android:text="Button" />

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!" />

</LinearLayout>
```

(리셋 방법 2 Handler, Post 사용)

```java
package com.example.p478;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    CountHandler countHandler;
    Button button;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);
        handler = new Handler();
        countHandler = new CountHandler();
    }
    Runnable r = new Runnable() {

        @Override
        public void run() {
            for(int i=11; i<=20;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("[T]","************" +i);
                Message message = countHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("cnt",i);
                message.setData(bundle);
                countHandler.sendMessage(message);// 서브에서 메인으로 메세지 전달, 즉 서브에서 메인으로 정보를 전달하고 싶을 때


            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    button.setEnabled(true);
                }
            });

        }
    };
    class CountHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {// 메세지가 들어오는 곳

            Bundle bundle = msg.getData();
            int value = bundle.getInt("cnt");
            textView.setText(value + ""); //settext는 문자로





        }
    }
    public void clicBt(View view){
        Thread t= new Thread(r);
        t.start();
        button.setEnabled(false);
    }
}

```

> 서비스와 Thread의 비슷 하지만 차이 :  서비스는 앱을 죽여도 무언가를 돌기위해 이용하고 Thread는 Main와 서브를 동작하기 위하여 주로 이용한다. 

- 일정 간격을 두고 작업을 실행 하기(AlertDialog)

  (MainActivity)

```java
package com.example.p478;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    CountHandler countHandler;
    Button button;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);
        handler = new Handler();
        countHandler = new CountHandler();
    }
    Runnable r = new Runnable() {

        @Override
        public void run() {
            for(int i=11; i<=20;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("[T]","************" +i);
                Message message = countHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("cnt",i);
                message.setData(bundle);
                countHandler.sendMessage(message);// 서브에서 메인으로 메세지 전달, 즉 서브에서 메인으로 정보를 전달하고 싶을 때


            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    button.setEnabled(true);
                }
            });

        }
    };
    class CountHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {// 메세지가 들어오는 곳

            Bundle bundle = msg.getData();
            int value = bundle.getInt("cnt");
            textView.setText(value + ""); //settext는 문자로





        }
    }
    public void clicBt(View view){
        Thread t= new Thread(r);
        t.start();// start안에 값을 못넣어 준다. 
        button.setEnabled(false);
    }

    public void clicBt2(View view){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("dialog");
        dialog.setMessage("5 minutes ......");
        dialog.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                progressDialog.show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();// 5초후에 없애기 
                        textView.setText("NEXT OK");
                    }
                },5000);
            }
        });
        dialog.show();
    }
}

```

(xml)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clicBt"
        android:text="Button" />

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clicBt2"
        android:text="Button" />

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!" />

</LinearLayout>
```

- start는 값을 넣어서 thread에 사용하지 못한다. 그래서 Main에서 서브 스레드로 값을 전달하는 법 (1)

  ```java
  package com.example.p480;
  
  import androidx.annotation.NonNull;
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.os.Bundle;
  import android.os.Handler;
  import android.os.Looper;
  import android.os.Message;
  import android.util.Log;
  import android.view.View;
  import android.widget.TextView;
  
  public class MainActivity extends AppCompatActivity {
      TextView textView;
      MyThread myThread;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          textView= findViewById(R.id.textview);
          myThread = new MyThread(); //thred를 만들고 start를 안하니 run을 실행 안한다.
      }
  
      public void clickbt(View view){
          Message message = Message.obtain();
          message.obj = 10; // message 를 넣어주고
          myThread.threadHandler.sendMessage(message);
      }
  
      class MyThread extends Thread{
          ThreadHandler threadHandler;
          public  MyThread(){
              threadHandler = new ThreadHandler();
          }
          @Override
          public void run() {
              Looper.prepare();
              Looper.loop();
          }
          class ThreadHandler extends Handler{//메인의 것을 받을 준비
              @Override
              public void handleMessage(@NonNull Message msg) {
                  int data = (int) msg.obj;// 메인에서 보내온 obj를 받음
                  for(int i =0; i<data;i++){
                      try {
                          Thread.sleep(300);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      Log.d("[T]","----------------------" + i);
                      //i 값에 100을 곱해서 TextView에 출력하시오
                      final int d = i ;
                      runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              textView.setText((d*100) + "");
                          }
                      });
  
                  }
  
  
                  //textView.setText(data+"");
              }
          }
      }
  }
  
  ```

  

