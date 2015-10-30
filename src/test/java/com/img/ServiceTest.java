package com.img;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.img.bean.ImgObject;

@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="file:src/main/resources/applicationContext.xml" ) // 加载配置
public class ServiceTest {
//	@Autowired
//	private FileMapDAO fileMapDao;
//	@Autowired
//	private ResolveUrlService resolveUrlService;
//	@Test
//	public void test() {
//	      ImgObject object = new ImgObject();
////	        object.newUrl = "n1/s350x120_gomefs/t37/263/3197746408/50087/4ca60e0a/53600bc1N53f9d4da.jpg!q100.jpg";
//	        object.newUrl = "n1/gomefs/t37/263/3197746408/50087/4ca60e0a/53600bc1N53f9d4da.jpg";
//	        resolveUrlService.resolveUrl(object);
//	}

}
