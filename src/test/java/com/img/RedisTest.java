package com.img;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="file:src/main/resources/applicationContext.xml" ) // 加载配置
public class RedisTest {
	@Autowired
	private RedisTemplate redisTemplate;
	@Test
	public void test() {
//		redisTemplate.keys(pattern)
	}

}
