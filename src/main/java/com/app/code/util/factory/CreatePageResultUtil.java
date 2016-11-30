package com.app.code.util.factory;

import com.app.code.constant.FreemarkConstant;
import com.app.code.constant.PathConstant;
import com.app.code.model.PageResultModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

public class CreatePageResultUtil {
	public static void createPageResult() {
		String basePackage = PathConstant.PROJECT_PACKAGE_BASE;
		String typePackage = PathConstant.PAGE_PACKAGE_PATH;
		String dirPath = StringUtil.getPackage(basePackage, typePackage);
		PageResultModel pageResultModel = new PageResultModel(basePackage, typePackage);
		String fileName = "PageResult.java";
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_PAGERESULT, pageResultModel, dirPath, fileName, true);
	}
}
