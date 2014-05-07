<#assign className = table.classNameBo>
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ${module}
 * $Id:  ${className}BatchDAO.java ${now?string('yyyy-MM-dd HH:mm:ss')} $
 */
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${persistence};

import cn.thinkjoy.common.dao.BaseBatchDAO;
import ${basepackage}.${persistence}.beans.${className};

public interface ${className}BatchDAO extends BaseBatchDAO<${className}>{
	
<#list table.columns as column>
	<#if (column.unique && !column.pk)>
	${className} findBy${column.columnName}(${column.possibleShortJavaType} ${column.columnNameFirstLower});
	</#if>
</#list>

}
