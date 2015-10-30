package com.img;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.img.bean.filemap.FileDelRecord;
import com.img.dao.cache.CacheDAO;
import com.img.dao.filemap.FileMapDAO;

@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="file:src/main/resources/applicationContext.xml" ) // 加载配置
public class CacheTest {
//	@Autowired
//	private FileMapDAO fileMapDao;
	@Autowired
	private CacheDAO cacheDAO;
	@Test
	public void test() {
		System.out.println("dd");
		cacheDAO.putCache("yang", "shuangjun");
//		System.out.println(fileMapDao);
//		List<FileDelRecord>  delRecords = fileMapDao.getDelRecord("yang.jpg");
//		for(FileDelRecord fdr : delRecords){
//			System.out.println(fdr.getGomefsURI());
//		}
	}

}
