<#include "/macro.include"/>
<#assign className = table.classNameBo>
<#assign classNameFirstLower = table.classNameFirstLower>
<#assign idJavaType = table.idColumn.javaType>
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#macro namespace>${basepackage}.${persistence}</#macro>

  <#list table.columns as column>
      INSERT INTO `resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`)
      VALUES(${column_index+1},#resId,'${column.remarks}','${column.sqlName}',${column_index},200,'{}',null,null);
  </#list>
