package com.app.code.model;

public class WebXmlModel {
	private String basePackage;
	private String springConfigName;
	private String servletConfigName;
	
	public String getBasePackage() {
		return basePackage;
	}
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	public String getSpringConfigName() {
		return springConfigName;
	}
	public void setSpringConfigName(String springConfigName) {
		this.springConfigName = springConfigName;
	}
	public String getServletConfigName() {
		return servletConfigName;
	}
	public void setServletConfigName(String servletConfigName) {
		this.servletConfigName = servletConfigName;
	}
	public WebXmlModel(String basePackage, String springConfigName,
			String servletConfigName) {
		super();
		this.basePackage = basePackage;
		this.springConfigName = springConfigName;
		this.servletConfigName = servletConfigName;
	}
	
	
}
