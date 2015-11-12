/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  DataModel2Controller.java 2015-11-12 16:18:23 $
 */

package cn.thinkjoy.controller;

import cn.thinkjoy.service.IDataModel2Service;
import cn.thinkjoy.common.managerui.dao.IResourceGridDAO;
import cn.thinkjoy.common.managerui.service.IResourceGridService;
import cn.thinkjoy.common.domain.view.BizData4Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cn.thinkjoy.common.managerui.controller.AbstractAdminController;

@Controller
@RequestMapping(value="/admin/managerui-biz-startup")
public class DataModel2Controller extends AbstractAdminController<IDataModel2Service>{


    @Autowired
    private IDataModel2Service dataModel2Service;

    /**
     * 页面主请求
     * @param request
     * @param response
     * @return  返回菜单数据、表格描述元数据、当前主描述  如本页面为org
     */
    @RequestMapping(value="/datamodel2")
    public ModelAndView renderMainView(HttpServletRequest request,HttpServletResponse response){


        return doRenderMainView(request, response);
    }

    /**
     * 获取所有的组织信息
     * @return
     */
    @RequestMapping(value="/datamodel2s")
    @ResponseBody
    public BizData4Page findAllDataModel2s(HttpServletRequest request,HttpServletResponse response){
        return doPage(request, response);
    }

    @Override
    protected IDataModel2Service getMainService() {
        return dataModel2Service;
    }

    @Override
    protected String getBizSys() {
        return "managerui-biz-startup";
    }

    @Override
    protected String getMainObjName() {
        return "datamodel2";
    }

    @Override
    protected String getViewTitle() {
        return "数据权限设置1";
    }

    @Override
    protected String getParentTitle() {
        return "基础管理1";
    }

    @Override
    public boolean getEnableDataPerm() {
        return true;
    }
}
