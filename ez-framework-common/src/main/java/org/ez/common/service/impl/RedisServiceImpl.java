package org.ez.common.service.impl;

import org.ez.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
	
	@Autowired
    private RedisTemplate<String, String> redisTemplate;

	@Override
	public boolean add(String key, Object value) {
		try {
			redisTemplate.opsForHash().put("HASH_KEY", key, value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
