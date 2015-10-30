package com.img;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.img.common.CommonConstants;
import com.img.log.RunLog;

public class JsoupTest {
 
	@Test
	public void test() throws IOException {
		
		String url = "http://prom.gome.com.cn/html/prodhtml/topics/201505/web/pk618.htm";
		
		 url = url.substring(url.lastIndexOf("/")+1);
		System.out.println(url.substring(0,url.indexOf("?")>0?url.indexOf("?"):url.length()));
//		URL url = new URL("http://prom.gome.com.cn/html/prodhtml/topics/201505/web/pk618.html?intcmp=sy-A-2-1-0-618");
//		HttpURLConnection    uc = (HttpURLConnection)url.openConnection();
//		uc.setRequestProperty("Accept-Charset", "utf-8");
//		uc.setRequestProperty("contentType", "utf-8");
//		uc.setConnectTimeout(6*1000);
//		 
//		InputStream is= uc.getInputStream();
//		File   file   =   new   File( "E:/app/abc.html "); 
//		FileOutputStream   out   =   new   FileOutputStream(file); 
//		int   i=0; 
//		while   ((i=is.read())!=-1)   {  
//		out.write(i); 
//		} 
//		is.close();
//		RunLog.LOG.info("抓取图片："+url.getPath());
//		System.out.println("dd");
	}

}
