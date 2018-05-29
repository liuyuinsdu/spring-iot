package com.runhang.framework;

public interface BeanProvider {
	/**
	 * 获取bean实例
	 * @param name
	 * @return
	 */
	Object getBean(String name);
	
	/**
	 * 获取指定类型的bean实例
	 * @param name
	 * @param clazz
	 * @return
	 */
	<T> T getBean(String name , Class<T> clazz);
	
	/**
	 * 根据类型获取bean实例
	 * @param clazz
	 * @return
	 */
	<T> T getBean(Class<T> clazz);
	
	/**
	 * 是否包含bean
	 * @param name
	 * @return
	 */
	boolean containsBean(String name);
	
	/**
	 * 是否为单例
	 * @param name
	 * @return
	 */
	boolean isSingleton(String name);
	
	/**
	 * 获取bean的类型
	 * @param name
	 * @return
	 */
	Class<?> getType(String name);
}
