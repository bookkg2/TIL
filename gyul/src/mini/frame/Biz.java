package mini.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface Biz<K,V> {
	@Transactional /* Ʈ������ ó�� ���ش�. */
	public abstract void register(V v) throws Exception;

	@Transactional
	public abstract void remove(K k) throws Exception;
	
	@Transactional
	public abstract void modify(V v) throws Exception;

	public abstract V get(K k) throws Exception;

	public abstract ArrayList<V> get() throws Exception;

	

	

}
