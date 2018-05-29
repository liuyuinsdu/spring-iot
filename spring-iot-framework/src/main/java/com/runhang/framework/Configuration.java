package com.runhang.framework;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: 
 * @author runhang
 * @date Oct 18, 2016 2:30:13 AM 
 *
 */
public class Configuration {

	private Map<String , Object> props;
	
	private Configuration() {
		String root = getClass().getClassLoader().getResource("props").getPath();
		PropertyReader pr = new PropertyReader(new File(root));
		Map<String, Object> localProps = pr.read();
		this.props = new HashMap<String , Object>();
		this.props.putAll(localProps);
	}
	
	private static class InstanceHolder {
		public static Configuration instance = new Configuration();
	}
	
	public static Configuration getInstance(){
		return InstanceHolder.instance;
	}
	
	public static void put(Map<String , Object> props){
		getInstance().props.putAll(props);
	}
	
	public static void put(String key , Object val){
		getInstance().props.put(key , val);
	}
	
	public static String getProp(String key){
		Object obj = getInstance().props.get(key);
		return obj == null ? null : obj.toString();
	}
	
	public static Integer getPropInt(String key){
		String str = getProp(key);
		return str == null ? null : Integer.parseInt(str);
	}
	
	public static Integer getPropInt(String key , Integer defaultValue){
		String str = getProp(key);
		return str == null ? defaultValue : Integer.parseInt(str);
	}
	
}
