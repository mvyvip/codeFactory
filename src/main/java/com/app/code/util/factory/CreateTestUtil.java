package com.app.code.util.factory;

import com.app.code.constant.PathConstant;
import com.app.code.constant.FileNameConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.model.PojoModel;
import com.app.code.model.TestModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

public class CreateTestUtil {
	
	public static void createTest(PojoModel model, boolean isCover) {
			model.setTypePackage(PathConstant.TEST_PACKAGE_NAME);
			String fileName = model.getTableModel().getClassName() + FileNameConstant.SERVICE_TEST;
			String dirPath = StringUtil.getDirPath(model,"src/test/java");
			
			TestModel testModel = new TestModel(model.getBasePackage(), model.getTypePackage(), 
					PathConstant.MODEL_PACKAGE_NAME, model.getTableModel().getClassName(), 
					model.getTableModel().getColName4Java()[0],PathConstant.PAGE_PACKAGE_NAME,
					FileNameConstant.SPRING_CONFIG_NAME);
			
			FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_TEST, testModel, dirPath, fileName , isCover);
	}
	
}
