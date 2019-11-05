```java
package com.example.tablet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.provider.Settings;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;

import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;


import java.util.List;
import java.util.Locale;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MainActivity extends AppCompatActivity {

    Button button_off;
    TextView textView, textView2;
    ServerSocket serverSocket;
    Socket socket;


    LinearLayout linearLayoutTmap;
    TMapView tMapView;
    TMapPoint tMapPointEnd;
    private GpsTracker gpsTracker;
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSION_REQUEST_CODE = 100;
    String[] permissions = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.INTERNET
    };
    //add map setting end

    boolean flag = true;
    boolean rflag = true;
    public static String str;
    public static int sss;
    Server server = null;
    //Map<String, String> nickMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button_on = findViewById(R.id.button1);
        //button3 = findViewById(R.id.button3);
        button_off = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);



        //add map
        linearLayoutTmap = findViewById(R.id.linearLayoutTmap);
        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey("8fe8578d-7236-4214-82fe-a41d45b6d10b");
        linearLayoutTmap.addView(tMapView);
        tMapPointEnd = new TMapPoint(37.504196,127.048041);
        //임시 목적지 좌표 37.501970, 127.041158

        if(!checkLocationServicesStatus()){
            showDialogForLocationServiceSetting();
        }else{
            checkRunTimePermission();
        }

        GpsThread gpsThread = new GpsThread();
        gpsThread.execute();
        //add map

        try {
            server = new Server(8889);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = "70.12.228.218";
        int port = 8888;
        /*Wreceiver wreceiver = null;
        wreceiver = new Wreceiver(url, port);
        wreceiver.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);*/
        button_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                int ip = wifiInfo.getIpAddress();
                String ipAddress = Formatter.formatIpAddress(ip);
                Log.d("ip*******", ipAddress);
            }
        });
    }



    class GpsThread extends AsyncTask<String, String, String>{
        public GpsThread(){

        }

        @Override
        protected void onPreExecute() {
            gpsTracker = new GpsTracker(MainActivity.this);
        }

        @Override
        protected void onPostExecute(String s) {
        }

        @Override
        protected void onProgressUpdate(String... values) {

            gpsTracker = new GpsTracker(MainActivity.this);
            Toast.makeText(MainActivity.this, "UPDATE", Toast.LENGTH_SHORT).show();
            textView2.setText("");
            String[] arr = values[0].split("#");
            textView2.append("주소: " + arr[0]);
            textView2.append("X: " + arr[1]+"\n");
            textView2.append("Y: " + arr[2]);

            double x = Double.parseDouble(arr[1]);//latitude, 위도
            double y = Double.parseDouble(arr[2]);//longitude, 경도

            TMapPoint tMapPoint = new TMapPoint(x, y);

            try{
                TMapMarkerItem mapMarkerItem = new TMapMarkerItem();

                mapMarkerItem.setTMapPoint(tMapPoint);
                mapMarkerItem.setName("현재 위치");
                mapMarkerItem.setVisible(TMapMarkerItem.VISIBLE);

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_pin);
                mapMarkerItem.setIcon(bitmap);
                mapMarkerItem.setPosition(0.5f,0.5f);

                TMapPolyLine tMapPolyLine = new TMapPolyLine();
                //원래 TMapPolyLine tMapPolyLine = new TMapData().findPathData(tMapPoint, tMapPointEnd);
                //로 해줬는데 안되서 아래 addLinePoint로 수정했더니 됨

                tMapPolyLine.setLineColor(Color.RED);
                tMapPolyLine.setLineWidth(3);
                tMapPolyLine.addLinePoint(tMapPoint);
                tMapPolyLine.addLinePoint(tMapPointEnd);

                tMapView.addTMapPolyLine("Line1", tMapPolyLine);

                tMapView.addMarkerItem("markerItem", mapMarkerItem);
                tMapView.setCenterPoint(y, x);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... strings) {

            while(flag) {
                double latitude = gpsTracker.getLatitude();
                double longitude = gpsTracker.getLongitude();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String address = getCurrentAddress(latitude, longitude);
                publishProgress(address+"#"+latitude+"#"+longitude);
                //publishProgress("주소 : " + address + "\n X: " +latitude + "\n Y: " + longitude);
            }
            /*Toast.makeText(MainActivity.this, "현재위치 \n위도 " + latitude + "\n경도 "
                    + longitude, Toast.LENGTH_LONG).show();*/
            return null;
        }
    }


    public String getCurrentAddress(double latitude, double longitude){
        //GPS의 X, Y 좌표를 주소로 변환해준다.
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;

        try{
            addresses = geocoder.getFromLocation(
                    latitude,
                    longitude,
                    7);
            //Log.d("CHECK_ADDRESS****************", addresses.toString());
        }catch (IOException e){
            //네트워크 문제 발생시
            //Toast.makeText(this,"Geocoder not Available", Toast.LENGTH_LONG).show();
            return "Geocoder not Available";
        }catch(IllegalArgumentException ie){
            //Toast.makeText(this,"Invalid GPS Value", Toast.LENGTH_LONG).show();
            return "Invalid GPS Value";
        }

        if(addresses == null || addresses.size() == 0){
            //Toast.makeText(this, "not Found Address", Toast.LENGTH_LONG).show();
            return "Address not Found";
        }

        Address address = addresses.get(0); //??? Address 클래스 알아보고
        //addresses에 값이 무엇이 들어가는지 확인하기
        return address.getAddressLine(0).toString()+"\n"; // 변환된 주소 문자열 들어있음
    }


    void checkRunTimePermission(){
        //먼저 위치 퍼미션을 가지고 있는지 체크
        int findPermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        int coarsePermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION);

        if(findPermission == PackageManager.PERMISSION_GRANTED &&
                coarsePermission == PackageManager.PERMISSION_GRANTED){
            //퍼미션을 가지고 있을 경우 위치 정보를 가져올 수 있다.
        }else{ //퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요
            //3-1 사용자가 퍼미션 거부를 한 적이 있는 경우
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permissions[0])){
                Toast.makeText(MainActivity.this, "앱을 실행하려면 위치 접근 권한이 필요", Toast.LENGTH_LONG).show();
                //사용자에게 퍼미션 요청, 요청 결과는 onRequestPermissionResult에서 수신됨
                ActivityCompat.requestPermissions(MainActivity.this, permissions, PERMISSION_REQUEST_CODE);
            }
            else{
                //4-1) 사용자가 퍼미션 거부를 한 적이 없는 경우 퍼미션 요청
                //요청 결과는 onRequestPermissionResult에서 수신됨
                ActivityCompat.requestPermissions(MainActivity.this, permissions, PERMISSION_REQUEST_CODE);
            }
        }
    }

    public boolean checkLocationServicesStatus(){
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //스마트폰 위치는 위치관리자(LocationManager)라는 시스템 서비스가 관리
        //android.location 패키지에 포함되어 있어 위치 정보 확인하는데 필요한 클래스들이 정의되어 있음
        //위치 관리자 객체 참조
        return manager.isProviderEnabled(manager.GPS_PROVIDER)
                || manager.isProviderEnabled(manager.NETWORK_PROVIDER);
        //여기서 GPS_PROVIDER는 WIFI를 통해 받을 때, NETWORK_PROVIDER는 기지국을 통해 받을 때 사용
    }

    private void showDialogForLocationServiceSetting(){
        //이 함수는 위치 관리자 참조를 못한 경우(??)
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                + "위치 설정 수정하세요");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent callGPSSettingIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PERMISSION_REQUEST_CODE && grantResults.length == permissions.length){
            //요청 코드가 PERMISSION_REQUEST_CODE이고, 요청한 퍼미션 개수만큼 수신될 경우
            boolean check_result = true;

            //아래 반복문에서 모든 퍼미션을 허용했는지 확인
            for(int result : grantResults){
                if(result != PackageManager.PERMISSION_GRANTED){
                    check_result = false;
                    break;
                }
            }

            if(check_result){
                //위치 값을 가져올 수 있음
            }
            else{ //거부 퍼미션이 있을 경우 앱을 사용할 수 없는 경우 설명해주고 앱 종료
                if(ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[1])){
                    Toast.makeText(MainActivity.this, "퍼미션이 거부, 앱을 다시 실행하여 퍼미션을 허용하시오",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "퍼미션이 거부 설정에서 허용하시오", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void clickbt(View view){
        String data = textView.getText().toString();
        String url = "http://70.12.60.98/test/webchat?data="+data;
        HttpTask httpTask = new HttpTask(url);
        Log.d("data =====",data);
        httpTask.execute();
    }

    class HttpTask extends AsyncTask<String,Void,String>{
        String url;

        public HttpTask(String url) {
            this.url = url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... strings) {
            String str1= HttpHandler.getString(url);
            return str1;
        }
    }

    private class Server {
        private boolean flag = true;
        //private ServerSocket serverSocket;

        private Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    while(flag) {
                        System.out.println("Server Ready..");
                        socket = serverSocket.accept();

                        System.out.println(socket.toString());
                        new Receiver(socket).start();
                        System.out.println(socket.getInetAddress());
                    }

                    System.out.println("Server End..");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        public Server() {
        }

        public Server(int port) throws IOException {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Start..");

            new Thread(r).start();
        }

        // 여기서 sendMsg함수를 만들어서 한 이유는 채팅 네트워크를 사용하는데 채팅 입력을 해야하니까 쓰레드와 메인 영역
        // 달라서 여기서 받아줘서 msg setting 후에 생성해준다.
        // 우리는 Scanner로 입력할 필요가 없어서 바로 sender 객체를 생성해줘야함
        //

//        public void sendMsg(String msg) {
//            Sender sender = new Sender();
//            //sender.setMsg(msg);
//            sender.start();
//        }


    }
    class Sender extends Thread  {
        OutputStream out;
        DataOutputStream dout;
        String msg = "SEND BUZZER CONTROL DATA";

        public Sender(Socket socket) throws Exception {

//            out = socket.getOutputStream();
//            dout = new DataOutputStream(out);

            Log.d("CREATE DATAOUTPUTSTREAM*****************","#####################3");
        }
        public void run() {

            if(dout != null) {
                while(rflag) {
                    try {

                        //Log.d("DATAOUTPUTSTREAM SEND START*****************", "#####################3");
                        System.out.println(msg);
                        dout.writeUTF(msg);
                        // dout.flush();
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }
            }
            else{
                Log.d("dout is null****************************************@!#!#", "CHECK DATAOUTPUTSTREAM");

            }
        }
    }
    private class Receiver extends Thread {
        Socket socket;

        InputStream in;
        DataInputStream din;
        //BufferedInputStream bin;

        OutputStream out;
        DataOutputStream dout;
        String ip;

        public Receiver(Socket socket) throws Exception {
            //receiver는 정보를 받아서 객체화해서 보내야한다.
            this.socket = socket;

            in = socket.getInputStream();
            din = new DataInputStream(in);
            //bin = new BufferedInputStream(in);
            out = socket.getOutputStream();
            dout = new DataOutputStream(out);
            ip = socket.getInetAddress().toString();
            new Sender(socket).start();
        }

        public void run() {
            try {
                while (rflag) {
                    Log.d("str", "Threadstart");
                    str = din.readUTF();
                    System.out.println("str : " + str);


                    if (Integer.parseInt(str.substring(12, 14)) >= 50) {
                        textView.setTextColor(Color.parseColor("#FF0000"));
                    } else {
                        textView.setTextColor(Color.parseColor("#009688"));
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(str);
                        }
                    });


                    System.out.println(str);
                    //sendMsg(str); *******************수정 필수****************
                }
            }catch(Exception e) {
                //e.printStackTrace();

//                System.out.println("ip"+ip);
//                    if(din != null) {
//                        try {
//                            din.close();
//                        } catch (Exception e1) {
//                            e1.printStackTrace();
//                        }
//                    }

            }finally {
//                    if(socket != null) {
//                        try {
//                            socket.close();
//                        } catch (IOException e1) {
//                            e1.printStackTrace();
//                        }
//                    }

            }
        }
    }
}

//    class Wsender extends AsyncTask<String, Object, String>{
//        OutputStream out = null;
//        ObjectOutputStream oos = null;
//        String msg;
//        User user = null;
//        public Wsender(Socket socket){
//            try {
//                //out = socket2.getOutputStream();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//
//        public void setUser(User user){
//            this.user = user;
//        }
//
//        public void setMsg(String msg){
//            this.msg = msg;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            //textView.append(this.user.toString()+"\n");
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//        }
//
//        @Override
//        protected void onProgressUpdate(Object... values) {
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//            try{
//                Log.d("book", "error wsender");
//                Log.d("book",user.getMsg());
//                oos = new ObjectOutputStream(out);
//                oos.writeObject(user);
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }
//    class Wreceiver extends AsyncTask<String, Object, String>{
//        InputStream in = null;
//        DataInputStream din = null;
//        String ip;
//        Integer port;
//        String str1;
//
//        public Wreceiver() {
//        }
//
//        public Wreceiver(String ip, Integer port) {
//            this.ip = ip;
//            this.port = port;
//        }
//
//        @Override
//        protected void onPreExecute() {
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//        }
//
//        @Override
//        protected void onProgressUpdate(Object... values) {
//            socket2 = (Socket)values[0];
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//            boolean flag = true;
//            while(flag){
//                try {
//                    socket2 = new Socket(ip, port);
//                    publishProgress(socket2);
//                    in = socket2.getInputStream();
//                    din = new DataInputStream(in);
//                    if(socket2 != null && socket2.isConnected()){
//                        break;
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                    System.out.println("RETRY");
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }//end while
//            while(flag){
//                try {
//                    try {
//                        str1 = din.readUTF();
//                    }catch (EOFException e){
//                        str1 = "no";
//                        break;
//                    }
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            textView.append(str1+"\n");
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return str1;
//        }
//    }

//    public void sentData(View view){
//        try {
//            Wsender wsender = null;
//            wsender = new Wsender(socket2);
//            wsender.setUser(new User(socket2.getLocalAddress().toString(), "ID101", "q"));
//            wsender.execute();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
```

