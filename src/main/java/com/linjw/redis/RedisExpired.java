package com.linjw.redis;

import redis.clients.jedis.Jedis;

public class RedisExpired {
	
	public static void main(String[] args) throws InterruptedException {
		
		Jedis jedis = new Jedis("localhost");
		jedis.set("a", "b");
		
		jedis.expire("a", 5);
		System.out.println(jedis.get("a"));
		Thread.sleep(6000);
		System.out.println(jedis.get("a"));
		jedis.close();
	}

}
