<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop" xmlns:jee="http://www.springframework.org/schema/jee"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="
			http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
			http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
			http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
			http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee.xsd
			http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
	
	<!-- 开启aop代理模式 -->
	<aop:aspectj-autoproxy />

	<!-- 导入配置文件 -->
	<context:property-placeholder location="classpath*:*.properties" />

	<!-- 自动扫描特定注解类并纳入容器管理 -->
	<context:component-scan base-package="${basePackage}">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Service" />
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository" />
	</context:component-scan>

	<!-- 配置数据源 -->
	<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"  init-method="init" destroy-method="close" >
		<property name="driverClassName" value="${r'$'}{jdbc.driver}" />
		<property name="url" value="${r'$'}{jdbc.url}" />
		<property name="username" value="${r'$'}{jdbc.username}" />
		<property name="password" value="${r'$'}{jdbc.password}" />
		<property name="maxActive" value="20" />
		<property name="initialSize" value="1" />
		<property name="maxWait" value="60000" />
		<property name="minIdle" value="1" />
		<property name="timeBetweenEvictionRunsMillis" value="3000" />
		<property name="minEvictableIdleTimeMillis" value="300000" />
		<property name="validationQuery" value="SELECT 1 FROM DUAL" />
		<property name="testWhileIdle" value="true" />
		<property name="testOnBorrow" value="false" />
		<property name="testOnReturn" value="false" />
		<property name="filters" value="stat" />
	</bean>

	<!-- 启用jdbc事务 -->
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>

    <!-- 全局事务配置 -->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="insert*" propagation="REQUIRED"/>
            <tx:method name="add*" propagation="REQUIRED"/>
            <tx:method name="delete*" propagation="REQUIRED"/>
            <tx:method name="update*" propagation="REQUIRED"/>
            <tx:method name="edit*" propagation="REQUIRED"/>
            <tx:method name="save*" propagation="REQUIRED"/>
            <tx:method name="upload*" propagation="REQUIRED"/>
            <tx:method name="sync*" propagation="REQUIRED"/>
            <tx:method name="*" read-only="true"/>
        </tx:attributes>
    </tx:advice>
    <aop:config>
        <aop:pointcut expression="execution(* com.source3g.eom.*.service.impl.*.*(..))" id="pointCut"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="pointCut"/>
    </aop:config>

	<!-- 启用注解事务 -->
	<#--<tx:annotation-driven transaction-manager="transactionManager" />-->

	<!-- mybatis相关配置 -->
	<bean id="sessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<!-- 批量为Model启用别名 -->
		<property name="typeAliasesPackage" value="${basePackage}.${modelPackage}" />
		<!-- 指定 MyBatis 的 XML 映射器文件的位置 -->
		<property name="mapperLocations" value="classpath:${mapperPath}/*.xml" />
	</bean>

	<!-- 启用mapper作为dao的接口 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<!-- 批量为Mapper注册映射接口 -->
		<property name="basePackage" value="${basePackage}.${daoPackage}" />
		<!--限制只有@Repository注解才会把它装配为mapper -->
		<property name="annotationClass" value="org.springframework.stereotype.Repository" />
	</bean>

	<!-- 导入其他配置文件 -->
	<!-- <import resource="" /> -->
	
</beans>