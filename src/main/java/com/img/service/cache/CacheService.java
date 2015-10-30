package com.img.service.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.img.bean.ImgObject;
import com.img.bean.filemap.FileDelRecord;
import com.img.bean.filemap.FileNameMap;
import com.img.dao.cache.CacheDAO;
import com.img.dao.filemap.FileMapDAO;

@Service
public class CacheService {
	@Autowired CacheDAO cacheDAO;
	@Autowired FileMapDAO fileMapDAO;
	@Value("${useCache}") 
	private boolean useCache ;       //是否用缓存
	
	
	/**
	 * 获取cache获取gomefsKey，如果没有，从数据库查找
	 * */
	public FileNameMap getGomefsKeyFromCache(ImgObject object){
		
		FileNameMap record = new FileNameMap();
		Map<String,String> recodeMap = null;
		String gomefsKey = null;
		if(useCache){
			recodeMap= cacheDAO.getCacheMap(object.getSourceKey());
		}
		if(recodeMap == null){
			record = getFileMapFromDb(object.getSourceKey());
		}else{
			record.setBusinessName(recodeMap.get("businessName"));
			record.setGomefsKey(recodeMap.get("gomefsKey"));
		}
		return record;
	}
	//查询数据库并cache
	public FileNameMap getFileMapFromDb(String sourceKey){
		 FileNameMap fileMap = fileMapDAO.getGomeFileMap(sourceKey);
		 if(fileMap != null && useCache){
			 Map<String,String> map = new HashMap();
			 map.put("businessName", fileMap.getBusinessName());
			 map.put("gomefsKey", fileMap.getGomefsKey());				
			 cacheDAO.putCacheMap(sourceKey, map);
		 }
		return fileMap;
	}
	//查询数据库并cache
	public FileDelRecord getGomeFsKeyFromDelRecord(ImgObject object){
		return null;  //暂时取消查询删除表
//		String sourceKey= object.getSourceKey();
//		FileDelRecord record = new FileDelRecord();
//		Map<String,String> recodeMap = null;
//		if(useCache){
//			recodeMap= cacheDAO.getCacheMap("N"+sourceKey);
//		}
//		if(recodeMap == null){
//			record =  getDelRecordFromDB(sourceKey);
//		}else{
//			record.setFlag(recodeMap.get("flag"));
//			record.setGomefsURI(recodeMap.get("gomefsUrl"));
//		}
//		return record;
	}	
	public FileDelRecord getDelRecordFromDB(String sourceKey){
		FileDelRecord fileDelRecord  = fileMapDAO.getDelRecord(sourceKey);
		if(fileDelRecord != null && useCache){
			Map<String,String> recodeMap = new HashMap();
			recodeMap.put("flag", fileDelRecord.getFlag());
			recodeMap.put("gomefsUrl", fileDelRecord.getGomefsURI());				
			cacheDAO.putCacheMap("N"+sourceKey, recodeMap);
		}
		return fileDelRecord;
	}
//	
//	public byte[] getGomeFsData(String key){
//		if(useCache){
//			return cacheDAO.getByteCache(key);
//		}else{
//			return null;
//		}
//	}
//	
//	public void putGomeFsData(String key,byte[] values){
//		if(useCache){
//		cacheDAO.putCache(key, values);
//		}
//	}
}
