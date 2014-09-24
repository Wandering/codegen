
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ${module}
 * $Id:  ServiceMaps.java ${now?string('yyyy-MM-dd HH:mm:ss')} $
 */

package ${basepackage}.common;

import cn.thinkjoy.common.service.IBaseService;
<#list tables as table>
<#assign className = table.classNameBo>
import ${basepackage}.service.${className}Service;
</#list>


import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;


/**
 * Created by shurrik on 14-9-24.
 */
@Service("serviceMaps")
public class ServiceMaps {

    <#list tables as table>
    <#assign className = table.classNameBo>
    <#assign classNameLower = className?uncap_first>

    @Autowired
    private ${className}Service ${classNameLower}Service;
    </#list>

    private final Map<String, IBaseService> serviceMap = Maps.newHashMap();

    @PostConstruct
    public void init(){
        <#list tables as table>
            <#assign className = table.classNameBo>
            <#assign classNameLower = className?uncap_first>
            serviceMap.put("${classNameLower}",${classNameLower}Service);
        </#list>
    }

    public IBaseService get(String mainObj){
        return serviceMap.get(mainObj);
    }

}
