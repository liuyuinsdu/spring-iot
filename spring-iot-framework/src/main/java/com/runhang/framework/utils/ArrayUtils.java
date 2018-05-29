package com.runhang.framework.utils;

import java.util.Arrays;

public class ArrayUtils {

	public static <T> T[] concat(T[] srouce1 , T[] source2){
		T[] result = Arrays.copyOf(srouce1, srouce1.length + source2.length);
		System.arraycopy(source2, 0, result, srouce1.length, source2.length);
		return result;
	}
	
}
