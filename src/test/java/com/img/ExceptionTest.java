package com.img;

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			showException();
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void showException() {
		try{
			int i = 0;
			int f = 10/i;
		}catch(Exception e){
//			throw e;
		}
	}
}
