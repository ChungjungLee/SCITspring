package global.sesoc.web8.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web8.mapper.CustomerMapper;
import global.sesoc.web8.vo.Customer;

/**
 * controller상에서 이것을 사용하려면 new를 통해 instance를 생성해야 한다
 * 그러면 메모리 낭비니까 하나만 만들고 사용하도록 할 필요가 있다
 * 그것을 해주는 것이 repository annotation(저장소로 활용하겠다)
 * 이 클래스의 객체를 미리 만들어 놓고 나중에 사용이 가능
 */

@Repository
public class CustomerDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	public int insert(Customer customer) {
		int result = 0;	// 몇 개가 insert 되었는지?
		
		try {
			CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
			result = mapper.insert(customer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Customer> getCustomerAll() {
		ArrayList<Customer> result = null;
		
		try {
			CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
			result = mapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Customer getCustomerOne(String id) {
		Customer result = null;
		
		try {
			CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
			result = mapper.selectOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(Customer customer) {
		int result = 0;
		
		try {
			CustomerMapper mapper = sqlsession.getMapper(CustomerMapper.class);
			result = mapper.update(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}


























