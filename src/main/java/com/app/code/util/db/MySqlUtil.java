package com.app.code.util.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import com.app.code.constant.SystemConstant;
import com.app.code.model.DBModel;
import com.app.code.model.PojoModel;
import com.app.code.model.TableModel;
import com.app.code.util.StringUtil;

/**
 * 通过表生成 java 类
 * @author admin
 *
 */
public class MySqlUtil {
	
	/**
	 * 根据表名称生成封装表信息的对象
	 * @param tableName
	 * @return
	 */
	public static PojoModel createPojoModel(String tableName, DBModel dbModel){
		// 检查表是否存在
		DBCommonUtil.checkTable(tableName, dbModel);
		
		Connection conn = DBCommonUtil.getConn(dbModel);
		
		// 拼装pojo对象
		TableModel tModel = createTabModel(conn, tableName);
		// 默认basepackage下面的包名为model
		PojoModel pojoModel = PojoModel.getInstance();
		pojoModel.setTableModel(tModel);
		return pojoModel;
	}
	
	/**
	 * 根据表名称创建表对象
	 * @param conn
	 * @param tableName
	 * @return
	 */
	private static TableModel createTabModel(Connection conn,String tableName) {
		try {
			TableModel tModel = null;
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet rs = dbmd.getTables(conn.getCatalog(), "%", "%", new String[]{"TABLE"});
			while(rs.next()) {
				ResultSet columnRs = dbmd.getColumns(conn.getCatalog(), null, tableName, "%");
				
				// 获取表字段总数
				columnRs.last(); // 移到最后一行
				int columnCount = columnRs.getRow(); // 获取当前行号
				columnRs.beforeFirst(); // 由于后面还需要用结果集，所以把指针初始化
				
				// 初始化表对象
				tModel = new TableModel(columnCount);
				tModel.setTableName(tableName);
				tModel.setClassName(parseClassName(tableName));
				
				// 拼装值
				int i = 0;
				while(columnRs.next()) {
					//判断是否导入util包
					String type = columnRs.getString("TYPE_NAME");
					if("DATETIME".equalsIgnoreCase(type) || "TIMESTAMP".equalsIgnoreCase(type)) {
						tModel.setFlag(true);
					}
					
					tModel.getColName4Java()[i] = StringUtil.replaceStr(columnRs.getString("COLUMN_NAME"));
					tModel.getColName4DB()[i] = columnRs.getString("COLUMN_NAME");
					tModel.getColType()[i] = sqlType2JavaType(columnRs.getString("TYPE_NAME"));
					tModel.getColDesc()[i] = columnRs.getString("REMARKS");
					i++;
				}
				// 拼装表注释
				String sql = "show create table " + tableName;
				ResultSet rs2 = conn.createStatement().executeQuery(sql);
				while (rs2.next()) {
					String[] split = rs2.getString(2).split("COMMENT=");
					if(split.length == 2) { //有注释
						tModel.setTabDesc(split[1].replace("'", ""));
					}else {
						tModel.setTabDesc("");
					}
				}
			}
			return tModel;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将mysql的类型转换为java类型
	 * @param sqlType mysql的类型
	 * @return
	 */
	private static String sqlType2JavaType(String sqlType) {
		if(sqlType.equalsIgnoreCase("bit")){
			return "boolean";
		}else if(sqlType.equalsIgnoreCase("tinyint")){
			return "Integer";
		}else if(sqlType.equalsIgnoreCase("smallint")){
			return "Integer";
		}else if(sqlType.equalsIgnoreCase("int")){
			return "Integer";
		}else if(sqlType.equalsIgnoreCase("bigint")){
			return "Long";
		}else if(sqlType.equalsIgnoreCase("float")){
			return "Float";
		}else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric") 
				|| sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money") 
				|| sqlType.equalsIgnoreCase("smallmoney")){
			return "Double";
		}else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char") 
				|| sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar") 
				|| sqlType.equalsIgnoreCase("text")){
			return "String";
		}else if(sqlType.equalsIgnoreCase("datetime")){
			return "Date";
		}else if(sqlType.equalsIgnoreCase("image")){
			return "Blod";
		}else if(sqlType.equalsIgnoreCase("timestamp")){
			return "Date";
		}else if(sqlType.equalsIgnoreCase("int unsigned")){
			return "Integer";
		}else if(sqlType.equalsIgnoreCase("tinyint unsigned")){
			return "Integer";
		}else if(sqlType.equalsIgnoreCase("mediumint unsigned")){
			return "Integer";
		}else if(sqlType.equalsIgnoreCase("date")){
			return "Date";
		}else if(sqlType.equalsIgnoreCase("smallint unsigned")){
			return "Integer";
		}else if(sqlType.equalsIgnoreCase("mediumint")){
			return "Integer";
		}else if(sqlType.equalsIgnoreCase("DECIMAL UNSIGNED")){
			return "BigDecimal";
		}
		return null;
	}
	
	/**
	 * 去掉表的前缀 比如 gogo_user_order  出来的类名称就是userOrder
	 * 前缀在 SystemConstant.DB_NAME_PREFIX 修改
	 * @param tabName
	 * @return
	 */
	private  static String parseClassName(String tabName) {
		String[] split = tabName.split("_");
		if(SystemConstant.DB_NAME_PREFIX != null && !"".equals(SystemConstant.DB_NAME_PREFIX)){
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < split.length; i++) {
				if(SystemConstant.DB_NAME_PREFIX.equals(split[i]))
					continue;
				sb.append(StringUtil.toUpperCase(split[i]));
			}
			return sb.toString();
		}else{
			return StringUtil.toUpperCase(StringUtil.replaceStr(tabName));
		}
	}
	
}
