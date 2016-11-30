<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"  
   xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"  
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
   xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd ">

    <!-- 对请求数据转码 -->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- 所有servlet和过滤器共享的根Spring容器的定义 -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:${springConfigName}</param-value>
    </context-param>

    <!-- 创建Spring容器所有servlet和过滤器共享 -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!-- 处理应用程序请求 -->
    <servlet>
        <servlet-name>appServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:${servletConfigName}</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>appServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>


	<!-- druid连接池内置监控界面 -->
	<servlet>
	    <servlet-name>DruidStatView</servlet-name>
	    <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
	    <!-- 设置false避免别人执行Reset All操作导致所有计数器清零并重新计数 -->
	    <init-param>
	        <param-name>resetEnable</param-name>
	        <param-value>false</param-value>
	    </init-param>
	</servlet>
	<servlet-mapping>
	    <servlet-name>DruidStatView</servlet-name>
	    <url-pattern>/druid</url-pattern>
	</servlet-mapping>
	
	<!-- 图形验证码 -->
    <!--
    <servlet>
        <servlet-name>kaptcha</servlet-name>
        <servlet-class>com.google.code.kaptcha.servlet.KaptchaServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>kaptcha</servlet-name>
        <url-pattern>/verificationCode/kaptcha.jpg</url-pattern>
    </servlet-mapping>
	<-->
</web-app>