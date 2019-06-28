package com.sds.frame;

import java.util.ArrayList;

public abstract class Dao<K,V> {
	public abstract void insert(V v) throws Exception;//���ܰ� �߻��Ҽ��� �־�
	public abstract void delete(K k) throws Exception;//���ܰ� �߻��Ҽ��� �־�
	public abstract void update(V v) throws Exception;//���ܰ� �߻��Ҽ��� �־�
	public abstract V select(K k) throws Exception;
	public abstract ArrayList<V> select() throws Exception;
}
