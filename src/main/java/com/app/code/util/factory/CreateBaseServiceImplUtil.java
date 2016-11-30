package com.app.code.util.factory;

import com.app.code.constant.FileNameConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.constant.PathConstant;
import com.app.code.model.BaseServiceImplModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

public class CreateBaseServiceImplUtil {
	public static void createBaseServiceImpl() {
		
		String basePackage = PathConstant.PROJECT_PACKAGE_BASE;
		// 由于basepackage下面有另外的两个包 由service+impl相加组成  所以需要处理一下
		String typePackage = PathConstant.SERVICE_PACKAGE_NAME + "." + PathConstant.SERVICE_IMPL_PACKAGE_NAME;
		String servicePackage = PathConstant.SERVICE_PACKAGE_NAME;
		String serviceImplPackage = PathConstant.SERVICE_IMPL_PACKAGE_NAME;
		String pagePackage = PathConstant.PAGE_PACKAGE_NAME;
		String daoPackage = PathConstant.DAO_PACKAGE_NAME;
		String dirPath = StringUtil.getPackage(basePackage, typePackage);
		
		
		BaseServiceImplModel baseServiceImplModel = new BaseServiceImplModel(basePackage, servicePackage, 
				serviceImplPackage, pagePackage, daoPackage);
		String fileName = FileNameConstant.BASE_SERVICE_IMPL;
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_BASE_SERVICE_IMPL, baseServiceImplModel, dirPath , fileName, true);
	}
}
