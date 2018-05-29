package com.runhang.framework.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.runhang.framework.model.AbstractModel;

public class BeanUtils {

	public static void copyProperties(Object source , Object target){
		try {
			org.springframework.beans.BeanUtils.copyProperties(source, target);
		} catch (Exception e) {
		}
	}

	public static <T> T mapToModel(Map map , Class<T> clazz){
		if(map == null || map.isEmpty()){
			return null;
		}
		T obj = null;
		try {
			obj = clazz.newInstance();
			mapToModel(map , obj);
		} catch (Exception e) {

		}
		return obj;
	}

	public static Object mapToModel(Map map , Object obj) {
		if(map == null || map.isEmpty()){
			return null;
		}
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
		} catch (IntrospectionException e) {

		}
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor descriptor : propertyDescriptors){
				Method writeMethod = descriptor.getWriteMethod();
				if(writeMethod != null){
					try {
						Object value = map.get(descriptor.getName());
						Type[] parameterTypes = writeMethod.getGenericParameterTypes();
						String typeName = parameterTypes[0].getTypeName();
						if(BigDecimal.class.getName().equals(typeName)){
							value = ArithUtils.toBigDecimal(value);
						}
						writeMethod.invoke(obj , value);
					} catch (Exception e) {
						continue;
					}
				}
			}
		return obj;
	}
	
	public static Map<String , Object> copyModelToMap(Object source){
		if(source == null){
			return null;
		}
		Map<String , Object> map = new HashMap<String , Object>();
		// 第二个参数表示在哪个层次上停止查询
		Class<?> clazz = source.getClass();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz , AbstractModel.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor descriptor : propertyDescriptors){
				String name = descriptor.getName();
				Method m = descriptor.getReadMethod();
				if(m == null){
					continue;
				}
				m.setAccessible(true);
				Object value = m.invoke(source);
				if(value != null){
					if(value instanceof Collection && ((Collection) value).size() == 0){
						continue;
					}
					map.put(name, value);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return map;
	}
}
