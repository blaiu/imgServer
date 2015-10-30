package com.img;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.img.bean.ImgObject;


public class TestNewURL {
    public final static String  FASTDFS_REGULAR                 = "^(.+)/(.*)g[0-9]{1,2}/M[0-9a-zA-Z]{2}/";
    public final static String  WEBP_REGULAR                    ="^(.+).webp";
    public final static String  JFS_REGULAR                     = "^(.+)gomefs(-(\\w+))?/t";

    private Pattern patternFdfs = Pattern.compile(FASTDFS_REGULAR);
    private Pattern patternJfs = Pattern.compile(JFS_REGULAR);
    private Pattern patternWebp = Pattern.compile(WEBP_REGULAR);

	@Test
	public void test() {
		ImgObject object = new ImgObject();
		object.newUrl = "";
		String url = "n1/s720x540_gomefs/t1/140/13596672/605516/15b65971cfe6163cN.jpg!q200";
        Matcher matcherFdfs = patternFdfs.matcher(url);
        Matcher matcherJfs = patternJfs.matcher(url);
        Matcher matcherWebp = patternWebp.matcher(url.toLowerCase());
        
        System.out.println(matcherJfs.find());
        
//        String nurl = imgZoneNewUrl(url, true, 0);
        String nurl = imgZoneNewUrl(url, false, matcherFdfs.end());
        
//        object.newUrl = rws.getNewUrlByFdfsJfsKey(url);
//	        if (matcherFdfs.find()) {
//	            object.isFdfsKey = true;
//	            url = imgZoneNewUrl(url, false, matcherFdfs.end());
//	            object.newUrl = rws.getNewUrlByFdfsJfsKey(url);
//	        } else if (matcherJfs.find()) {
//	            object.isGomefsKey = false;
//	            url = imgZoneNewUrl(url, true, 0);
//	            object.newUrl = rws.getNewUrlByFdfsJfsKey(url);
//	        } else {
//	            object.isFdfsKey = false;
//	            object.newUrl = rws.getNewUrlByOtherKey(url);
//	        }
	}
	   public String imgZoneNewUrl(String url, boolean isJfs, int fdfsMatcherEnd)  {
	        int fileIdPos = -1;
	        String oldUrl = null;
	        String newUrl = url;
	        int businessEnd = url.indexOf("/");
//	        Precondition.assertion(businessEnd != -1, ErrorEnum.BadRequest);
	        String businessName = url.substring(0, businessEnd);
//	        if (!businessName.equals("imgzone")) {
//	            return newUrl;
//	        }
	        if (isJfs) {
	            fileIdPos = url.indexOf("gomefs/t");
	        } else {
	            fileIdPos = fdfsMatcherEnd - 7;
	            if (url.charAt(fileIdPos) != 'g') {
	                fileIdPos--;
	            }
	        }
	        if (fileIdPos != -1) {
	            oldUrl = url.substring(fileIdPos);
	        } else {
	            oldUrl = url;
	        }
	        System.out.println(oldUrl);
//	        ImgZoneDel izd = imgZoneDelDao.getDelRecord(oldUrl);
//	        if (izd == null) {
//	            return newUrl;
//	        }
//	        if (izd.getFlag().contains("1")) {
//	            throw new ImgRuntimeException(ErrorEnum.NoSuchKey,"izd.getFlag contanis 1 "+izd.getFlag());
//	        } else if (izd.getFlag().equals("2")) {
//	            if (izd.getNewUrl() != null && izd.getNewUrl().trim().length() > 3) {
//	                newUrl = url.replaceAll(oldUrl, izd.getNewUrl());
//	            } else {
//	                throw new ImgRuntimeException(ErrorEnum.InternalError,
//	                        "jfs_delete_record businessFlag is replace,but not find new url");
//	            }
//	        } else {
//	            throw new ImgRuntimeException(ErrorEnum.InternalError,"unknow business flag");
//	        }
//
	        return newUrl;
	    }
}
