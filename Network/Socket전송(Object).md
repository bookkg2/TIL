## Client 에서 서버로 Socket 전송

```java
package com.example.appclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {

   Socket socket;
   boolean rflag = true;
      
   public Client() {
      
   }
   
   public Client(String ip, int port) throws IOException {
      boolean flag = true;
      while(flag) {
         try {
            socket = new Socket(ip, port);
            if(socket != null && socket.isConnected()) {
               break;
            }
         } catch (Exception e) {
            System.out.println("Retry...");
            try {
               Thread.sleep(3000);
               //서버가 죽어있을 경우 
               //3초마다 연결시도
            } catch (InterruptedException e1) {
               e1.printStackTrace();
            }
         } 
      }//end while
      //소켓이 만들어지면 (서버로부터) 받는 작업부터 하겠다.
      new Receiver(socket).start();
   }
   
   public void sendMsg(String msg) throws IOException {
      Sender sender = null;
      sender = new Sender(socket);
      sender.setMsg(msg);
      sender.setUser(new User(socket.getLocalAddress().toString(), "ID02", msg));
      sender.start();   
   }
   
   public void start() throws Exception {
      Scanner sc = new Scanner(System.in);
      boolean sflag = true;
      while(sflag) {
         System.out.println("Input Message...");
         String str = sc.next();
         sendMsg(str);
         if(str.equals("q")) {
            //System.out.println("END...");
            break;
         }
      }
      System.out.println("Bye....");
      sc.close();
   }
   
   class Sender extends Thread{
      
      OutputStream out;
      ObjectOutputStream oos;
      String msg;
      User user;
         
      public Sender() {
      }
      
      public Sender(Socket socket) throws IOException {
         out = socket.getOutputStream();
         oos = new ObjectOutputStream(out);
      }
      
      public void setUser(User user) {
         this.user = user;
      }

      public void setMsg(String msg) throws IOException {
         this.msg = msg;
      }
      
      
      public void run() {
         if(oos != null) {
            try {
            	System.out.println(user.toString());
               oos.writeObject(user);
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }

   class Receiver extends Thread{
      
      Socket socket;
      InputStream in;
      DataInputStream din;
      
      public Receiver() {
         
      }
      
      public Receiver(Socket socket) throws IOException {
         this.socket = socket;
         in = socket.getInputStream();
         din = new DataInputStream(in);
      }
      
      
      public void run() {
         while(rflag) {
            try {
               //서버가 보낸 것을 받음
               String str = din.readUTF();
               System.out.println(str);
            } catch (IOException e) {
               
            }
         }
      }
   }

   
   public static void main(String[] args) throws IOException {
      Client client = null;
      client = new Client("70.12.228.242", 8888);
      try {
         client.start();
         //소켓 생성
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}
```

## Server에서 받기 

```java
package com.example.appclient;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Server {

   boolean flag = true;
   boolean rflag = true;
   Map<String, DataOutputStream> map = new HashMap<String, DataOutputStream>();
   Map<String, String> ipnickMap = new HashMap<>();
   // datainputstream을 넣어두면 나중에

   ServerSocket serverSocket;

   public Server() {

   }

   public Server(int port) throws IOException {
      serverSocket = new ServerSocket(port);
      System.out.println("Server Start ...");

      Runnable r = new Runnable() {

         @Override
         public void run() {
            try {
               while (flag) {
                  System.out.println("Server Ready ...");
                  Socket socket = serverSocket.accept();
                  // 다른 사람이 기존 소켓의 레퍼런스를 바꿀 경우가 있어서 while 문 안에서
                  // Socket 객체 생성한다.(만약 위와 같은 경우 기존의 소켓이 바뀜)
                  // 단 한 서버가 열 수 있는 소켓의 갯수는 제한되어 있다
                  // accept() 후에 데이터를 주고받을 수 있다.

                  new Receiver(socket).start();
                  // 만일 sender 쓰레드를 추가하고자 한다면 돌아가는데 메인쓰레드가 아니여서 문자입력할 수 가 없다.
                  System.out.println(socket.getInetAddress());

               } // server end
               System.out.println("Server End ...");
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      };
      new Thread(r).start();
      // 서버 연결,start() 바로시작,ㄱ 쓰레드에 의해서 while
   }

   public void start() throws IOException {
      Scanner sc = new Scanner(System.in);
      boolean sflag = true;
      while (sflag) {
         System.out.println("Input Message...");
         String str = sc.next();
         sendMsg(str, null, null);
         if (str.equals("q")) {

            System.out.println("END...");
            break;
         }
      }
      sc.close();
   }

   public void sendMsg(String msg, String toNick, String fromNick) {
      Sender sender = null;
      sender = new Sender();
      if(toNick!=null) {
         sender.setToNick(toNick);
      }
      if(fromNick!=null) {
         sender.setFromNick(fromNick);
      }
      sender.setMsg(msg);
      sender.start();
   }

   class Sender extends Thread {

      String msg;
      String toNick;
      String fromNick;

      public Sender() {

      }

      public Sender(Socket socket) throws IOException {
//         out = socket.getOutputStream();
//         dout = new DataOutputStream(out);

      }
      
      public void setFromNick(String fromNick) {
         this.fromNick = fromNick;
      }

      public void setToNick(String toNick) {
         this.toNick = toNick;
      }

      public void setMsg(String msg) {
         this.msg = msg;
      }

      
      public void run() {
         // 맵에 있는 dout 상태만 내보내면된다
         Collection<DataOutputStream> col = map.values();
         Iterator<DataOutputStream> it = col.iterator();

         if(toNick == null) {
            this.msg = "For All >> "+msg ;
            while (it.hasNext()) {
               try {
                  it.next().writeUTF(msg);
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
            
         }else {
            try {
//               System.out.println("귓속말 확인1");
               this.msg = "From "+fromNick+" >> "+msg ;
//               System.out.println("귓속말 확인2");
               System.out.println(msg);
               System.out.println(ipnickMap.get(toNick));
               map.get(ipnickMap.get(toNick)).writeUTF(msg);
//               System.out.println(ipnickMap.get(toNick));
//               System.out.println("귓속말 확인3");
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }

   class Receiver extends Thread {

      Socket socket;
      InputStream in;
      ObjectInputStream ois;
//      DataInputStream din;
      OutputStream out;
      DataOutputStream dout;
      User user;
      
      String ip;

      public Receiver() {

      }

      public Receiver(Socket socket) throws Exception {
         this.socket = socket;
         in = socket.getInputStream();
//         ois = new ObjectInputStream(in);
//         din = new DataInputStream(in);
         out = socket.getOutputStream();
         dout = new DataOutputStream(out);
         
         
         ip = socket.getInetAddress().toString();
         // ip = key , dout = value
         map.put(ip, dout);
         System.out.println("접속자수: " + map.size());
         // receiver객체가 생성될 때마다 출력됨
      }

      public void run() {
    	  
         try {
            while (rflag) {
               // 서버가 보낸 것을 받음
               System.out.println("object가 들어오기를 대기");
               ois = new ObjectInputStream(in);
               try {
            	   user = (User)ois.readObject();  
               }catch(EOFException e3) {
            	   
               }
             
               System.out.println("objectstream 새로 생성");
               //stream 새로 생성해서 user 들어오기를 대기(sender에서 계속 생성해주니까 objectstream은 header가 맞아야함)
              
             
              
               
               ipnickMap.put(user.getNickName(), user.getId());
//               System.out.println(ipnickMap.keySet());
//               for(String tmp : ipnickMap.keySet()) {
//                  System.out.println(ipnickMap.get(tmp));
//               }
//               System.out.println("user받음");
               String str = user.getMessage();
//               String nick = user.getNickName();
//               String userIp = user.getId();
//               System.out.println(nick);
//               String str = din.readUTF();
               System.out.println(str);
//               System.out.println(userIp);
//               sendMsg(str, null); // 나한테도 메시지 보이게끔
               if (str.equals("q")) {
                  map.remove(ip);
                  System.out.println("접속자수: " + map.size());
                  break;
               }else if (str.equals("p2p")) {
//                  sendMsg(""+ipnickMap.keySet(), null, null);
//                  System.out.println(ipnickMap.keySet());
            	  System.out.println(user.getNickName());
                  sendMsg("Connect Nicknames(Only u can c) : "+ipnickMap.keySet(), user.getNickName(), "Server");
                  Thread.sleep(500);
//                  System.out.println("왜 씹히니");
                  sendMsg("choose one:message", user.getNickName(), "Server");
                  Thread.sleep(500);
               }else if(str.contains(":")) {
                  String tmp[] = str.split(":");
                  for (String string : tmp) {
//                     System.out.println(string);
                  }
                  if (ipnickMap.containsKey(tmp[0])) {
//                     System.out.println("확인이 안됨?");
                     sendMsg(tmp[1], tmp[0], user.getNickName());
                  }
               }
            }
         } catch (IOException e) {
            e.printStackTrace();
            System.out.println("비정상 아웃: " + ip);
            map.remove(ip);
            System.out.println("나간 후 접속자수: " + map.size());
            if (ois != null) {
               System.out.println("object스트림 닫힘");
               try {
                  ois.close();
               } catch (IOException e1) {
                  e1.printStackTrace();
               }
            }
//            if (din != null) {
//               try {
//                  din.close();
//               } catch (IOException e1) {
//                  e1.printStackTrace();
//               }
//            }
         } catch (ClassNotFoundException e) {
            System.out.println("User 객체 찾지 못함");
            e.printStackTrace();
         } catch (InterruptedException e) {
        	System.out.println("Thread Sleep 오류");
        	 e.printStackTrace();
		} finally {
            if (socket != null) {
               try {
                  socket.close();
               } catch (IOException e1) {
                  e1.printStackTrace();
               }
            }
         }
      }
   }

   public static void main(String[] args) {
      Server server = null;
      try {
         server = new Server(8888);
         server.start();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }


}
```

