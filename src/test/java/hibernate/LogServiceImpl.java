package hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class LogServiceImpl implements Log {

	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void insertFailLog(String reason) {
		jdbcTemplate.update("insert into t_fail_log values('1','" + reason +"',sysdate)");
	}
	
}
