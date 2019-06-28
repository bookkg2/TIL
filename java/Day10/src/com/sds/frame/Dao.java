package com.sds.frame;

import java.util.ArrayList;

public abstract class Dao<K,V> {
	public abstract void insert(V v) throws Exception;//예외가 발생할수도 있어
	public abstract void delete(K k) throws Exception;//예외가 발생할수도 있어
	public abstract void update(V v) throws Exception;//예외가 발생할수도 있어
	public abstract V select(K k) throws Exception;
	public abstract ArrayList<V> select() throws Exception;
}
