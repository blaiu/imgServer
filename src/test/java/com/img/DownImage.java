package com.img;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import com.img.log.RunLog;

public class DownImage {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://10.58.50.20/image/prodimg/promotion_image/promoImg/201505/20150513/1F左侧导航下方广告模板198x160-01.jpg");
//		Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1", 8888));  
//		URL serverUrl = new URL(url);  
//		HttpURLConnection uc = (HttpURLConnection) url.openConnection(proxy);
		HttpURLConnection    uc = (HttpURLConnection)url.openConnection();

//		HttpURLConnection    uc = (HttpURLConnection)url.openConnection();
		uc.setConnectTimeout(6*1000);
		if (uc.getResponseCode() != 200) {
			 
		}
		InputStream is= uc.getInputStream();
		File   file   =   new   File( "E:/app/abc.jpg "); 
		FileOutputStream   out   =   new   FileOutputStream(file); 
		int   i=0; 
		while   ((i=is.read())!=-1)   { 
		out.write(i); 
		} 
		is.close();
		RunLog.LOG.info("抓取图片："+url.getPath());
		System.out.println("dd");
	}

}
