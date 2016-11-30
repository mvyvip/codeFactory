package com.app.code.service;


import com.app.code.model.DBModel;
import com.app.code.model.FlagModel;
import com.app.code.model.PojoModel;
import com.app.code.util.db.MySqlUtil;
import com.app.code.util.factory.CreateControllerUtil;
import com.app.code.util.factory.CreateDaoUtil;
import com.app.code.util.factory.CreateMapperUtil;
import com.app.code.util.factory.CreateModelUtil;
import com.app.code.util.factory.CreateManagerUtil;
import com.app.code.util.factory.CreateServiceImplUtil;
import com.app.code.util.factory.CreateServiceUtil;
import com.app.code.util.factory.CreateTestUtil;
import com.app.code.util.factory.CreateWebUtil;

/**
 * 代码生成器入口
 * @author admin
 *
 */
public class CodeFactoryService {
	
	/**
	 * 初始化项目(非web项目)  根据配置文件生成   IBaseDao  IBaseService BaseServiceImpl PaegResult spring-contextx.xml
	 */
	public static void initProject4Manager(){
		CreateManagerUtil.initProject();
	}
	
	/**
	 * 初始化项目(web项目调用此方法)  根据配置文件生成   IBaseDao  IBaseService BaseServiceImpl PaegResult spring-contextx.xml spring-servlet.xml web.xml
	 */
	public static void initProject4Web(){
		initProject4Manager();
		CreateWebUtil.initProject();
	}
	
	/**
	 * 代码生成入口 默认只生成 model dao service serviceImpl mapper test（非web项目）
	 * @param name 表名称
	 * @param isCover 是否覆盖生成
	 */
	public static void createCode(String tableName, boolean isCover, DBModel dbModel){
		createCode(tableName, isCover, new FlagModel(), dbModel);
	}
	
	/**
	 * 代码生成入口 默认只生成 model dao service serviceImpl mapper test controller（web项目）
	 * @param name 表名称
	 * @param isCover 是否覆盖生成
	 */
	public static void createCode4Web(String tableName, boolean isCover, DBModel dbModel){
		FlagModel flagModel = new FlagModel();
		flagModel.setCreateController(true);
		createCode(tableName, isCover, flagModel, dbModel);
	}
	
	/**
	 * 
	 * @param name 表名称
	 * @param isCover 是否覆盖生成
	 * @param flagModel 生成文件的标识
	 */
	public static void createCode(String tableName, boolean isCover, FlagModel flagModel, DBModel dbModel){
		PojoModel model = MySqlUtil.createPojoModel(tableName,dbModel);
		
		// 创建 javabean
		if(flagModel.isCreateModel()) {
			CreateModelUtil.createModel(model,isCover);
		}
		
		// 创建 dao
		if(flagModel.isCreateDao()) {
			CreateDaoUtil.createDao(model,isCover);
		}
		
		// 创建 service 接口
		if(flagModel.isCreateDao()) {
			CreateServiceUtil.createService(model,isCover);
		}
		
		// 创建 service 接口实现类
		if(flagModel.isCreateServiceImpl()) {
			CreateServiceImplUtil.createServiceImpl(model, isCover);
		}
		
		// 创建  mapper 文件
		if (flagModel.isCreateMapper()) {
			CreateMapperUtil.createMapper(model, isCover);
		}
		
		// 创建 test 文件
		if(flagModel.isCreateTest()) {
			CreateTestUtil.createTest(model, isCover);
		}
		
		// 创建 controller 文件
		if(flagModel.isCreateController()) {
			CreateControllerUtil.createController(model, isCover);
		}
		
	}
	
}
