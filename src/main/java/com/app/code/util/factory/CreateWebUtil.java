package com.app.code.util.factory;

/**
 * 创建 web.xml spring-servlet.xml
 * @author admin
 *
 */
public class CreateWebUtil {

	public static void initProject() {
		CreateSpringServletConfUtil.createServletConf();
		CreateWebXmlUtil.createWebXml();
	}

}
