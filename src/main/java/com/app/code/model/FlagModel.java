package com.app.code.model;

/**
 * 是否生成对应的文件，默认为true都生成
 * @author admin
 *
 */
public class FlagModel {
	/**
	 * 是否生成 model
	 */
	private boolean isCreateModel = true;
	
	/**
	 * 是否生成 dao
	 */
	private boolean isCreateDao = true;
	
	/**
	 * 是否生成 service
	 */
	private boolean isCreateService = true;
	
	/**
	 * 是否生成 serviceimpl
	 */
	private boolean isCreateServiceImpl = true;

	/**
	 * 是否生成 mapper
	 */
	private boolean isCreateMapper = true;
	
	/**
	 * 是否生成 test
	 */
	private boolean isCreateTest = true;
	

	//============= 以下为默认不生成的
	/**
	 * 是否生成 action
	 */
	private boolean isCreateController = false;
	
	/**
	 * 是否生成 jsp
	 */
	private boolean isCreateJsp = false;

	public boolean isCreateModel() {
		return isCreateModel;
	}

	public void setCreateModel(boolean isCreateModel) {
		this.isCreateModel = isCreateModel;
	}

	public boolean isCreateDao() {
		return isCreateDao;
	}

	public void setCreateDao(boolean isCreateDao) {
		this.isCreateDao = isCreateDao;
	}

	public boolean isCreateService() {
		return isCreateService;
	}

	public void setCreateService(boolean isCreateService) {
		this.isCreateService = isCreateService;
	}

	public boolean isCreateMapper() {
		return isCreateMapper;
	}

	public void setCreateMapper(boolean isCreateMapper) {
		this.isCreateMapper = isCreateMapper;
	}

	public boolean isCreateJsp() {
		return isCreateJsp;
	}

	public void setCreateJsp(boolean isCreateJsp) {
		this.isCreateJsp = isCreateJsp;
	}

	public boolean isCreateServiceImpl() {
		return isCreateServiceImpl;
	}

	public void setCreateServiceImpl(boolean isCreateServiceImpl) {
		this.isCreateServiceImpl = isCreateServiceImpl;
	}

	public boolean isCreateTest() {
		return isCreateTest;
	}

	public void setCreateTest(boolean isCreateTest) {
		this.isCreateTest = isCreateTest;
	}

	public boolean isCreateController() {
		return isCreateController;
	}

	public void setCreateController(boolean isCreateController) {
		this.isCreateController = isCreateController;
	}

}
