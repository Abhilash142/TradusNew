package com.tradus.core;

import static com.tradus.core.GlobalConstants.osName;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	
	
	public static String getUserId(String userType,String value) throws IOException {
	Properties prop=new Properties();
	String uid=getCred(prop,value);
	int temp=Integer.parseInt(uid);
	temp++;
	String newUid=Integer.toString(temp);
	setCred(prop, newUid, value);
	String temp_id=null;
	if(userType.equalsIgnoreCase("Seller")){
		temp_id="harish.boyapati+"+uid+"@olx.com";
	}
	else {
		temp_id=uid;
	}
	return temp_id;
	}
	
	public static String getCred(Properties prop,String value) throws IOException {
		String tempOS = "";
		if(osName.equalsIgnoreCase("Windows"))
			tempOS = "\\Credential.properties";
		else
			tempOS = "/Credential.properties";
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + tempOS);
		prop.load(fis);
		fis.close();
		
		String uid=prop.getProperty(value);
		return uid;
	}
	
	public static void setCred(Properties prop, String newUid,String value) throws IOException {
		String tempOS = "";
		if(osName.equalsIgnoreCase("Windows"))
			tempOS = "\\Credential.properties";
		else
			tempOS = "/Credential.properties";
		FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + tempOS);
		prop.setProperty(value, newUid);
		prop.store(out, null);
		out.close();
		
	}
}
