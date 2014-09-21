<#assign className = table.classNameBo>
<#assign classNameLower = className?uncap_first>
<#assign classNameAllLower = table.classNameBo?lower_case>
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ${module}
 * $Id:  ${className}ServiceImpl.java ${now?string('yyyy-MM-dd HH:mm:ss')} $
 */
<#include "/macro.include"/>
package ${basepackage}.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("${className}ServiceImpl")
public class ${className}ServiceImpl extends AbstractPageService<${className}DAO, ${className}> implements ${className}Service {
    @Autowired
    private ${className}DAO ${classNameLower}DAO;

    @Override
    protected ${className}DAO getDao() {
        return ${classNameLower}DAO;
    }

}
