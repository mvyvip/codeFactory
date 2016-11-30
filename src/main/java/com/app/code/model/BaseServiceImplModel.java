package com.app.code.model;

public class BaseServiceImplModel {
	private String basePackage;
	private String servicePackage;
	private String serviceImplPackage;
	private String pagePackage;
	private String daoPackage;
	
	public BaseServiceImplModel(String basePackage, String servicePackage,
			String serviceImplPackage, String pagePackage, String daoPackage) {
		super();
		this.basePackage = basePackage;
		this.servicePackage = servicePackage;
		this.serviceImplPackage = serviceImplPackage;
		this.pagePackage = pagePackage;
		this.daoPackage = daoPackage;
	}
	public String getBasePackage() {
		return basePackage;
	}
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	public String getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getServiceImplPackage() {
		return serviceImplPackage;
	}
	public void setServiceImplPackage(String serviceImplPackage) {
		this.serviceImplPackage = serviceImplPackage;
	}
	public String getPagePackage() {
		return pagePackage;
	}
	public void setPagePackage(String pagePackage) {
		this.pagePackage = pagePackage;
	}
	public String getDaoPackage() {
		return daoPackage;
	}
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	
}
