package com.runhang.framework;

import org.springframework.context.ApplicationContext;

/**
 * Spring 工具类
 * @author runhang
 *
 */
public class BeanProviderSpring implements BeanProvider{

	private static ApplicationContext applicationContext = null;
	
	public static void initContext(ApplicationContext applicationContext){
		BeanProviderSpring.applicationContext = applicationContext; 
	}
	
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	/**
	 * 获取bean实例
	 * @param name
	 * @return
	 */
	public Object getBean(String name){
		return applicationContext.getBean(name);
	}
	
	/**
	 * 获取指定类型的bean实例
	 * @param name
	 * @param clazz
	 * @return
	 */
	public <T> T getBean(String name , Class<T> clazz){
		return applicationContext.getBean(name , clazz);
	}
	
	/**
	 * 根据类型获取bean实例
	 * @param clazz
	 * @return
	 */
	public <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}
	
	/**
	 * 是否包含bean
	 * @param name
	 * @return
	 */
	public boolean containsBean(String name){
		return applicationContext.containsBean(name);
	}
	
	/**
	 * 是否为单例
	 * @param name
	 * @return
	 */
	public boolean isSingleton(String name){
		return applicationContext.isSingleton(name);
	}
	
	/**
	 * 获取bean的类型
	 * @param name
	 * @return
	 */
	public Class<?> getType(String name){
		return applicationContext.getType(name);
	}
}
