## 안드로이드

- 문제가 발생하면 setting에 sdk 들어가서 sdk location을 다 지우고 실행
- gradle 은 실제로 컴파일을 하면 자동으로 다운 받아서 실행 해준다.
- build.gradle에 외부 라이브러리를 세팅할 수 도 있다.
- 자바 서블릿과 비슷하다. 
- mipmap : 앱 시작시 이미지를 관리
- drawble : 앱에 사용되는 이미지
- layout : ui 부분

- manifeats : 앱 전체의 환경 적인 부분을 담당한다. 

  - icon , label 등등 관리 

  - 페이지 이동은 다 등록해놔야 한다. (spring xml bean과 유사)

    ```xml
    <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />
    
                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>
    ```

    

- 이미지 drawble에 넣을 떄 -24는 형식에 맞춰야 하니 그냥 기본으로 복사
- (아이콘 변셩) 아이콘은 mipmap에 저장 하고 manifast에서 수정

        ```bash
 android:icon="@mipmap/ic_launcher"
 android:label="@string/app_name"
 android:roundIcon="@mipmap/ic_launcher_round"
        ```

- 모든 string은 "res -> values -> string.xml" 설정 하고 사용하는게 원칙

 ```xml
<resources>
    <string name="app_name">Hello</string>
</resources>

 ```

```bash
android:label="@string/app_name"
```

- 버튼 클릭 기능

  - 먼저 버튼 환경을 설정해 놓는다.(Design으로도 가능)

    ```xml
      <Button
            android:id="@+id/button3"
            android:layout_width="200dp"
            android:layout_height="100dp"
            android:layout_weight="1"
            android:onClick="clickButton"
            android:text="Button" />
    ```

    

  - main.activity 에서 onclick 설정(toast : 클릭시 메시지 출력)

    ````java
     public void clickButton(View v){
            Toast.makeText(this,"click button",Toast.LENGTH_SHORT).show();
            // this : 현재, text : 메세지 , 길이를 나타 낸다.
    
        }
    ````

    > 자동 import 방법 : File -> setttings -> Editor -> General -> Auto Import -> Add unambi... 와 Optimize .... 체크 하고 apply 하기

  

  - Log 찍기 (logcat에서 확인(filter로 원하는 부분만 볼수도 있음)) - MainActicity.java

  ```java
  package com.example.hello;
  
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.os.Bundle;
  import android.util.Log;
  import android.view.View;
  import android.widget.Toast;
  
  public class MainActivity extends AppCompatActivity {
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {//start point
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
      }
      public void clickButton(View v){
          Toast.makeText(this,"click button",Toast.LENGTH_SHORT).show();
          // this : 현재, text : 메세지 , 길이를 나타 낸다.
  
          //Log 찍기
          Log.d("[Debug]..............","OKBARY");
          Log.i("[Info]..........","Information");
          Log.e("[Error]............","Error");
      }
  }
  
  ```

  

- apk : 하나의 어플리케이션 묶음 (java의 war랑 비슷)
  - apk가 playstore에 등록이 되면 apk가 풀리면서 사용가능! 

- 하단의 logcat에는 에러 및 log를 확인할 수 있다. 

- 안드로이드에서 홈버튼은 메모리에 남아있는거고 back 버튼을 눌러야 죽고 히스토리만 남아있음 !!

- 앱 실행 및 종료 이벤트 (MainActivity.java)

  ```java
  package com.example.hello;
  
  import android.os.Bundle;
  import android.util.Log;
  import android.view.View;
  import android.widget.Toast;
  
  import androidx.appcompat.app.AppCompatActivity;
  
  public class MainActivity extends AppCompatActivity {
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {//start point
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
      }
      @Override
      protected void onResume() { // 앱 다시 실행 이벤트 (Generate 사용하여 가져온다.)
          super.onResume();
          Toast.makeText(this,"Resume.....",Toast.LENGTH_SHORT).show();
  
      }
  
  
      @Override
      protected void onPause() { // 앱 닫을 때 이벤트(Generate 사용하여 가져온다.)
          super.onPause();
          Toast.makeText(this,"Pause...",Toast.LENGTH_SHORT).show();
      }
  
   
  }
  
  ```

  ##### 뷰와 뷰의 크기 및 속성

  - wrap_content은 글자 기준

    ```bash
      <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Button"
            android:textSize="36sp" />
    ```

    

  - match_parent는 layout 기준

    ```bash
     <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Button" />
    ```

    

  - dp는 픽셀을 나타 낸다. (다른 화면에서는 깨질 수 있다.)

    ````
    <Button
            android:id="@+id/button3"
            android:layout_width="200dp"
            android:layout_height="200dp"
            android:text="Button" />
    ````

    ![1566879245015](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1566879245015.png)



 ##### 레이아웃 익히기

| 레이아웃 이름   | 설명                                                         |
| --------------- | ------------------------------------------------------------ |
| 제약 레이아웃   | 제약 조건 기반 모델 , 제약 조건을 사용해 화면을구성하는 방법, 안드로이드 스튜디오에서 자동으로 설정하는 디폴트 레이아웃 |
| 리니어 레이아웃 | 박스(Box) 모델 , 한 쪽 방향으로 차례대로 뷰를 추가하며 화면을 구성하는 방법 |
| 상대 레이아웃   | 규칙(Rule) 기반 모델, 부모 컨테이너나 다른 뷰와의 상대적 위치로 화면을 구성하는 방법, 제약 레이아웃을 사용하게 되면서 상대 레이아웃은 권장하지 않음 |
| 프레임          | 싱글(Single) 모델, 가장 상위에 있는 하나의 뷰 또는 뷰그룹만 보여주는 방법, 여러개의 뷰가 들어가면 중첩하여 쌓게 됨, 가장 단순하지만 여러 개의 뷰를 중첩한 후 각 뷰를 전환하여 보여주는 방식 |
| 테이블 레이아웃 | 격자(Grid) 모델, 격자 모양의 배열을 사용하여 화면을 구성하는 방법, HTML 에서 많이 사용하눈 정렬 방식과 유사 하지만 많이 사용하지는 않음 |

- 레이아웃 안에 레이아웃

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    tools:context=".MainActivity">


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <Button
            android:id="@+id/button24"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:text="Button" />

        <Button
            android:id="@+id/button20"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:text="Button" />

    </LinearLayout>

    <Button
        android:id="@+id/button25"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

    </LinearLayout>
</LinearLayout>
```

![1566880717400](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1566880717400.png)

- 버튼 클릭시 다른 버튼 배경 및 TEST 바꾸기

```java
<MainActivity.java>
package com.example.p115;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt2 = findViewById(R.id.button26);  //R 은 모든 resource들을 관힌
    }
    public void btclick(View v){ // 눌렀을 때 다른 버튼 변화 주기
        bt2.setBackgroundColor(Color.RED);
        bt2.setText("Clicked");
    }
}

```

```xml
<XML>

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button27"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="btclick"
        android:text="Button" />

    <Button
        android:id="@+id/button26"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button" />
</LinearLayout>
```

![1566881731314](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1566881731314.png)

-  뷰 영역 알아보기

  - padding : 테두리 안쪽 공간

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/colorAccent"
        android:orientation="vertical"
        tools:context=".MainActivity">
    
        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="50dp"
            android:paddingTop="100dp"
            android:paddingBottom="50dp"
            android:text="Button" />
    </LinearLayout>
    ```

    

  - layout_margin : 테두리 바깥쪽 공간 

  - gravity :  전체를 설정

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/colorAccent"
        android:gravity="center"
        android:orientation="vertical"
        tools:context=".MainActivity">
    
        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="50dp"
            android:paddingTop="100dp"
            android:paddingBottom="50dp"
            android:text="Button" />
    </LinearLayout>
    ```

- weight : 비율로 배치 (Linearlayout을 1:2 비율로 설정)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorAccent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:background="@color/colorAccent"
        android:orientation="horizontal">

        <Button
            android:id="@+id/button4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Button" />

        <Button
            android:id="@+id/button3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Button" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="2"
        android:background="#FF0000"
        android:orientation="horizontal"></LinearLayout>

</LinearLayout>
```

- Relative Layout

  - alignParent

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
    
        <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentTop="false"
            android:layout_alignParentBottom="true"
            android:text="Button" />
    </RelativeLayout>
    ```

    

- 각 버튼별로 이미지 및 layout 나타내기

```xml
<xml>

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity" >

    <FrameLayout
        android:id="@+id/fr"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="2"
        android:background="#FFEB3B">

        <androidx.constraintlayout.widget.ConstraintLayout
            android:id="@+id/registerLayter"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#FFEB3B">

            <TextView
                android:id="@+id/textView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="회원가입"
                android:textColor="#9C27B0"
                android:textSize="30sp"
                tools:layout_editor_absoluteX="147dp"
                tools:layout_editor_absoluteY="59dp" />

            <Button
                android:id="@+id/button5"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
        </androidx.constraintlayout.widget.ConstraintLayout>

        <androidx.constraintlayout.widget.ConstraintLayout
            android:id="@+id/logLayer"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#FF9800">

            <Button
                android:id="@+id/button6"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Button" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="로그인"
                android:textColor="#000C0000"
                android:textSize="30sp"
                tools:layout_editor_absoluteX="164dp"
                tools:layout_editor_absoluteY="110dp" />
        </androidx.constraintlayout.widget.ConstraintLayout>

    </FrameLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="2"
        android:background="#03A9F4"
        android:orientation="horizontal">

        <ImageView
            android:id="@+id/img"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            tools:srcCompat="@tools:sample/avatars" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="3.5"
        android:background="#FF5722"
        android:orientation="horizontal">

        <Button
            android:id="@+id/bt1"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />

        <Button
            android:id="@+id/bt2"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />

        <Button
            android:id="@+id/bt3"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />

        <Button
            android:id="@+id/bt4"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:onClick="clickBt"
            android:text="Button" />
    </LinearLayout>

</LinearLayout>
```

```java
<MainActivity.java>

package com.example.p158;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ConstraintLayout logLayer, registerLayter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }

    private void setUi() {
        img = (ImageView) findViewById(R.id.img);

        logLayer = findViewById(R.id.logLayer);
        registerLayter = findViewById(R.id.registerLayter);
        disable();
    }

    public void disable(){
        logLayer.setVisibility(View.INVISIBLE);
        registerLayter.setVisibility(View.INVISIBLE);
    }

    public void clickBt(View v){
        // 안드로이드는 알아서 argument를 넣어준다.
        //View 모든 widget의 최상위
        if(v.getId() == R.id.bt1){ // id가 bt1 이면 , 버튼을 4개 만들어 사용해도 된다.
            disable();
            img.setImageResource(R.drawable.g1);
        }else if(v.getId() == R.id.bt2){
            disable();
            img.setImageResource(R.drawable.g2);
        }else if(v.getId() == R.id.bt3){
            logLayer.setVisibility(View.VISIBLE);
            registerLayter.setVisibility(View.INVISIBLE);
        }else if(v.getId() == R.id.bt4){
            logLayer.setVisibility(View.INVISIBLE);
            registerLayter.setVisibility(View.VISIBLE);
        }
    }

}

```

- 각 버튼 별로 해당 위치에 이미지 나타내기

````xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:visibility="visible"
    tools:context=".MainActivity">

    <LinearLayout
        android:id="@+id/page1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"


        android:layout_weight="10"
        android:orientation="vertical"
        android:visibility="visible">

        <LinearLayout
            android:id="@+id/up"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="2"
            android:background="#FFFFFF"
            android:orientation="vertical">

            <ImageView
                android:id="@+id/img1"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:background="#E91E63"
                tools:srcCompat="@tools:sample/avatars" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="3"
            android:orientation="vertical">

            <Button
                android:id="@+id/btup"
                android:layout_width="50dp"
                android:layout_height="match_parent"
                android:layout_gravity="center"
                android:layout_weight="1"
                android:onClick="clickBt"
                android:text="Button" />

            <Button
                android:id="@+id/btdown"
                android:layout_width="50dp"
                android:layout_height="match_parent"
                android:layout_gravity="center"
                android:layout_weight="1"
                android:onClick="clickBt"
                android:text="Button"
                android:textColor="#FFFFFF" />
        </LinearLayout>

        <LinearLayout
            android:id="@+id/down"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="2"
            android:background="#FFEB3B"
            android:orientation="vertical"
            android:visibility="visible">

            <ImageView
                android:id="@+id/img2"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:srcCompat="@tools:sample/avatars" />
        </LinearLayout>


    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:background="#00BCD4"
        android:gravity="bottom">

        <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:text="Button" />

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:text="Button" />
    </LinearLayout>

</LinearLayout>
````

```java
package com.example.p170;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout up;
    LinearLayout down;
    ImageView img1;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setui();
    }

    private void setui() {
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        up.setVisibility(View.INVISIBLE);
        down.setVisibility(View.INVISIBLE);

    }

    public void clickBt(View v){
        // 안드로이드는 알아서 argument를 넣어준다.
        //View 모든 widget의 최상위
        if(v.getId() == R.id.btup){ // id가 bt1 이면 , 버튼을 4개 만들어 사용해도 된다.
            up.setVisibility(View.VISIBLE);
            down.setVisibility(View.INVISIBLE);
            img1.setImageResource(R.drawable.g1);

        }else if(v.getId() == R.id.btdown){
            up.setVisibility(View.INVISIBLE);
            down.setVisibility(View.VISIBLE);
            img2.setImageResource(R.drawable.g1);
        }
    }
}

```

- 입력하는 Test카운트 하기

```xml
<XML>

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:id="@+id/page2"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="2"
            android:orientation="vertical">

            <EditText
                android:id="@+id/editText"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:ems="10"
                android:hint="입력상자"
                android:inputType="textPersonName"
                android:textAlignment="center" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="4"
            android:orientation="vertical">

            <TextView
                android:id="@+id/textView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="TextView" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_gravity="center"
            android:layout_weight="5">

            <Button
                android:id="@+id/button2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="ctnbt"
                android:text="전송" />

            <Button
                android:id="@+id/button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="닫기" />
        </LinearLayout>
    </LinearLayout>

</LinearLayout>

```

```java
package com.example.p189;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = editText.getText().toString();
                textView.setText(input.length() + "/80 byte");
                if(input.length() >= 80) {
                    editText.setText(null);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }
    public void ctnbt(View v){
        if(v.getId() == R.id.button2) { // id가 bt1 이면 , 버튼을 4개 만들어 사용해도 된다.
            Toast.makeText(this,"전송 완료",Toast.LENGTH_SHORT).show();
            editText.setText(null);
        }
    }
}

```

