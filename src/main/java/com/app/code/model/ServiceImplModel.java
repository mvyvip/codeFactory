package com.app.code.model;

/**
 * 封装 生成serviceimpl相关的属性
 * @author admin
 *
 */
public class ServiceImplModel {
	private String basePackage;
	private String servicePackage;
	private String typePackage;
	private String modelPackage;
	private String className;
	private String keyType; //主键类型
	
	public ServiceImplModel(String basePackage, String servicePackage,
			String typePackage, String modelPackage, String className,
			String keyType) {
		super();
		this.basePackage = basePackage;
		this.servicePackage = servicePackage;
		this.typePackage = typePackage;
		this.modelPackage = modelPackage;
		this.className = className;
		this.keyType = keyType;
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
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	
	public String getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	
}
