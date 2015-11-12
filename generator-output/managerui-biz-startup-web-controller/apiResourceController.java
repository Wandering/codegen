/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  ResourceController.java 2015-11-12 16:18:26 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IResourceService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.Resource;
import cn.thinkjoy.common.managerui.service.IResourceService;

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
public class apiResourceController{
    private static final Logger logger = LoggerFactory.getLogger(apiResourceController.class);

    @Autowired
    private IResourceService resourceService;

   /**
     * 新增 资源
     * @param resource
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/resource", method = RequestMethod.POST)
    public Object addResource(@RequestBody Resource resource) {
        try {
            String msg = "";

            if(resource==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(resource.getUrl())){
                msg = "资源页面url不能为空";
            }else if(resource.getUrl().length() > 256){
                msg = "资源页面url长度不可超过256";
            }else if(resource.getOrderNum() != null){
                msg = "资源顺序不能为空";
            }else if(StringUtils.isBlank(resource.getNumber())){
                msg = "资源编码不能为空";
            }else if(resource.getNumber().length() > 32){
                msg = "资源编码长度不可超过32";
            }else if(StringUtils.isBlank(resource.getLongNumber())){
                msg = "资源长编码不能为空";
            }else if(resource.getLongNumber().length() > 128){
                msg = "资源长编码长度不可超过128";
            }else if(StringUtils.isBlank(resource.getName())){
                msg = "资源资源名称不能为空";
            }else if(resource.getName().length() > 16){
                msg = "资源资源名称长度不可超过16";
            }else if(resource.getCreator() != null){
                msg = "资源创建人不能为空";
            }else if(resource.getCreateDate() != null){
                msg = "资源创建时间不能为空";
            }else if(resource.getLastModifier() != null){
                msg = "资源修改人不能为空";
            }else if(resource.getLastModDate() != null){
                msg = "资源修改时间不能为空";
            }else if(StringUtils.isBlank(resource.getBizModelName())){
                msg = "资源业务模型名称|在同一个业务系统里不允许有同名的业务模型不能为空";
            }else if(resource.getBizModelName().length() > 16){
                msg = "资源业务模型名称|在同一个业务系统里不允许有同名的业务模型长度不可超过16";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=resourceService.add(resource);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(resource.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源异常");
        }
    }


    /**
     * 删除 资源
     *
     * @param {resourceId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/resource/{resourceId}" ,method = RequestMethod.DELETE)
    public Object delResource(@PathVariable String resourceId) {
        try {
            if(StringUtils.isBlank(resourceId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=resourceService.deleteByProperty("id", resourceId);
            if(row > 0) {
                return new StringWrapper( "删除资源成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源异常");
        }
    }


    /**
     * 修改资源数据
     * @param resource 提交上来的资源JSON数据
     * @param resourceId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/resource/{resourceId}", method = RequestMethod.PATCH)
    public StringWrapper editResource(@RequestBody Resource resource, @PathVariable String resourceId) {
        try {
            String msg = "";
            if(resource==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(resource.getUrl())){
                msg = "资源页面url不能为空";
            }else if(resource.getUrl().length() > 256){
                msg = "资源页面url长度不可超过256";
            }else if(resource.getOrderNum() != null){
                msg = "资源顺序不能为空";
            }else if(StringUtils.isBlank(resource.getNumber())){
                msg = "资源编码不能为空";
            }else if(resource.getNumber().length() > 32){
                msg = "资源编码长度不可超过32";
            }else if(StringUtils.isBlank(resource.getLongNumber())){
                msg = "资源长编码不能为空";
            }else if(resource.getLongNumber().length() > 128){
                msg = "资源长编码长度不可超过128";
            }else if(StringUtils.isBlank(resource.getName())){
                msg = "资源资源名称不能为空";
            }else if(resource.getName().length() > 16){
                msg = "资源资源名称长度不可超过16";
            }else if(resource.getCreator() != null){
                msg = "资源创建人不能为空";
            }else if(resource.getCreateDate() != null){
                msg = "资源创建时间不能为空";
            }else if(resource.getLastModifier() != null){
                msg = "资源修改人不能为空";
            }else if(resource.getLastModDate() != null){
                msg = "资源修改时间不能为空";
            }else if(StringUtils.isBlank(resource.getBizModelName())){
                msg = "资源业务模型名称|在同一个业务系统里不允许有同名的业务模型不能为空";
            }else if(resource.getBizModelName().length() > 16){
                msg = "资源业务模型名称|在同一个业务系统里不允许有同名的业务模型长度不可超过16";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Resource resource_old = (Resource) resourceService.findOne("id",resourceId);
            if(resource==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(resource.getId() != null){
                resource_old.setId(resource.getId());
            }
            if(!StringUtils.isBlank(resource.getUrl())){
                resource_old.setUrl(resource.getUrl());
            }
            if(resource.getOrderNum() != null){
                resource_old.setOrderNum(resource.getOrderNum());
            }
            if(resource.getParentId() != null){
                resource_old.setParentId(resource.getParentId());
            }
            if(!StringUtils.isBlank(resource.getNumber())){
                resource_old.setNumber(resource.getNumber());
            }
            if(!StringUtils.isBlank(resource.getLongNumber())){
                resource_old.setLongNumber(resource.getLongNumber());
            }
            if(!StringUtils.isBlank(resource.getName())){
                resource_old.setName(resource.getName());
            }
            if(resource.getCreator() != null){
                resource_old.setCreator(resource.getCreator());
            }
            if(resource.getCreateDate() != null){
                resource_old.setCreateDate(resource.getCreateDate());
            }
            if(resource.getLastModifier() != null){
                resource_old.setLastModifier(resource.getLastModifier());
            }
            if(resource.getLastModDate() != null){
                resource_old.setLastModDate(resource.getLastModDate());
            }
            if(!StringUtils.isBlank(resource.getDescription())){
                resource_old.setDescription(resource.getDescription());
            }
            if(resource.getModelId() != null){
                resource_old.setModelId(resource.getModelId());
            }
            if(!StringUtils.isBlank(resource.getBizModelName())){
                resource_old.setBizModelName(resource.getBizModelName());
            }


            int row=resourceService.edit(resource_old);
            if(row > 0) {
                return new StringWrapper("修改资源成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源数据异常");
        }
    }


    /**
     * 获取单资源实体
     *
     * @param resourceId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/resource/{resourceId}", method = RequestMethod.GET)
    public Resource getResource(@PathVariable String resourceId) {
        try {
            if(StringUtils.isBlank(resourceId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", resourceId);
            Resource resource= (Resource) resourceService.queryOne(whereParams);
            if(null == resource){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return resource;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单资源实体异常");
        }
    }


    /**
     * 资源数据输出 带分页
     *
     * @param resource 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/resourcelist", method = RequestMethod.POST)
    public BizData4Page resourcelist(Resource resource, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(resource.getId() != null){
                whereParams.put("id", new SearchField("id", "=", resource.getId()));
            }
            if(!StringUtils.isBlank(resource.getUrl())){
                whereParams.put("url", new SearchField("url", "like", "%" + resource.getUrl() + "%"));
            }
            if(resource.getOrderNum() != null){
                whereParams.put("orderNum", new SearchField("orderNum", "=", resource.getOrderNum()));
            }
            if(resource.getParentId() != null){
                whereParams.put("parentId", new SearchField("parentId", "=", resource.getParentId()));
            }
            if(!StringUtils.isBlank(resource.getNumber())){
                whereParams.put("number", new SearchField("number", "like", "%" + resource.getNumber() + "%"));
            }
            if(!StringUtils.isBlank(resource.getLongNumber())){
                whereParams.put("longNumber", new SearchField("longNumber", "like", "%" + resource.getLongNumber() + "%"));
            }
            if(!StringUtils.isBlank(resource.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + resource.getName() + "%"));
            }
            if(resource.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", resource.getCreator()));
            }
            if(resource.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", resource.getCreateDate()));
            }
            if(resource.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", resource.getLastModifier()));
            }
            if(resource.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", resource.getLastModDate()));
            }
            if(!StringUtils.isBlank(resource.getDescription())){
                whereParams.put("description", new SearchField("description", "like", "%" + resource.getDescription() + "%"));
            }
            if(resource.getModelId() != null){
                whereParams.put("modelId", new SearchField("modelId", "=", resource.getModelId()));
            }
            if(!StringUtils.isBlank(resource.getBizModelName())){
                whereParams.put("bizModelName", new SearchField("bizModelName", "like", "%" + resource.getBizModelName() + "%"));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            resourceService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
