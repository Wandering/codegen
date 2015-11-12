/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  UserDatagroupController.java 2015-11-12 16:18:27 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IUserDatagroupService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.UserDatagroup;
import cn.thinkjoy.common.managerui.service.IUserDatagroupService;

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
public class apiUserDatagroupController{
    private static final Logger logger = LoggerFactory.getLogger(apiUserDatagroupController.class);

    @Autowired
    private IUserDatagroupService userDatagroupService;

   /**
     * 新增 用户数据组
     * @param userDatagroup
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/userdatagroup", method = RequestMethod.POST)
    public Object addUserDatagroup(@RequestBody UserDatagroup userDatagroup) {
        try {
            String msg = "";

            if(userDatagroup==null) {
                msg = "添加用户数据组参数不正确";
            }else if(userDatagroup.getCreator() != null){
                msg = "用户数据组创建人不能为空";
            }else if(userDatagroup.getCreateDate() != null){
                msg = "用户数据组创建时间不能为空";
            }else if(userDatagroup.getLastModifier() != null){
                msg = "用户数据组修改人不能为空";
            }else if(userDatagroup.getLastModDate() != null){
                msg = "用户数据组修改时间不能为空";
            }else if(userDatagroup.getStatus() != null){
                msg = "用户数据组状态不能为空";
            }else if(userDatagroup.getDatagroupId() != null){
                msg = "用户数据组数据组id不能为空";
            }else if(userDatagroup.getUserId() != null){
                msg = "用户数据组用户id不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=userDatagroupService.add(userDatagroup);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(userDatagroup.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增用户数据组失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增用户数据组异常");
        }
    }


    /**
     * 删除 用户数据组
     *
     * @param {userDatagroupId} 用户数据组ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userdatagroup/{userDatagroupId}" ,method = RequestMethod.DELETE)
    public Object delUserDatagroup(@PathVariable String userDatagroupId) {
        try {
            if(StringUtils.isBlank(userDatagroupId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除用户数据组失败，参数不正确");
            }
            int row=userDatagroupService.deleteByProperty("id", userDatagroupId);
            if(row > 0) {
                return new StringWrapper( "删除用户数据组成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除用户数据组失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除用户数据组异常");
        }
    }


    /**
     * 修改用户数据组数据
     * @param userDatagroup 提交上来的用户数据组JSON数据
     * @param userDatagroupId  用户数据组ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/userdatagroup/{userDatagroupId}", method = RequestMethod.PATCH)
    public StringWrapper editUserDatagroup(@RequestBody UserDatagroup userDatagroup, @PathVariable String userDatagroupId) {
        try {
            String msg = "";
            if(userDatagroup==null) {
                msg = "添加用户数据组参数不正确";
            }else if(userDatagroup.getCreator() != null){
                msg = "用户数据组创建人不能为空";
            }else if(userDatagroup.getCreateDate() != null){
                msg = "用户数据组创建时间不能为空";
            }else if(userDatagroup.getLastModifier() != null){
                msg = "用户数据组修改人不能为空";
            }else if(userDatagroup.getLastModDate() != null){
                msg = "用户数据组修改时间不能为空";
            }else if(userDatagroup.getStatus() != null){
                msg = "用户数据组状态不能为空";
            }else if(userDatagroup.getDatagroupId() != null){
                msg = "用户数据组数据组id不能为空";
            }else if(userDatagroup.getUserId() != null){
                msg = "用户数据组用户id不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            UserDatagroup userDatagroup_old = (UserDatagroup) userDatagroupService.findOne("id",userDatagroupId);
            if(userDatagroup==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(userDatagroup.getId() != null){
                userDatagroup_old.setId(userDatagroup.getId());
            }
            if(userDatagroup.getCreator() != null){
                userDatagroup_old.setCreator(userDatagroup.getCreator());
            }
            if(userDatagroup.getCreateDate() != null){
                userDatagroup_old.setCreateDate(userDatagroup.getCreateDate());
            }
            if(userDatagroup.getLastModifier() != null){
                userDatagroup_old.setLastModifier(userDatagroup.getLastModifier());
            }
            if(userDatagroup.getLastModDate() != null){
                userDatagroup_old.setLastModDate(userDatagroup.getLastModDate());
            }
            if(userDatagroup.getStatus() != null){
                userDatagroup_old.setStatus(userDatagroup.getStatus());
            }
            if(userDatagroup.getDatagroupId() != null){
                userDatagroup_old.setDatagroupId(userDatagroup.getDatagroupId());
            }
            if(userDatagroup.getUserId() != null){
                userDatagroup_old.setUserId(userDatagroup.getUserId());
            }


            int row=userDatagroupService.edit(userDatagroup_old);
            if(row > 0) {
                return new StringWrapper("修改用户数据组成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改用户数据组失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改用户数据组数据异常");
        }
    }


    /**
     * 获取单用户数据组实体
     *
     * @param userDatagroupId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userdatagroup/{userDatagroupId}", method = RequestMethod.GET)
    public UserDatagroup getUserDatagroup(@PathVariable String userDatagroupId) {
        try {
            if(StringUtils.isBlank(userDatagroupId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", userDatagroupId);
            UserDatagroup userDatagroup= (UserDatagroup) userDatagroupService.queryOne(whereParams);
            if(null == userDatagroup){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到用户数据组相关数据！");
            }
            return userDatagroup;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单用户数据组实体异常");
        }
    }


    /**
     * 用户数据组数据输出 带分页
     *
     * @param userDatagroup 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/userdatagrouplist", method = RequestMethod.POST)
    public BizData4Page userDatagrouplist(UserDatagroup userDatagroup, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(userDatagroup.getId() != null){
                whereParams.put("id", new SearchField("id", "=", userDatagroup.getId()));
            }
            if(userDatagroup.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", userDatagroup.getCreator()));
            }
            if(userDatagroup.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", userDatagroup.getCreateDate()));
            }
            if(userDatagroup.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", userDatagroup.getLastModifier()));
            }
            if(userDatagroup.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", userDatagroup.getLastModDate()));
            }
            if(userDatagroup.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", userDatagroup.getStatus()));
            }
            if(userDatagroup.getDatagroupId() != null){
                whereParams.put("datagroupId", new SearchField("datagroupId", "=", userDatagroup.getDatagroupId()));
            }
            if(userDatagroup.getUserId() != null){
                whereParams.put("userId", new SearchField("userId", "=", userDatagroup.getUserId()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            userDatagroupService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询用户数据组数据异常");
        }
    }
}
