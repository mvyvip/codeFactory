package com.app.code.model;

import com.app.code.constant.PathConstant;
import com.app.code.constant.SystemConstant;
import com.app.code.util.DateUtil;

/**
 * 生成javabean所需要的常见属性,属性值都从配置文件中获取(/resources.properties)
 * @author admin
 *
 */
public class PojoModel {
	
	private static PojoModel pojoModel;
	
	/**
	 * 生成包的根路径 比如:com.xx.xx
	 */
	private String basePackage;
	
	/**
	 * basePackage下面的路径
	 */
	private String typePackage;
	
	/**
	 * 生成作者名称
	 */
	private String author;
	
	/**
	 * 创建时间
	 */
	private String createDate;
	
	private TableModel tableModel;
	
	private PojoModel(){}
	
	public static PojoModel getInstance(){
		if (pojoModel == null) {
			synchronized (PojoModel.class) {
				if(pojoModel == null) {
					pojoModel = new PojoModel();
					pojoModel.setAuthor(SystemConstant.MODEL_AUTHOR_NAME);
					pojoModel.setBasePackage(PathConstant.PROJECT_PACKAGE_BASE);
					pojoModel.setCreateDate(DateUtil.getCurrent());
				}
			}
		}
		return pojoModel;
	}

	public static void setPojoModel(PojoModel pojoModel) {
		PojoModel.pojoModel = pojoModel;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getTypePackage() {
		return typePackage;
	}

	public void setTypePackage(String typePackage) {
		this.typePackage = typePackage;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public TableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(TableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	@Override
	public String toString() {
		return "PojoModel [basePackage=" + basePackage + ", typePackage=" + typePackage + ", author=" + author
				+ ", createDate=" + createDate + ", tableModel=" + tableModel + "]";
	}

}
