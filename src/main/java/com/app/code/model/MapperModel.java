package com.app.code.model;

import java.util.Arrays;

public class MapperModel {
	private String basePackage; //项目包的根路径
	private String daoPackage; // dao包的名称
	private String tableName; // 表名称
	private String className; // 类名称
	private String[] colName4DB; // 表字段对应数据库的名称  比如create_date
	private String[] colName4Java; // 表字段对应java的名称 比如createDate
	public String getBasePackage() {
		return basePackage;
	}
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	public String getDaoPackage() {
		return daoPackage;
	}
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String[] getColName4DB() {
		return colName4DB;
	}
	public void setColName4DB(String[] colName4DB) {
		this.colName4DB = colName4DB;
	}
	public String[] getColName4Java() {
		return colName4Java;
	}
	public void setColName4Java(String[] colName4Java) {
		this.colName4Java = colName4Java;
	}
	public MapperModel(String basePackage, String daoPackage, String tableName, String className,
			String[] colName4DB, String[] colName4Java) {
		super();
		this.basePackage = basePackage;
		this.daoPackage = daoPackage;
		this.tableName = tableName;
		this.className = className;
		this.colName4DB = colName4DB;
		this.colName4Java = colName4Java;
	}
	
	@Override
	public String toString() {
		return "MapperModel [basePackage=" + basePackage + ", daoPackage=" + daoPackage + ", tableName=" + tableName
				+ ", className=" + className + ", colName4DB=" + Arrays.toString(colName4DB) + ", colName4Java="
				+ Arrays.toString(colName4Java) + "]";
	}
	
}
