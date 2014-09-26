-- model
<#list tables as table>
<#assign className = table.classNameBo>
<#assign classNameLower = className?uncap_first>
INSERT INTO `ehr_model`(`id`,`name`,`tblName`)
VALUES(${table_index+1},'${table.remarks}','${table.sqlName}');
</#list>

-- resource
<#assign resourceId=1/>
<#assign resourceGridId=1/>
<#list tables as table>

<#assign className = table.classNameBo>
<#assign classNameFirstLower = table.classNameFirstLower>
<#assign classNameAllLower = table.classNameBo?lower_case>

INSERT INTO `ehr_resource`(`id`,`url`,`orderNum`,`parentId`,`number`,`longNumber`,`name`,`creator`,`createDate`,`lastModifier`,`lastModDate`,`description`,`modelId`)
VALUES(${resourceId},'/admin/${classNameAllLower}',1,null,'a','a_1','${table.remarks}',0,0,0,0,null,null);

  <#assign className = table.classNameBo>
  <#assign classNameFirstLower = table.classNameFirstLower>
  <#assign idJavaType = table.idColumn.javaType>
  <#macro mapperEl value>${r"#{"}${value}}</#macro>
  <#macro namespace>${basepackage}.${persistence}</#macro>

  -- resource_grid
  <#list table.columns as column>
      INSERT INTO `ehr_resource_grid` (`id`,`resId`,`displayName`,`colId`,`orderNum`,`width`,`editoptions`,`edittype`,`unformat`,`description`,`moduleName`)
      VALUES(${resourceGridId},${resourceId},'${column.remarks}','${column.sqlName}',${column_index},200,'{}',null,null,'','${classNameAllLower}');
      <#assign resourceGridId=resourceGridId+1/>
  </#list>
<#assign resourceId=resourceId+1/>
</#list>