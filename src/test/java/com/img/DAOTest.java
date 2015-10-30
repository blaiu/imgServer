package com.img;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.img.bean.filemap.FileDelRecord;
import com.img.dao.filemap.FileMapDAO;

@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="file:src/main/resources/applicationContext.xml" ) // 加载配置
public class DAOTest {
	 public final static Logger LOG = LoggerFactory.getLogger(DAOTest.class);
	@Autowired
	private FileMapDAO fileMapDao;
	@Test
	public void test() {
//		System.out.println("dd");
//		System.out.println(fileMapDao);
//		FileDelRecord  delRecords = fileMapDao.getDelRecord("yang.jpg");
//		fileMapDao.getGomefsKey("yang.jpg");
//		System.out.println(delRecords.getGomefsURI());
//		fileMapDao.addFileNameMap("asdfs.jpg", "n1", "asdf");
		System.out.println(fileMapDao.getGomefsKey("asdfs.jpg"));
		LOG.error("error");
		
	}

}
