/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  DataModelController.java 2015-11-12 16:18:25 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IDataModelService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.DataModel;
import cn.thinkjoy.common.managerui.service.IDataModelService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/api")
public class apiDataModelController{
    private static final Logger logger = LoggerFactory.getLogger(apiDataModelController.class);

    @Autowired
    private IDataModelService dataModelService;

   /**
     * 新增 数据权限模型
     * @param dataModel
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/datamodel", method = RequestMethod.POST)
    public Object addDataModel(@RequestBody DataModel dataModel) {
        try {
            String msg = "";

            if(dataModel==null) {
                msg = "添加数据权限模型参数不正确";
            }else if(dataModel.getCreator() != null){
                msg = "数据权限模型创建人不能为空";
            }else if(dataModel.getCreateDate() != null){
                msg = "数据权限模型创建时间不能为空";
            }else if(dataModel.getLastModifier() != null){
                msg = "数据权限模型修改人不能为空";
            }else if(dataModel.getLastModDate() != null){
                msg = "数据权限模型修改时间不能为空";
            }else if(dataModel.getStatus() != null){
                msg = "数据权限模型状态不能为空";
            }else if(dataModel.getPriority() != null){
                msg = "数据权限模型优先级不能为空";
            }else if(dataModel.getModelId() != null){
                msg = "数据权限模型其对应的模型主体id不能为空";
            }else if(StringUtils.isBlank(dataModel.getAssignUrl())){
                msg = "数据权限模型分配的url不能为空";
            }else if(dataModel.getAssignUrl().length() > 32){
                msg = "数据权限模型分配的url长度不可超过32";
            }else if(StringUtils.isBlank(dataModel.getWhereSql())){
                msg = "数据权限模型追加数据权限的sql不能为空";
            }else if(dataModel.getWhereSql().length() > 512){
                msg = "数据权限模型追加数据权限的sql长度不可超过512";
            }else if(StringUtils.isBlank(dataModel.getName())){
                msg = "数据权限模型按**维度设置不能为空";
            }else if(dataModel.getName().length() > 32){
                msg = "数据权限模型按**维度设置长度不可超过32";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=dataModelService.add(dataModel);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(dataModel.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增数据权限模型失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增数据权限模型异常");
        }
    }


    /**
     * 删除 数据权限模型
     *
     * @param {dataModelId} 数据权限模型ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/datamodel/{dataModelId}" ,method = RequestMethod.DELETE)
    public Object delDataModel(@PathVariable String dataModelId) {
        try {
            if(StringUtils.isBlank(dataModelId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据权限模型失败，参数不正确");
            }
            int row=dataModelService.deleteByProperty("id", dataModelId);
            if(row > 0) {
                return new StringWrapper( "删除数据权限模型成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据权限模型失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据权限模型异常");
        }
    }


    /**
     * 修改数据权限模型数据
     * @param dataModel 提交上来的数据权限模型JSON数据
     * @param dataModelId  数据权限模型ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/datamodel/{dataModelId}", method = RequestMethod.PATCH)
    public StringWrapper editDataModel(@RequestBody DataModel dataModel, @PathVariable String dataModelId) {
        try {
            String msg = "";
            if(dataModel==null) {
                msg = "添加数据权限模型参数不正确";
            }else if(dataModel.getCreator() != null){
                msg = "数据权限模型创建人不能为空";
            }else if(dataModel.getCreateDate() != null){
                msg = "数据权限模型创建时间不能为空";
            }else if(dataModel.getLastModifier() != null){
                msg = "数据权限模型修改人不能为空";
            }else if(dataModel.getLastModDate() != null){
                msg = "数据权限模型修改时间不能为空";
            }else if(dataModel.getStatus() != null){
                msg = "数据权限模型状态不能为空";
            }else if(dataModel.getPriority() != null){
                msg = "数据权限模型优先级不能为空";
            }else if(dataModel.getModelId() != null){
                msg = "数据权限模型其对应的模型主体id不能为空";
            }else if(StringUtils.isBlank(dataModel.getAssignUrl())){
                msg = "数据权限模型分配的url不能为空";
            }else if(dataModel.getAssignUrl().length() > 32){
                msg = "数据权限模型分配的url长度不可超过32";
            }else if(StringUtils.isBlank(dataModel.getWhereSql())){
                msg = "数据权限模型追加数据权限的sql不能为空";
            }else if(dataModel.getWhereSql().length() > 512){
                msg = "数据权限模型追加数据权限的sql长度不可超过512";
            }else if(StringUtils.isBlank(dataModel.getName())){
                msg = "数据权限模型按**维度设置不能为空";
            }else if(dataModel.getName().length() > 32){
                msg = "数据权限模型按**维度设置长度不可超过32";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            DataModel dataModel_old = (DataModel) dataModelService.findOne("id",dataModelId);
            if(dataModel==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(dataModel.getId() != null){
                dataModel_old.setId(dataModel.getId());
            }
            if(dataModel.getCreator() != null){
                dataModel_old.setCreator(dataModel.getCreator());
            }
            if(dataModel.getCreateDate() != null){
                dataModel_old.setCreateDate(dataModel.getCreateDate());
            }
            if(dataModel.getLastModifier() != null){
                dataModel_old.setLastModifier(dataModel.getLastModifier());
            }
            if(dataModel.getLastModDate() != null){
                dataModel_old.setLastModDate(dataModel.getLastModDate());
            }
            if(dataModel.getStatus() != null){
                dataModel_old.setStatus(dataModel.getStatus());
            }
            if(dataModel.getPriority() != null){
                dataModel_old.setPriority(dataModel.getPriority());
            }
            if(dataModel.getModelId() != null){
                dataModel_old.setModelId(dataModel.getModelId());
            }
            if(!StringUtils.isBlank(dataModel.getAssignUrl())){
                dataModel_old.setAssignUrl(dataModel.getAssignUrl());
            }
            if(!StringUtils.isBlank(dataModel.getWhereSql())){
                dataModel_old.setWhereSql(dataModel.getWhereSql());
            }
            if(!StringUtils.isBlank(dataModel.getName())){
                dataModel_old.setName(dataModel.getName());
            }


            int row=dataModelService.edit(dataModel_old);
            if(row > 0) {
                return new StringWrapper("修改数据权限模型成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改数据权限模型失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改数据权限模型数据异常");
        }
    }


    /**
     * 获取单数据权限模型实体
     *
     * @param dataModelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/datamodel/{dataModelId}", method = RequestMethod.GET)
    public DataModel getDataModel(@PathVariable String dataModelId) {
        try {
            if(StringUtils.isBlank(dataModelId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", dataModelId);
            DataModel dataModel= (DataModel) dataModelService.queryOne(whereParams);
            if(null == dataModel){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到数据权限模型相关数据！");
            }
            return dataModel;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单数据权限模型实体异常");
        }
    }


    /**
     * 数据权限模型数据输出 带分页
     *
     * @param dataModel 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/datamodellist", method = RequestMethod.POST)
    public BizData4Page dataModellist(DataModel dataModel, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(dataModel.getId() != null){
                whereParams.put("id", new SearchField("id", "=", dataModel.getId()));
            }
            if(dataModel.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", dataModel.getCreator()));
            }
            if(dataModel.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", dataModel.getCreateDate()));
            }
            if(dataModel.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", dataModel.getLastModifier()));
            }
            if(dataModel.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", dataModel.getLastModDate()));
            }
            if(dataModel.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", dataModel.getStatus()));
            }
            if(dataModel.getPriority() != null){
                whereParams.put("priority", new SearchField("priority", "=", dataModel.getPriority()));
            }
            if(dataModel.getModelId() != null){
                whereParams.put("modelId", new SearchField("modelId", "=", dataModel.getModelId()));
            }
            if(!StringUtils.isBlank(dataModel.getAssignUrl())){
                whereParams.put("assignUrl", new SearchField("assignUrl", "like", "%" + dataModel.getAssignUrl() + "%"));
            }
            if(!StringUtils.isBlank(dataModel.getWhereSql())){
                whereParams.put("whereSql", new SearchField("whereSql", "like", "%" + dataModel.getWhereSql() + "%"));
            }
            if(!StringUtils.isBlank(dataModel.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + dataModel.getName() + "%"));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            dataModelService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询数据权限模型数据异常");
        }
    }
}
