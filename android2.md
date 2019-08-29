## 기본 위젯과 드로어블 사용

##### 텍스트뷰

- text 속성을 추가하는 방법은 text 속성 값으로 직접 문자열을 넣는 방법과 /app/res/values 폴더에서 string.xml 파일에 작성하여 이용합니다

        ```xml
<resources>
    <string name="app_name">P170</string>
</resources>

        ```

- textColor 속성은 # 사용하고, Alpha는 투명도로 두명하지 않음(FF), 투명함(00), 반투명(88)을 설정
- textSize 는 "dp","sp","px"등을 사용할 수 있다. "sp" 단휘는 단말의 해상도에 따라 글자의 크기를 일정한 크기로 보일 수 있게 하며 폰트를 변경했을 때 해당 폰트도 반영되도록 해준다. 
- textStyle은 "normal","bold","ital-ic" 등의 값을 지정할 수 있으며, | 기호를 사용하면 여러 개의 속성 값을 함께 지정할 수 있습니다. 이때 | 앞뒤에 공백이 있으면 안된다. 
- maxLines 문자열의 최대 줄 수를 설정한다. 한 줄로만 표시하고 싶을 때는 값을 "1"로 설정 



##### 버튼

- 여러 가지 버튼 위젯들 (Radio는 둘장 하나, Check는 복수 선택 가능)

      ````xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity" >

    <Switch
        android:id="@+id/switch1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Switch" />

    <ToggleButton
        android:id="@+id/toggleButton"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="ToggleButton" />

    <RadioGroup
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <RadioButton
            android:id="@+id/radioButton2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="RadioButton" />
    
        <RadioButton
            android:id="@+id/radioButton"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="RadioButton" />
    </RadioGroup>

    <CheckBox
        android:id="@+id/checkBox2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="CheckBox" />

    <CheckBox
        android:id="@+id/checkBox"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="CheckBox" />

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button" />
</LinearLayout>
      ````

<추가적으로 정리!!!!!!!!!>



- onClickListener 를 이용하여 버튼 기능 구현

```java
package com.example.p178;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        Button bt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt  = findViewById(R.id.button);
        bt.setOnClickListener(this); //현재 click으로 반응 하겠다.(즉 implement 영향으로 onclicl 메소드 호출)
    }

    @Override
    public void onClick(View view){
        Toast.makeText(this,"Click",Toast.LENGTH_SHORT).show();
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



    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button" />

</LinearLayout>
```



 ###### 이벤트 처리하기



- OnClickListener의 경우에는 버튼과 같은 객체에 자주 사용되지만 OnTouchListener 는 버튼 뿐만 아니라 일반적인 뷰 객체에도 사용할 수 있따. 따라서 사용자와의 상호작용이 필요한 경우 훨씬 많이 사용된다. OnTouchListener에 정의된 onTouch()메서드는 사용자가 손가락으로 터치할 때마다 발생되는 이벤트를 받아 처리할수 있으면, OnKeyListener에 정의된 onKey()메서드는 키 입력이 발생할 때마다 발생하는 이벤트를 받아 처리합니다. FocusChange 이벤트는 OnFocusChangeListener를 사용해 처리 합니다. 

​       

| 속성           | 설명                                                         |
| -------------- | ------------------------------------------------------------ |
| 터치 이벤트    | 화면을 손가락으로 누를 때 발생하는 이벤트                    |
| 키 이벤트      | 키패드나 하드웨어 버튼을 누를 때 발생하는 이벤트             |
| 제스처 이벤트  | 터치 이벤트 중에 스크롤과 같이 일정 패턴으로 구분되는 이벤트 |
| 포커스         | 뷰마다 순서대로 주어지는 포커스                              |
| 화면 방향 변경 | 화면의 방향이 가로와 세로로 바뀜에 따라 발생하는 이벤트      |

- 제스처 이벤트를 통해 처리할 수 있는 이벤트

| 메서드                 | 이벤트 유형                                                  |
| ---------------------- | ------------------------------------------------------------ |
| onDown()               | 화면이 눌렀을 경우                                           |
| onShowPress()          | 화면이 눌렀다 뗴어지는 경우                                  |
| onSingleTapUp()        | 화면이 한 손가락으로 눌렀다 떼어지는 경우                    |
| onSingleTapConfirmed() | 화면이 한 손가락으로 눌려지는 경우                           |
| onDoubleTap()          | 화면이 두 손가락으로 눌려지는 경우                           |
| onDoubleTapEvent()     | 화면이 두 손가락으로 눌려진 상태에서 떼거나 이동하는 등 세부적인 액션을 취하는 행동 |
| onScroll()             | 화면이 눌린 채 일정한 속도와 방향으로 움직였다 떼는 경우     |
| onFing()               | 화면이 눌린 채 가속도를 붙여 손가락을 움직였다 떼는 경우     |
| onLongPress()          | 화면을 손가락으로 오래 누르는 경우                           |

<예시>

(MainActivity.java)

```java
package com.example.p200;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View view,view2;
    TextView testView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }

    private void setUi() {
        view = findViewById(R.id.view);
        view2 = findViewById(R.id.view2);
        testView = findViewById(R.id.textView);


        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction(); // 손가락 행동 캐치
                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    printMsg("DOWN:" + curX + "," + curY);
                }else if(action == MotionEvent.ACTION_MOVE){
                    printMsg("MOVE:" + curX + "," + curY);
                }else if(action == MotionEvent.ACTION_UP){
                    printMsg("UP:" + curX + "," + curY);
                }
                return true;
            }
        });
    }

    private void printMsg(String str){//어디서든 String 이 들어오면 textView에 출력 한다.
        testView.append(str+"\n");
    }

}

```

> MotionEvent.ACTION_DOWN : 손가락이 눌렀을 때
>
> MotionEvent.ACTION_MOVE : 손가락이 눌린 상태로 움직일 때
>
> MotionEvent.ACTION_UP : 손가락이 떼졌을 때

(XML)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <View
        android:id="@+id/view2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:background="#CDDC39" />

    <View
        android:id="@+id/view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:background="#FFEB3B" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:orientation="vertical">

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="2"
            android:text="TextView" />
    </LinearLayout>

</LinearLayout>
```

- GestureDetector 사용 : 제스처 이벤트를 처리해주는 클래스는 GestureDetector

  (MainActivity.java) - view2 이용

```java
package com.example.p200;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View view,view2;
    TextView testView;
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }

    private void setUi() {
        view = findViewById(R.id.view);
        view2 = findViewById(R.id.view2);
        testView = findViewById(R.id.textView);
        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                printMsg("onDown() 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                printMsg("onShowPress() 호출됨");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                printMsg("onSingleTapUp() 호출됨");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                printMsg("onScroll() 호출됨");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                printMsg("onLongPress() 호출됨");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                printMsg("onFling() 호출됨");
                return true;
            }
        });
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction(); // 손가락 행동 캐치
                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    printMsg("DOWN:" + curX + "," + curY);
                }else if(action == MotionEvent.ACTION_MOVE){
                    printMsg("MOVE:" + curX + "," + curY);
                }else if(action == MotionEvent.ACTION_UP){
                    printMsg("UP:" + curX + "," + curY);
                }
                return true;
            }
        });
    }

    private void printMsg(String str){//어디서든 String 이 들어오면 textView에 출력 한다.
        testView.append(str+"\n");
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
    android:orientation="vertical"
    tools:context=".MainActivity">

    <View
        android:id="@+id/view2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:background="#CDDC39" />

    <View
        android:id="@+id/view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:background="#FFEB3B" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:orientation="vertical">

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="2"
            android:text="TextView" />
    </LinearLayout>

</LinearLayout>
```

##### 키 이벤트 처리하기 

| 키 코드               | 설명                       |
| --------------------- | -------------------------- |
| KEYCODE_DPAD_LEFT     | 왼쪽 화살표                |
| KEYCODE_DPAD_RIGHT    | 오른쪽 화살표              |
| KEYCODE_DPAD_UP       | 위쪽 화살표                |
| KEYCODE_DPAD_DOWN     | 아래쪽 화살표              |
| KEYCODE_DPAD_CENTER   | [중앙] 버튼                |
| KEYCODE_CALL          | [통화] 버튼                |
| KEYCODE_ENDCALL       | [통화 종료] 버튼           |
| KEYCODE_BACK          | [뒤로가기] 버튼            |
| KEYCODE_VOLUME_UP     | [소리 크기 증가] 버튼      |
| KEYCODE_VOLUME_DOWN   | [소리 크기 감소] 버튼      |
| KEYCODE_0 ~ KEYCODE_9 | 숫자 0부터 9까지의 키 값   |
| KEYCODE_A ~ KEYCODE_Z | 알파벳 A부터 Z까지의 키 값 |

```java
(MainActivity.java)

 @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//onKeyDown :  핸드폰에 있는 다양한 버튼을 의미
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this,"Back......",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
```

- Bundle 과 SharedPreferences을 이용한 데이터 저장 
  - Bundle 은 앱을 실행 중에 데이터를 저장 (앱을 종료하면 삭제됨)
  - SharedPreferences은 앱을 종료해도 데이터 저장 (앱을 삭제해야 삭제됨)

​         (Bundle)

```java
(MainActivity.java)

package com.example.p212;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button,button2;
    String appID;
    EditText editText;
    @Override
    protected void onCreate(final Bundle savedInstanceState) { // 앱이 실행 되면 Bundle이 동작한다. 즉 Bundle을 이용하면 자동으로 동작을 구현 할 수 있다(값을 저장해 놓고 가져올 수 있다.(앱이 살아 있을 경우)).
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {//Bundle을 사용해서 구현 함으로 해당 기능이 onCreate 안에 있어야 한다.
            @Override
            public void onClick(View view) {
                // editText 는 String 이 아니여서 형변환을 해줘야함

                //savedInstanceState.putString("save",appID);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {//Bundle을 사용해서 구현 함으로 해당 기능이 onCreate 안에 있어야 한다.
            @Override
            public void onClick(View view) {
                appID = editText.getText().toString();
                String data = null;
                if(savedInstanceState != null){
                    data = savedInstanceState.getString("ID");
                }else{
                    data = "Empty";
                }
                Toast.makeText(MainActivity.this,appID,Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {//Bundle : 앱이 떠있을 때 잠시 저장했다 사용하는것 ~
        super.onSaveInstanceState(outState);

        Toast.makeText(MainActivity.this,appID,Toast.LENGTH_SHORT).show();
        outState.putString("ID", appID); //appID 변수의 값을 저장
    }
}

```

```xml
(XML)

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity" >

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Name" />

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button" />

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button" />
</LinearLayout>
```

(SharedPreferences)



```java
(MainActivity.java)

package com.example.p213;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //SharedPreferences : 앱이 꺼져도 데이터 값을 저장 (앱을 삭제 하면 죽음 )
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickbt(View view){
        if(view.getId() == R.id.button){
            //save
            sp = getSharedPreferences("ma",MODE_PRIVATE); //MODE_PRIVATE : 나밖에 못보게 하겠다.
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("key01","id01");
            editor.commit();
        }else if(view.getId() == R.id.button2){
            // load
            sp = getSharedPreferences("ma",MODE_PRIVATE);
            String id = sp.getString("key01","default"); //두번째 argument는 default값
            Toast.makeText(this,id,Toast.LENGTH_SHORT).show();
        }
    }
}

```

```xml
(XML)

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

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="clickbt"
        android:text="Button" />
</LinearLayout>
```





- 단말 방향을 전환했을 때 이벤트 처리하기 

- 토스트, 스낵바 그리고 대화상자 사용하기 

  - toast 설정 변경 (이미지로 toast 구성 및 toast 위치)

    - 이미지로 toast 구성하기 위해서는 이미지로된 또다른 XML 형식을 만들어 준다.

    ```java
    package com.example.p217;
    
    import androidx.appcompat.app.AppCompatActivity;
    
    import android.os.Bundle;
    import android.view.Gravity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Toast;
    
    public class MainActivity extends AppCompatActivity {
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
        public void toast(View view){
            //LayoutInflater xml 가져와서 이미지로 Toast 띄우기
            LayoutInflater intflater = getLayoutInflater();
            View tview =  intflater.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.tlayout)); //findViewById(R.id.tlayout) : xml 판
            Toast toast  = new Toast(this);
            toast.setGravity(Gravity.CENTER,0,-100);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(tview);
            toast.show();
    
               /* Toast toastView = Toast.makeText(this,"호잇",Toast.LENGTH_LONG);
                toastView.setGravity(Gravity.TOP|Gravity.TOP,50,300); //toast 위치
                toastView.show();*/
    
    
    
        }
        public void snack(View view){
    
        }
        public void dialog(View view){
    
        }
        public void progress(View view){
    
        }
    }
    
    ```

    ```xml
    (toast.xml)
    
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/tlayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
    
        <ImageView
            android:id="@+id/imageView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:srcCompat="@drawable/g2" />
    </LinearLayout>
    
    ```

    ```xml
    (main.xml)
    
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
            android:onClick="toast"
            android:text="Toast" />
    
        <Button
            android:id="@+id/button2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="snack"
            android:text="SNACK" />
    
        <Button
            android:id="@+id/button3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="dialog"
            android:text="DIalog" />
    
        <Button
            android:id="@+id/button4"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="progress"
            android:text="progress" />
    
        <Button
            android:id="@+id/button5"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="progress"
            android:text="progressEnd" />
    
    </LinearLayout>
    ```

    

  - dialog 설정 (dialog 부분 , AlertDialog.Builder 사용)

    ```java
    package com.example.p217;
    
    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;
    
    import android.content.DialogInterface;
    import android.os.Bundle;
    import android.view.Gravity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;
    import android.widget.Toast;
    
    public class MainActivity extends AppCompatActivity {
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
        public void toast(View view){
            //LayoutInflater xml 가져와서 이미지로 Toast 띄우기 즉 임이의 view 객체를 만드는 방법
            LayoutInflater intflater = getLayoutInflater();
            View tview =  intflater.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.tlayout)); //findViewById(R.id.tlayout) : xml 판
            Toast toast  = new Toast(this);
            toast.setGravity(Gravity.CENTER,0,-100);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(tview);
            toast.show();
    
               /* Toast toastView = Toast.makeText(this,"호잇",Toast.LENGTH_LONG);
                toastView.setGravity(Gravity.TOP|Gravity.TOP,50,300); //toast 위치
                toastView.show();*/
    
    
    
        }
        public void snack(View view){
    
        }
        public void dialog(View view){
            LayoutInflater intflater = getLayoutInflater();
            View tview =  intflater.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.tlayout)); //findViewById(R.id.tlayout) : xml 판
            
            TextView tv = tview.findViewById(R.id.textView);
            tv.setText("glglggl"); // 기존의 view 글 가져와서 수정도 가능 하다 .
            
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("my dialg"); 
            builder.setMessage("Do you Exit App ? ");
            builder.setIcon(R.drawable.g2);
            builder.setView(tview);
    
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
    
                }
            });//두번째 argument는 동작,DialogInterface.OnClickListener()
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
    
                }
            });
            AlertDialog dialog = builder.create();
            builder.setCancelable(false); // alert 중 배경화면 및 뒤로가기 무력화 , true 는 가능 하게 함
            builder.show();
        }
        public void progress(View view){
    
        }
    }
    
    ```

    ```xml
    (toast.xml)
    
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/tlayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
    
        <ImageView
            android:id="@+id/imageView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:srcCompat="@drawable/g2" />
    </LinearLayout>
    
    ```

    ```xml
    (main xml)
    
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
            android:onClick="toast"
            android:text="Toast" />
    
        <Button
            android:id="@+id/button2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="snack"
            android:text="SNACK" />
    
        <Button
            android:id="@+id/button3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="dialog"
            android:text="DIalog" />
    
        <Button
            android:id="@+id/button4"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="progress"
            android:text="progress" />
    
        <Button
            android:id="@+id/button5"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="progress"
            android:text="progressEnd" />
    
    </LinearLayout>
    ```

    

  - Progressbar 설정 및 구현 

    ```java
    (MainActivity.java)
    
    package com.example.p228;
    
    import androidx.appcompat.app.AppCompatActivity;
    
    import android.app.ProgressDialog;
    import android.content.DialogInterface;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ProgressBar;
    
    public class MainActivity extends AppCompatActivity {
        ProgressBar progressBar;
        ProgressDialog progressDialog;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            progressBar = findViewById(R.id.progressBar);
        }
        public void bar(View view){
            if(view.getId() == R.id.button){
                progressBar.setProgress(progressBar.getProgress()+10); //증가
            }else if(view.getId() == R.id.button2){
                progressBar.setProgress(progressBar.getProgress()-10); // 감소
            }
        }
        public void dialog(View view){
            if(view.getId() == R.id.button3){
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("Progress....");
                progressDialog.setButton(progressDialog.BUTTON_NEGATIVE, "취소", new DialogInterface.OnClickListener() {//종료 버튼 만들기
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
    
                    }
                });
                progressDialog.setCancelable(false);
                progressDialog.show();
    
            }else if(view.getId() == R.id.button4){//progress 종료
                progressDialog.dismiss();
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
        android:baselineAligned="false"
        android:orientation="vertical"
        tools:context=".MainActivity" >
    
        <ProgressBar
            android:id="@+id/progressBar"
            style="?android:attr/progressBarStyle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    
        <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="bar"
            android:text="increament" />
    
        <Button
            android:id="@+id/button2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="bar"
            android:text="decreament" />
    
        <Button
            android:id="@+id/button3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="dialog"
            android:text="open" />
    
        <Button
            android:id="@+id/button4"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="dialog"
            android:text="close" />
    </LinearLayout>
    ```

- seekbar 가 변화하면 progressbar가 변하고 text에 값 출력

  (XML)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity" >

    <SeekBar
        android:id="@+id/seekBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <ProgressBar
        android:id="@+id/progressBar"
        style="?android:attr/progressBarStyleHorizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />
</LinearLayout>
```

 (MainActivity.java)

```java
package com.example.p229;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText(String.valueOf(i));
                progressBar.setProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });







    }


}

```

