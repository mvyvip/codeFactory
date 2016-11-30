<#list colName4Java as col>
<if test="${col} != null">
	and ${colName4DB[col_index]} = ${r'#'}{${col}}<#if col_has_next>,</#if>
</if>
</#list>

=======

${colName4Java[0]}

====
<#list colName4Java as col>${col}</#list>


===ee
<#list colName4DB as col><#if col_index!=0>${col}<#if col_has_next>,</#if></#if></#list>


======
<#list colName4Java as col><#if col_index!=0>${r'#'}{${col}}<#if col_has_next>,</#if></#if></#list>