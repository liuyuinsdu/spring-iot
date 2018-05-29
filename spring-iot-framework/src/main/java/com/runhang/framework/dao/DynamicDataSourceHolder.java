package com.runhang.framework.dao;

/**
 * 保存数据源
 * @author runhang
 *
 */
public class DynamicDataSourceHolder {

	private static final ThreadLocal<String> keyHolder = new ThreadLocal<String>();
	
	public static String getDataSource(){
		return keyHolder.get();
	}
	
	public static void setDataSource(String dsKey){
		keyHolder.set(dsKey);
	}
	
	public static void clearDataSource(){
		keyHolder.remove();
	}

	public static void read(){
		if (keyHolder.get() != null && keyHolder.get().equals("master")) {
			return;
		}
		keyHolder.set("cluster");
	}
	
	public static void write(){
		keyHolder.set("master");
	}
}
