package com.app.code.util.factory;

import com.app.code.constant.PathConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.model.PojoModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

/**
 * 根据表名称生成javabean
 * @author admin
 *
 */
public class CreateModelUtil {
	
	public static void createModel(PojoModel pojoModel, boolean isCover){
		pojoModel.setTypePackage(PathConstant.MODEL_PACKAGE_NAME);
		String fileName = pojoModel.getTableModel().getClassName() + ".java";
		String dirPath = StringUtil.getDirPath(pojoModel);
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_MODEL, pojoModel, dirPath, fileName, isCover);
	}
	
}
