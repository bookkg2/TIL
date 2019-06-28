package db;

public class App {

	public static void main(String[] args) {
		User user = new User("id01", "james", "pwd01");
//		Biz biz = new Instance("UserBiz");// Instance : biz에 있는 Userbiz를 사용하겠습니다. 하지만 현재 API가 없어서 못씀 ,.
		Biz biz = new UserBiz("192.168.111.100");
		biz.register(user);//자바의 장단점 ! ,register 가 추상함수가 있으니깐 가능 !!
		biz.remove("id01");
		
		User dbuser = null;
		dbuser = (User)biz.get("id01");//object를 가져 올수 없으니 
		System.out.println(dbuser);

	}

}
