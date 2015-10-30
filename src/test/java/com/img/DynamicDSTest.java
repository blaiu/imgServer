package com.img;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.img.bean.auth.Authorization;
import com.img.ds.DataSourceContextHolder;
import com.img.service.auth.AuthService;

/**
 * 多数据源测试
 * */

@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="file:src/main/resources/applicationContext.xml" ) // 加载配置
public class DynamicDSTest {
	@Autowired
	private AuthService authService;
	
	@Test
	public void test() {
//		System.out.println(DataSourceContextHolder.slaveDs);
//		DataSourceContextHolder.setDsConfig(DataSourceContextHolder.slaveDs);
//		System.out.println(authService.authorization("yangdkj"));
		DataSourceContextHolder.setDsConfig(DataSourceContextHolder.masterDs);
//		System.out.println(authService.authorization("yangdkj"));
//		DataSourceContextHolder.setDsConfig(DataSourceContextHolder.masterDs);
//		for(int i = 0;i<1000;i++){
//			if(i%2==0){
//				DataSourceContextHolder.setDsConfig(DataSourceContextHolder.slaveDs);
				Authorization auth = new Authorization();
				auth.setAuthCode("yangsj");
				auth.setAuthStatus("1");
				auth.setCreateDatetime(new Date());
				auth.setOrgName("云平台");
				authService.addAuth(auth);
//
//			}else{
//				DataSourceContextHolder.setDsConfig(DataSourceContextHolder.masterDs);
//				Authorization auth = new Authorization();
//				auth.setAuthCode("yangm"+i);
//				auth.setAuthStatus("1");
//				auth.setCreateDatetime(new Date());
//				auth.setOrgName("云平台");
//				authService.addAuth(auth);
//
//			}
//			
//		}

	}
	

}
