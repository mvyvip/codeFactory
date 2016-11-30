package com.app.code.util.factory;

import com.app.code.constant.PathConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.model.DaoModel;
import com.app.code.model.PojoModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

public class CreateDaoUtil {
	
	public static void createDao(PojoModel model,boolean isCover){
		try {
			model.setTypePackage(PathConstant.DAO_PACKAGE_NAME);
			String fileName = "I" + model.getTableModel().getClassName() + "Dao.java";
			String dirPath = StringUtil.getDirPath(model);
			String className = model.getTableModel().getClassName();
			String basePackage = model.getBasePackage();
			String typePackage = model.getTypePackage();
			String modelPackage = PathConstant.MODEL_PACKAGE_NAME;
			String keyType = model.getTableModel().getColType()[0];
			DaoModel daoModel = new DaoModel(basePackage, typePackage, modelPackage, className, keyType);
			FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_DAO, daoModel, dirPath, fileName, isCover);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
