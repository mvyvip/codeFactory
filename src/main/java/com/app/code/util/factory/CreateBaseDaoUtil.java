package com.app.code.util.factory;

import com.app.code.constant.FileNameConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.constant.PathConstant;
import com.app.code.model.BaseDaoModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

public class CreateBaseDaoUtil {
	public static void createBaseDao() {
		String dirPath = StringUtil.getPackage(PathConstant.PROJECT_PACKAGE_BASE, PathConstant.DAO_PACKAGE_NAME);
		BaseDaoModel baseDaoModel = new BaseDaoModel(PathConstant.PROJECT_PACKAGE_BASE, PathConstant.DAO_PACKAGE_NAME);
		String fileName = FileNameConstant.BASE_DAO;
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_BASE_DAO, baseDaoModel, dirPath , fileName , true);
	}
}
