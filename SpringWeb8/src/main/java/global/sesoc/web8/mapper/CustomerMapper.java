package global.sesoc.web8.mapper;

import java.util.ArrayList;

import global.sesoc.web8.vo.Customer;

public interface CustomerMapper {
	int insert(Customer customer);
	
	ArrayList<Customer> selectAll();
	
	Customer selectOne(String custid);
}
