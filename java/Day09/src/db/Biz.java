package db;

public abstract class Biz {
	
	public abstract void register(Object obj);
	public abstract void remove(Object obj);
	public abstract Object get(Object obj); //app에서 가져온 데이터를 다시 Object로 리턴 
	

}
