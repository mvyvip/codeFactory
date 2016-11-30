package com.app.code.model;

import java.util.Arrays;

/**
 * 表相关属性的封装
 * @author admin
 *
 */
public class TableModel {
	
	/**
	 * 表名称
	 */
	private String tableName;
	
	/**
	 * 类名称
	 */
	private String className;
	
	/**
	 * 表字段名称(java)
	 */
	private String[] colName4Java;
	
	/**
	 * 表字段名称(数据库)
	 */
	private String[] colName4DB;
	
	/**
	 * 表字段类型
	 */
	private String[] colType;
	
	/**
	 * 表字段描述
	 */
	private String[] colDesc;
	
	/**
	 * 表描述
	 */
	private String tabDesc;
	
	/**
	 * 是否导入util包
	 */
	private boolean flag;

	/**
	 * 
	 * @param columnCount 表字段长度
	 */
	public TableModel(Integer columnCount) {
		this.colName4Java = new String[columnCount];
		this.colName4DB = new String[columnCount];
		this.colType = new String[columnCount];
		this.colDesc = new String[columnCount];
	}

	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public String[] getColName4Java() {
		return colName4Java;
	}

	public void setColName4Java(String[] colName4Java) {
		this.colName4Java = colName4Java;
	}

	public String[] getColName4DB() {
		return colName4DB;
	}

	public void setColName4DB(String[] colName4DB) {
		this.colName4DB = colName4DB;
	}

	public String[] getColType() {
		return colType;
	}

	public void setColType(String[] colType) {
		this.colType = colType;
	}

	public String[] getColDesc() {
		return colDesc;
	}

	public void setColDesc(String[] colDesc) {
		this.colDesc = colDesc;
	}

	public String getTabDesc() {
		return tabDesc;
	}

	public void setTabDesc(String tabDesc) {
		this.tabDesc = tabDesc;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "TableModel [tableName=" + tableName + ", className=" + className
				+ ", colName4Java=" + Arrays.toString(colName4Java)
				+ ", colName4DB=" + Arrays.toString(colName4DB) + ", colType="
				+ Arrays.toString(colType) + ", colDesc="
				+ Arrays.toString(colDesc) + ", tabDesc=" + tabDesc + ", flag="
				+ flag + "]";
	}

}
