package com.app.code.model;

public class SpringContextModel {
	private String basePackage;
	private String modelPackage;
	private String mapperPath;
	private String daoPackage;
	public SpringContextModel(String basePackage, String modelPackage,
			String mapperPath, String daoPackage) {
		super();
		this.basePackage = basePackage;
		this.modelPackage = modelPackage;
		this.mapperPath = mapperPath;
		this.daoPackage = daoPackage;
	}
	public String getBasePackage() {
		return basePackage;
	}
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	public String getMapperPath() {
		return mapperPath;
	}
	public void setMapperPath(String mapperPath) {
		this.mapperPath = mapperPath;
	}
	public String getDaoPackage() {
		return daoPackage;
	}
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	
}
