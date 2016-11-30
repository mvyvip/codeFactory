package com.app.code.model;

public class BaseDaoModel {
	private String basePackage;
	private String typePackage;
	
	public BaseDaoModel(String basePackage, String typePackage) {
		super();
		this.basePackage = basePackage;
		this.typePackage = typePackage;
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
	
}
