/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  RoleController.java 2015-11-12 16:18:27 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IRoleService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.Role;
import cn.thinkjoy.common.managerui.service.IRoleService;

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
public class apiRoleController{
    private static final Logger logger = LoggerFactory.getLogger(apiRoleController.class);

    @Autowired
    private IRoleService roleService;

   /**
     * 新增 角色
     * @param role
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public Object addRole(@RequestBody Role role) {
        try {
            String msg = "";

            if(role==null) {
                msg = "添加角色参数不正确";
            }else if(StringUtils.isBlank(role.getName())){
                msg = "角色角色名称不能为空";
            }else if(role.getName().length() > 32){
                msg = "角色角色名称长度不可超过32";
            }else if(role.getCreator() != null){
                msg = "角色创建人不能为空";
            }else if(role.getCreateDate() != null){
                msg = "角色创建时间不能为空";
            }else if(role.getLastModifier() != null){
                msg = "角色修改人不能为空";
            }else if(role.getLastModDate() != null){
                msg = "角色修改时间不能为空";
            }else if(StringUtils.isBlank(role.getDescription())){
                msg = "角色描述不能为空";
            }else if(role.getDescription().length() > 256){
                msg = "角色描述长度不可超过256";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=roleService.add(role);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(role.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增角色失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增角色异常");
        }
    }


    /**
     * 删除 角色
     *
     * @param {roleId} 角色ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/{roleId}" ,method = RequestMethod.DELETE)
    public Object delRole(@PathVariable String roleId) {
        try {
            if(StringUtils.isBlank(roleId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除角色失败，参数不正确");
            }
            int row=roleService.deleteByProperty("id", roleId);
            if(row > 0) {
                return new StringWrapper( "删除角色成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除角色失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除角色异常");
        }
    }


    /**
     * 修改角色数据
     * @param role 提交上来的角色JSON数据
     * @param roleId  角色ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/role/{roleId}", method = RequestMethod.PATCH)
    public StringWrapper editRole(@RequestBody Role role, @PathVariable String roleId) {
        try {
            String msg = "";
            if(role==null) {
                msg = "添加角色参数不正确";
            }else if(StringUtils.isBlank(role.getName())){
                msg = "角色角色名称不能为空";
            }else if(role.getName().length() > 32){
                msg = "角色角色名称长度不可超过32";
            }else if(role.getCreator() != null){
                msg = "角色创建人不能为空";
            }else if(role.getCreateDate() != null){
                msg = "角色创建时间不能为空";
            }else if(role.getLastModifier() != null){
                msg = "角色修改人不能为空";
            }else if(role.getLastModDate() != null){
                msg = "角色修改时间不能为空";
            }else if(StringUtils.isBlank(role.getDescription())){
                msg = "角色描述不能为空";
            }else if(role.getDescription().length() > 256){
                msg = "角色描述长度不可超过256";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Role role_old = (Role) roleService.findOne("id",roleId);
            if(role==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(role.getId() != null){
                role_old.setId(role.getId());
            }
            if(!StringUtils.isBlank(role.getName())){
                role_old.setName(role.getName());
            }
            if(role.getCreator() != null){
                role_old.setCreator(role.getCreator());
            }
            if(role.getCreateDate() != null){
                role_old.setCreateDate(role.getCreateDate());
            }
            if(role.getLastModifier() != null){
                role_old.setLastModifier(role.getLastModifier());
            }
            if(role.getLastModDate() != null){
                role_old.setLastModDate(role.getLastModDate());
            }
            if(!StringUtils.isBlank(role.getDescription())){
                role_old.setDescription(role.getDescription());
            }


            int row=roleService.edit(role_old);
            if(row > 0) {
                return new StringWrapper("修改角色成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改角色失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改角色数据异常");
        }
    }


    /**
     * 获取单角色实体
     *
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/{roleId}", method = RequestMethod.GET)
    public Role getRole(@PathVariable String roleId) {
        try {
            if(StringUtils.isBlank(roleId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", roleId);
            Role role= (Role) roleService.queryOne(whereParams);
            if(null == role){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到角色相关数据！");
            }
            return role;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单角色实体异常");
        }
    }


    /**
     * 角色数据输出 带分页
     *
     * @param role 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/rolelist", method = RequestMethod.POST)
    public BizData4Page rolelist(Role role, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(role.getId() != null){
                whereParams.put("id", new SearchField("id", "=", role.getId()));
            }
            if(!StringUtils.isBlank(role.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + role.getName() + "%"));
            }
            if(role.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", role.getCreator()));
            }
            if(role.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", role.getCreateDate()));
            }
            if(role.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", role.getLastModifier()));
            }
            if(role.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", role.getLastModDate()));
            }
            if(!StringUtils.isBlank(role.getDescription())){
                whereParams.put("description", new SearchField("description", "like", "%" + role.getDescription() + "%"));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            roleService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询角色数据异常");
        }
    }
}
