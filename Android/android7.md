## AsyncTask

- 핸들러를 사용하지 않고 좀 더 간단하게 작업하는 방법
- 서브스레드와 메인 스레드를 아울러서 사용

| 메서드 이름      | 설명                                                         |
| ---------------- | ------------------------------------------------------------ |
| doInBackground   | 새로 만든 스레드에서 백그라운드 작업을 수행합니다. execute() 메서드를 호출할 때 사용된 파라미터를 배열로 전달 |
| onPreExecute     | 백그라운드 작업을 수행하기 전에 호출된다. 메인 스레드에서 실행되며 초기화 작업에 사용합니다. |
| onProgressUpdate | 백그라운드 작업의 진행 상태를 표시하기 위해 호출됩니다. 작업 수행 중간 중간에 UI 객체에 접근하는 경우에 사용 |
| onPostExecute    | 백그라운드 작업이 끝난 후에 호출됩니다. 메인 스레드에서 실행되며 메모리 리소스를 해제하는 등의 작업에 사용 |

```java
package com.example.p490;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    ProgressBar progressBar;
    ProgressDialog progressDialog;

    MyTask myTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textview);
        progressBar = findViewById(R.id.progressBar2);
        progressDialog = new ProgressDialog(this);
    }
    public void clickBt(View view){
        myTask = new MyTask(30);
        myTask.execute(); // 스레드와 핸들러를 같이 동작
    }

    class MyTask extends AsyncTask<Integer,Integer,String>{//받아올 때 argument, 스레드가 동작되는 와중에 타입,종료되고 리턴 되어지는 타입
        int cnt;
        public MyTask(int cnt){
            this.cnt = cnt;
        }


        @Override
        protected String doInBackground(Integer... integers) {
            String result = ""; //메인 스레드가 끝나면 String이 리턴된다.
            int sum = 0 ;
            for(int i = 0 ; i<cnt;i++){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum += i;
                publishProgress(i);//onProgressUpdate 이동
            }
            result = sum + "";
            return result;
        }

        @Override
        protected void onPreExecute() {// 스레드 전
             super.onPreExecute();
             progressBar.setMax(cnt);
             button.setEnabled(false);
            textView.setText("Start Task");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {// 스레드 중
             super.onProgressUpdate(values);
             progressBar.setProgress(values[0].intValue()); // 배열 값이 저장 되어 있음
             textView.setText(values[0].intValue() +"");// 진행중을 text에 출력

        }

        @Override
        protected void onPostExecute(String s) {// 끝났을 때 부분
            super.onPostExecute(s);
            button.setEnabled(true);
            textView.setText("End Task" + s);
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
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickBt"
        android:text="Button" />

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!" />

    <ProgressBar
        android:id="@+id/progressBar2"
        style="?android:attr/progressBarStyleHorizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```

- 두 가지 스레드를 동시에 적용 하기 (THREAD_POOL_EXECUTOR 사용)
  - 자동차 및 rpm의 랜덤 값으로 출력하고 , 100km/h 속력이 넘으면 '과속' 문자 띄우기

```java
package com.example.p499;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView, textView2,textView3;

    Mytask mytask;
    MyRpm myRpm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        mytask = new Mytask();
        myRpm = new MyRpm();

    }

    public void clickbt(View view){
        mytask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);//다중 Thread 처리
        myRpm.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
    class MyRpm extends AsyncTask<Integer,Integer,String>{

        @Override
        protected String doInBackground(Integer... integers) {
            String result = "";
            Random r = new Random();

            for (int i = 0 ; i < 100; i++){
                int speed = r.nextInt(270);
                int rpm = r.nextInt(1000);

                try {
                    Thread.sleep(300);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("ssss" , "-----------------------------" +i);
                publishProgress(speed);
            }

            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView3.setText(values[0].intValue() +"");// 진행중을 text에 출력

        }

        @Override
        protected void onPostExecute(String s) {// 끝났을 때 부분
            super.onPostExecute(s);


        }
    }

    class Mytask extends AsyncTask<Integer,Integer,String>{

        @Override
        protected String doInBackground(Integer... integers) {
            String result = "";
            Random r = new Random();

            for (int i = 0 ; i < 100; i++){
                int speed = r.nextInt(270);


                try {
                    Thread.sleep(300);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(speed);
            }

            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView2.setText(values[0].intValue() +"");// 진행중을 text에 출력
            if(values[0].intValue() > 100){
                textView.setText("과속");
            }else {
                textView.setText("안전한 여행 되세요");
            }

        }

        @Override
        protected void onPostExecute(String s) {// 끝났을 때 부분
            super.onPostExecute(s);


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
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:orientation="vertical">

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="clickbt"
            android:text="Button" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_gravity="center|right"
            android:layout_weight="1"
            android:gravity="center|right"
            android:text="TextView"
            android:textSize="36sp" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:orientation="vertical">

        <TextView
            android:id="@+id/textView2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="TextView" />

        <TextView
            android:id="@+id/textView3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="TextView" />
    </LinearLayout>

</LinearLayout>
```

