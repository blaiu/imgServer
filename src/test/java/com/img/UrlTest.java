package com.img;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.google.common.base.Strings;




public class UrlTest {
    public  static String  WEBP_SUFFIX                     =".webp";
    public  static String  DEFAULT_ENCODING                = "UTF-8";
    public  static String  IMG_CONTEXT                     = "Img-Context";
    public  static String  FASTDFS_REGULAR                 = "^(.+)/(.*)g[0-9]{1,2}/M[0-9a-zA-Z]{2}/";
    public  static String  WEBP_REGULAR                    ="^(.+).webp";
    public  static String  JFS_REGULAR                     = "^(.+)jfs(-(\\w+))?/t";
    public  static String  TABLE_NAME_PREFIX               = "img_map_";
    public  static String  IMG_CONFIG_MAP                  = "IMG_CONFIG";
    public  static String  IMG_CUT_RATE                    = "0.78@";
    public  static String  ZOOM_ARGS_REGULAT               ="^s(\\d{1,4})x(\\d{1,4})$";
    
    
    public final static String  IMG_DOMAIN_1X                   = "http://img1.gomein.net.cn";
    public final static String  IMG_DOMAIN_2X                   = "http://img2.gomein.net.cn";
    public final static String  IMG_DOMAIN_3X                   = "http://img3.gomein.net.cn";
    public final static String  IMG_DOMAIN_4X                   = "http://img4.gomein.net.cn";
    public final static String  IMG_DOMAIN_5X                   = "http://img5.gomein.net.cn";  
    public final static String  IMG_DOMAIN_6X                   = "http://img6.gomein.net.cn";
    public final static int     MAXRETRY                        = 6;									//读取原图重试次数

    public final static String  SOURCE_IMG						="^/?image/(.+)$";		    		//原系统 		
    public final static String  PRODESC							="^(.+)/productDesc/descImg/(.+)$";		//商品描述
    public final static String  PROMOTION						="^(.+)/prodimg/promimg/(.+)$";		    //促销商品 		
    public final static String  SOURCE_KEY                      ="^(\\d*)(-30)?(-180)?(-bq)?(_\\d{0,3})?.[a-zA-Z]+$";
	@Test
	public void test() throws UnsupportedEncodingException {
		
//		System.out.println(Strings.isNullOrEmpty("s"));
		
//		String str = "/201503/desc1174/1122150062/1000648705-180-bq_800.jpg";
//		String sourceKey = str.substring(str.lastIndexOf("/")+1);
//		Pattern pa = Pattern.compile(SOURCE_KEY);
//		Matcher mat = pa.matcher(sourceKey);
//		System.out.println(mat.find());
//		System.out.println(mat.group(1));
//		System.out.println(mat.group(2));
//		System.out.println(mat.group(3));
//		System.out.println(mat.group(4));
//		System.out.println(mat.group(5));
//		
//		System.out.println(sourceKey.replace(mat.group(5), "_800"));
//		
//		
		String url = "image/prodimg/productDesc/descImg/201503/desc1174/1122150062/1122150062_01.jpg";
		Pattern patternFdfs = Pattern.compile(SOURCE_IMG);
		Matcher matcherFdfs = patternFdfs.matcher(url) ;
		System.out.println(matcherFdfs.find());
//
//		Pattern patterndesc = Pattern.compile(PRODESC);
//		Matcher matcherdesc = patterndesc.matcher(url) ;
//		System.out.println(matcherdesc.find());
//
//		
//		Pattern patternprom = Pattern.compile(PROMOTION);
//		Matcher matcherprom = patternprom.matcher(url) ;
//		System.out.println(matcherprom.find());

		
//		String key = "2.webp";
//		 int pos = key.lastIndexOf(".");
//	        char[] bit = { 1, 1 };
//	        System.out.println((bit[0] == 1) +"@@@"+bit[1]);
//	        if (pos == -1) {
//	            pos = key.length();
//	        }
//	        int j = 1;
//	        for (int i = pos - 1; i >= 0 && j >= 0; i--) {
//	            char c = key.charAt(i);
//	            if (c >= 48 && c <= 57) {
//	            	System.out.println("@@"+c);
//	                bit[j] = c;
//	                j--;
//	            }
//	        }
//		String tableName = "";
//		System.out.println(bit[0]+"@@@"+bit[1]);
//		 if (bit[0] == 1) {
//			 System.out.println("this ");
//	            tableName = "img_map_"+String.format("%02d", (key.charAt(pos - 1) + key.charAt(pos - 2)) % 100);
//	        } else {
//	            tableName = "img_map_"+ String.valueOf(bit);
//	        }
//		System.out.println(tableName);
//		System.out.println((key.charAt(9)+key.charAt(8))%100);
//		
//		
//		char[] bits = { '1', '1' };
//		System.out.println("yang"+String.valueOf(bits));
//		String url="http://10.126.53.10/s720x540_jfs/t1/140/13596672/605516/15b65971cfe6163cN.jpg!q200";
//        url = URLDecoder.decode(url, "UTF-8");
//        url = url.replaceAll("/{2,}", "/");
//        String newUrl =  url.startsWith("/") ? url.substring(1) : url;
//        
//        int fileIdPos = url.indexOf("jfs/t");
//       String  oldUrl = url.substring(fileIdPos);
//        System.out.println( oldUrl );
//        System.out.println(newUrl);
//        
//
//         Pattern patternFdfs = Pattern.compile(FASTDFS_REGULAR);
//         Pattern patternJfs = Pattern.compile(JFS_REGULAR);
//         Pattern patternWebp = Pattern.compile(WEBP_REGULAR);
//
//        Matcher matcherFdfs = patternFdfs.matcher(url);
//        Matcher matcherJfs = patternJfs.matcher(url);
//        Matcher matcherWebp = patternWebp.matcher(url.toLowerCase());
//
//        System.out.println(matcherFdfs.find());
//        System.out.println(matcherJfs.find());
//        System.out.println(matcherWebp.find());
//        System.out.println(matcherJfs.end());
//        System.out.println(matcherJfs.group());
//        System.out.println(matcherWebp.group());
//        String urlT = "WWW>HKJIFDU.skdio.Com";
//        System.out.println(urlT.toLowerCase());
//        
//        
//        
//        Pattern patternArg = Pattern.compile(ZOOM_ARGS_REGULAT);
//
//        Matcher matcherarg = patternArg.matcher(url);
//        System.out.println(matcherarg.find());
	}

}
