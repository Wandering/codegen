/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  ResourceActionController.java 2015-11-12 16:18:26 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IResourceActionService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.ResourceAction;
import cn.thinkjoy.common.managerui.service.IResourceActionService;

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
public class apiResourceActionController{
    private static final Logger logger = LoggerFactory.getLogger(apiResourceActionController.class);

    @Autowired
    private IResourceActionService resourceActionService;

   /**
     * 新增 资源操作
     * @param resourceAction
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/resourceaction", method = RequestMethod.POST)
    public Object addResourceAction(@RequestBody ResourceAction resourceAction) {
        try {
            String msg = "";

            if(resourceAction==null) {
                msg = "添加资源操作参数不正确";
            }else if(resourceAction.getResourceId() != null){
                msg = "资源操作所属资源id不能为空";
            }else if(StringUtils.isBlank(resourceAction.getName())){
                msg = "资源操作操作名称不能为空";
            }else if(resourceAction.getName().length() > 16){
                msg = "资源操作操作名称长度不可超过16";
            }else if(StringUtils.isBlank(resourceAction.getActionAlias())){
                msg = "资源操作操作标识不能为空";
            }else if(resourceAction.getActionAlias().length() > 16){
                msg = "资源操作操作标识长度不可超过16";
            }else if(resourceAction.getCreator() != null){
                msg = "资源操作创建人不能为空";
            }else if(resourceAction.getCreateDate() != null){
                msg = "资源操作创建时间不能为空";
            }else if(resourceAction.getLastModifier() != null){
                msg = "资源操作修改人不能为空";
            }else if(resourceAction.getLastModDate() != null){
                msg = "资源操作修改时间不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=resourceActionService.add(resourceAction);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(resourceAction.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源操作失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源操作异常");
        }
    }


    /**
     * 删除 资源操作
     *
     * @param {resourceActionId} 资源操作ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/resourceaction/{resourceActionId}" ,method = RequestMethod.DELETE)
    public Object delResourceAction(@PathVariable String resourceActionId) {
        try {
            if(StringUtils.isBlank(resourceActionId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源操作失败，参数不正确");
            }
            int row=resourceActionService.deleteByProperty("id", resourceActionId);
            if(row > 0) {
                return new StringWrapper( "删除资源操作成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源操作失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源操作异常");
        }
    }


    /**
     * 修改资源操作数据
     * @param resourceAction 提交上来的资源操作JSON数据
     * @param resourceActionId  资源操作ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/resourceaction/{resourceActionId}", method = RequestMethod.PATCH)
    public StringWrapper editResourceAction(@RequestBody ResourceAction resourceAction, @PathVariable String resourceActionId) {
        try {
            String msg = "";
            if(resourceAction==null) {
                msg = "添加资源操作参数不正确";
            }else if(resourceAction.getResourceId() != null){
                msg = "资源操作所属资源id不能为空";
            }else if(StringUtils.isBlank(resourceAction.getName())){
                msg = "资源操作操作名称不能为空";
            }else if(resourceAction.getName().length() > 16){
                msg = "资源操作操作名称长度不可超过16";
            }else if(StringUtils.isBlank(resourceAction.getActionAlias())){
                msg = "资源操作操作标识不能为空";
            }else if(resourceAction.getActionAlias().length() > 16){
                msg = "资源操作操作标识长度不可超过16";
            }else if(resourceAction.getCreator() != null){
                msg = "资源操作创建人不能为空";
            }else if(resourceAction.getCreateDate() != null){
                msg = "资源操作创建时间不能为空";
            }else if(resourceAction.getLastModifier() != null){
                msg = "资源操作修改人不能为空";
            }else if(resourceAction.getLastModDate() != null){
                msg = "资源操作修改时间不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            ResourceAction resourceAction_old = (ResourceAction) resourceActionService.findOne("id",resourceActionId);
            if(resourceAction==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(resourceAction.getId() != null){
                resourceAction_old.setId(resourceAction.getId());
            }
            if(resourceAction.getResourceId() != null){
                resourceAction_old.setResourceId(resourceAction.getResourceId());
            }
            if(!StringUtils.isBlank(resourceAction.getDivId())){
                resourceAction_old.setDivId(resourceAction.getDivId());
            }
            if(!StringUtils.isBlank(resourceAction.getActionScript())){
                resourceAction_old.setActionScript(resourceAction.getActionScript());
            }
            if(!StringUtils.isBlank(resourceAction.getName())){
                resourceAction_old.setName(resourceAction.getName());
            }
            if(!StringUtils.isBlank(resourceAction.getActionAlias())){
                resourceAction_old.setActionAlias(resourceAction.getActionAlias());
            }
            if(resourceAction.getCreator() != null){
                resourceAction_old.setCreator(resourceAction.getCreator());
            }
            if(resourceAction.getCreateDate() != null){
                resourceAction_old.setCreateDate(resourceAction.getCreateDate());
            }
            if(resourceAction.getLastModifier() != null){
                resourceAction_old.setLastModifier(resourceAction.getLastModifier());
            }
            if(resourceAction.getLastModDate() != null){
                resourceAction_old.setLastModDate(resourceAction.getLastModDate());
            }
            if(!StringUtils.isBlank(resourceAction.getDescription())){
                resourceAction_old.setDescription(resourceAction.getDescription());
            }


            int row=resourceActionService.edit(resourceAction_old);
            if(row > 0) {
                return new StringWrapper("修改资源操作成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源操作失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源操作数据异常");
        }
    }


    /**
     * 获取单资源操作实体
     *
     * @param resourceActionId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/resourceaction/{resourceActionId}", method = RequestMethod.GET)
    public ResourceAction getResourceAction(@PathVariable String resourceActionId) {
        try {
            if(StringUtils.isBlank(resourceActionId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", resourceActionId);
            ResourceAction resourceAction= (ResourceAction) resourceActionService.queryOne(whereParams);
            if(null == resourceAction){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源操作相关数据！");
            }
            return resourceAction;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单资源操作实体异常");
        }
    }


    /**
     * 资源操作数据输出 带分页
     *
     * @param resourceAction 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/resourceactionlist", method = RequestMethod.POST)
    public BizData4Page resourceActionlist(ResourceAction resourceAction, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(resourceAction.getId() != null){
                whereParams.put("id", new SearchField("id", "=", resourceAction.getId()));
            }
            if(resourceAction.getResourceId() != null){
                whereParams.put("resourceId", new SearchField("resourceId", "=", resourceAction.getResourceId()));
            }
            if(!StringUtils.isBlank(resourceAction.getDivId())){
                whereParams.put("divId", new SearchField("divId", "like", "%" + resourceAction.getDivId() + "%"));
            }
            if(!StringUtils.isBlank(resourceAction.getActionScript())){
                whereParams.put("actionScript", new SearchField("actionScript", "like", "%" + resourceAction.getActionScript() + "%"));
            }
            if(!StringUtils.isBlank(resourceAction.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + resourceAction.getName() + "%"));
            }
            if(!StringUtils.isBlank(resourceAction.getActionAlias())){
                whereParams.put("actionAlias", new SearchField("actionAlias", "like", "%" + resourceAction.getActionAlias() + "%"));
            }
            if(resourceAction.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", resourceAction.getCreator()));
            }
            if(resourceAction.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", resourceAction.getCreateDate()));
            }
            if(resourceAction.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", resourceAction.getLastModifier()));
            }
            if(resourceAction.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", resourceAction.getLastModDate()));
            }
            if(!StringUtils.isBlank(resourceAction.getDescription())){
                whereParams.put("description", new SearchField("description", "like", "%" + resourceAction.getDescription() + "%"));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            resourceActionService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源操作数据异常");
        }
    }
}
