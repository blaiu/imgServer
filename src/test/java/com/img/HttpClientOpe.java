package com.img;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

public class HttpClientOpe {

	/**
	 * 测试文件上传
	 * */
	public static void main(String[] args) throws IOException {

		String fileUrl = "E://mm.html";
		// Prepare HTTP post
		PostMethod post = new PostMethod(
				"http://10.58.56.44:8080/upload");
		// from the input stream
		byte[] buffer = file2byte(fileUrl);
		ByteArrayRequestEntity entity = new ByteArrayRequestEntity(buffer);
		post.setRequestEntity(entity);
		CRC32 crc = new CRC32();
		crc.update(buffer);
		StringBuilder imageInfo = new StringBuilder();
		imageInfo.append(crc.getValue()).append("-").append(entity.getContentLength());
		post.addRequestHeader("authCode", "1234567");
		post.addRequestHeader("busiCode", "n1");
		post.addRequestHeader("imageInfo", imageInfo.toString()+".html");
		post.addRequestHeader("customName", "决战618.html");
		// Get HTTP client
		HttpClient httpclient = new HttpClient();
		// Execute request
		try {
			int result = httpclient.executeMethod(post);
			// Display status code
//			System.out.println("Response status code: " + result);
			// Display response
//			System.out.println("Response body: ");
			System.out.println(post.getResponseBodyAsString());
		} finally {
			// Release current connection to the connection pool once you are
			// done
			post.releaseConnection();
		}
	}

	public static byte[] file2byte(String filePath) {
		byte[] buffer = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			buffer = bos.toByteArray();
			bos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	public static void byte2File(byte[] buf, String filePath, String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists() && dir.isDirectory()) {
				dir.mkdirs();
			}
			file = new File(filePath + File.separator + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(buf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
