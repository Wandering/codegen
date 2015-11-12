/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  RoleResourceController.java 2015-11-12 16:18:27 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IRoleResourceService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.RoleResource;
import cn.thinkjoy.common.managerui.service.IRoleResourceService;

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
public class apiRoleResourceController{
    private static final Logger logger = LoggerFactory.getLogger(apiRoleResourceController.class);

    @Autowired
    private IRoleResourceService roleResourceService;

   /**
     * 新增 角色资源
     * @param roleResource
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/roleresource", method = RequestMethod.POST)
    public Object addRoleResource(@RequestBody RoleResource roleResource) {
        try {
            String msg = "";

            if(roleResource==null) {
                msg = "添加角色资源参数不正确";
            }else if(roleResource.getCreator() != null){
                msg = "角色资源创建人不能为空";
            }else if(roleResource.getCreateDate() != null){
                msg = "角色资源创建时间不能为空";
            }else if(roleResource.getLastModifier() != null){
                msg = "角色资源修改人不能为空";
            }else if(roleResource.getLastModDate() != null){
                msg = "角色资源修改时间不能为空";
            }else if(roleResource.getStatus() != null){
                msg = "角色资源状态不能为空";
            }else if(roleResource.getResourceId() != null){
                msg = "角色资源资源id不能为空";
            }else if(roleResource.getResourceActionId() != null){
                msg = "角色资源功能按钮id不能为空";
            }else if(roleResource.getRoleId() != null){
                msg = "角色资源角色id不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=roleResourceService.add(roleResource);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(roleResource.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增角色资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增角色资源异常");
        }
    }


    /**
     * 删除 角色资源
     *
     * @param {roleResourceId} 角色资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleresource/{roleResourceId}" ,method = RequestMethod.DELETE)
    public Object delRoleResource(@PathVariable String roleResourceId) {
        try {
            if(StringUtils.isBlank(roleResourceId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除角色资源失败，参数不正确");
            }
            int row=roleResourceService.deleteByProperty("id", roleResourceId);
            if(row > 0) {
                return new StringWrapper( "删除角色资源成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除角色资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除角色资源异常");
        }
    }


    /**
     * 修改角色资源数据
     * @param roleResource 提交上来的角色资源JSON数据
     * @param roleResourceId  角色资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/roleresource/{roleResourceId}", method = RequestMethod.PATCH)
    public StringWrapper editRoleResource(@RequestBody RoleResource roleResource, @PathVariable String roleResourceId) {
        try {
            String msg = "";
            if(roleResource==null) {
                msg = "添加角色资源参数不正确";
            }else if(roleResource.getCreator() != null){
                msg = "角色资源创建人不能为空";
            }else if(roleResource.getCreateDate() != null){
                msg = "角色资源创建时间不能为空";
            }else if(roleResource.getLastModifier() != null){
                msg = "角色资源修改人不能为空";
            }else if(roleResource.getLastModDate() != null){
                msg = "角色资源修改时间不能为空";
            }else if(roleResource.getStatus() != null){
                msg = "角色资源状态不能为空";
            }else if(roleResource.getResourceId() != null){
                msg = "角色资源资源id不能为空";
            }else if(roleResource.getResourceActionId() != null){
                msg = "角色资源功能按钮id不能为空";
            }else if(roleResource.getRoleId() != null){
                msg = "角色资源角色id不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            RoleResource roleResource_old = (RoleResource) roleResourceService.findOne("id",roleResourceId);
            if(roleResource==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(roleResource.getId() != null){
                roleResource_old.setId(roleResource.getId());
            }
            if(roleResource.getCreator() != null){
                roleResource_old.setCreator(roleResource.getCreator());
            }
            if(roleResource.getCreateDate() != null){
                roleResource_old.setCreateDate(roleResource.getCreateDate());
            }
            if(roleResource.getLastModifier() != null){
                roleResource_old.setLastModifier(roleResource.getLastModifier());
            }
            if(roleResource.getLastModDate() != null){
                roleResource_old.setLastModDate(roleResource.getLastModDate());
            }
            if(roleResource.getStatus() != null){
                roleResource_old.setStatus(roleResource.getStatus());
            }
            if(roleResource.getResourceId() != null){
                roleResource_old.setResourceId(roleResource.getResourceId());
            }
            if(roleResource.getResourceActionId() != null){
                roleResource_old.setResourceActionId(roleResource.getResourceActionId());
            }
            if(roleResource.getRoleId() != null){
                roleResource_old.setRoleId(roleResource.getRoleId());
            }


            int row=roleResourceService.edit(roleResource_old);
            if(row > 0) {
                return new StringWrapper("修改角色资源成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改角色资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改角色资源数据异常");
        }
    }


    /**
     * 获取单角色资源实体
     *
     * @param roleResourceId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleresource/{roleResourceId}", method = RequestMethod.GET)
    public RoleResource getRoleResource(@PathVariable String roleResourceId) {
        try {
            if(StringUtils.isBlank(roleResourceId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", roleResourceId);
            RoleResource roleResource= (RoleResource) roleResourceService.queryOne(whereParams);
            if(null == roleResource){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到角色资源相关数据！");
            }
            return roleResource;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单角色资源实体异常");
        }
    }


    /**
     * 角色资源数据输出 带分页
     *
     * @param roleResource 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/roleresourcelist", method = RequestMethod.POST)
    public BizData4Page roleResourcelist(RoleResource roleResource, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(roleResource.getId() != null){
                whereParams.put("id", new SearchField("id", "=", roleResource.getId()));
            }
            if(roleResource.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", roleResource.getCreator()));
            }
            if(roleResource.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", roleResource.getCreateDate()));
            }
            if(roleResource.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", roleResource.getLastModifier()));
            }
            if(roleResource.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", roleResource.getLastModDate()));
            }
            if(roleResource.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", roleResource.getStatus()));
            }
            if(roleResource.getResourceId() != null){
                whereParams.put("resourceId", new SearchField("resourceId", "=", roleResource.getResourceId()));
            }
            if(roleResource.getResourceActionId() != null){
                whereParams.put("resourceActionId", new SearchField("resourceActionId", "=", roleResource.getResourceActionId()));
            }
            if(roleResource.getRoleId() != null){
                whereParams.put("roleId", new SearchField("roleId", "=", roleResource.getRoleId()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            roleResourceService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询角色资源数据异常");
        }
    }
}
