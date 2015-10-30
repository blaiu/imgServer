package com.img.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.img.bean.auth.Authorization;
import com.img.dao.auth.AuthDAO;
import com.img.dao.cache.CacheDAO;
import com.img.log.RunLog;

@Service
public class AuthService {

	@Autowired 	AuthDAO authdao  ;
	@Autowired 	CacheDAO cachedao  ;
	
	/**
	 * 查看授权，授权:true;未授权:false
	 * @param authCode
	 * @return boolean
	 * */
	public boolean authorization(String authCode){
		if (authdao.authorization(authCode.toString())) {
			RunLog.LOG.info(" authCode pass :" + authCode.toString());
			return true;
		} else {
			RunLog.LOG.warn(" authCode is not authorize :"
					+ authCode.toString());
			return false;
		}
	}
	/**
	 * 新增授权信息
	 * */
	public int addAuth(Authorization auth){
		return authdao.addAuthorization(auth);
	}
}
