package com.app.code.util.factory;

import com.app.code.constant.FileNameConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.constant.PathConstant;
import com.app.code.model.BaseServiceModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

public class CreateBaseServiceUtil {
	public static void createBaseService() {
		String basePackage = PathConstant.PROJECT_PACKAGE_BASE;
		String typePackage = PathConstant.SERVICE_PACKAGE_NAME;
		String pageName = PathConstant.PAGE_PACKAGE_NAME;
		String dirPath = StringUtil.getPackage(basePackage, typePackage);
		
		BaseServiceModel baseServiceModel = new BaseServiceModel(basePackage, typePackage, pageName);
		String fileName = FileNameConstant.BASE_SERVICE;
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_BASE_SERVICE, baseServiceModel , dirPath, fileName , true);
	}
}
