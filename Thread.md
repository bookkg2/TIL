## 쓰레드(Thread)

- 프로세스 :  '실행 중인 프로그램' 이다. 실행하면 OS로부터 실행에 필요한 자원을 할당받아 프로세스가 된다. 
- 프로세스의 자원을 이용해서 실제로 작업을 수행하는 것이 바로 쓰레드 이다.  둘 이상의 쓰레드를 가진 프로세스를 '멀티쓰레드 프로세스' 라고 한다. 
  - 멀티쓰레딩의 장점
    - CPU의 사용률을 향상시킨다.
    - 자원을 보다 효율적으로 사용할 수 있다.
    - 사용자에 대한 응답성이 향상된다.
    - 작업이 분리되어 코드가 간결해진다. 

- 과거 Process invocation 은  메모리 사용이 들어나 속도가 느려진다. 
- 쓰레드는 하나의 메모리 영역을 사용할 수 있지만, 많이지면 CPU 사용량이 증가하여 느려질 수 있다. (단, 각 페이지에서 발생하는 메모리로 메모리가 늘어날 수 있다.)
- 우리가 사용하고 있는 윈도우나 유닉스를 포함한 대부분의 OS는 멀티태스킹을 지원하기 때문에 여러 개의 프로세스가 동시에 실행될 수 있다.

- 멀티태스킹과 멀티쓰레딩 차이
  - 멀티태스킹은 하나의 OS에서 여러개의 프로세스를 이용 (window에서 이클립스, 브라우저 등의 프로세스를 동시에 가능)
  - 멀티쓰레딩은 하나의 프로세스 안에서 여러가지 쓰레드 행위 (하나의 프로세스 안에서 Thread를 통해 동시에 여러 기능을 구현)

- 일반적인 프로세스 구조 (A가 다 돌고 B 가 동작한다.)

```java
public class T1 {

	public static void main(String[] args) throws InterruptedException {
		for(int i= 0 ; i <100 ; i++) {
			Thread.sleep(10);//for문이 끝날 때까지 interrupt 밖에 못한다. 
			System.out.println("A : " + i);
		}
		System.out.println("end");
		
		for(int i= 0 ; i <100 ; i++) {
			Thread.sleep(10);//for문이 끝날 때까지 interrupt 밖에 못한다. 
			System.out.println("B : " + i);
		}
	}

}

```

- 쓰레드를 구성 한뒤 프로세스 구조 (동시 다발적으로 구현)

  ```java
  class MyThread extends Thread{//Thread에서 생성 
  	
  	String name;
  
  	public MyThread(String name) {//Thread 이름 생성
  		this.name = name;
  	}
  	
  	@Override
  	public void run() {//Thread의 행위가 이루어지는 곳
  		for(int i=0; i < 30; i++) {
  			try {
  				Thread.sleep(300);
  			} catch (InterruptedException e) {
  				
  				e.printStackTrace();
  			}
  			System.out.println(name + " " + i);
  		}
  	}
  	
  }
  
  public class Th1 {//프로세스
  
  	public static void main(String[] args) {//Main Thread
  		MyThread t1 = new MyThread("T1");
  		MyThread t2 = new MyThread("T2");
  		
  		t1.start(); // Thread의 Run이 동작한다.
  		t2.start();
  
  	}
  
  }
  
  ```

  

- 쓰레드를 구성 한뒤 프로세스 구조 방법 2 (동시 다발적으로 구현) - 인터페이스 Runnable 사용

```java
class MyThread2 implements Runnable{//자바는 하나의 상속 밖에 받아올수 없어서  인터페이스 Runnable로도 구현이 가능하게 제공한다. 
	
	String name;

	public MyThread2(String name) {//Thread 이름 생성
		this.name = name;
	}
	
	@Override
	public void run() {//Thread의 행위가 이루어지는 곳
		for(int i=0; i < 30; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(name + " " + i);
		}
	}
	
}

public class Th2 {//프로세스

	public static void main(String[] args) {//Main Thread
		Thread t1 = new Thread(new MyThread2("T1"));//인터페이스에서 상속 받을 때
		Thread t2 = new Thread(new MyThread2("T2"));
		
		t1.start();
		t2.start();
	}

}

```

> UI 프로그램에서 중요했던 부분이 "Thread" 였다. (동시 작업이 가능하니깐!)
>
> 기존의 웹은 one_Thread 여서 하나의 작업이 끝나야 동작 할 수 있지만, HTML5 부터는 멀티 스레드가 가능해졌다. 



- 쓰레드의 우선순위 - setPriority()

```java
class MyThread extends Thread{//Thread에서 생성 
	
	String name;

	public MyThread(String name) {//Thread 이름 생성
		this.name = name;
	}
	
	@Override
	public void run() {//Thread의 행위가 이루어지는 곳
		for(int i=0; i < 1000; i++) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			yield();//우선 순위가 높아도 양보를 하겠다 
			System.out.println(name + " " + i);
		}
	}
	
}

public class Th1 {//프로세스

	public static void main(String[] args) {//Main Thread
		MyThread t1 = new MyThread("T1");
		MyThread t2 = new MyThread("T2");
		MyThread t3 = new MyThread("T3");
		
		t3.setPriority(10);
		t1.start(); // Thread의 Run이 동작한다.
		t2.start();
		t3.start();

	}

}

```

- Thread를 Runnable을 사용하여 Main에서 바로 생성하여 동작 

```java

public class Th3 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {//class 없이 thread를 사용 하고 싶을 때 
			
			@Override
			public void run() {
				for(int i=0; i < 100; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					System.out.println(i);
				}
				
			}
		};
		new Thread(r).start();

	}

}

```

- Thread Group

```java

public class Th3 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {//class 없이 thread를 사용 하고 싶을 때 
			
			@Override
			public void run() {
				for(int i=0; i < 100; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					System.out.println("R:"+i);
				}
				
			}
		};
     Runnable r2 = new Runnable() {//class 없이 thread를 사용 하고 싶을 때 
			
			@Override
			public void run() {
				for(int i=0; i < 100; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					System.out.println("R2:"+i);
				}
				
			}
		};
		//여러개의 Thread 중 특정 범위의 스레드를 관리하고 싶을 떄 Group 을 사용 
		ThreadGroup tg1 = new ThreadGroup("TG1");
		tg1.setMaxPriority(3);
		new Thread(tg1,r,"th1").start(); //th1은 쓰레드 이름 
		new Thread(tg1,r2,"th1").start(); //th1은 쓰레드 이름 

	}

}

```

- 스레드를 이용하여 작업 도중 Save  하는 기본 원리 - setDaemon활용

  > setDaemon : Main 프로세스가 종료되면 Thread 가 종료 된다.

```java
class SaveThread extends Thread{

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(2000);
				save();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}

	public void save() {
		System.out.println("Save...");
		
	}
	
}

public class Th4 {

	public static void main(String[] args) {
		SaveThread st = new SaveThread();
		st.setDaemon(true); //이 부분이 없으면 종료되지 않는다.(무한 루프가)
		st.start();
		
		for(int i=0; i<20; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}

```

- 쓰레드의 실행 제어 

  - 쓰레드 프로그래밍이 어려운 이유는 동기화와 스케줄링 때문이다. 효율적인 멀티쓰레드 프로그램을 만들기 위해서는 보다 정교한 스케줄링을 통해 프로세스에게 주어진 자원과 시간을 여러 쓰레드가 낭비없이 잘 사용하도록 프로그래밍 해야 한다.

    - | 메서드                                                       | 설명                                                         |
      | ------------------------------------------------------------ | ------------------------------------------------------------ |
      | static voie sleep(long millis) , static void sleep (long milis,int nanos) | 지정된 시간 동안 쓰레드를 일시정지시킨다. 지정한 시간이 지나고 나면, 자동적으로 다시 실행대기상태가 된다. |
      | void join() , void join(long millis) ,void join(long milis,int nanos) | 지정된 시간동안 쓰레드가 실행되도록 한다. 지정된 시간이 지나거나 작업이 종료되면 join()을 호출한 쓰레드로 다시 돌아와 실행을 계속한다. |
      | void interrupt()                                             | sleep()이나 join()에 의해 일시정지상태인 쓰레드를 깨워서 실행대기상태로 만든다. 해당 쓰레드에서는 InterruptedException이 발생함으로써 일시정지상태를 벗어나게 된다. |
      | void stop()                                                  | 쓰레드를 즉기 종료시킨다.                                    |
      | void suspend()                                               | 쓰레드를 일시정지시킨다. resume()을 호출하면 다시 실행대기상태가 된다. |
      | void resume()                                                | suspend()에 의해 일시정지상태에 있는 쓰레드를 실행대기 상태로 만든다. |
      | static void yield()                                          | 실행 중에 자신에게 주어진 실행시간을 다른 쓰레드에게 양보하고 자신은 실행대기상태가 된다. |

    > Stop 보다는 Interrupt 를 사용해야 한다. Stop은 소멸되서 코드로 제어가 불가능 하기 때문에!!

- PipedReader 와 PipedWriter

  - 쓰레드 간에 데이터를 주고받을 때 사용된다. 다른 스트림과는 달리 입력과 출력스트림을 하나의 스트림으로 연결해서 데이터를 주고 받는다.

  (OutputThread)

       ```java
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class OutputThread extends Thread {
	PipedWriter output;
	public OutputThread(String name) {
		super(name); // super로 하면 Thread의 이름이 된다.
		output = new PipedWriter();
	}
	
```java
public void run() {
	try {
		String msg = "OutputThread .... Hello";
		System.out.println("send :" + msg);
		output.write(msg);// output 이라는 파이프로 보낸다. 
		output.close();// close는 항상 finally 에서 해주고 null 체트 한다. 
	}catch(Exception e) {
		
	}
}

public PipedWriter getOutput() {
	return output;
}

public void connect(PipedReader input) {
	try {
		output.connect(input);//Thread끼리 연결할 곳을 세팅 해줘야힘.
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
```

}

       ```

(InputThread)

```java
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class InputThread extends Thread{
	PipedReader input;
	public InputThread(String name) {
		super(name);
		input = new PipedReader();
	}
	
	public void run() {
		int data = 0;
		StringWriter sw = new StringWriter();
		try {
			while((data = input.read()) != -1) {
				sw.write(data);//받은 것을 Byte 단위로 받아온다.
				
			}
			System.out.println("Received : "+ sw.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public PipedReader getInput() {
		return input;
	}
	public void connect(PipedWriter output) {
		try {
			input.connect(output);//output될 곳을 연결 해줘야한다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

```

(Main)

```java

public class Main {

	public static void main(String[] args) {
		InputThread it = new InputThread("inThread");
		OutputThread ot = new OutputThread("outThread");
		it.connect(ot.getOutput()); // 두 개의 Thread를 연결
		it.start();//input.read에서 멈춰 잇는다.
		ot.start();// 데이터를 전송하면 input.read가 받는다. 
	}

}

```

- BufferedReader사용 하는 법

  (OutputThread)

```java
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class OutputThread extends Thread {
	PipedWriter output;
	public OutputThread(String name) {
		super(name); // super로 하면 Thread의 이름이 된다.
		output = new PipedWriter();
	}
	
	public void run() {
	    String msg;
		try {
			
				Scanner sc = new Scanner(System.in);
				System.out.println("Write : ");
				msg = sc.nextLine();
				output.write(msg);
				output.close();
				
			
			// output 이라는 파이프로 보낸다	
		
			/*
			 * String msg = "OutputThread .... Hello"; System.out.println("send :" + msg);
			 */
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public PipedWriter getOutput() {
		return output;
	}
	
	public void connect(PipedReader input) {
		try {
			output.connect(input);//Thread끼리 연결할 곳을 세팅 해줘야힘.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

```

​        (InputThread)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class InputThread extends Thread{
	PipedReader input;
	BufferedReader br; //BufferedReader는 스티링으로 받을 수 있다.
	public InputThread(String name) {
		super(name);
		input = new PipedReader();
		br = new BufferedReader(input);
		}
	
	public void run() {
		String data = " ";
		StringBuffer sw = new StringBuffer();
		
		try {
			System.out.println("Ready");
			while((data = br.readLine()) != null) {
				
				sw.append(data);//받은 것을 Byte 단위로 받아온다.
				
			}
			System.out.println("Received : "+ sw.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public PipedReader getInput() {
		return input;
	}
	public void connect(PipedWriter output) {
		try {
			input.connect(output);//output될 곳을 연결 해줘야한다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

```

​     (Main)

```java

public class Main {

	public static void main(String[] args) {
		InputThread it = new InputThread("inThread");
		OutputThread ot = new OutputThread("outThread");
		it.connect(ot.getOutput()); // 두 개의 Thread를 연결
		it.start();//input.read에서 멈춰 잇는다.
		ot.start();// 데이터를 전송하면 input.read가 받는다. 
	}

}

```

