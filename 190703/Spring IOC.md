### Spring IOC

-기존의 자바 기반으로 애플리케이션을 개발할 때, 객체를 생성하고 객체들 사이의 의존관계를 처리하는 것에 대한 책임은 전적으로 개발자에게 있었다. 즉 개발자가 어떤 객체를 생성할지 판단하고 객체간의 의존관계 역시 소스코드로 표현해야 했다. 하지만 제어의 역행(IOC)을 이용하면 소스에서 객체 생성과 의존관계에 대한 코드가 사라져 결과적으로 낮은 결합도의 컴포넌트를 구현할 수 있게 한다.

> 결합도 : 하나의 클래스가 다른 클래스와 얼마나 많이 연결되어 있는지를 나타내는 표현이며, 결합도가 높은 프로그램은 유지보수가 어렵다. 
>
> 유지보수를 편리하기 위한 과정  ) 결합도 -> 다형성(인터페이스 이용) ->디자인 패턴 이용(Factory이용)







1) xml

스프링 컨테이너는 <bean> 저장소에 해당하는 XML 설정 파일을 참조하여 <bean>의 생명주기를 관리하고 여러 가지 서비스를 제공한다. 따라서 <bean>,<description>,<alias>,<import> 등 네개의 엘리먼트를 자식 엘리멘트로 사용할 수 있다. 이 중에서 <bean>,<import> 정도가 실제 프로젝트에 사용된다.

- <import> 엘리먼트 : 분리하여 작성한 설정 파일들을 하나로 통합할 때 이용(트랜잭션 관리,예외처리 등 다양한 설정을 필요할 때 한곳에 하면 너무 길어지고 관리가 어렵다.)

1)mybiz.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	
	<bean id="ubiz" class="com.user.UserBiz" p:dao-ref="uod"/> <!--p:dao-ref="uod" : 어느 Dao ?-->

</beans>

```



2) mydao.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean id="uod" class="com.user.UserOracleDao"/>
	<bean id="umd" class="com.user.UserMariaDao"/>
	
	

</beans>

```



1) 과 2)를 합친 import 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<import resource="mydao.xml"/>
	<import resource="mybiz.xml"/>

</beans>

```

- <bean> 엘리멘트 및 각종 기능 : 스프링 설정 파일에 클래스를 등록할 대 <bean> 엘리먼트를 사용하여 클래스 하나당 <bean> 설정을 한다. 
  - init-method (시작할 때 실행할 메소드) ,destroy-method(끌날 때 실행할 메소드)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	
<bean id="ubiz" class="com.user.UserBiz" p:dao-ref="uod" init-method="startBiz" destroy-method="endBiz"/> <!-- 클래스 시작할 때 는 startbiz 메소드를 끝날때는 endbiz 메소드를 호출 -->

</beans>

```



2) Annotation (@)

- context를 Namespaces에서 가져옴 

  @xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd">
 	<context:component-scan base-package="springtv"/> <!-- springtv 안에 있는 클래스 전부를 수용 -->
	
</beans>




```

- 클래스 들에 component 이름을 만들어 준다.

​      @LTV

```java
package springtv;

import org.springframework.stereotype.Component;

@Component("ltv") /* xml에 component를 뿌려줌 */
public class LTV implements TV {
	String status;
	int volume;
	
	@Override
	public void turnOn() {
		this.status = "LTV ON";
	}

	@Override
	public void turnOff() {
		this.status = "LTV OFF";
	}

	@Override
	public void volumeUp(int v) {
		this.volume += v;
	}

	@Override
	public void volumeDown(int v) {
		this.volume -= v;
	}

	@Override
	public String toString() {
		return "LTV [status=" + status + ", volume=" + volume + "]";
	}
	
}

```

​      @STV

```java
package springtv;

import org.springframework.stereotype.Component;

@Component("stv")
public class STV implements TV {
	String status;
	int volume;
	int size;
	String color;
	
	
	public STV() {
		System.out.println("Constructor STV ...");
	}
	public void startTV() {
		System.out.println("Start STV ...");
	}
	
	public void endTV() {
		System.out.println("End STV ...");
	}
	
	@Override
	public void turnOn() {
		this.status = "STV ON";
	}

	@Override
	public void turnOff() {
		this.status = "STV OFF";
	}

	@Override
	public void volumeUp(int v) {
		this.volume += v;
	}

	@Override
	public void volumeDown(int v) {
		this.volume -= v;
	}
	@Override
	public String toString() {
		return "STV [status=" + status + ", volume=" + volume + ", size=" + size + ", color=" + color + "]";
	}

	
	
}


```

   @Apptest

```java
package springtv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("Spring Start...");
		
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("mytv.xml");//XML을 보고 Spring container가 생성됨 즉 tv객체가 만들어짐 (IOC) 
		
		System.out.println("Spring Started");
		
		TV stv = (TV)factory.getBean("ltv");
		stv.turnOn();
		stv.volumeUp(10);
		System.out.println(stv);
		
		
		
		
		
		factory.close();
	}

}

```

- 특정 객체 불러와서 Speaker 인터페이스 구현(방법 1) - 이방법은 나중에 component를 수정해줘야함

  @ Speaker 인터페이스

```java
package springtv;

public interface Speaker {
	public void up();
	public void down();
}

```

​        @ HarmanSpeaker

```java
package springtv;

import org.springframework.stereotype.Component;

@Component("hs")
public class HarmanSpeaker implements Speaker {

	@Override
	public void up() {
		System.out.println("Harman Speaker Volume Up");

	}

	@Override
	public void down() {
		System.out.println("Harman Speaker Volume Down");

	}

}

```

​       @ MarganzSpeaker

```java
package springtv;

import org.springframework.stereotype.Component;

@Component("ms")
public class MarganzSpeaker implements Speaker {

	@Override
	public void up() {
		System.out.println("Marganz Speaker Volume Up");

	}

	@Override
	public void down() {
		System.out.println("Marganz Speaker Volume Down");

	}

}

```

​     @해당 TV 객체에 Speaker를 단다.

```java
package springtv;

import javax.annotation.Resource;
import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("stv")
public class STV implements TV {
	String status;
	int volume;
	
	/*@Autowired 자동적으로 Speaker type의 객체를 불러옴 (단 해당 타입 객체가 하나일 때만)*/
	/*@Autowired @Qualifier("ms") /* 특정 객체를 가져오고 싶을 때(방법1) */
	
	@Resource(name = "ms") /* 특정 객체를 가져오고 싶을 때(방법2) */
	Speaker speaker;
	
	
	public STV() {
		System.out.println("Constructor STV ...");
	}
	/*
	 * public void startTV() { System.out.println("Start STV ..."); }
	 * 
	 * public void endTV() { System.out.println("End STV ..."); }
	 */
	
	@Override
	public void turnOn() {
		this.status = "STV ON";
	}

	@Override
	public void turnOff() {
		this.status = "STV OFF";
	}

	@Override
	public void volumeUp(int v) {
		speaker.up();
	}

	@Override
	public void volumeDown(int v) {
		speaker.down();
	}
	@Override
	public String toString() {
		return "STV [status=" + status + ", volume=" + volume + "]";
	}
	

	
	
}





```

  @Apptest

```java
package springtv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("Spring Start...");
		
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("mytv.xml");//XML을 보고 Spring container가 생성됨 즉 tv객체가 만들어짐 (IOC) 
		
		System.out.println("Spring Started");
		
		TV stv = (TV)factory.getBean("stv");
		stv.turnOn();
		stv.volumeUp(10);
		System.out.println(stv);
		
		
		
		
		
		factory.close();
	}

}

```

   @XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd">
 	<context:component-scan base-package="springtv"/> <!-- springtv 안에 있는 클래스 전부를 수용 -->
	
</beans>




```



- 특정 객체 불러와서 Speaker 인터페이스 구현(방법 2) - 수정시 XML만 수정하면됨.(NICE)

​     @해당 객체에서 Autowired 만 설정

    ```java
package springtv;

import javax.annotation.Resource;
import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("stv")
public class STV implements TV {
	String status;
	int volume;
	
	@Autowired 
	Speaker speaker;
	
	
	public STV() {
		System.out.println("Constructor STV ...");
	}
	/*
	 * public void startTV() { System.out.println("Start STV ..."); }
	 * 
	 * public void endTV() { System.out.println("End STV ..."); }
	 */
	
	@Override
	public void turnOn() {
		this.status = "STV ON";
	}

	@Override
	public void turnOff() {
		this.status = "STV OFF";
	}

	@Override
	public void volumeUp(int v) {
		speaker.up();
	}

	@Override
	public void volumeDown(int v) {
		speaker.down();
	}
	@Override
	public String toString() {
		return "STV [status=" + status + ", volume=" + volume + "]";
	}
	

	
	
}





    ```

​    @Speaker는 java 소스 들만 구현

​     - HarmanSpeaker

```java
package springtv;

import org.springframework.stereotype.Component;


public class HarmanSpeaker implements Speaker {

	@Override
	public void up() {
		System.out.println("Harman Speaker Volume Up");

	}

	@Override
	public void down() {
		System.out.println("Harman Speaker Volume Down");

	}

}

```

   -MarganzSpeaker

```java
package springtv;

import org.springframework.stereotype.Component;


public class MarganzSpeaker implements Speaker {

	@Override
	public void up() {
		System.out.println("Marganz Speaker Volume Up");

	}

	@Override
	public void down() {
		System.out.println("Marganz Speaker Volume Down");

	}

}

```

 @XML에서 해당 Class로 불러옴

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd">
 	<context:component-scan base-package="springtv"/> <!-- springtv 안에 있는 클래스 전부를 수용 -->
	<bean id="ms" class="springtv.HarmanSpeaker"/>
</beans>




```

 @apptest

```java
package springtv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("Spring Start...");
		
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("mytv.xml");//XML을 보고 Spring container가 생성됨 즉 tv객체가 만들어짐 (IOC) 
		
		System.out.println("Spring Started");
		
		TV stv = (TV)factory.getBean("ltv");
		stv.turnOn();
		stv.volumeUp(10);
		System.out.println(stv);
		
		
		
		
		
		factory.close();
	}

}

```

Quiz) Annotation을 기입하시오 단, Dao는 XML에 기입 하시오.

  @XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd">
	<context:component-scan base-package="com.*"></context:component-scan> <!-- com밑에 모든걸 scan -->
	<bean id="ms" class="com.user.UserOracleDao"/>
</beans>

```

 @UserBiz(Component, Autowired)

```java
package com.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.frame.Dao;

@Component("ubiz")
public class UserBiz implements Biz<String, User> {
	
	@Autowired
    Dao<String,User> dao;
    
    public void startBiz() {
    	System.out.println("Start Biz ...");
    }
    
    public void endBiz() {
    	System.out.println("End Biz ...");
    }



	public void setDao(Dao<String, User> dao) {
		this.dao = dao;
	}

	@Override
	public void insert(User v) throws Exception {
		dao.insert(v);

	}

	@Override
	public void update(User v) throws Exception {
		dao.update(v);

	}

	@Override
	public void delete(String k) throws Exception {
		dao.delete(k);

	}

	@Override
	public User select(String k) throws Exception {
		
		return dao.select(k);
	}

	@Override
	public ArrayList<User> select() throws Exception {
		// TODO Auto-generated method stub
		return dao.select();
	}

}

```

@UserMariaDao

```java
package com.user;

import java.util.ArrayList;

import com.frame.Dao;

public class UserMariaDao implements Dao<String, User> {

	@Override
	public void insert(User v) throws Exception {
		System.out.println(v+"UserMariaDao Inserted ...");

	}

	@Override
	public void update(User v) throws Exception {
		System.out.println(v+"UserMariaDao Updated ...");

	}

	@Override
	public void delete(String k) throws Exception {
		System.out.println(k+"UserMariaDao Deleted ...");

	}

	@Override
	public User select(String k) throws Exception {
		
		return new User("id01","pwd01","이말숙");
	}

	@Override
	public ArrayList<User> select() throws Exception {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01","pwd01","이말숙"));
		list.add(new User("id02","pwd02","김말숙"));
		list.add(new User("id03","pwd03","정말숙"));
		list.add(new User("id04","pwd04","장말숙"));
		return list;
	}

}

```

@UserOracleDao

```java
package com.user;

import java.util.ArrayList;

import com.frame.Dao;

public class UserOracleDao implements Dao<String, User> {

	@Override
	public void insert(User v) throws Exception {
		System.out.println(v+"UserOracleDao Inserted ...");

	}

	@Override
	public void update(User v) throws Exception {
		System.out.println(v+"UserOracleDao Updated ...");

	}

	@Override
	public void delete(String k) throws Exception {
		System.out.println(k+"UserOracleDao Deleted ...");

	}

	@Override
	public User select(String k) throws Exception {
		
		return new User("id01","pwd01","이말숙");
	}

	@Override
	public ArrayList<User> select() throws Exception {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01","pwd01","이말숙"));
		list.add(new User("id02","pwd02","김말숙"));
		list.add(new User("id03","pwd03","정말숙"));
		list.add(new User("id04","pwd04","장말숙"));
		return list;
	}

}

```

@apptest

```java
package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.user.User;

public class App {

	public static void main(String[] args) {
     AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");//XML에서 자동적으로 모든 객체 생성
		
		System.out.println("Spring Started");
		
		Biz<String,User> biz = (Biz<String,User>)factory.getBean("ubiz");
		
		User user = new User("id01","pwd01","이말자");
		try {
			biz.insert(user);
			System.out.println("Inserted Ok From app.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		factory.close();

	}

}

```

- 추가 어노테이션 - 비즈니스 레이어는 사용자의 요청에 대한 비즈니스 로직을 담당

  | 어노테이션  | 위치           | 의미                                     |
  | ----------- | -------------- | ---------------------------------------- |
  | @Service    | XXXServicelmpi | 비즈니스 로직을 처리하는 Service 클래스  |
  | @Repository | XXXDAO         | 데이터베이스 연동을 처리하는 DAO 클래스  |
  | @Controller | XXXController  | 사용지 요청을 제어하는 Controller 클래스 |

  



### 스프링 AOP(Aspect Oriented Programming)

Log 함수 넣을 때

@LogAdvice

```java
package com.frame;

import java.util.Date;

public class LogAdvice {
	public void printLog() {
		Date d = new Date();
		System.out.println(d+ "[공통 로그 ] 비즈니스 로직 수행  ....");
	}
}

```



@UserBiz

```java
package com.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.frame.LogAdvice;

@Service("ubiz") /* Component랑 같은데 이름만 Service */
public class UserBiz implements Biz<String, User> {
	
	@Resource(name="uod")
    Dao<String,User> dao;
	LogAdvice log; //수행 결과를 찍을 LogAdvice 객체 호출
	
	public UserBiz() {
		log = new LogAdvice();
	}
    
    public void startBiz() {
    	log.printLog();
    	System.out.println("Start Biz ...");
    }
    
    public void endBiz() {
    	log.printLog();
    	System.out.println("End Biz ...");
    }



	public void setDao(Dao<String, User> dao) {
		log.printLog();
		this.dao = dao;
	}

	@Override
	public void insert(User v) throws Exception {
		log.printLog();
		dao.insert(v);

	}

	@Override
	public void update(User v) throws Exception {
		log.printLog();
		dao.update(v);

	}

	@Override
	public void delete(String k) throws Exception {
		log.printLog();
		dao.delete(k);

	}

	@Override
	public User select(String k) throws Exception {
		log.printLog();
		
		return dao.select(k);
	}

	@Override
	public ArrayList<User> select() throws Exception {
		log.printLog();
		// TODO Auto-generated method stub
		return dao.select();
	}

}

```

 @Apptest

```java
package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.product.Product;
import com.user.User;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");// XML에서 자동적으로 모든 객체 생성

		System.out.println("Spring Started");

		Biz<String, User> biz = (Biz<String, User>) factory.getBean("ubiz");

		User user = new User("id01", "pwd01", "이말자");
		try {
			biz.insert(user);
			System.out.println("Inserted Ok From app.");
		} catch (Exception e) {

			e.printStackTrace();
		}

		factory.close();


	}

}

```

> 문제 - 기존의 OOP 언어에서는 횡단 관심에 해당하는 공통 코드를 완벽하게 독립적인 모듈로 분리해내기가 어렵다. -> **"AOP가 등장"** 



- AOP 는 Spring 뿐만 아니라 ASPECT 라이브러리도 필요하다. (우리는 지금 Maven에 들어가 있음)

<AOP방법 >

1) XML

- XML -> namespace에서 AOP 추가한다.



2) Annotation