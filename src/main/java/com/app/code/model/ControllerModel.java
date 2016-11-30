package com.app.code.model;

public class ControllerModel {
	private String basePackage;
	private String modelPackage;
	private String className;
	private String servicePackage;
	private String keyType;
	private String typePackage;
	// 主键名称 比如 id uuid
	private String keyName;
	
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	public String getTypePackage() {
		return typePackage;
	}
	public void setTypePackage(String typePackage) {
		this.typePackage = typePackage;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public ControllerModel(String basePackage, String modelPackage,
			String className, String servicePackage, String keyType, String typePackage,String keyName) {
		super();
		this.basePackage = basePackage;
		this.modelPackage = modelPackage;
		this.className = className;
		this.servicePackage = servicePackage;
		this.keyType = keyType;
		this.typePackage = typePackage;
		this.keyName = keyName;
	}
	
}
