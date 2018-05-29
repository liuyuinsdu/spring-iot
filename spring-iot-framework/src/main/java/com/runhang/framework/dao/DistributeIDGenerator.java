package com.runhang.framework.dao;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import com.runhang.framework.utils.DateUtils;

/**
 * 当前时间+机器号+自增数
 * 
 * @Description:
 * @author runhang
 * @date Nov 10, 2016 5:24:13 PM
 *
 */
public class DistributeIDGenerator implements IDGenerator {

	private AtomicInteger counter = new AtomicInteger(1);

	@Override
	public Object generate() {
		StringBuilder id = new StringBuilder();
		String dateTime = DateUtils.toStringYMDHMS(new Date());
		String num = String.format("%07d", counter.get());
		id.append(dateTime).append(num);
		System.out.println(id.toString());
		System.out.println(id.toString().getBytes().length);
		return null;
	}
	
	public static void main(String[] args) {
		DistributeIDGenerator gen = new DistributeIDGenerator();
		gen.generate();
	}

}
