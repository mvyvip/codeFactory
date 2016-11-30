package com.app.code.util.factory;

import com.app.code.constant.PathConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.model.PojoModel;
import com.app.code.model.ServiceImplModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

/**
 * 创建 service 实现类
 * @author admin
 *
 */
public class CreateServiceImplUtil {
	
	public static void createServiceImpl(PojoModel model,boolean isCover){
		// 由于basepackage下面有另外的两个包 由service+impl相加组成  所以需要处理一下
		model.setTypePackage(PathConstant.SERVICE_PACKAGE_NAME + "." + PathConstant.SERVICE_IMPL_PACKAGE_NAME);
		String fileName = model.getTableModel().getClassName() + "ServiceImpl.java";
		String dirPath = StringUtil.getDirPath(model);
		String className = model.getTableModel().getClassName();
		String basePackage = model.getBasePackage();
		String typePackage = PathConstant.SERVICE_IMPL_PACKAGE_NAME;
		String servicePackage = PathConstant.SERVICE_PACKAGE_NAME;
		String modelPackage = PathConstant.MODEL_PACKAGE_NAME;
		String keyType = model.getTableModel().getColType()[0];
		ServiceImplModel serviceImplModel = new ServiceImplModel(basePackage, servicePackage, typePackage, modelPackage, className, keyType);
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_SERVICE_IMPL, serviceImplModel, dirPath, fileName, isCover);
	}
}
