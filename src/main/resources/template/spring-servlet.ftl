<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
   xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="
			http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
			http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
			http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">

	<!-- 开启mvc注解 -->
	<mvc:annotation-driven />

	<!-- 处理静态资源映射 -->
	<mvc:default-servlet-handler />
	<mvc:resources mapping="/static/**" location="/static/" />

	<!-- 自动扫描特定注解类并纳入容器管理 -->
	<context:component-scan base-package="${basePackage}.web.controller">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
	</context:component-scan>
	
	<!--通用视图解析器 -->
	<bean id="viewResolverCommon" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
		<property name="prefix" value="/WEB-INF/views/"/>
		<property name="suffix" value=".jsp"/>
		<property name="order" value="1"/>
	</bean>

</beans>