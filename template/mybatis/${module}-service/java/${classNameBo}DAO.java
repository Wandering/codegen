<#assign className = table.classNameBo>
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ${module}
 * $Id:  ${className}DAO.java ${now?string('yyyy-MM-dd HH:mm:ss')} $
 */
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${persistence};

import ${basepackage}.BaseDAO;
import ${basepackage}.domain.${className};

public interface ${className}DAO extends BaseDAO<${className}>{
	
<#list table.columns as column>
	<#if (column.unique && !column.pk)>
	${className} findBy${column.columnName}(${column.possibleShortJavaType} ${column.columnNameFirstLower});
	</#if>
</#list>

}
