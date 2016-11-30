package com.app.code.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.app.code.exception.TableNotFoundException;
import com.app.code.model.DBModel;

public class DBCommonUtil {
	
	public static Connection getConn(DBModel dbModel){
		try {
			Class.forName(dbModel.getDriver());
			return DriverManager.getConnection(dbModel.getUrl(), dbModel.getUsername(),dbModel.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void checkTable(String tableName, DBModel dbModel) {
		boolean flag = false; // 表是否存在 默认不存在
		try {
			Connection conn = getConn(dbModel);
			String sql = "show tables";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				if(tableName.equalsIgnoreCase(rs.getString(1))) {
					flag = true;
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(!flag) {
				throw new TableNotFoundException("表>" + tableName + "不存在");
			}
		}
	}
	
}
