package com.runhang.framework;



/**
 * 
 * @Description:抽象的bean提供类,默认为Spring容器提供bean对象
 * @author runhang
 * 2015年6月11日上午10:47:16
 *
 */
public class BeanProviderFactory {
	
	private static BeanProvider instance = null;
	
	public static BeanProvider getProvider(){
		if(instance == null){
			synchronized(BeanProviderFactory.class){
				if(instance == null){
					// 默认spring的实现类
					instance = new BeanProviderSpring();
				}
			}
		}
		return instance;
	}

}
