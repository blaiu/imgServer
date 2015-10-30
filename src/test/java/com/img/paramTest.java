package com.img;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="file:src/main/resources/applicationContext.xml" ) // 加载配置

public class paramTest {
	
	@Value("${sourceUrl}") 
	public  static String sourceUrl ;
	public List<String> sourceDomain  =Lists.newArrayList(sourceUrl);
	@Test
	public void test() {
		System.out.println(sourceUrl);
		System.out.println(sourceDomain.size());
		for(String s : sourceDomain){
			System.out.println(s);
		}
	}

}
