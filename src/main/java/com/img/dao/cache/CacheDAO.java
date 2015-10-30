package com.img.dao.cache;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.img.log.RunLog;

@Repository
public class CacheDAO {
	@Autowired
	private RedisTemplate redisTemplate;
	
	public void putCache(String key ,String value){
		try{
			redisTemplate.opsForValue().set(key, value);
		}catch(Exception e){
			RunLog.LOG.error(" Redis put cache  [{}-{}] error ",key,value,e);
		}
	}
	 
	public String getCache(String key){
		try{
			return (String)redisTemplate.opsForValue().get(key);
		}catch(Exception e){
			RunLog.LOG.error(" Redis Get cache Error key : {}",key,e);
			return null;
		}
	}
	
	public void putCacheMap(String key,Map map){
		try{
//			redisTemplate.opsForSet().add(key, map);
			BoundHashOperations hashBound = redisTemplate.boundHashOps(key);
			hashBound.putAll(map);
		}catch(Exception e){
			RunLog.LOG.error(" Redis put cache  [{}-{}] error ",key,map,e);
		}
	}
	
	public Map getCacheMap(String key){
		try{
			BoundHashOperations hashBound = redisTemplate.boundHashOps(key);
			Map map =  hashBound.entries();
			if(map.isEmpty()){
				return null;
			}
			return map;
		}catch(Exception e){
			RunLog.LOG.error(" Redis Get cache Error key : {}",key,e);
			return null;
		}
	}
	
//	
//	//存取数据
//	public void putCache(String key ,byte[] value){
//		try{
//			redisTemplate.opsForValue().set(key, value);
//		}catch(Exception e){
//			RunLog.LOG.error(" Redis put cache  [{}-{}] error ",key,value,e);
//		}
//	}
//	 
//	public byte[] getByteCache(String key){
//		try{
//			return (byte[]) redisTemplate.opsForValue().get(key);
//		}catch(Exception e){
//			RunLog.LOG.error(" Redis Get cache Error key : {}",key,e);
//			return null;
//		}
//	}

}
