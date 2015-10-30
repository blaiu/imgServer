package com.img.service.resolve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.img.bean.ImgObject;
import com.img.common.CommonConstants;
import com.img.dao.filesys.GomefsDAO;
import com.img.service.filemap.FileMapService;
import com.img.service.transfer.FsTransfer;

/**
 * 处理HTML URL业务，没有参数，只保留原信息读取返回
 * */
@Service
public class ResolveSourceHtmlUrl extends UrlResolveAbstract {
	@Autowired FsTransfer fsTransfer;
	@Autowired FileMapService fileMapService;
	@Autowired GomefsDAO gomefsDao;
	@Override
	public void resolveLabelSize(ImgObject object) {
		//读取原key
		object.setSourceKey(object.getNewUrl().substring(object.getNewUrl().lastIndexOf("/")+1));
	}

	@Override
	public void resolveQuality(ImgObject object) {

	}

	@Override
	public void doTransferAndSetKey(ImgObject object){
		if(object.getIsGomefsKey()){
			object.setZoomData(gomefsDao.read(object.getGomefsKey())); 
		}else{
    	fsTransfer.transferFile(object);
    	fileMapService.addFileNameMap(object.getSourceKey(), CommonConstants.HTML_BUSINESS, object.getGomefsKey());
		}
	}
}
