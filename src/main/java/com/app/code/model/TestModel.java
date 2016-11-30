package com.app.code.model;

public class TestModel {
	private String basePackage;
	private String typePackage;
	private String modelPackage;
	private String className;
	private String primaryKey;
	private String pagePackage;
	private String springConfigName;
	
	public TestModel(String basePackage, String typePackage,
			String modelPackage, String className, String primaryKey, String pagePackage, String springConfigName) {
		super();
		this.basePackage = basePackage;
		this.typePackage = typePackage;
		this.modelPackage = modelPackage;
		this.className = className;
		this.primaryKey = primaryKey;
		this.pagePackage = pagePackage;
		this.springConfigName = springConfigName;
	}
	
	public String getBasePackage() {
		return basePackage;
	}
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	public String getTypePackage() {
		return typePackage;
	}
	public void setTypePackage(String typePackage) {
		this.typePackage = typePackage;
	}
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getPagePackage() {
		return pagePackage;
	}

	public void setPagePackage(String pagePackage) {
		this.pagePackage = pagePackage;
	}

	public String getSpringConfigName() {
		return springConfigName;
	}

	public void setSpringConfigName(String springConfigName) {
		this.springConfigName = springConfigName;
	}

}
