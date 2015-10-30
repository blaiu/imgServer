package com.img;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

import org.junit.Test;

import com.img.common.CommonConstants;

public class ZZ {
	 private Pattern PATTERN_GOMEFS_KEY = Pattern.compile(CommonConstants.GOMEFS_REGULAR);
	@Test
	public void test() {
//		String url = "sd_gomefs/tjsdfk";
//    	Matcher gomeMatcher = PATTERN_GOMEFS_KEY.matcher(url);
//    	System.out.println(gomeMatcher.find());
		String name = "yang.jpg";
		System.out.println(name.hashCode()%100);
		CRC32 crc = new CRC32();
		System.out.println(crc.getValue());
	}

}
