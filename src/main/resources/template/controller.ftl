package ${basePackage}.${typePackage};

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basePackage}.common.page.PageResult;
import ${basePackage}.common.resp.RespBody;
import ${basePackage}.${modelPackage}.${className};
import ${basePackage}.${servicePackage}.I${className}Service;

@Controller
@RequestMapping("/${className?uncap_first}")
public class ${className}Controller {
	@Autowired
	private I${className}Service ${className?uncap_first}Service;
	
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(Integer page,Integer rows){
		Map<String,Object> map = new HashMap<>();
		map.put("currentPage", page);
		map.put("pageSize", rows);
		return ${className?uncap_first}Service.getPageResult4Model(map);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public RespBody delete(@PathVariable ${keyType} id){
		${className?uncap_first}Service.deleteById(id);
		return new RespBody(true, "删除成功");
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public RespBody edit(${className} ${className?uncap_first}){
		if(${className?uncap_first}.get${keyName?cap_first}() != null){
			${className?uncap_first}Service.update(${className?uncap_first});
			return new RespBody(true, "修改成功");
		} else {
			${className?uncap_first}Service.save(${className?uncap_first});
			return new RespBody(true, "添加成功");
		}
	}
	
}

