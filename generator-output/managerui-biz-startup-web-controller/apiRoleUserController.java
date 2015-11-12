/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  RoleUserController.java 2015-11-12 16:18:27 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IRoleUserService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.RoleUser;
import cn.thinkjoy.common.managerui.service.IRoleUserService;

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
public class apiRoleUserController{
    private static final Logger logger = LoggerFactory.getLogger(apiRoleUserController.class);

    @Autowired
    private IRoleUserService roleUserService;

   /**
     * 新增 用户角色
     * @param roleUser
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/roleuser", method = RequestMethod.POST)
    public Object addRoleUser(@RequestBody RoleUser roleUser) {
        try {
            String msg = "";

            if(roleUser==null) {
                msg = "添加用户角色参数不正确";
            }else if(roleUser.getCreator() != null){
                msg = "用户角色创建人不能为空";
            }else if(roleUser.getCreateDate() != null){
                msg = "用户角色创建时间不能为空";
            }else if(roleUser.getLastModifier() != null){
                msg = "用户角色修改人不能为空";
            }else if(roleUser.getLastModDate() != null){
                msg = "用户角色修改时间不能为空";
            }else if(roleUser.getStatus() != null){
                msg = "用户角色状态不能为空";
            }else if(roleUser.getUserId() != null){
                msg = "用户角色用户id不能为空";
            }else if(roleUser.getRoleId() != null){
                msg = "用户角色角色id不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=roleUserService.add(roleUser);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(roleUser.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增用户角色失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增用户角色异常");
        }
    }


    /**
     * 删除 用户角色
     *
     * @param {roleUserId} 用户角色ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleuser/{roleUserId}" ,method = RequestMethod.DELETE)
    public Object delRoleUser(@PathVariable String roleUserId) {
        try {
            if(StringUtils.isBlank(roleUserId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除用户角色失败，参数不正确");
            }
            int row=roleUserService.deleteByProperty("id", roleUserId);
            if(row > 0) {
                return new StringWrapper( "删除用户角色成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除用户角色失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除用户角色异常");
        }
    }


    /**
     * 修改用户角色数据
     * @param roleUser 提交上来的用户角色JSON数据
     * @param roleUserId  用户角色ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/roleuser/{roleUserId}", method = RequestMethod.PATCH)
    public StringWrapper editRoleUser(@RequestBody RoleUser roleUser, @PathVariable String roleUserId) {
        try {
            String msg = "";
            if(roleUser==null) {
                msg = "添加用户角色参数不正确";
            }else if(roleUser.getCreator() != null){
                msg = "用户角色创建人不能为空";
            }else if(roleUser.getCreateDate() != null){
                msg = "用户角色创建时间不能为空";
            }else if(roleUser.getLastModifier() != null){
                msg = "用户角色修改人不能为空";
            }else if(roleUser.getLastModDate() != null){
                msg = "用户角色修改时间不能为空";
            }else if(roleUser.getStatus() != null){
                msg = "用户角色状态不能为空";
            }else if(roleUser.getUserId() != null){
                msg = "用户角色用户id不能为空";
            }else if(roleUser.getRoleId() != null){
                msg = "用户角色角色id不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            RoleUser roleUser_old = (RoleUser) roleUserService.findOne("id",roleUserId);
            if(roleUser==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(roleUser.getId() != null){
                roleUser_old.setId(roleUser.getId());
            }
            if(roleUser.getCreator() != null){
                roleUser_old.setCreator(roleUser.getCreator());
            }
            if(roleUser.getCreateDate() != null){
                roleUser_old.setCreateDate(roleUser.getCreateDate());
            }
            if(roleUser.getLastModifier() != null){
                roleUser_old.setLastModifier(roleUser.getLastModifier());
            }
            if(roleUser.getLastModDate() != null){
                roleUser_old.setLastModDate(roleUser.getLastModDate());
            }
            if(roleUser.getStatus() != null){
                roleUser_old.setStatus(roleUser.getStatus());
            }
            if(roleUser.getUserId() != null){
                roleUser_old.setUserId(roleUser.getUserId());
            }
            if(roleUser.getRoleId() != null){
                roleUser_old.setRoleId(roleUser.getRoleId());
            }


            int row=roleUserService.edit(roleUser_old);
            if(row > 0) {
                return new StringWrapper("修改用户角色成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改用户角色失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改用户角色数据异常");
        }
    }


    /**
     * 获取单用户角色实体
     *
     * @param roleUserId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleuser/{roleUserId}", method = RequestMethod.GET)
    public RoleUser getRoleUser(@PathVariable String roleUserId) {
        try {
            if(StringUtils.isBlank(roleUserId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", roleUserId);
            RoleUser roleUser= (RoleUser) roleUserService.queryOne(whereParams);
            if(null == roleUser){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到用户角色相关数据！");
            }
            return roleUser;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单用户角色实体异常");
        }
    }


    /**
     * 用户角色数据输出 带分页
     *
     * @param roleUser 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/roleuserlist", method = RequestMethod.POST)
    public BizData4Page roleUserlist(RoleUser roleUser, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(roleUser.getId() != null){
                whereParams.put("id", new SearchField("id", "=", roleUser.getId()));
            }
            if(roleUser.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", roleUser.getCreator()));
            }
            if(roleUser.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", roleUser.getCreateDate()));
            }
            if(roleUser.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", roleUser.getLastModifier()));
            }
            if(roleUser.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", roleUser.getLastModDate()));
            }
            if(roleUser.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", roleUser.getStatus()));
            }
            if(roleUser.getUserId() != null){
                whereParams.put("userId", new SearchField("userId", "=", roleUser.getUserId()));
            }
            if(roleUser.getRoleId() != null){
                whereParams.put("roleId", new SearchField("roleId", "=", roleUser.getRoleId()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            roleUserService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询用户角色数据异常");
        }
    }
}
