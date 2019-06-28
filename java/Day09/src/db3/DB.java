package db3;

public abstract class DB<T,U> {
	public abstract void insert(T obj);//User = T
	public abstract T select(U obj);// U = String 

}
