<#assign className = table.classNameBo>
<#assign classNameLower = className?uncap_first>
<#assign classNameAllLower = table.classNameBo?lower_case>
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ${module}
 * $Id:  ${className}FacadeImpl.java ${now?string('yyyy-MM-dd HH:mm:ss')} $
 */
<#include "/macro.include"/>
package ${basepackage}.facade.impl;
public class ${className}FacadeImpl implements ${className}Facade {
    @Autowired
    private ${className}Service ${classNameLower}Service;


//    @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public void add() {
//        ${classNameLower}Service.add();
//    }
}
