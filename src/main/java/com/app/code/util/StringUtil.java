package com.app.code.util;

import com.app.code.model.PojoModel;

public class StringUtil {
	/**
	 * 将首字母大写 
	 * @param str
	 * @return
	 */
	public static String toUpperCase(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}
	
	/**
	 * 删掉 "_" 并且把后面的字母大写 比如 :login_time >> loginTime
	 * @param string
	 * @return
	 */
	public static String replaceStr(String str) {
		String[] fields = str.split("_");
		if (fields.length > 1) {
			StringBuilder sb = new StringBuilder();
			sb.append(fields[0]);
			for (int i = 1; i < fields.length; i++) {
				sb.append(toUpperCase(fields[i].replace("_", "")));
			}
			return sb.toString();
		}else {
			return str;
		}
	}
	
	/**
	 * 根据 javabean获取生成的文件夹路径 默认根路径为 src/main/java
	 * @param pojoModel
	 * @return
	 */
	public static String getDirPath(PojoModel model){
		return getDirPath(model, "src/main/java");
	}
	
	/**
	 * 
	 * @param model
	 * @param dir
	 * @return
	 */
	public static String getDirPath(PojoModel model, String dir){
		// linux和windows文件分隔符不一样 通过system类获取
		String fileSeparator = System.getProperty("file.separator");
		// 文件相对于项目 /src/main/java 的路径
		String javaPath = getProPathByTemp(dir);
		String packagePath = (model.getBasePackage() + "." + model.getTypePackage()).replace(".", fileSeparator);
		String dirPath = javaPath + packagePath;
		return dirPath;
	}
	
	/**
	 * 返回基于src/main/java的路径
	 * @param basePackage
	 * @param typePackage
	 * @return
	 */
	public static String getPackage(String basePackage, String typePackage){
		// linux和windows文件分隔符不一样 通过system类获取
		String fileSeparator = System.getProperty("file.separator");
		String javaPath = getProPathByTemp("src/main/java");
		String packagePath = (basePackage + "." + typePackage).replace(".", fileSeparator);
		return javaPath + packagePath;
	}
	
	/**
	 * 根据路径获取当前项目路径+路径的路径  比如获取当前项目 src/main/java的路径  直接传入 src/main/java 返回 ${PAOJECT_PATH}/src/main/java/
	 * @param temp  传入的路径 多个以"/" 分割
	 * @return 当前项目路径+路径
	 */
	public static String getProPathByTemp(String temp) {
		// linux和windows文件分隔符不一样 通过system类获取
		String fileSeparator = System.getProperty("file.separator");
		// 获取项目根路径
		String relativelyPath = System.getProperty("user.dir");
		// 文件相对于项目 /src/main/resources 的路径
		String path = relativelyPath + fileSeparator + temp.replace("/", fileSeparator) + fileSeparator;
		return path;
	}
	
}
