package ws;

import java.util.ArrayList;

public abstract class DB<C,T> {
	
	ArrayList<C> datas = new ArrayList<>();

	
	
	public abstract void insert(C obj);
	public abstract C select(T obj);
	public abstract C selectAll(C obj);
	public abstract C update(C obj);
	public abstract void delete(T obj);
	

}
