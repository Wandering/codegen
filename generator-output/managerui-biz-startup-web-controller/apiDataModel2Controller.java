/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  DataModel2Controller.java 2015-11-12 16:18:23 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.service.IDataModel2Service;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.DataModel2;
import cn.thinkjoy.service.IDataModel2Service;

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
public class apiDataModel2Controller{
    private static final Logger logger = LoggerFactory.getLogger(apiDataModel2Controller.class);

    @Autowired
    private IDataModel2Service dataModel2Service;

   /**
     * 新增 数据权限模型1
     * @param dataModel2
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/datamodel2", method = RequestMethod.POST)
    public Object addDataModel2(@RequestBody DataModel2 dataModel2) {
        try {
            String msg = "";

            if(dataModel2==null) {
                msg = "添加数据权限模型1参数不正确";
            }else if(dataModel2.getCreator() != null){
                msg = "数据权限模型1创建人不能为空";
            }else if(dataModel2.getCreateDate() != null){
                msg = "数据权限模型1创建时间不能为空";
            }else if(dataModel2.getLastModifier() != null){
                msg = "数据权限模型1修改人不能为空";
            }else if(dataModel2.getLastModDate() != null){
                msg = "数据权限模型1修改时间不能为空";
            }else if(dataModel2.getStatus() != null){
                msg = "数据权限模型1状态不能为空";
            }else if(dataModel2.getPriority() != null){
                msg = "数据权限模型1优先级不能为空";
            }else if(dataModel2.getModelId() != null){
                msg = "数据权限模型1其对应的模型主体id不能为空";
            }else if(StringUtils.isBlank(dataModel2.getAssignUrl())){
                msg = "数据权限模型1分配的url不能为空";
            }else if(dataModel2.getAssignUrl().length() > 32){
                msg = "数据权限模型1分配的url长度不可超过32";
            }else if(StringUtils.isBlank(dataModel2.getWhereSql())){
                msg = "数据权限模型1追加数据权限的sql不能为空";
            }else if(dataModel2.getWhereSql().length() > 512){
                msg = "数据权限模型1追加数据权限的sql长度不可超过512";
            }else if(StringUtils.isBlank(dataModel2.getName())){
                msg = "数据权限模型1按**维度设置不能为空";
            }else if(dataModel2.getName().length() > 32){
                msg = "数据权限模型1按**维度设置长度不可超过32";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=dataModel2Service.add(dataModel2);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(dataModel2.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增数据权限模型1失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增数据权限模型1异常");
        }
    }


    /**
     * 删除 数据权限模型1
     *
     * @param {dataModel2Id} 数据权限模型1ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/datamodel2/{dataModel2Id}" ,method = RequestMethod.DELETE)
    public Object delDataModel2(@PathVariable String dataModel2Id) {
        try {
            if(StringUtils.isBlank(dataModel2Id)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据权限模型1失败，参数不正确");
            }
            int row=dataModel2Service.deleteByProperty("id", dataModel2Id);
            if(row > 0) {
                return new StringWrapper( "删除数据权限模型1成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据权限模型1失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据权限模型1异常");
        }
    }


    /**
     * 修改数据权限模型1数据
     * @param dataModel2 提交上来的数据权限模型1JSON数据
     * @param dataModel2Id  数据权限模型1ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/datamodel2/{dataModel2Id}", method = RequestMethod.PATCH)
    public StringWrapper editDataModel2(@RequestBody DataModel2 dataModel2, @PathVariable String dataModel2Id) {
        try {
            String msg = "";
            if(dataModel2==null) {
                msg = "添加数据权限模型1参数不正确";
            }else if(dataModel2.getCreator() != null){
                msg = "数据权限模型1创建人不能为空";
            }else if(dataModel2.getCreateDate() != null){
                msg = "数据权限模型1创建时间不能为空";
            }else if(dataModel2.getLastModifier() != null){
                msg = "数据权限模型1修改人不能为空";
            }else if(dataModel2.getLastModDate() != null){
                msg = "数据权限模型1修改时间不能为空";
            }else if(dataModel2.getStatus() != null){
                msg = "数据权限模型1状态不能为空";
            }else if(dataModel2.getPriority() != null){
                msg = "数据权限模型1优先级不能为空";
            }else if(dataModel2.getModelId() != null){
                msg = "数据权限模型1其对应的模型主体id不能为空";
            }else if(StringUtils.isBlank(dataModel2.getAssignUrl())){
                msg = "数据权限模型1分配的url不能为空";
            }else if(dataModel2.getAssignUrl().length() > 32){
                msg = "数据权限模型1分配的url长度不可超过32";
            }else if(StringUtils.isBlank(dataModel2.getWhereSql())){
                msg = "数据权限模型1追加数据权限的sql不能为空";
            }else if(dataModel2.getWhereSql().length() > 512){
                msg = "数据权限模型1追加数据权限的sql长度不可超过512";
            }else if(StringUtils.isBlank(dataModel2.getName())){
                msg = "数据权限模型1按**维度设置不能为空";
            }else if(dataModel2.getName().length() > 32){
                msg = "数据权限模型1按**维度设置长度不可超过32";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            DataModel2 dataModel2_old = (DataModel2) dataModel2Service.findOne("id",dataModel2Id);
            if(dataModel2==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(dataModel2.getId() != null){
                dataModel2_old.setId(dataModel2.getId());
            }
            if(dataModel2.getCreator() != null){
                dataModel2_old.setCreator(dataModel2.getCreator());
            }
            if(dataModel2.getCreateDate() != null){
                dataModel2_old.setCreateDate(dataModel2.getCreateDate());
            }
            if(dataModel2.getLastModifier() != null){
                dataModel2_old.setLastModifier(dataModel2.getLastModifier());
            }
            if(dataModel2.getLastModDate() != null){
                dataModel2_old.setLastModDate(dataModel2.getLastModDate());
            }
            if(dataModel2.getStatus() != null){
                dataModel2_old.setStatus(dataModel2.getStatus());
            }
            if(dataModel2.getPriority() != null){
                dataModel2_old.setPriority(dataModel2.getPriority());
            }
            if(dataModel2.getModelId() != null){
                dataModel2_old.setModelId(dataModel2.getModelId());
            }
            if(!StringUtils.isBlank(dataModel2.getAssignUrl())){
                dataModel2_old.setAssignUrl(dataModel2.getAssignUrl());
            }
            if(!StringUtils.isBlank(dataModel2.getWhereSql())){
                dataModel2_old.setWhereSql(dataModel2.getWhereSql());
            }
            if(!StringUtils.isBlank(dataModel2.getName())){
                dataModel2_old.setName(dataModel2.getName());
            }


            int row=dataModel2Service.edit(dataModel2_old);
            if(row > 0) {
                return new StringWrapper("修改数据权限模型1成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改数据权限模型1失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改数据权限模型1数据异常");
        }
    }


    /**
     * 获取单数据权限模型1实体
     *
     * @param dataModel2Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/datamodel2/{dataModel2Id}", method = RequestMethod.GET)
    public DataModel2 getDataModel2(@PathVariable String dataModel2Id) {
        try {
            if(StringUtils.isBlank(dataModel2Id)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", dataModel2Id);
            DataModel2 dataModel2= (DataModel2) dataModel2Service.queryOne(whereParams);
            if(null == dataModel2){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到数据权限模型1相关数据！");
            }
            return dataModel2;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单数据权限模型1实体异常");
        }
    }


    /**
     * 数据权限模型1数据输出 带分页
     *
     * @param dataModel2 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/datamodel2list", method = RequestMethod.POST)
    public BizData4Page dataModel2list(DataModel2 dataModel2, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(dataModel2.getId() != null){
                whereParams.put("id", new SearchField("id", "=", dataModel2.getId()));
            }
            if(dataModel2.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", dataModel2.getCreator()));
            }
            if(dataModel2.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", dataModel2.getCreateDate()));
            }
            if(dataModel2.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", dataModel2.getLastModifier()));
            }
            if(dataModel2.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", dataModel2.getLastModDate()));
            }
            if(dataModel2.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", dataModel2.getStatus()));
            }
            if(dataModel2.getPriority() != null){
                whereParams.put("priority", new SearchField("priority", "=", dataModel2.getPriority()));
            }
            if(dataModel2.getModelId() != null){
                whereParams.put("modelId", new SearchField("modelId", "=", dataModel2.getModelId()));
            }
            if(!StringUtils.isBlank(dataModel2.getAssignUrl())){
                whereParams.put("assignUrl", new SearchField("assignUrl", "like", "%" + dataModel2.getAssignUrl() + "%"));
            }
            if(!StringUtils.isBlank(dataModel2.getWhereSql())){
                whereParams.put("whereSql", new SearchField("whereSql", "like", "%" + dataModel2.getWhereSql() + "%"));
            }
            if(!StringUtils.isBlank(dataModel2.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + dataModel2.getName() + "%"));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            dataModel2Service.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询数据权限模型1数据异常");
        }
    }
}
