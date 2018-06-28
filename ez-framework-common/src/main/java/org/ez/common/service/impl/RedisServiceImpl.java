package org.ez.common.service.impl;

import java.util.UUID;

import org.ez.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;

	@Override
	public boolean add(String key, Object value) {
		try {
			redisTemplate.opsForHash().put("HASH", key, value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
	}

}
