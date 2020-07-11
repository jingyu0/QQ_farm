package com.chinaedu.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static String read() {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("config.properties");
			prop.load(fis);
			String food = (String) prop.get("food");
//			System.out.println(food);
			return food;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		PropertiesUtil.read();
	}
}
