package ${basePackage}.${typePackage};
<#if tableModel.flag>

import java.util.Date;
</#if>

/**
 * ${tableModel.tabDesc}
 * @author: ${author}
 * @date: ${createDate}
 * create by codeFactory
 */
public class ${tableModel.className} {
	<#list tableModel.colName4Java as col>
	<#if tableModel.colDesc[col_index]!="">
	/**
	 * ${tableModel.colDesc[col_index]}
	 */
	</#if>
	private ${tableModel.colType[col_index]} ${col};
	
	</#list>
	
	<#list tableModel.colName4Java as col>
	public ${tableModel.colType[col_index]} get${col?cap_first}() {
		return ${col};
	}

	public void set${col?cap_first}(${tableModel.colType[col_index]} ${col}) {
		this.${col} = ${col};
	}
	</#list>
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("${tableModel.className} [ ");
		<#list tableModel.colName4Java as col>
			sb.append("${col}=" + ${col} + ",");
		</#list>
		sb.replace(sb.length()-1, sb.length(), " ]");
		return sb.toString();
	}
	
	
}
