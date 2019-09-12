## 멀티미디어 다루기

- 음악 파일 재생하기

(Manifests)

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="org.techtown.audio.player">

    <uses-permission android:name="android.permission.INTERNET" />

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

(MainActivity.java)

```java
package org.techtown.audio.player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String AUDIO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";

    MediaPlayer mediaPlayer;
    int position = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playAudio(AUDIO_URL);
                Toast.makeText(getApplicationContext(),"음악 파일 재생 시작됨.", Toast.LENGTH_LONG).show();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    Toast.makeText(getApplicationContext(),"음악 파일 재생 중지됨.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    position = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                    Toast.makeText(getApplicationContext(),"음악 파일 재생 일시정지됨.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    mediaPlayer.seekTo(position);
                    Toast.makeText(getApplicationContext(),"음악 파일 재생 재시작됨.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void playAudio(String url) {
        killMediaPlayer();

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        killMediaPlayer();
    }

    private void killMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

```

(Xml)

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
        android:text="재생" />

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="중지" />

    <Button
        android:id="@+id/button3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="일시정지" />

    <Button
        android:id="@+id/button4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="재시작" />
</LinearLayout>
```



- 음악 재생하기 2 (앱에 음악 파일을 저장하고)



- Video 재생 (replay 버튼에)

(Manifests)

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="org.techtown.video.player">

    <uses-permission android:name="android.permission.INTERNET"/>

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

(MainActivity.java)

```java
package com.example.p641;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;



public class MainActivity extends AppCompatActivity {
   // public static final String VIDEO_URL = "https://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    VideoView videoView;
    MediaPlayer mediaPlayer;
    int position = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

    }

    @Override
    protected void onDestroy() {//back 버튼 누르면 종료
        super.onDestroy();
        if(mediaPlayer != null){
            releasemedia();
        }
    }

    public void releasemedia(){
        if(mediaPlayer != null){
            mediaPlayer.release();
        }
    }


    public void paly(View view){
        releasemedia();
        mediaPlayer = MediaPlayer.create(this,R.raw.kalimba);

        mediaPlayer.start();
    }

    public void stop(View view){

    }

    public void pause(View view){

    }

    public void replay(View view){
        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/" + R.raw.sample_video);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
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
        android:text="재생하기" />

    <VideoView
        android:id="@+id/videoView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</LinearLayout>
```

## 위치기반 서비스와 앱 위젯 사용하기

- GPS로 나의 위치 확인하기 

  (xml)

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      tools:context=".MainActivity">
  
      <TextView
          android:id="@+id/textView"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="TextView" />
  </LinearLayout>
  ```

  (manifests) - 'ACCESS_FINE_LOCATION' permission 추가

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <manifest xmlns:android="http://schemas.android.com/apk/res/android"
      package="com.example.p673">
      <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
  
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

  (MainActivity.java)

  ```java
  package com.example.p673;
  
  import androidx.appcompat.app.AppCompatActivity;
  import androidx.core.app.ActivityCompat;
  import androidx.core.content.PermissionChecker;
  
  import android.Manifest;
  
  import android.content.Context;
  
  import android.content.pm.PackageManager;
  
  import android.location.Location;
  import android.location.LocationManager;
  
  import android.os.Bundle;
  
  import android.widget.TextView;
  import android.widget.Toast;
  
  
  import android.location.LocationListener;
  
  
  
  
  public class MainActivity extends AppCompatActivity {
      TextView textView;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          textView = findViewById(R.id.textView);
          String[] permissions = {
                  Manifest.permission.ACCESS_FINE_LOCATION
          };
          ActivityCompat.requestPermissions(this, permissions, 101);
  
          int check =
                  PermissionChecker.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);
  
          if(check == PackageManager.PERMISSION_GRANTED){//수락
              Toast.makeText(this,
                      "ACCEPT", Toast.LENGTH_SHORT).show();
              startLocationService();
              return;
  
          }else{
              Toast.makeText(this,
                      "DENY", Toast.LENGTH_SHORT).show();
              return;
          }
      }
      public void startLocationService() {
          LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
  
          try {
              Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
              if (location != null) {
                  double latitude = location.getLatitude();
                  double longitude = location.getLongitude();
                  String message = "최근 위치 -> Latitude : " + latitude + "\nLongitude:" + longitude;
  
                  textView.setText(message);
              }
  
              GPSListener gpsListener = new GPSListener();//장치에서 바뀌는 위치를 계속해서 받는다.
              long minTime = 10000; //10초에 한번씩 체크 ,크게 잡으면 배터리 소요를 줄일 수 있다.
              float minDistance = 0;
  
              manager.requestLocationUpdates(//현재 위치를 반영하겠다. (어떤걸로 할거냐 (NETWORK_PROVIDER는 와이파이나 기지국), 변화는데 걸리는 시간, 측정 거리,좌표랑 경도를 실시간으로 가져옴 )
                      LocationManager.GPS_PROVIDER,
                      minTime, minDistance, gpsListener);
  
              Toast.makeText(getApplicationContext(), "내 위치확인 요청함",
                      Toast.LENGTH_SHORT).show();
  
          } catch(SecurityException e) {
              e.printStackTrace();
          }
      }
  
      class GPSListener implements LocationListener {
          public void onLocationChanged(Location location) {
              Double latitude = location.getLatitude();
              Double longitude = location.getLongitude();
  
              String message = "내 위치 -> Latitude : "+ latitude + "\nLongitude:"+ longitude;
              textView.setText(message);
          }
  
          public void onProviderDisabled(String provider) { }
  
          public void onProviderEnabled(String provider) { }
  
          public void onStatusChanged(String provider, int status, Bundle extras) { }
      }
  }
  
  ```

  

- 핸드폰으로 나의 위치 찾는 법

  - 대부분의 기지국은 범용적인 Wifi 위치를 가지고 있다.
  - 기지국 삼각대로 나의 위치 찾기
  - GPS 켜서 나의 위치 찾기

- 구글 API 사용 하여 GPS 맵 찍기 (방법 1 [File] -> [new] ->[Google Maps Activity] 로 프로젝트 생성)

  - 구글 KEY 받는 법

    - http://console.developers.google.com 접속

    - 프로젝트를 하나 생성한다. 

    - [사용자 인증 정보] -> [사용자 인증 정보 만들기] -> [API 키] 

    - 생성된 [키 이름 클릭] -> (애플리케이션 제한사항) Android 앱 체크 -> (Android 앱의 사용량 제한) 항목 추가 하여 Package명과 본체 SHA1 주소를 추가 한다.

      > SHA1 : 주소는 "CMD" 콘솔에서 "cp C:\Program Files\Java\jdk1.8.0_91\bin" 입력하여 keytool프로그램이 있는 위치로 이동한다. 그 다음 "keytool -list -v -keystore "%USERPROFILE%\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android" 입력하고 [Enter] 치면 나타난다. 
      >
      > (주의)
      >
      > 해당 본체에서만 사용이 가능하다.

    - 저장

- Android Studio

  (manifests) - 'ACCESS_FINE_LOCATION' permission추가

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.p674">

    <!--
         The ACCESS_COARSE/FINE_LOCATION permissions are not required to use
         Google Maps Android API v2, but you must specify either coarse or fine
         location permissions for the 'MyLocation' functionality.
    -->
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">

        <!--
             The API key for Google Maps-based APIs is defined as a string resource.
             (See the file "res/values/google_maps_api.xml").
             Note that the API key is linked to the encryption key used to sign the APK.
             You need a different API key for each encryption key, including the release key that is used to
             sign the APK for publishing.
             You can define the keys for the debug and release targets in src/debug/ and src/release/.
        -->
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/google_maps_key" />

        <activity
            android:name=".MapsActivity"
            android:label="@string/title_activity_maps">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

(build.gradle) - google 라이브러리를 가져온다. (단 Oracle 등의 라이브러리는 직접 파일을 다운 받아서 [project] 밑에 [libs] 에 추가 해줘야함) , implementation 'com.google.android.gms:play-services-maps:16.1.0' 추가

```bash
apply plugin: 'com.android.application'

android {
    compileSdkVersion 29
    buildToolsVersion "29.0.2"
    defaultConfig {
        applicationId "com.example.p674"
        minSdkVersion 22
        targetSdkVersion 29
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.0.2'
    implementation 'com.google.android.gms:play-services-maps:16.1.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
}

```

(google_maps_api.xml) - google에서 받은 키를 입력한다. <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">키 입력</string>

```bash
<resources>
    <!--
    TODO: Before you run your application, you need a Google Maps API key.

    To get one, follow this link, follow the directions and press "Create" at the end:

    https://console.developers.google.com/flows/enableapi?apiid=maps_android_backend&keyType=CLIENT_SIDE_ANDROID&r=12:72:61:EA:4B:32:22:75:BD:A4:22:B2:34:7E:72:FB:37:67:51:1D%3Bcom.example.p674

    You can also add your credentials to an existing key, using these values:

    Package name:
    12:72:61:EA:4B:32:22:75:BD:A4:22:B2:34:7E:72:FB:37:67:51:1D

    SHA-1 certificate fingerprint:
    12:72:61:EA:4B:32:22:75:BD:A4:22:B2:34:7E:72:FB:37:67:51:1D

    Alternatively, follow the directions here:
    https://developers.google.com/maps/documentation/android/start#get-key

    Once you have your key (it starts with "AIza"), replace the "google_maps_key"
    string in this file.
    -->
    <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">키 입력</string>
</resources>

```

(xml)

```xml
<?xml version="1.0" encoding="utf-8"?>
<fragment xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:map="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/map"
    android:name="com.google.android.gms.maps.SupportMapFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MapsActivity" />
```

(MapsActicity.java)

```java
package com.example.p674;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);//xml 안에 map fragement를 가져온다.(map 뿌린다는 준비)
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {//getMapAsync 하면 자동으로 실행,OnMapReadyCallback에서 Override된 함수
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(37.501682, 127.039611);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));//mark를 추가
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(sydney,15)
        );
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));//mark 위치로 이동해라
    }
}

```

- 구글 API 사용 하여 GPS 맵 찍기 (방법 2 일반 [Empty] 에서 찍기)

(manifests) -  meta-data value에 key 값을 넣어 줘도 된다. 

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.p675">
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="GOOGLE KEY 입력" />
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

(build.gradle) - google 라이브러리 설정 (implementation 'com.google.android.gms:play-services-maps:16.1.0')

```bash
apply plugin: 'com.android.application'

android {
    compileSdkVersion 29
    buildToolsVersion "29.0.2"
    defaultConfig {
        applicationId "com.example.p675"
        minSdkVersion 22
        targetSdkVersion 29
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.0.2'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'com.google.android.gms:play-services-maps:16.1.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
}

```

(MainActivity.java) - (추가) 내 위치 말고 다른위치 이미지 마트로 찍기

```java
package com.example.p675;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.Manifest;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;


import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity {//fragment 상속 받은게 아니라 일반적으로 map 이용
    SupportMapFragment mapFragment;
    GoogleMap map;
    TextView textView;
    MarkerOptions myLocationMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d("Map", "지도 준비됨.");
                map = googleMap;
                map.setMyLocationEnabled(true);
                startLocationService();

            }
        });

        try {
            MapsInitializer.initialize(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] permissions = {
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        ActivityCompat.requestPermissions(this, permissions, 101);

        int check =
                PermissionChecker.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);

        if(check == PackageManager.PERMISSION_GRANTED){//수락
            Toast.makeText(this,
                    "ACCEPT", Toast.LENGTH_SHORT).show();


            return;

        }else{
            Toast.makeText(this,
                    "DENY", Toast.LENGTH_SHORT).show();
            return;
        }
    }
    public void startLocationService() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                String message = "최근 위치 -> Latitude : " + latitude + "\nLongitude:" + longitude;

                textView.setText(message);
            }

            GPSListener gpsListener = new GPSListener();//장치에서 바뀌는 위치를 계속해서 받는다.
            long minTime = 10000; //10초에 한번씩 체크 ,크게 잡으면 배터리 소요를 줄일 수 있다.
            float minDistance = 0;

            manager.requestLocationUpdates(//현재 위치를 반영하겠다. (어떤걸로 할거냐 (NETWORK_PROVIDER는 와이파이나 기지국), 변화는데 걸리는 시간, 측정 거리,좌표랑 경도를 실시간으로 가져옴 )
                    LocationManager.GPS_PROVIDER,
                    minTime, minDistance, (LocationListener) gpsListener);

            Toast.makeText(getApplicationContext(), "내 위치확인 요청함",
                    Toast.LENGTH_SHORT).show();

        } catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    class GPSListener implements LocationListener {
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();
            showCurrentLocation(latitude,longitude);

            String message = "내 위치 -> Latitude : "+ latitude + "\nLongitude:"+ longitude;
           textView.setText(message);
        }

        public void onProviderDisabled(String provider) { }

        public void onProviderEnabled(String provider) { }

        public void onStatusChanged(String provider, int status, Bundle extras) { }
    }

    private void showCurrentLocation(Double latitude, Double longitude) {
        LatLng curPoint = new LatLng(latitude, longitude);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint,15));
        showMyLocationMarker(curPoint);
    }

    private void showMyLocationMarker(LatLng curPoint) {//다른 위치 마크 찍기
        if (myLocationMarker == null) {
            myLocationMarker = new MarkerOptions();
            myLocationMarker.position(curPoint);
            myLocationMarker.title("● 내 위치\n");
            myLocationMarker.snippet("● GPS로 확인한 위치");
            myLocationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));
            map.addMarker(myLocationMarker);
        } else {
            myLocationMarker.position(curPoint);
        }
    }



}

```

