package com.app.code.util.factory;

import com.app.code.constant.PathConstant;
import com.app.code.constant.FileNameConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.model.SpringContextModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

/**
 * 创建spring配置文件
 * @author admin
 *
 */
public class CreateSpringContextlUtil {
	
	public static void createSpringContext(){
		String basePackage = PathConstant.PROJECT_PACKAGE_BASE;
		String daoPackage = PathConstant.DAO_PACKAGE_NAME;
		String fileName = FileNameConstant.SPRING_CONFIG_NAME;
		String modelPackage = PathConstant.MODEL_PACKAGE_NAME;
		String mapperPackage = PathConstant.MAPPER_PACKAGE_NAME;
		String dirPath = StringUtil.getProPathByTemp("src/main/resources");
		String mapperPath = (basePackage + "." + mapperPackage).replace(".", "/");
		
		SpringContextModel springContextModel = new SpringContextModel(basePackage, modelPackage, mapperPath, daoPackage);
		
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_SPRING, springContextModel, dirPath, fileName, true);
	}
}
