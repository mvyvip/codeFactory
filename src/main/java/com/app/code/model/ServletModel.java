package com.app.code.model;

public class ServletModel {
	public String basePackage;

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public ServletModel(String basePackage) {
		super();
		this.basePackage = basePackage;
	}
	
}
