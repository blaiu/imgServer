package com.img.dao.common;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.img.bean.auth.Authorization;



public class BaseDAO {
	
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;

}
