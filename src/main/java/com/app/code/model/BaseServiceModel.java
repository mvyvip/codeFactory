package com.app.code.model;

public class BaseServiceModel {
	private String basePackage;
	private String typePackage;
	private String pagePackage;
	
	public BaseServiceModel(String basePackage, String typePackage,
			String pagePackage) {
		super();
		this.basePackage = basePackage;
		this.typePackage = typePackage;
		this.pagePackage = pagePackage;
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

	public String getPagePackage() {
		return pagePackage;
	}

	public void setPagePackage(String pagePackage) {
		this.pagePackage = pagePackage;
	}
	
}
