## 프래그 먼트(2)

- 프래그먼트는 메인 엑티비티의 위젯 및 UI는 건들 수 없다. 

- 단 메인엑티비티는 프래그먼트를 제어가 가능하다. ('setT() 임시 함수로 컨드롤 확인')

  (MainActivity)

  ```java
  package com.example.p287;
  
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.graphics.Color;
  import android.os.Bundle;
  import android.util.Log;
  import android.view.View;
  import android.widget.Button;
  
  public class MainActivity extends AppCompatActivity {
      View1Fragment view1Fragment;
      View2Fragment view2Fragment;
      View3Fragment view3Fragment;
      Button button,button2,button3;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
  
          view1Fragment = (View1Fragment) getSupportFragmentManager().findFragmentById(R.id.fragment);// 방법 1 ) (fragment에 ID설정 한 후)Activity와 fragment 간의 컨트롤을 하기 위하여
  
          view2Fragment = new View2Fragment();//방법 2 ) 객체를 그대로 불러와서 이용한다.
          view3Fragment = new View3Fragment();
          button =findViewById(R.id.button);
          button2 = findViewById(R.id.button2);
          button3 = findViewById(R.id.button3);
      }
      public void setBt(){
         Log.i("*","---------------------------------");
      }
  
      public void clickBt(View view){
          if(view.getId() == R.id.button){
              onFragmentChange(1);
              view1Fragment.setT();
          }else if(view.getId() == R.id.button2){
              onFragmentChange(2);
          }else if(view.getId() == R.id.button3){
              onFragmentChange(3);
          }
      }
  
      public void onFragmentChange(int index){
          if(index==1){
              getSupportFragmentManager().beginTransaction().replace(R.id.container,view1Fragment).commit();
          }else if(index==2){
              getSupportFragmentManager().beginTransaction().replace(R.id.container,view2Fragment).commit();
          }else if(index==3){
              getSupportFragmentManager().beginTransaction().replace(R.id.container,view3Fragment).commit();
          }
      }
  }
  
  ```

  (Main.xml)

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
              android:text="View1" />
  
          <Button
              android:id="@+id/button2"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:layout_weight="1"
              android:onClick="clickBt"
              android:text="View2" />
  
          <Button
              android:id="@+id/button3"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:layout_weight="1"
              android:onClick="clickBt"
              android:text="View3" />
  
      </LinearLayout>
  
      <LinearLayout
          android:id="@+id/container"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:orientation="vertical">
  
          <fragment
              android:id="@+id/fragment"
              android:name="com.example.p287.View1Fragment"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:layout_weight="1" />
      </LinearLayout>
  
  </LinearLayout>
  ```

  

  (View1Fragment.java)

   ```java
  package com.example.p287;
  
  import android.content.Context;
  import android.net.Uri;
  import android.os.Bundle;
  
  import androidx.fragment.app.Fragment;
  
  import android.view.LayoutInflater;
  import android.view.View;
  import android.view.ViewGroup;
  import android.widget.Button;
  import android.widget.TextView;
  
  
  public class View1Fragment extends Fragment {
      Button button4,button5;
      TextView textView;
      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
          // Inflate the layout for this fragment
          ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_view1, container, false);
          button4 = viewGroup.findViewById(R.id.button4);
          button5 = viewGroup.findViewById(R.id.button5);
          textView = viewGroup.findViewById(R.id.textView);
          button4.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  MainActivity ma = new MainActivity(); //버튼이 클릭되면 main에 어느 부분을 수정한다.
                  ma.setBt(); // 메인에 있는 함수 호출
  
              }
          });
  
          button5.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  textView.setText("View1 Fragment");
              }
          });
          return viewGroup;
  
      }
      public void setT(){
          textView.setText("Main....");
      }
  
  
  
  }
  
   ```

  (fragment_view1.xml)

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:background="#673AB7"
      android:orientation="vertical"
      tools:context=".View1Fragment" >
  
      <Button
          android:id="@+id/button4"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="Button" />
  
      <Button
          android:id="@+id/button5"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="Button" />
  
      <TextView
          android:id="@+id/textView"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="TextView"
          android:textSize="36sp" />
  </LinearLayout>
  ```

  

## 액션바 사용하기

- 화면에 메뉴 기능 넣기

  - 메뉴 안에 메뉴를 넣고 싶으면 ITEM 안에 MENU를 생성해서 설정한다. 

  - 실행 ) 

    - 먼저 [res] -> [New] -> [Android Resource Directory] 생성  type을 [menu] 해서 생성

    - 생성된 menu 파일에 [New] -> [Menu resource file] 해서 xml 파일 생성 한다.

    - (XML)\

      ````xml
      <?xml version="1.0" encoding="utf-8"?>
      <menu xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto">
      
          <item
              android:id="@+id/msetting"
              android:icon="@drawable/icon"
              android:title="Setting"
              app:showAsAction="always" />
          <item
              android:id="@+id/mlogin"
              android:icon="@drawable/icon2"
              android:title="Login"
              app:showAsAction="always" />
      </menu>
      ````

      

    - (MainActivity.java)

      ```java
      package com.example.p312;
      
      import androidx.annotation.NonNull;
      import androidx.appcompat.app.ActionBar;
      import androidx.appcompat.app.AppCompatActivity;
      
      import android.app.Notification;
      import android.os.Bundle;
      import android.view.Menu;
      import android.view.MenuItem;
      import android.widget.Toast;
      
      public class MainActivity extends AppCompatActivity {
          ActionBar actionBar;
      
          @Override
          protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.activity_main);
              actionBar = getSupportActionBar(); // 액션바 가져오기
              actionBar.setLogo(R.drawable.g2);
              actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
      
          }
          @Override
          public boolean onCreateOptionsMenu(Menu menu) {// 메뉴를 나타내는 함수
              getMenuInflater().inflate(R.menu.mymenu, menu); // 메인이 아닌 상태에서 xml를 가져오려면 inflate를 사용
              return true;
          }
      
          @Override
          public boolean onOptionsItemSelected(@NonNull MenuItem item) {//메뉴의 각 별로 기능 규현
              if(item.getItemId() == R.id.msetting){
                  Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
              }else if(item.getItemId() == R.id.mlogin){
                  Toast.makeText(this,"login",Toast.LENGTH_SHORT).show();
              }
              return super.onOptionsItemSelected(item);
          }
      }
      
      
      ```

  

- 액션바 설정 하기 

  - 액션바 : 상단 영역 

  (MainActivity.java)

  ```java
  package com.example.p312;
  
  import androidx.annotation.NonNull;
  import androidx.appcompat.app.ActionBar;
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.app.Notification;
  import android.os.Bundle;
  import android.view.Menu;
  import android.view.MenuItem;
  import android.widget.Toast;
  
  public class MainActivity extends AppCompatActivity {
      ActionBar actionBar;// 액션바 사용
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          actionBar = getSupportActionBar(); // 액션바 가져오기
          actionBar.setLogo(R.drawable.g2);
          actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);//액션바 옵션
  
      }
      @Override
      public boolean onCreateOptionsMenu(Menu menu) {// 메뉴를 나타내는 함수
          getMenuInflater().inflate(R.menu.mymenu, menu); // 메인이 아닌 상태에서 xml를 가져오려면 inflate를 사용
          return true;
      }
  
      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {//메뉴의 각 별로 기능 규현
          if(item.getItemId() == R.id.msetting){
              Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
          }else if(item.getItemId() == R.id.mlogin){
              Toast.makeText(this,"login",Toast.LENGTH_SHORT).show();
          }
          return super.onOptionsItemSelected(item);
      }
  }
  
  
  ```

  (xml)

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <menu xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto">
  
      <item
          android:id="@+id/msetting"
          android:icon="@drawable/icon"
          android:title="Setting"
          app:showAsAction="always" />
      <item
          android:id="@+id/mlogin"
          android:icon="@drawable/icon2"
          android:title="Login"
          app:showAsAction="always" />
  </menu>
  ```

  

  | 디스플레이 옵션 상수 | 설명                                             |
  | -------------------- | ------------------------------------------------ |
  | DISPLAY_USE_LOGO     | 홈 아이콘 부분에 로고 아이콘을 사용합니다.       |
  | DISPLAY_SHOW_HOME    | 홈 아이콘을 표시하도록 합니다.                   |
  | DISPLAY_HOME_AS_UP   | 홈 아이콘에 뒤로가기 모양의 < 아이콘을 같이 표시 |
  | DISPLAY_SHOW_TITLE   | 타이틀을 표시                                    |

  - 달력과 시간을 텍스트 뷰에 출력

    (MainActivity.java)

    ```java
    package com.example.p351;
    
    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    
    import android.os.Bundle;
    import android.widget.CalendarView;
    import android.widget.TextView;
    import android.widget.TimePicker;
    
    public class MainActivity extends AppCompatActivity {
        TextView textView;
        CalendarView calendarView;
        TimePicker timePicker;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textView = findViewById(R.id.textView);
            calendarView = findViewById(R.id.calendarView);
            timePicker = findViewById(R.id.timePicker);
    
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                    String date = i + "/" + i1 + "/"+ i2;
                    textView.setText(date);
                }
            });
    
            timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                @Override
                public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                    String time = i + ":" + i1;
                    textView.setText(time);
                }
            });
    
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
    
        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="TextView" />
    
        <CalendarView
            android:id="@+id/calendarView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    
        <TimePicker
            android:id="@+id/timePicker"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </LinearLayout>
    ```

    

  ## 서비스와 수신자 이해하기

- 서비스 : 앱이 실행되어 있다고 해서 항상 화면이 보이는 것은 아니다. 즉 화면없이 백그라운드에서 실행되는 것이 서비스 이다. 즉 백그라운드에서 실행되는 앱의 구성요소를 말한다. 서비스도 앱의 구성 요소이므로 시스템에서 관리한다. 

  - Service class를 먼저 만든다. ([New]  -> [service] -> [service])

  (MainActivity.java)

  ```java
  package com.example.p353;
  
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.content.Intent;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.ImageView;
  import android.widget.TextView;
  
  public class MainActivity extends AppCompatActivity {
      Intent intent; //서비스를 호출 할때도 사용
      TextView textView;
      ImageView imageView;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          textView = findViewById(R.id.textView);
          imageView = findViewById(R.id.imageView);
      }
      public void clickbt(View view){
          intent = new Intent(this, MyService.class);
          startService(intent); //service의 onStartCommand을 실행
  
      }
  
      @Override
      protected void onNewIntent(Intent intent) {//service에서 값을 보내주면 자동으로 실행
          process(intent);
      }
  
      public void process(Intent intent){
          if(intent != null){
              int data = intent.getIntExtra("cmd",0);
              textView.setText(data+"");
              if(data % 2 == 0){
                  imageView.setImageResource(R.drawable.g1);
              }else{
                  imageView.setImageResource(R.drawable.g2);
              }
          }
      }
  
  
  
  
      @Override
      protected void onDestroy() {
          super.onDestroy();
          if(intent != null){
              stopService(intent);
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
  
      <Button
          android:id="@+id/button"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:onClick="clickbt"
          android:text="Button" />
  
      <TextView
          android:id="@+id/textView"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="TextView" />
  
      <ImageView
          android:id="@+id/imageView"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          app:srcCompat="@drawable/g1"
          tools:srcCompat="@drawable/g1" />
  </LinearLayout>
  ```

  (Myservice.java)

  ```java
  package com.example.p353;
  
  import android.app.Service;
  import android.content.Intent;
  import android.os.IBinder;
  import android.util.Log;
  
  public class MyService extends Service {//화면이 없는 서비스
  
      public MyService() {
      }
  
      @Override
      public void onCreate() {
          super.onCreate();
          Log.d("[Myservice]","onCreate........................");
      }
  
      @Override
      public void onDestroy() {//죽을 때
          super.onDestroy();
          Log.d("[Myservice]","onDestroy........................");
  
      }
  
      @Override
      public int onStartCommand(final Intent intent, int flags, int startId) {//intent가 있으니 담아서 보내고 받을 수 있다.
          Log.d("[Myservice]","onStartCommand........................");
          final Intent sIntent = new Intent(getApplicationContext(),MainActivity.class); //thread 안은 final로
          sIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
  
          Runnable run = new Runnable() {
              boolean flag = true;
  
              @Override
              public void run() {
                  for(int i = 0; i <= 30 ; i++){
                      Log.d("[Myservice]","while........................");
                      sIntent.putExtra("cmd",i);
                      startActivity(sIntent);
                      try {
                          Thread.sleep(1000);
                      }catch (InterruptedException e){
                          e.printStackTrace();
                      }
  
  
                      if(flag == false){
                          break;
                      }
                  }
              }
          };
          new Thread(run).start();
  
  
          return super.onStartCommand(intent, flags, startId);
  
      }
  
      @Override
      public IBinder onBind(Intent intent) {
          // TODO: Return the communication channel to the service.
          throw new UnsupportedOperationException("Not yet implemented");
      }
  }
  
  ```

  