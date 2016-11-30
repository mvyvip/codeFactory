package com.app.code.constant;

/**
 * 包名（路径）系统常量
 * @author admin
 *
 */
public interface PathConstant {
	
	/**
	 * 生成文件的包路径
	 */
	public static final String PROJECT_PACKAGE_BASE = "com.app.code";
	
	/**
	 * 生成javabean文件的包名称
	 */
	public static final String MODEL_PACKAGE_NAME = "model";
	
	/**
	 * 生成dao包的名称
	 */
	public static final String DAO_PACKAGE_NAME = "dao";
	
	/**
	 * 生成service包的名称
	 */
	public static final String SERVICE_PACKAGE_NAME = "service";
	
	/**
	 * 生成serviceImpl包的名称
	 */
	public static final String SERVICE_IMPL_PACKAGE_NAME = "impl";
	
	/**
	 * 生成mapper包的名称
	 */
	public static final String MAPPER_PACKAGE_NAME = "mappers";
	
	/**
	 * 生成test包的名称
	 */
	public static final String TEST_PACKAGE_NAME = "service";
	
	/**
	 * 分页对象针对于basepackage的全路径
	 */
	public static final String PAGE_PACKAGE_NAME = "common.page.PageResult";
	
	/**
	 * pageresult包名的路径
	 */
	public static final String PAGE_PACKAGE_PATH = "common.page";
	
	/**
	 * controller包名的路径
	 */
	public static final String CONTROLELR_PACKAGE_NAME = "web.controller";
	
	/**
	 * jsp路径
	 */
	public static final String JSP_PATH_NAME = "/WEB-INF/views/";
	
}
