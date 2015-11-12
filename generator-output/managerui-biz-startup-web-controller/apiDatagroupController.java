/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  DatagroupController.java 2015-11-12 16:18:25 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IDatagroupService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.Datagroup;
import cn.thinkjoy.common.managerui.service.IDatagroupService;

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
public class apiDatagroupController{
    private static final Logger logger = LoggerFactory.getLogger(apiDatagroupController.class);

    @Autowired
    private IDatagroupService datagroupService;

   /**
     * 新增 数据组
     * @param datagroup
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/datagroup", method = RequestMethod.POST)
    public Object addDatagroup(@RequestBody Datagroup datagroup) {
        try {
            String msg = "";

            if(datagroup==null) {
                msg = "添加数据组参数不正确";
            }else if(StringUtils.isBlank(datagroup.getName())){
                msg = "数据组名称不能为空";
            }else if(datagroup.getName().length() > 16){
                msg = "数据组名称长度不可超过16";
            }else if(StringUtils.isBlank(datagroup.getNumber())){
                msg = "数据组编码不能为空";
            }else if(datagroup.getNumber().length() > 16){
                msg = "数据组编码长度不可超过16";
            }else if(StringUtils.isBlank(datagroup.getDescription())){
                msg = "数据组描述不能为空";
            }else if(datagroup.getDescription().length() > 64){
                msg = "数据组描述长度不可超过64";
            }else if(datagroup.getStatus() != null){
                msg = "数据组状态不能为空";
            }else if(datagroup.getCreator() != null){
                msg = "数据组创建人不能为空";
            }else if(datagroup.getCreateDate() != null){
                msg = "数据组创建时间不能为空";
            }else if(datagroup.getLastModifier() != null){
                msg = "数据组修改人不能为空";
            }else if(datagroup.getLastModDate() != null){
                msg = "数据组修改时间不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=datagroupService.add(datagroup);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(datagroup.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增数据组失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增数据组异常");
        }
    }


    /**
     * 删除 数据组
     *
     * @param {datagroupId} 数据组ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/datagroup/{datagroupId}" ,method = RequestMethod.DELETE)
    public Object delDatagroup(@PathVariable String datagroupId) {
        try {
            if(StringUtils.isBlank(datagroupId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据组失败，参数不正确");
            }
            int row=datagroupService.deleteByProperty("id", datagroupId);
            if(row > 0) {
                return new StringWrapper( "删除数据组成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据组失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据组异常");
        }
    }


    /**
     * 修改数据组数据
     * @param datagroup 提交上来的数据组JSON数据
     * @param datagroupId  数据组ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/datagroup/{datagroupId}", method = RequestMethod.PATCH)
    public StringWrapper editDatagroup(@RequestBody Datagroup datagroup, @PathVariable String datagroupId) {
        try {
            String msg = "";
            if(datagroup==null) {
                msg = "添加数据组参数不正确";
            }else if(StringUtils.isBlank(datagroup.getName())){
                msg = "数据组名称不能为空";
            }else if(datagroup.getName().length() > 16){
                msg = "数据组名称长度不可超过16";
            }else if(StringUtils.isBlank(datagroup.getNumber())){
                msg = "数据组编码不能为空";
            }else if(datagroup.getNumber().length() > 16){
                msg = "数据组编码长度不可超过16";
            }else if(StringUtils.isBlank(datagroup.getDescription())){
                msg = "数据组描述不能为空";
            }else if(datagroup.getDescription().length() > 64){
                msg = "数据组描述长度不可超过64";
            }else if(datagroup.getStatus() != null){
                msg = "数据组状态不能为空";
            }else if(datagroup.getCreator() != null){
                msg = "数据组创建人不能为空";
            }else if(datagroup.getCreateDate() != null){
                msg = "数据组创建时间不能为空";
            }else if(datagroup.getLastModifier() != null){
                msg = "数据组修改人不能为空";
            }else if(datagroup.getLastModDate() != null){
                msg = "数据组修改时间不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Datagroup datagroup_old = (Datagroup) datagroupService.findOne("id",datagroupId);
            if(datagroup==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(datagroup.getId() != null){
                datagroup_old.setId(datagroup.getId());
            }
            if(!StringUtils.isBlank(datagroup.getName())){
                datagroup_old.setName(datagroup.getName());
            }
            if(!StringUtils.isBlank(datagroup.getNumber())){
                datagroup_old.setNumber(datagroup.getNumber());
            }
            if(!StringUtils.isBlank(datagroup.getDescription())){
                datagroup_old.setDescription(datagroup.getDescription());
            }
            if(datagroup.getStatus() != null){
                datagroup_old.setStatus(datagroup.getStatus());
            }
            if(datagroup.getCreator() != null){
                datagroup_old.setCreator(datagroup.getCreator());
            }
            if(datagroup.getCreateDate() != null){
                datagroup_old.setCreateDate(datagroup.getCreateDate());
            }
            if(datagroup.getLastModifier() != null){
                datagroup_old.setLastModifier(datagroup.getLastModifier());
            }
            if(datagroup.getLastModDate() != null){
                datagroup_old.setLastModDate(datagroup.getLastModDate());
            }


            int row=datagroupService.edit(datagroup_old);
            if(row > 0) {
                return new StringWrapper("修改数据组成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改数据组失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改数据组数据异常");
        }
    }


    /**
     * 获取单数据组实体
     *
     * @param datagroupId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/datagroup/{datagroupId}", method = RequestMethod.GET)
    public Datagroup getDatagroup(@PathVariable String datagroupId) {
        try {
            if(StringUtils.isBlank(datagroupId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", datagroupId);
            Datagroup datagroup= (Datagroup) datagroupService.queryOne(whereParams);
            if(null == datagroup){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到数据组相关数据！");
            }
            return datagroup;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单数据组实体异常");
        }
    }


    /**
     * 数据组数据输出 带分页
     *
     * @param datagroup 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/datagrouplist", method = RequestMethod.POST)
    public BizData4Page datagrouplist(Datagroup datagroup, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(datagroup.getId() != null){
                whereParams.put("id", new SearchField("id", "=", datagroup.getId()));
            }
            if(!StringUtils.isBlank(datagroup.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + datagroup.getName() + "%"));
            }
            if(!StringUtils.isBlank(datagroup.getNumber())){
                whereParams.put("number", new SearchField("number", "like", "%" + datagroup.getNumber() + "%"));
            }
            if(!StringUtils.isBlank(datagroup.getDescription())){
                whereParams.put("description", new SearchField("description", "like", "%" + datagroup.getDescription() + "%"));
            }
            if(datagroup.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", datagroup.getStatus()));
            }
            if(datagroup.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", datagroup.getCreator()));
            }
            if(datagroup.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", datagroup.getCreateDate()));
            }
            if(datagroup.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", datagroup.getLastModifier()));
            }
            if(datagroup.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", datagroup.getLastModDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            datagroupService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询数据组数据异常");
        }
    }
}
