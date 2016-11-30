package com.app.code.util.factory;

import com.app.code.constant.FileNameConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.constant.PathConstant;
import com.app.code.model.ControllerModel;
import com.app.code.model.PojoModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

public class CreateControllerUtil {
	public static void createController(PojoModel model,boolean isCover){
		model.setTypePackage(PathConstant.CONTROLELR_PACKAGE_NAME);
		String modelPackage = PathConstant.MODEL_PACKAGE_NAME;
		String basePackage = PathConstant.PROJECT_PACKAGE_BASE;
		String className = model.getTableModel().getClassName();
		String servicePackage = PathConstant.SERVICE_PACKAGE_NAME;
		String keyType = model.getTableModel().getColType()[0];
		String typePackage = model.getTypePackage();
		String keyName = model.getTableModel().getColName4Java()[0];
		ControllerModel controllerModel = new ControllerModel(basePackage, modelPackage, className, servicePackage, keyType, typePackage, keyName);
		String fileName = className + FileNameConstant.CONTROLLER;
		String dirPath = StringUtil.getDirPath(model);
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_CONROLLER, controllerModel, dirPath , fileName , isCover);
	}
	
}
