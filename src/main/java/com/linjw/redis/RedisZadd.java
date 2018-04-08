package com.linjw.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisZadd {
	
	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("localhost");
		Map<String, Double> scores = new HashMap<String, Double>();
		scores.put("lucy", 1d);
		scores.put("ross", 2d);
		scores.put("tam", 9d);
		scores.put("xxx", 3d);
		scores.put("riducsa", 5d);
		jedis.zadd("classMember", scores);
		Set<String> set = jedis.zrevrange("classMember", 0, 2);
		for (String string : set) {
			System.out.println(string);
		}
		jedis.setbit("daily count", 1, true);
		jedis.close();
		
	}

}
