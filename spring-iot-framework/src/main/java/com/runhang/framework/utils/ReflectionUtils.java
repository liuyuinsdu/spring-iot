package com.runhang.framework.utils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description:
 * @author runhang 2015年6月13日下午9:20:42
 *
 */
public class ReflectionUtils {
	
	public static Object invokeMethod(String className, String methodName, Class[] parameterTypes, Object[] values, Object object) {
		try {
			Method method = Class.forName(className).getDeclaredMethod(methodName, parameterTypes);
			method.setAccessible(true);
			return method.invoke(object, values);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static Method getMethod(String className , String methodName , Class[] parameterTypes){
		Method method = null;
		try {
			method = getMethod(Class.forName(className) , methodName , parameterTypes);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return method;
	}

	public static Method getMethod(Class<?> clazz , String methodName , Class[] parameterTypes){
		Method method = null;
		try {
			method = clazz.getMethod(methodName, parameterTypes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return method;
	}
	
	public static List<Method> getMethodsWithAnnotation(Class<?> clazz , Class< ? extends Annotation> anno){
		List<Method> methodList = new ArrayList<Method>();
		Method[] methods = clazz.getMethods();
		for(Method m : methods){
			if(m.isAnnotationPresent(anno)){
				methodList.add(m);
			}
		}
		return methodList;
	}
	
	public static Object constructorNewInstance(String className, Class[] parameterTypes, Object[] initargs) {
		try {
			Constructor<?> constructor = (Constructor<?>) Class.forName(className).getDeclaredConstructor(parameterTypes); // 暴力反射
			constructor.setAccessible(true);
			return constructor.newInstance(initargs);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Object constructorNewInstance(String className) {
		try {
			Constructor<?> constructor = (Constructor<?>) Class.forName(className).getDeclaredConstructor(new Class[] {}); // 暴力反射
			constructor.setAccessible(true);
			return constructor.newInstance(new Object[] {});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void setProperty(Object obj , String pname , Object value){
		try {
			PropertyDescriptor pd = new PropertyDescriptor(pname, obj.getClass());
			Method getMethod = pd.getWriteMethod();
			getMethod.setAccessible(true);
			getMethod.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object getProperty(Object obj , String pname){
		try {
			PropertyDescriptor pd = new PropertyDescriptor(pname, obj.getClass());
			Method readMethod = pd.getReadMethod();
			readMethod.setAccessible(true);
			return readMethod.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
