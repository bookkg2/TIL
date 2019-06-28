package db;

public class ProductBiz extends Biz {
	
	Dao dao;
	
	public ProductBiz(String ip) {
		dao = new ProductDao(ip);
	}
	
	@Override
	public void register(Object obj) {
		//Transaction start....
		dao.insert(obj);//DBø° ≥÷æÓ¡‡ !
		//Transaction end....


	}

	@Override
	public void remove(Object obj) {
		

	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
