package com.img.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.img.bean.ImgObject;
import com.img.dao.filesys.GomefsDAO;
import com.img.service.cache.CacheService;
import com.img.service.filemap.FileMapService;
import com.img.service.resolve.ResolveHolder;
import com.img.service.transfer.FsTransfer;
import com.img.util.MetadataUtils;

/**
 * 图片访问
 * */
@Service
public class ImgServer {
	private static Logger log = LoggerFactory.getLogger(ImgServer.class);
	@Autowired GomefsDAO gomefsDao;
	@Autowired FsTransfer fsTransfer;
	@Autowired FileMapService fileMapService;
	@Autowired
	private    ResolveHolder  resolveHolder;
	@Autowired private CacheService cacheService;
	/**
	 * 获取图片
	 * */
	public void getImage(ImgObject object){
//        //解析URI
//		resolveUrlServer.resolveUrl(object);
//        //判断gomefsKey是否为null，如果为null 说明没有获取到相关信息，需要转换
//        if(object.gomefsKey != null){
//        	object.zoomData = gomefsDao.read(object.gomefsKey);
//        }else{  
//        	fsTransfer.transferFile(object);
//        	fileMapService.addFileNameMap(object.sourceKey, null, object.gomefsKey);
//        }
			 resolveHolder.resolve(object);
        MetadataUtils.process(object);
	}
	
	
	public String writeImge(byte[] data){
		return gomefsDao.write(data);
	}
	
	
}
