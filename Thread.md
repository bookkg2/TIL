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

