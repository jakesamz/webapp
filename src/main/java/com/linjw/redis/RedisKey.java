package com.linjw.redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisKey {

	public static void main(String[] args) {
		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		// store data in redis list
		// Get the stored data and print it
		Set<String> list = jedis.keys("*");

		for (String string : list) {
			System.out.println(string);
		}
		jedis.close();
	}

}
