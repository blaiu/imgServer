package com.img.service.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.img.bean.ImgObject;
import com.img.dao.cache.CacheDAO;
import com.img.dao.filesys.GomefsDAO;
import com.img.dao.filesys.SourcefsDAO;
import com.img.log.RunLog;

@Service
public class FsTransfer {
	@Autowired GomefsDAO gomefsDAO;
	@Autowired SourcefsDAO sourcefsDAO;
	
	public String transferFile(ImgObject object){
		byte[] sourceFile =  sourcefsDAO.read(object);
		if(sourceFile != null && sourceFile.length > 0){
			 String gomefsKey = gomefsDAO.write(sourceFile);
			 if(gomefsKey != null && !gomefsKey.equals("")){
				 object.setZoomData(sourceFile);
				 object.setGomefsKey(gomefsKey+object.getSourceKey().substring(object.getSourceKey().lastIndexOf(".")));
			 }
			 RunLog.LOG.error("transfer file "+gomefsKey);
			 return gomefsKey;
		}else{
			RunLog.LOG.error(" method transferFile error,can not read file  :{} ", object.getSourceKey());
			return null;
		}
	}
}
