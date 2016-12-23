package ${basePackage}.${servicePackage}.${serviceImplPackage};

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ${basePackage}.${pagePackage};
import ${basePackage}.${daoPackage}.IBaseDao;
import ${basePackage}.${servicePackage}.IBaseService;

public class BaseServiceImpl<T,PK> implements IBaseService<T,PK> {
	
	@Autowired
	private IBaseDao<T, PK> baseDao;

	@Override
	public T getById(PK id) {
		return baseDao.getById(id);
	}

	@Override
	public List<Map<String, Object>> getListByCondition(Map<String, Object> map) {
		return baseDao.getListByCondition(map);
	}

	@Override
	public List<T> getModelByCondition(Map<String, Object> map) {
		return baseDao.getModelByCondition(map);
	}
	
	@Override
	public Integer getCount(Map<String, Object> map) {
		return baseDao.getCount(map);
	}

	@Override
	public Integer deleteById(PK id) {
		return baseDao.deleteById(id);
	}

	@Override
	public Integer deleteByIds(String ids) {
		@SuppressWarnings("unchecked")
		List<PK> list = (List<PK>) Arrays.asList(ids.split(","));
		return baseDao.deleteByIds(list);
	}

	@Override
	public Integer update(T t) {
		return baseDao.update(t);
	}

	@Override
	public Integer save(T t) {
		return baseDao.save(t);
	}

	@Override
	public PageResult getPageResult4List(Map<String, Object> map) {
		Integer pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize").toString());
		Integer currentPage = map.get("currentPage") == null ? 1 : Integer.parseInt(map.get("currentPage").toString());
		if(pageSize < 1) {
			pageSize = 10;
		}
		if(currentPage < 1) {
			currentPage = 1;
		}
		map.put("currentPage", (currentPage - 1) * pageSize);
		map.put("pageSize",pageSize);
		
		Integer count = baseDao.getCount(map);
		List<Map<String, Object>> rows = baseDao.getListByCondition(map);
		return new PageResult(count, currentPage, pageSize, rows);
	}
	
	@Override
	public PageResult getPageResult4Model(Map<String, Object> map) {
		Integer pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize").toString());
		Integer currentPage = map.get("currentPage") == null ? 1 : Integer.parseInt(map.get("currentPage").toString());
		if(pageSize < 1) {
			pageSize = 10;
		}
		if(currentPage < 1) {
			currentPage = 1;
		}
		map.put("currentPage", (currentPage - 1) * pageSize);
		map.put("pageSize",pageSize);
		
		Integer count = baseDao.getCount(map);
		List<T> rows = baseDao.getModelByCondition(map);
		return new PageResult(count, currentPage, pageSize, rows);
	}
}