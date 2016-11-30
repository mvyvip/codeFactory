package ${basePackage}.${typePackage};

import java.util.List;
import java.util.Map;

import ${basePackage}.${pagePackage};

/**
 * 公共service封装
 * @author admin
 *
 * @param <T> model类型
 * @param <PK> 主键类型
 */
public interface IBaseService<T,PK> {
	/**
	 * 根据id查询单条数据
	 * @param id
	 * @return
	 */
	public T getById(PK id);
	
	/**
	 * 根据条件查询  返回list<map> 方便多表关联查询
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getListByCondition(Map<String,Object> map);
	
	/**
	 * 根据条件查询  返回model对象
	 * @param map
	 * @return
	 */
	public List<T> getModelByCondition(Map<String,Object> map);
	
	/**
	 * 根据条件查询总数
	 * @param map
	 * @return
	 */
	public Integer getCount(Map<String,Object> map);
	
	/**
	 * 根据条件查询分页数据 返回数据是 List<Map<String,Object>> 方便多表查询
	 * @param map
	 * @return
	 */
	public PageResult getPageResult4List(Map<String,Object> map);
	
	/**
	 * 根据条件查询分页数据 返回数据是 List<T>
	 * @param map
	 * @return
	 */
	public PageResult getPageResult4Model(Map<String,Object> map);
	
	/**
	 * 根据id删除数据
	 * @param id
	 * @return 返回删除的条数
	 */
	public Integer deleteById(PK id);
	
	/**
	 * 根据id集合删除数据
	 * @param ids
	 * @return 返回删除的条数
	 */
	public Integer deleteByIds(String ids);
	
	/**
	 * 修改对象
	 * @param t
	 * @return 返回修改的条数
	 */
	public Integer update(T t);
	
	/**
	 * 保存数据
	 * @param t
	 * @return 返回修改的条数
	 */
	public Integer save(T t);
}
