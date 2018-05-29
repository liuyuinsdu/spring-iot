package com.runhang.framework.dao;

import java.util.List;

import com.runhang.framework.model.AbstractModel;

public interface JdbcDAO {

	int insert(final String sql , final Object[] params);
	
	int insert(final String sql , final Object[] params , GeneratedKey generatedKey);
	
	int delete(final String sql , final Object[] params);
	
	int update(final String sql , final Object[] params);
	
	Long count(final String sql , final Object[] params);
	
	<M extends AbstractModel> M load(final Class<M> type , final String sql ,final Object[] params );
	
	<M extends AbstractModel> List<M> list(final Class<M> type ,final String sql ,final Object[] params );

	int batchInsert(final String sql,final Object[] params);
}
