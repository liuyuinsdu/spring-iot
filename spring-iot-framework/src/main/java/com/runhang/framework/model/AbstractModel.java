package com.runhang.framework.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.runhang.framework.dao.AutoIncrementIDGenerator;
import com.runhang.framework.dao.GeneratedID;
import com.runhang.framework.dao.IDGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @Title:
 * @Description:
 * @author runhang
 * @date 2015年9月15日 上午8:53:22
 * @version V1.0
 */
public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = -1033643221448719111L;

	public static final String COLUMN_CREATE_DATE = "create_date";
	public static final String COLUMN_UPDATE_DATE = "update_date";
	public static final String COLUMN_DELETED = "deleted";

	public static final String COLUMN_TYPE_DATETIME = "DATETIME";

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedID(generator = AutoIncrementIDGenerator.class)
	protected String id;
	@Column(name = "create_date", updatable = false, columnDefinition = COLUMN_TYPE_DATETIME, nullable = false)
	protected Date createDate;
	@Column(name = "update_date", columnDefinition = COLUMN_TYPE_DATETIME, nullable = false)
	protected Date updateDate;
	@Column(name = "deleted")
	protected Integer deleted = 0;

	protected String table;
	protected IDGenerator idGenerator;
	private static Map<String, Map<String, Field>> dbFieldMapCache = new HashMap<String, Map<String, Field>>();

	public AbstractModel() {
	}

	public AbstractModel(String id) {
		this.id = id;
	}

	public void setIdGenerator(IDGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	@JsonIgnore
	public IDGenerator getIDGenerator() {
		if (idGenerator == null) {
			GeneratedID anno = this.recursiveGeneratedIDAnnotation(getClass());
			Class<? extends IDGenerator> generatorClass = anno.generator();
			try {
				idGenerator = generatorClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return idGenerator;
	}

	@JsonIgnore
	public abstract String getModule();

	@JsonIgnore
	public Map<String, Field> getDBFieldMap() {
		Map<String, Field> columnMap = dbFieldMapCache.get(getModule());
		if (columnMap == null) {
			synchronized (this) {
				if (columnMap == null) {
					columnMap = new HashMap<String, Field>();
					this.recursiveFieldAnnotation(columnMap, this.getClass());
					dbFieldMapCache.put(getModule(), columnMap);
				}
			}
		}
		return columnMap;
	}

	/**
	 * 目前默认获取@Table注解的name
	 * 
	 * @return
	 */
	@JsonIgnore
	public String getTableName() {
		if (table != null) {
			return table;
		}
		Table tableAnno = this.recursiveTableAnnotation(this.getClass());
		return tableAnno.name();
	}

	private void recursiveFieldAnnotation(Map<String, Field> columnMap, Class<?> clazz) {
		if (clazz.getName().equals(Object.class.getName())) {
			return;
		}
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				String columnName = field.getAnnotation(Column.class).name();
				columnMap.put(columnName, field);
			}
		}
		this.recursiveFieldAnnotation(columnMap, clazz.getSuperclass());
	}

	private GeneratedID recursiveGeneratedIDAnnotation(Class<?> clazz) {
		if (clazz.getName().equals(Object.class.getName())) {
			return null;
		}
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class) && field.isAnnotationPresent(GeneratedID.class)) {
				return field.getAnnotation(GeneratedID.class);
			}
		}
		return this.recursiveGeneratedIDAnnotation(clazz.getSuperclass());
	}

	private Table recursiveTableAnnotation(Class<?> clazz) {
		if (clazz.getName().equals(Object.class.getName())) {
			return null;
		}
		if (clazz.isAnnotationPresent(Table.class)) {
			return clazz.getAnnotation(Table.class);
		}
		return this.recursiveTableAnnotation(clazz.getSuperclass());
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
