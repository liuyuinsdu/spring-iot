package com.runhang.framework.dao;

import java.util.List;

import com.runhang.framework.model.AbstractModel;

/**
 * 
 * @Description:
 * @author runhang
 * 2018年5月9日上午8:43:06
 * @param <M> Entity, 实体对象,搜索对应的类
 * @param <M> View , 视图对象,页面显示对应的类
 *
 */
public interface BaseService<M extends AbstractModel> {

	void create(M e) throws Exception;
	
	int delete(M e) throws Exception;
	
	int delete(String id) throws Exception;

	int delete(String[] ids) throws Exception;

	int update(M e) throws Exception;

	M load(M e) throws Exception;
	
	M load(String id) throws Exception;
	
	Long count(M e) throws Exception;

	int batchCreate(List<M> eList) throws Exception;

}
