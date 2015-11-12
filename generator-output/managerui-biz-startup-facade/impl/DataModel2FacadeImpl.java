/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  DataModel2FacadeImpl.java 2015-11-12 16:18:23 $
 */
package cn.thinkjoy.facade.impl;

import cn.thinkjoy.facade.IDataModel2Facade;
import cn.thinkjoy.service.IDataModel2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DataModel2FacadeImpl")
public class DataModel2FacadeImpl implements IDataModel2Facade {
    @Autowired
    private IDataModel2Service dataModel2Service;


//    @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public void add() {
//        dataModel2Service.add();
//    }
}
