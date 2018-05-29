package com.runhang.framework.dao;

import java.util.UUID;

public class UUIDIDGenerator implements IDGenerator{

	@Override
	public Object generate() {
		return UUID.randomUUID().toString();
	}

}
