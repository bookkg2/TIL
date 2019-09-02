## BroadCast 와 PERMISSION(전화걸기)

(MainActivity.java)

```java
package com.example.p370;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        String[] Permissions = {
                Manifest.permission.CALL_PHONE,
        };
        ActivityCompat.requestPermissions(this, Permissions, 101);



        BroadcastReceiver boBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                ConnectivityManager connectivityManager = null;
                NetworkInfo mobile = null;
                NetworkInfo wifi = null;
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                    wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                    if (mobile != null && mobile.isConnected()) {
                        Toast.makeText(context, "moble", Toast.LENGTH_SHORT).show();
                    } else if (wifi != null && wifi.isConnected()) {
                        Toast.makeText(context, "wifi", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "not Conn", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
        registerReceiver(boBroadcastReceiver, intentFilter);
    }

    public void onClick(View v) {
        int permission = PermissionChecker.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permission == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1213-1415"));
            startActivity(intent);
        }else{
            Toast.makeText(this,"권한 부여가 안되었습니다",Toast.LENGTH_LONG).show();
            return;
        }





    }
}




```

(XML)

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:onClick="onClick"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

(Manifest)

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.p370">

    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />


    <uses-permission android:name="android.permission.CALL_PHONE" />

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

</manifest>
```

## 리싸이클러뷰 만들기

- ListView 배치 시킨다.

- Object를 하나 생성 (java -> new -> java class)

  ```java
  package com.example.p427;
  
  public class Item {//Object 생성
      String name;
      String phone;
      int imgId;
  
      public Item() {
      }
  
      public Item(String name, String phone, int imgId) {
          this.name = name;
          this.phone = phone;
          this.imgId = imgId;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public String getPhone() {
          return phone;
      }
  
      public void setPhone(String phone) {
          this.phone = phone;
      }
  
      public int getImgId() {
          return imgId;
      }
  
      public void setImgId(int imgId) {
          this.imgId = imgId;
      }
  }
  
  ```

  

- list안에 들어갈 layout을 하나 만든다. (layoout -> xml -> LinearLayout)

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:id="@+id/container"
      android:layout_width="match_parent"
      android:layout_height="match_parent">
  
      <ImageView
          android:id="@+id/imageView"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_weight="1"
          tools:srcCompat="@drawable/it01" />
  
      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:layout_weight="3"
          android:orientation="vertical">
  
          <TextView
              android:id="@+id/textView"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:layout_weight="1"
              android:text="TextView"
              android:textSize="36sp" />
  
          <TextView
              android:id="@+id/textView2"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:layout_weight="1"
              android:text="TextView"
              android:textSize="36sp" />
      </LinearLayout>
  </LinearLayout>
  
  ```

  

- Adapter를 이용하야 list와 date 간에 연결을 해준다. (이미지 더하기 기능 포함)

```java
package com.example.p427;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> list;
    ListView listView;
    LinearLayout container;
    ItemAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        container= findViewById(R.id.container);

    }
    class ItemAdapter extends BaseAdapter{

        ArrayList<Item> alist;

        public ItemAdapter(){}
        public ItemAdapter(ArrayList<Item> alist){
            this.alist = alist;
        }

        public void addItem(Item item){
            alist.add(item);
        }

        @Override
        public int getCount() {
            return alist.size();
        }

        @Override
        public Object getItem(int i) {
            return alist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {//각각의 셀의 화면을 만들어서 넘겨준다.
            View myview = null;
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE); //View 만들기 위한 과정
            myview = inflater.inflate(R.layout.layout, container,true);
            ImageView iv =  myview.findViewById(R.id.imageView);
            TextView tx1 = myview.findViewById(R.id.textView);
            TextView tx2 = myview.findViewById(R.id.textView2);

            iv.setImageResource(alist.get(i).getImgId());
            tx1.setText(alist.get(i).getName());
            tx2.setText(alist.get(i).getPhone());

            //거꾸로 찍는 법
             //tx1.setText(alist.get(alist.size() - i - 1).getName());
           // tx2.setText(alist.get(alist.size() - i - 1).getPhone());
            return myview;
        }//list 개수 만큼 호출 된다.

    }//listview에 뿌리기전 과정, 즉 가져온 데이터와 listview와 연결

    public void clickBt(View view){
        getData();
        itemAdapter = new ItemAdapter(list);
        listView.setAdapter(itemAdapter);

    }

    public void clickBt2(View view){
            itemAdapter.addItem(new Item("김재영","010-4776-4831",R.drawable.it11)); //데이터 추가
            itemAdapter.notifyDataSetChanged();// 한번 리플레쉬 해줘야 한다.
    }


    private void getData() {
        list = new ArrayList<>();
        list.add(new Item("임찬규","010-1111-2222",R.drawable.it01));
        list.add(new Item("고우석","010-1111-2222",R.drawable.it02));
        list.add(new Item("진해수","010-1111-2222",R.drawable.it03));
        list.add(new Item("켈리","010-1111-5555",R.drawable.it04));
        list.add(new Item("차우찬","010-1111-2222",R.drawable.it05));
        list.add(new Item("한선태","010-1111-2222",R.drawable.it06));
        list.add(new Item("구본혁","010-1111-2222",R.drawable.it07));
        list.add(new Item("오지환","010-1111-2222",R.drawable.it08));
        list.add(new Item("이천웅","010-1111-2222",R.drawable.it09));
        list.add(new Item("김현수","010-1111-2222",R.drawable.it10));
    }
}

```

- 해당 번호에 전화걸기 

```java
package com.example.p427;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener { //Adapter에 있는 listview 에 클릭 속성을 줘야 하기 때문에 implements 해준다.

    ArrayList<Item> list;
    ListView listView;
    LinearLayout container;
    ItemAdapter itemAdapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        container= findViewById(R.id.container);
        listView.setOnItemClickListener(this);
        textView = findViewById(R.id.textView2);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        String[] Permissions = {
                Manifest.permission.CALL_PHONE,
        };
        ActivityCompat.requestPermissions(this, Permissions, 101);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Item item = list.get(i);
      int permission = PermissionChecker.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permission == PackageManager.PERMISSION_GRANTED) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+item.getPhone()));
                startActivity(intent);

        }else{
            Toast.makeText(this,"권한 부여가 안되었습니다",Toast.LENGTH_LONG).show();
            return;
        }
        //Toast.makeText(this, "ddd", Toast.LENGTH_SHORT).show();
    }


    class ItemAdapter extends BaseAdapter{

        ArrayList<Item> alist;

        public ItemAdapter(){}
        public ItemAdapter(ArrayList<Item> alist){
            this.alist = alist;
        }

        public void addItem(Item item){
            alist.add(item);
            list = alist; // alist를 전역 list에 반영하자
        }

        @Override
        public int getCount() {
            return alist.size();
        }

        @Override
        public Object getItem(int i) {
            return alist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {//각각의 셀의 화면을 만들어서 넘겨준다.
            View myview = null;
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE); //View 만들기 위한 과정
            myview = inflater.inflate(R.layout.layout, container,true);
            ImageView iv =  myview.findViewById(R.id.imageView);
            TextView tx1 = myview.findViewById(R.id.textView);
            TextView tx2 = myview.findViewById(R.id.textView2);

            iv.setImageResource(alist.get(i).getImgId());
            tx1.setText(alist.get(i).getName());
            tx2.setText(alist.get(i).getPhone());

            //거꾸로 찍는 법
             //tx1.setText(alist.get(alist.size() - i - 1).getName());
           // tx2.setText(alist.get(alist.size() - i - 1).getPhone());
            return myview;
        }//list 개수 만큼 호출 된다.

    }//listview에 뿌리기전 과정, 즉 가져온 데이터와 listview와 연결

    public void clickBt(View view){
        getData();
        itemAdapter = new ItemAdapter(list);
        listView.setAdapter(itemAdapter);

    }

    public void clickBt2(View view){
            itemAdapter.addItem(new Item("김재영","010-4776-4831",R.drawable.it11)); //데이터 추가
            itemAdapter.notifyDataSetChanged();// 한번 리플레쉬 해줘야 한다.
    }




    private void getData() {
        list = new ArrayList<>();
        list.add(new Item("임찬규","010-1111-2222",R.drawable.it01));
        list.add(new Item("고우석","010-1111-2222",R.drawable.it02));
        list.add(new Item("진해수","010-1111-2222",R.drawable.it03));
        list.add(new Item("켈리","010-1111-5555",R.drawable.it04));
        list.add(new Item("차우찬","010-1111-2222",R.drawable.it05));
        list.add(new Item("한선태","010-1111-2222",R.drawable.it06));
        list.add(new Item("구본혁","010-1111-2222",R.drawable.it07));
        list.add(new Item("오지환","010-1111-2222",R.drawable.it08));
        list.add(new Item("이천웅","010-1111-2222",R.drawable.it09));
        list.add(new Item("김현수","010-1111-2222",R.drawable.it10));
    }
}

```

## 스피너 사용하기

(MainActivity.java)

```java
package com.example.p436;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<String> list;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        getData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);//안드로이드 에서 제공하는 Adapter 사용 , list를 사용하는 이유는 다른 형식으로 list구현 하기 위해서 (시작 화면 구성)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//손가락으로 눌렀을 때 밑으로 떨어지는 모양 설정
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this); //spinner에 이벤트 발생하면 처리
    }

    private void getData() {
        list = new ArrayList<>();
        list.add("01083546854");
        list.add("01083546854");
        list.add("01083546854");
        list.add("01083546854");
        list.add("01083546854");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String str = list.get(i);
        Toast.makeText(this,"" + str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="CHOICE ITEM" />

    <Spinner
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```

- 이미지 view 와 별점 사용

(MainActivity.java)

```java
package com.example.p436;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<Integer> list;
    Spinner spinner;
    ImageView imageView;
    RatingBar ratingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        imageView= findViewById(R.id.imageView);
        ratingBar = findViewById(R.id.ratingBar);


        getData();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,list);//안드로이드 에서 제공하는 Adapter 사용 , list를 사용하는 이유는 다른 형식으로 list구현 하기 위해서 (시작 화면 구성)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//손가락으로 눌렀을 때 밑으로 떨어지는 모양 설정
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this); //spinner에 이벤트 발생하면 처리
    }

    private void getData() {
        list = new ArrayList<>();
        list.add(R.drawable.it01);
        list.add(R.drawable.it02);
        list.add(R.drawable.it03);
        list.add(R.drawable.it04);
        list.add(R.drawable.it05);
        list.add(R.drawable.it06);
        list.add(R.drawable.it07);
        list.add(R.drawable.it08);
        list.add(R.drawable.it09);
        list.add(R.drawable.it10);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int str = list.get(i);


        imageView.setImageResource(str);


        ratingBar.setNumStars(10);
        //ratingBar.setStepSize(1);
        ratingBar.setRating(i+1);
        return;


      //  Toast.makeText(this,"" + str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="CHOICE ITEM" />

    <Spinner
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        tools:srcCompat="@tools:sample/avatars" />

    <RatingBar
        android:id="@+id/ratingBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:rating="0" />

</LinearLayout>
```

