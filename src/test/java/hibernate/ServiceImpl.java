package hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	Log logImpl;
	
	@Transactional
	public void service() {
		//CglibAopProxy
		try {
			this.insertOrder();
			this.raiseException();
			
		} catch (Exception e) {
			logImpl.insertFailLog(e.getMessage());
			throw e;
		} finally {
		}
	}
	
	public void insertOrder() {
		jdbcTemplate.update("insert into t_order values('1','a',sysdate)");
	}
	
	public void raiseException() {
		System.out.println(1/0);
	}
	
	
	@Transactional
	public void invokeService() {
		this.service();
	}
	
}
