
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  managerui-biz-startupServiceMaps.java 2015-11-12 16:18:27 $
 */

package cn.thinkjoy.common;

import cn.thinkjoy.common.service.IBaseService;
import cn.thinkjoy.service.IDataModel2Service;


import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

import cn.thinkjoy.common.managerui.controller.helpers.BaseServiceMaps;

/**
 * Created by shurrik on 14-9-24.
 */
@Service("managerui-biz-startupServiceMaps")
public class ServiceMaps extends BaseServiceMaps{


    @Autowired
    private IDataModel2Service dataModel2Service;

    @PostConstruct
    public void init(){
        super.init();
        serviceMap.put("dataModel2",dataModel2Service);
    }

}
