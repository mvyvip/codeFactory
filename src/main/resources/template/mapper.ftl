<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper  
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackage}.${daoPackage}.I${className}Dao">

	<resultMap type="${className}" id="${className?uncap_first}Map">
		<#list colName4Java as col>
		<result column="${colName4DB[col_index]}" property="${colName4Java[col_index]}"/>
		</#list>
	</resultMap>
	
	<sql id="columnList">
		<#list colName4DB as col><#if col_index!=0>${col}<#if col_has_next>,</#if></#if></#list>
	</sql>
	
	<sql id="columnWhere">
		<where>
			<#list colName4Java as col>
			<if test="${col} != null">
				and ${colName4DB[col_index]} = ${r'#'}{${col}}
			</if>
			</#list>
		</where>
	</sql>
	
	<sql id="columnUpdate">
		<set>
			<#list colName4Java as col>
			<#if col_index!=0>
			<if test="${col} != null">
				${colName4DB[col_index]} = ${r'#'}{${col}}<#if col_has_next>,</#if>
			</if>
			</#if>
			</#list>
		</set>
	</sql>
	
	<select id="getById" resultMap="${className?uncap_first}Map">
		select ${colName4DB[0]},<include refid="columnList" /> from ${tableName} where ${colName4DB[0]} = ${r'#'}{${colName4Java[0]}}
	</select>
	
	<select id="getListByCondition" parameterType="map" resultType="map">
		select ${colName4DB[0]},<include refid="columnList" /> from ${tableName}
		<include refid="columnWhere" />
		<if test="sort != null and sort == true">
            order by ${colName4DB[0]} desc
        </if>
        <if test="currentPage != null and pageSize != null">
            limit ${r'#'}{currentPage},${r'#'}{pageSize}
        </if>
	</select>
	
	<select id="getModelByCondition" parameterType="map" resultMap="${className?uncap_first}Map">
		select ${colName4DB[0]},<include refid="columnList" /> from ${tableName}
		<include refid="columnWhere" />
		<if test="sort != null and sort == true">
            order by ${colName4DB[0]} desc
        </if>
        <if test="currentPage != null and pageSize != null">
            limit ${r'#'}{currentPage},${r'#'}{pageSize}
        </if>
	</select>
	
	<select id="getCount" parameterType="map" resultType="integer">
		select count(1) from ${tableName}
		<include refid="columnWhere" />
	</select>
	
	<insert id="save" parameterType="${className}" useGeneratedKeys="true" keyProperty="${colName4DB[0]}">
		insert into ${tableName}(<include refid="columnList" />) values(<#list colName4Java as col><#if col_index!=0>${r'#'}{${col}}<#if col_has_next>,</#if></#if></#list>)
	</insert>
	
	<delete id="deleteById" parameterType="integer">
		delete from ${tableName} where ${colName4DB[0]} = ${r'#'}{${colName4Java[0]}}
	</delete>
	
	<delete id="deleteByIds" parameterType="list">
		delete from ${tableName} where ${colName4DB[0]} in
		<foreach collection="list" open="(" close=")" separator="," item="id">
			${r'#'}{id}
		</foreach>
	</delete>
	
	<update id="update" parameterType="${className}">
		update ${tableName}
		<include refid="columnUpdate" />
		where ${colName4DB[0]} = ${r'#'}{${colName4Java[0]}}
	</update>
</mapper>