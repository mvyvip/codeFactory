package ${basePackage}.${typePackage};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${basePackage}.${pagePackage};
import ${basePackage}.${modelPackage}.${className};

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:${springConfigName}")
@SuppressWarnings("all")
public class ${className}ServiceTest {
	
	@Autowired
	private I${className}Service ${className?uncap_first}Service;

	@Test
	public void testGetById() throws Exception {
		System.err.println(${className?uncap_first}Service.getById(1));
	}
	
	@Test
	public void testGetCount() throws Exception {
		Map<String, Object> map = new HashMap<>();
		Integer count = ${className?uncap_first}Service.getCount(map);
		System.err.println("共有>> " + count + " 条数据");
	}
	
	@Test
	public void testGetListByCondition() throws Exception {
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> lists = ${className?uncap_first}Service.getListByCondition(map);
		for (Map<String, Object> m : lists) {
			System.err.println(m);
		}
		System.err.println("共有>> " + lists.size() + " 条数据");
	}
	
	@Test
	public void testGetModelByCondition() throws Exception {
		Map<String, Object> map = new HashMap<>();
		List<${className}> ${className?uncap_first}s = ${className?uncap_first}Service.getModelByCondition(map);
		for (${className} ${className?uncap_first} : ${className?uncap_first}s) {
			System.err.println(${className?uncap_first});
		}
		System.err.println("共有>> " + ${className?uncap_first}s.size() + " 条数据");
	}
	
	@Test
	public void testDeleteById() throws Exception {
		Integer num = ${className?uncap_first}Service.deleteById(1);
		System.err.println("本次删除：" + num + " 条数据");
	}

	@Test
	public void testDeleteByIds() throws Exception {
		Integer num = ${className?uncap_first}Service.deleteByIds("731,732,733");
		System.err.println("本次删除：" + num + " 条数据");
	}
	
	@Test
	public void testUpdate() throws Exception {
		${className} ${className?uncap_first} = new ${className}();
		${className?uncap_first}.set${primaryKey?cap_first}(1);
		Integer num = ${className?uncap_first}Service.update(${className?uncap_first});
		System.err.println("本次修改：" + num + " 条数据");
	}
	
	@Test
	public void testSave() throws Exception {
	    ${className} ${className?uncap_first} = new ${className}();
		${className?uncap_first}Service.save(${className?uncap_first});
		System.err.println(${className?uncap_first});
	}
	
	@Test
	public void testGetPageResult4List() throws Exception {
		Map<String, Object> map = new HashMap<>();
		PageResult pageResult = ${className?uncap_first}Service.getPageResult4List(map);
		List<Map<String,Object>> rows = (List<Map<String, Object>>) pageResult.getRows();
		for (Map<String, Object> m : rows) {
			System.err.println(m);
		}
		System.err.println("总条数：" + pageResult.getCount());
		System.err.println("总页数：" + pageResult.getTotalPage());
		System.err.println("当前页：" + pageResult.getCurrentPage());
		System.err.println("每页显示的条数：" + pageResult.getPageSize());
	}
	
	@Test
	public void testGetPageResult4Model() throws Exception {
		Map<String, Object> map = new HashMap<>();
		PageResult pageResult = ${className?uncap_first}Service.getPageResult4Model(map);
		List<${className}> ${className?uncap_first}s = (List<${className}>) pageResult.getRows();
		for (${className} ${className?uncap_first} : ${className?uncap_first}s) {
			System.err.println(${className?uncap_first});
		}
		System.err.println("总条数：" + pageResult.getCount());
		System.err.println("总页数：" + pageResult.getTotalPage());
		System.err.println("当前页：" + pageResult.getCurrentPage());
		System.err.println("每页显示的条数：" + pageResult.getPageSize());
	}
}
