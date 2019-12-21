## 레이아웃 인플레이션 

- 안드로이드 앱을 구성하는 네가지 구성 요소
  - 액티비티
  - 서비스
  - 브로드캐스트 수신자
  - 내용 제공자
- :star2: Activity를 생성하면 반드시 Manifests에 등록

```xml
<activity android:name=".Main2Activity"></activity>
```

- Activity와 Activity 간에 이동을 위한 Intent를 사용하여 이동

  (MainActivity.java) - 보낼 곳

  ```java
  package com.example.p246;
  
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.content.Intent;
  import android.os.Bundle;
  import android.view.View;
  
  public class MainActivity extends AppCompatActivity {
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
      }
      public void clickB1(View view){
          Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
          intent.putExtra("num",100);
          intent.putExtra("str","Hi.sY");
          startActivity(intent);
  
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
      android:background="#FA0842"
      tools:context=".MainActivity" >
  
      <Button
          android:id="@+id/button"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_weight="1"
          android:onClick="clickB1"
          android:text="Button" />
  </LinearLayout>
  ```

  

  (Main2Activity.java) - 받을 곳

  ```java
  package com.example.p246;
  
  import androidx.annotation.Nullable;
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.content.Intent;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.TextView;
  
  public class Main2Activity extends AppCompatActivity {
  
      TextView textView,textView2;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main2);
          textView = findViewById(R.id.textView);
          textView2 = findViewById(R.id.textView2);
  
      }
      public void clickB1(View view){
          finish();
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
      android:background="#1289E7"
      android:orientation="vertical"
      tools:context=".Main2Activity">
  
      <Button
          android:id="@+id/button2"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:onClick="clickB1"
          android:text="Button" />
  
      <TextView
          android:id="@+id/textView"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:layout_gravity="center"
          android:gravity="center"
          android:text="TextView"
          android:textSize="36sp" />
  
      <Button
          android:id="@+id/button3"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:onClick="clickB2"
          android:text="NEXT" />
  
      <TextView
          android:id="@+id/textView2"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:gravity="center"
          android:text="TextView"
          android:textColor="#FFEB3B"
          android:textSize="36sp" />
  </LinearLayout>
  ```

  

- Intent를 이용한 데이터 전달 (intent.putExtra 로 보내기(Main -> Main2) , startActivityForResult 및 onActivityResult 함수를 이용 (Main2 -> Main3) )

  (MainActivity.java)

```java
package com.example.p246;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickB1(View view){
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        intent.putExtra("num",100);
        intent.putExtra("str","Hi.sY");
        startActivity(intent);

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
    android:background="#FA0842"
    tools:context=".MainActivity" >

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:onClick="clickB1"
        android:text="Button" />
</LinearLayout>
```

(Main2Activity.java)

```java
package com.example.p246;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        Intent intent = getIntent();
        int num = intent.getIntExtra("num",0); // 두번째는 defaults값 없으면 nullpoint에러
        String str = intent.getStringExtra("str");
        textView.setText(num+" "+str);
    }
    public void clickB1(View view){
        finish();
    }

    public void clickB2(View view){
        Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
        startActivityForResult(intent, 100);//Main3에서 어떠한 값을 보내면 받겠다.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//결과를 받는 놈
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode ==RESULT_OK){
            int nn = data.getIntExtra("nm",0);
            String st = data.getStringExtra("st");
            textView2.setText(nn + " " + st);
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
    android:background="#1289E7"
    android:orientation="vertical"
    tools:context=".Main2Activity">

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickB1"
        android:text="Button" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:gravity="center"
        android:text="TextView"
        android:textSize="36sp" />

    <Button
        android:id="@+id/button3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickB2"
        android:text="NEXT" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="TextView"
        android:textColor="#FFEB3B"
        android:textSize="36sp" />
</LinearLayout>
```

(Main3Activity.java)

```java
package com.example.p246;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }

    public void clickbt(View view){
        Intent intent = new Intent();
        intent.putExtra("nm",1000);
        intent.putExtra("st","Hi.SS");
        setResult(RESULT_OK,intent);
        finish();
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
    android:background="#FFEB3B"
    tools:context=".Main3Activity">

    <Button
        android:id="@+id/button4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickbt"
        android:text="Button" />
</LinearLayout>
```

- Intent를 이용해서 안드로이드를 실행시키기

  - manifests에 permission 추가

    ```xml
     <uses-permission android:name="android.permission.CALL_PHONE"/>
    ```

    

  (MainActivity.java)

```java
package com.example.p258;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickBt(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.button:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));

                break;
            case R.id.button2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://010-2232-3456"));
                break;
            case R.id.button3:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel://010-2232-3456"));
                break;
        }
        startActivity(intent);
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
        android:onClick="clickBt"
        android:text="Button" />

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickBt"
        android:text="Button" />

    <Button
        android:id="@+id/button3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickBt"
        android:text="Button" />
</LinearLayout>
```

- 액티비티의 수명주기와 SharedPreferences 이해하기

| 상태 메서드 | 설명 |
| ----------- | ---- |
|             |      |
|             |      |
|             |      |
|             |      |
|             |      |
|             |      |
|             |      |

```java
(MainActivity.java)

package com.example.p258;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
    }

    public void clickBt(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.button:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));

                break;
            case R.id.button2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://010-2232-3456"));
                break;
            case R.id.button3:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel://010-2232-3456"));
                break;
        }
        startActivity(intent);
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
        android:onClick="clickBt"
        android:text="Button" />

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickBt"
        android:text="Button" />

    <Button
        android:id="@+id/button3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickBt"
        android:text="Button" />
</LinearLayout>
```

- 자동로그인 기능 구현 (SharedPreferences 사용)

  - SharedPreferences 는 데이터를 보관 앱이 삭제 되면 지워진다.

  (MainActivity.java)

```java
package com.example.p285;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    SharedPreferences sp;
    EditText editText,editText2;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
        editText = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        checkBox = findViewById(R.id.checkBox);
       /* SharedPreferences.Editor editor = sp.edit();
        editor.putString("ID","boo");
        editor.putString("PWD","1111");
        editor.commit();*/
//        String id = sp.getString("ID","default"); //두번째 argument는 default값
//        String pwd = sp.getString("PWD","defacult");
        if (sp != null && sp.contains("CHECK")) {//SharedPreferences sp 있는지 확인 여부
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        }
    }
    public void clickbt(View view){

        if(editText.getText().toString().equals("boo") && editText2.getText().toString().equals("1111") ){
            sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            if(checkBox.isChecked()){
                editor.putString("ID",editText.getText().toString());
                editor.putString("PWD",editText2.getText().toString());
                editor.putBoolean("CHECK", true);

                editor.commit();


            }else{
                editor.clear();
                editor.commit();
            }
            Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
            startActivity(intent);
            Toast.makeText(this, editText.getText() +"반갑습니다.",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"회원 정보랑 맞지 않습니다.",Toast.LENGTH_SHORT).show();
        }

    }

}

```

(XML)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#D9F0F3"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="로그인 하기 "
        android:textSize="24sp"
        android:textStyle="bold" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_weight="2"
        android:gravity="center"
        android:orientation="vertical">

        <EditText
            android:id="@+id/editText1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="아이디"
            android:inputType="textPersonName" />

        <EditText
            android:id="@+id/editText2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="비밀번호"
            android:inputType="textPersonName|textPassword" />

        <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="clickbt"
            android:text="로그인" />

        <CheckBox
            android:id="@+id/checkBox"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:checked="true"
            android:text="자동로그인" />
    </LinearLayout>
</LinearLayout>
```

(MenuActivity.java)

```java
package com.example.p285;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


}

```

(XML)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FCE0D7"
    android:orientation="vertical"
    tools:context=".MenuActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="메인메뉴"
        android:textSize="24sp"
        android:textStyle="bold" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="center"
        android:layout_weight="15"
        android:gravity="center"
        android:orientation="vertical">

        <Button
            android:id="@+id/button2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="고객관리" />

        <Button
            android:id="@+id/button3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="매출관리" />

        <Button
            android:id="@+id/button4"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="상품관리" />
    </LinearLayout>
</LinearLayout>
```

- 프래그먼트

  - 여러 개의 화면을 구성할 때는 보통 각각의 화면을 액티비티로 만든 후 액티비티를 전환하는 방법을 사용합니다. 하나의 화면을 구성하는 XML 레이아웃을 만들 때 또 다른 리니어 레이아웃을 넣을 수 있다. 즉 고정된 메인에 특정 부분만 화면을 전환시키는 것이 가능한다. 

  - 프로그먼트는 독립적으로 사용 못하고 전체를 감싸는 layout이 필요하다.

:blue_car:실습)

   - 먼저 MainActivity 및 Fragment를 세팅한다. 

   - (Main.xml)

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

     (MainActivity.java)

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


​     
```xml
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
```


​     
​     
​     
~~~xml
 }
 
 ```

 (fragment_view2.xml)

 ```xml
 <?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
     xmlns:tools="http://schemas.android.com/tools"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:background="#FFEB3B"
     android:orientation="vertical"
     tools:context=".View2Fragment" />
 ```

 (fragment_view2.java)

 ```java
 package com.example.p287;
 
 import androidx.lifecycle.ViewModelProviders;
 
 import android.os.Bundle;
 
 import androidx.annotation.NonNull;
 import androidx.annotation.Nullable;
 import androidx.fragment.app.Fragment;
 
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 
 public class View2Fragment extends Fragment {
 
     @Override
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_view2, container, false);
     }
 
 }
 
 ```

 (fragment_view3.xml)

 ```xml
 <?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
     xmlns:tools="http://schemas.android.com/tools"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:background="#1BB2C5"
     android:orientation="vertical"
     tools:context=".View3Fragment" />
 ```

 (fragment_view3.java)

 ```java
 package com.example.p287;
 
 import android.content.Context;
 import android.net.Uri;
 import android.os.Bundle;
 
 import androidx.fragment.app.Fragment;
 
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
~~~


​     
​     
~~~java
 public class View3Fragment extends Fragment {
 
     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
         // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_view3, container, false);
     }
 
 }
 
 ```

 > 프래그먼트를 사용하면 코드를 독립적으로 구성하기 때문에 코드를 더 많이 입력해야 할 수도 있습니다. 또한 프래그먼트를 완벽하게 이해하지 않으면 프래그먼트 자체가 어렵게 느껴질 수 있다. (사용 목적) 분할된 화면들을 독립적으로 구성하기 위해, 분할된 화면들의 상태를 관리하기 위해 
~~~