package com.app.code.factory;

import org.junit.Test;

import com.app.code.model.DBModel;
import com.app.code.model.FlagModel;
import com.app.code.service.CodeFactoryService;
import com.app.code.util.db.DBCommonUtil;
import com.app.code.util.db.MySqlUtil;
import com.app.code.util.factory.CreateModelUtil;

/**
 * 代码生成参考本类测试方法
 * @author admin
 *
 */
public class FactoryTest {
	
	private DBModel db = new DBModel("root", "admin", "com.mysql.jdbc.Driver",
			"jdbc:mysql:///crm?useUnicode=true&characterEncoding=utf-8");
	
	/**
	 * 初始化项目(非web项目)  根据配置文件生成   IBaseDao  IBaseService BaseServiceImpl PaegResult spring-contextx.xml
	 * @throws Exception
	 */
	@Test
	public void testInitProject4Manager() throws Exception {
		CodeFactoryService.initProject4Manager();
	}
	
	
	/**
	 * 初始化项目(web项目调用此方法)  根据配置文件生成   IBaseDao  IBaseService BaseServiceImpl PaegResult spring-contextx.xml spring-servlet.xml web.xml
	 * @throws Exception
	 */
	@Test
	public void testInitProject4Web() throws Exception {
		CodeFactoryService.initProject4Web();
	}
	
	/**
	 * 开发中使用本方法(非web项目)
	 * 代码生成入口 默认只生成 model dao service serviceImpl mapper test
	 * 如需要自定义生成对象
	 * 参考下面的方法
	 * @throws Exception
	 */
	@Test
	public void testCreateCode() throws Exception {
		CodeFactoryService.createCode("gogo_user_info", true, db);
	}

	/**
	 * 开发中使用本方法
	 * 生成 model dao service serviceImpl mapper test controller（web项目）
	 * 如需要自定义生成对象
	 * 参考下面的方法
	 * @throws Exception
	 */
	@Test
	public void testCreateCode4Web() throws Exception {
		CodeFactoryService.createCode4Web("dept", true, db);
	}
	
	@Test
	public void testCreateCode02() throws Exception {
		FlagModel flagModel = new FlagModel();
		flagModel.setCreateDao(false);
		CodeFactoryService.createCode("user", true, flagModel, db);
	}
	

	/**
	 * 生成单个文件
	 * 详情参考 com.app.code.util.factory 下面的类
	 * @throws Exception
	 */
	@Test
	public void testCreateOne() throws Exception {
		CreateModelUtil.createModel(MySqlUtil.createPojoModel("user", db), true);
	}
	
	@Test
	public void testName() throws Exception {
		System.out.println(DBCommonUtil.getConn(db));
	}
}
