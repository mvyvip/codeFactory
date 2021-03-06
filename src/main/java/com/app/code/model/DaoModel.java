package com.app.code.model;

/**
 * 生成dao的常见属性封装
 * @author admin
 *
 */
public class DaoModel {
	private String basePackage;
	private String typePackage;
	private String modelPackage;
	private String className;
	private String keyType; //主键类型
	
	public DaoModel(String basePackage, String typePackage,
			String modelPackage, String className, String keyType) {
		super();
		this.basePackage = basePackage;
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
	@Override
	public String toString() {
		return "DaoModel [basePackage=" + basePackage + ", typePackage="
				+ typePackage + ", modelPackage=" + modelPackage + ", className="
				+ className + ", keyType=" + keyType + "]";
	}
	
}
