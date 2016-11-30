package com.app.code.util.factory;

import com.app.code.constant.PathConstant;
import com.app.code.constant.FileNameConstant;
import com.app.code.constant.FreemarkConstant;
import com.app.code.model.MapperModel;
import com.app.code.model.PojoModel;
import com.app.code.util.FreemarkUtil;
import com.app.code.util.StringUtil;

/**
 * 创建 mapper 文件
 * @author admin
 *
 */
public class CreateMapperUtil {
	
	public static void createMapper(PojoModel model, boolean isCover) {
		try {
			// linux和windows文件分隔符不一样 通过system类获取
			String fileSeparator = System.getProperty("file.separator");
			// 文件相对于项目 /src/main/resources 的路径
			String javaPath = StringUtil.getProPathByTemp("src/main/resources");
			// mapper 路径由 basePack+mapperPackage 组成
			String mapperPath = javaPath + model.getBasePackage().replace(".", fileSeparator) + fileSeparator + PathConstant.MAPPER_PACKAGE_NAME;
			
			String fileName = model.getTableModel().getClassName() + FileNameConstant.MAPPER;
			
			MapperModel mapperModel = createMapperModel(model);
			
			FreemarkUtil.createTemplate(FreemarkConstant.TEMPLATE_MAPPER, mapperModel, mapperPath, fileName , isCover);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据javabean生成mapper文件所需要的字段
	 * @param model
	 * @return
	 */
	private static MapperModel createMapperModel(PojoModel model) {
		String basePackage = model.getBasePackage();
		String daoPackage = PathConstant.DAO_PACKAGE_NAME;
		String tableName = model.getTableModel().getTableName();
		String className = model.getTableModel().getClassName();
		String[] colName4DB = model.getTableModel().getColName4DB();
		String[] colName4Java = model.getTableModel().getColName4Java();
		MapperModel mapperModel = new MapperModel(basePackage, daoPackage, tableName, className, colName4DB, colName4Java);
		return mapperModel;
	}

}
