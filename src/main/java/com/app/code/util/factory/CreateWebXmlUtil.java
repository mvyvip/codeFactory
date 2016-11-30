package com.app.code.util.factory;

import com.app.code.constant.FileNameConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.constant.PathConstant;
import com.app.code.model.WebXmlModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

public class CreateWebXmlUtil {
	public static void createWebXml(){
		String dirPath = StringUtil.getProPathByTemp("src/main/webapp/WEB-INF");
		String fileName = FileNameConstant.WEB_XML;
		WebXmlModel dataModel = new WebXmlModel(PathConstant.PROJECT_PACKAGE_BASE, FileNameConstant.SPRING_CONFIG_NAME,
				FileNameConstant.SPRING_SERVER_NAME);
		FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_WEB_XML, dataModel, dirPath, fileName, true);
	}
	
}
