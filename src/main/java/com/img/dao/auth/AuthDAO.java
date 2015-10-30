package com.img.dao.auth;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.img.bean.auth.Authorization;
import com.img.dao.common.BaseDAO;



@Repository
public class AuthDAO extends BaseDAO {
	
	/**
	 * 根据授权码查询用户是否经过授权
	 * */
	public boolean authorization(String authCode){
		Authorization auth = (Authorization)sqlSessionTemplate.selectOne("Authorization.selAuth",authCode);
		if(auth == null) return false ;
		return true;
	}
	
	/**
	 * 新增授权
	 * */
	public int  addAuthorization(Authorization auth){
		return sqlSessionTemplate.insert("Authorization.addAuth", auth);
	}
	
}
