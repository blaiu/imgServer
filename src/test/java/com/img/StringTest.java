package com.img;

import static org.junit.Assert.*;

import org.junit.Test;

import com.img.ds.TableUtil;


public class StringTest {
	public final static String TABLE_NAME_PREFIX  = "file_name_map_";
	@Test
	public void test() {
		String key = "";
		Long start = System.currentTimeMillis();
		System.out.println(this.getOneTableName(key));
		Long end = System.currentTimeMillis();
		System.out.println("hashName:"+(end-start));
//		start = System.currentTimeMillis();
//		System.out.println(this.getTableName(key));
//		end = System.currentTimeMillis();
//		System.out.println("CharName:"+(end-start));
	}

    public final static String getTableName(String key) {
    	//key = 12312321.jpg
        int pos = key.lastIndexOf(".");
        char[] bit = { 1, 1 };
        if (pos == -1) {
            pos = key.length();
        }
        int j = 1;
        for (int i = pos - 1; i >= 0 && j >= 0; i--) {
            char c = key.charAt(i);
            if (c >= 48 && c <= 57) {
                bit[j] = c;
                j--;
            }
        }
        String tableName = StringTest.TABLE_NAME_PREFIX + String.valueOf(bit);
        if (bit[0] == 1) {
            tableName = StringTest.TABLE_NAME_PREFIX
                    + String.format("%02d", (key.charAt(pos - 1) + key.charAt(pos - 2)) % 100);
        } else {
            tableName = StringTest.TABLE_NAME_PREFIX + String.valueOf(bit);
        }
        return tableName;
    }
    
	public static String getOneTableName(String key){
		
		String tableName = "";
		int hashCode = key.hashCode();
		if(hashCode>=0){
			if(key != null ){
				 tableName = TableUtil.TABLE_NAME_PREFIX + String.format("%02d", hashCode%100);
			}else{
				
			}			
		}else{
			if(key != null && key.lastIndexOf(".")>0){
				 tableName = TableUtil.TABLE_NAME_PREFIX + String.format("%02d", hashCode%100*(-1));
			}else{
				
			}			
			
		}


		return tableName;
	}
}
