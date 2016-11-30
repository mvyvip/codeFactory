import org.junit.Test;

import com.app.code.model.FlagModel;
import com.app.code.service.CodeFactoryService;

/**
 * 代码生成参考本类测试方法（可直接复制com.app.code.factory.FactoryTest）
 * 数据库连接配置参考：src/test/sources/jdbc.properties
 * 使用准备：
 *  ① 拷贝codeFactory.jar下面的 codeFactory.properties 到项目中 修改相关属性
 *  ② 修改pom文件 添加本地依赖（还有其他spring mybatis的自行添加）
		<!-- 代码生成器jar -->
		<dependency>
			<groupId>com.app</groupId>
		    <artifactId>codeFactory</artifactId>
		    <version>0.0.1-SNAPSHOT</version>
			<scope>system</scope>
			<systemPath>D:\codeFactory.jar</systemPath>
		</dependency>
		<!-- mysql驱动 -->
		<dependency>
		    <groupId>mysql</groupId>
		    <artifactId>mysql-connector-java</artifactId>
		    <version>5.1.18</version>
		</dependency>
		<!-- freemark jar -->
		<dependency>
		    <groupId>org.freemarker</groupId>
		    <artifactId>freemarker</artifactId>
		    <version>2.3.23</version>
		</dependency>
 *  ③ 调用下面的方法生成  生成之后一定要刷新项目！！！！然后再clean project！！！ 否则配置文件不能加载到target目录
 *  ④ 如果需要生成spring相关配置文件 参考 src/test/sources/jdbc.properties 来定义数据库连接信息
 * @author admin
 *
 */
public class FactoryTest {
	
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
	 * 开发中使用本方法
	 * 代码生成入口 默认只生成 model dao service serviceImpl mapper test
	 * 如需要自定义生成对象
	 * 参考下面的方法
	 * @throws Exception
	 */
	@Test
	public void testCreateCode() throws Exception {
		CodeFactoryService.createCode("user", true);
	}
	
	@Test
	public void testCreateCode02() throws Exception {
		FlagModel flagModel = new FlagModel();
		flagModel.setCreateDao(false);
		CodeFactoryService.createCode("user", true, flagModel );
	}
	
	
	/**
	 * 生成单个文件
	 * 详情参考 com.app.code.util.factory 下面的类
	 * @throws Exception
	 */
	@Test
	public void testCreateOne() throws Exception {
		CreateModelUtil.createModel(MySqlUtil.createPojoModel("${tableName}"), true);
	}
}