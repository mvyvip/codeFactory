package com.app.code.util.factory;

import com.app.code.constant.PathConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.model.PojoModel;
import com.app.code.model.ServiceModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

public class CreateServiceUtil {
	
	public static void createService(PojoModel model,boolean isCover){
		model.setTypePackage(PathConstant.SERVICE_PACKAGE_NAME);
		String fileName = "I" + model.getTableModel().getClassName() + "Service.java";
		String dirPath = StringUtil.getDirPath(model);
		String className = model.getTableModel().getClassName();
		String basePackage = model.getBasePackage();
		String typePackage = model.getTypePackage();
		String modelPackage = PathConstant.MODEL_PACKAGE_NAME;
		String keyType = model.getTableModel().getColType()[0];
		ServiceModel serviceModel = new ServiceModel(basePackage, typePackage, modelPackage, className, keyType);
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_SERVICE, serviceModel, dirPath, fileName, isCover);
	}
	
}
