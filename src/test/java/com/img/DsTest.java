package com.img;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.img.service.auth.AuthService;

@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="file:src/main/resources/applicationContext.xml" ) // 加载配置
public class DsTest {
	
	@Autowired
	private AuthService authService;
	

	@Test
	public void test() throws ParseException {
//		System.out.println("杨双军"+authService);
		System.out.println(authService.authorization("yangdkj"));
//		System.out.println(authService.authorizationByMap("yangdkj"));
	}
	
	
	public AuthService getAuthService() {
		return authService;
	}
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

}
