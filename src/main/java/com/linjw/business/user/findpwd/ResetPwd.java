package com.linjw.business.user.findpwd;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjw.business.noGen.random.RandomNoGenerator;
import com.linjw.business.utils.Result;
import com.linjw.business.utils.WebUtils;
import redis.clients.jedis.Jedis;

@Controller
public class ResetPwd {

	@Autowired
	ResetPwdService service;

	Jedis jedis = new Jedis("localhost");
	
	@RequestMapping("/redis_code")
	public String redisCode() {
		return "redis-code";
	}

	@RequestMapping("/reset_pwd")
	public void testSend(String phoneNumber,
			HttpServletRequest req, HttpServletResponse resp) {

		System.out.println(req.getRemoteAddr());;
		
		String ip = WebUtils.getRemoteRealIPAddr(req);
		System.out.println(ip);
		try {
			String numIp = jedis.get(ip);
			if(StringUtils.isBlank(numIp)) {
				jedis.expire(ip, 24 * 60 * 60);
			}
			else if(Integer.valueOf(numIp) > 30){
				req.getSession().setAttribute("respStr", "exceed 5 times by current ip");
				return;
			}
			
			String code = jedis.get(phoneNumber);
			
			if(StringUtils.isBlank(code)) {
				RandomNoGenerator randomNoGenerator = new RandomNoGenerator();
				code = randomNoGenerator.generate();
				jedis.set(phoneNumber, code);
				jedis.expire(phoneNumber, 10);
				jedis.incr(ip);
				req.getSession().setAttribute("respStr", "resent successfully, code : " + code);
			}else {
				req.getSession().setAttribute("respStr", "cannot resend code in 10s, code : " + code);
			}
		}catch(Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("respStr", "server error");
		}finally {
			jedis.close();
		}
		Set<String> list = jedis.keys("*");

		for (String string : list) {
			System.out.println(string);
		}
		
	}
	
}
