package com.app.code.util.factory;

import com.app.code.constant.FileNameConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.constant.PathConstant;
import com.app.code.model.ServletModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

/**
 * 创建spring-servlet.xml配置文件
 * @author admin
 *
 */
public class CreateSpringServletConfUtil {
	public static void createServletConf(){
		ServletModel dataModel = new ServletModel(PathConstant.PROJECT_PACKAGE_BASE);
		String dirPath = StringUtil.getProPathByTemp("src/main/resources");
		String fileName = FileNameConstant.SPRING_SERVER_NAME;
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_SERVLET, dataModel, dirPath, fileName, true);
	}
	
	public static void main(String[] args) {
		createServletConf();
	}
}
