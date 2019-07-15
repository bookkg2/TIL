package mini.customer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.frame.Dao;
import mini.mapper.CustomerMapper;
import mini.vo.Customer;

@Repository("cdao")
public class CustomerDao implements Dao<String, Customer> {
	
	@Autowired
	CustomerMapper cm;
	@Override
	public void insert(Customer v) throws Exception {
		cm.insert(v);
		
	}

	@Override
	public void update(Customer v) throws Exception {
		cm.update(v);
		
	}

	@Override
	public void delete(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer select(String k) throws Exception {
		// TODO Auto-generated method stub
		return cm.select(k);
	}

	@Override
	public ArrayList<Customer> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
