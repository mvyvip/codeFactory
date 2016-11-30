package com.app.code.util.factory;

public class CreateManagerUtil {
	
	/**
	 * 初始化项目 创建 IBaseDao  IBaseService BaseServiceImpl PaegResult
	 */
	public static void initProject(){
		CreateBaseDaoUtil.createBaseDao();
		CreateBaseServiceUtil.createBaseService();
		CreateBaseServiceImplUtil.createBaseServiceImpl();
		CreatePageResultUtil.createPageResult();
		CreateSpringContextlUtil.createSpringContext();
	}
	
}
