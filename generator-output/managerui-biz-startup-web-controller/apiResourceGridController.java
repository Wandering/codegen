/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  ResourceGridController.java 2015-11-12 16:18:26 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IResourceGridService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.ResourceGrid;
import cn.thinkjoy.common.managerui.service.IResourceGridService;

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
public class apiResourceGridController{
    private static final Logger logger = LoggerFactory.getLogger(apiResourceGridController.class);

    @Autowired
    private IResourceGridService resourceGridService;

   /**
     * 新增 资源grid
     * @param resourceGrid
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/resourcegrid", method = RequestMethod.POST)
    public Object addResourceGrid(@RequestBody ResourceGrid resourceGrid) {
        try {
            String msg = "";

            if(resourceGrid==null) {
                msg = "添加资源grid参数不正确";
            }else if(resourceGrid.getCreator() != null){
                msg = "资源grid创建人不能为空";
            }else if(resourceGrid.getCreateDate() != null){
                msg = "资源grid创建时间不能为空";
            }else if(resourceGrid.getLastModifier() != null){
                msg = "资源grid修改人不能为空";
            }else if(resourceGrid.getLastModDate() != null){
                msg = "资源grid修改时间不能为空";
            }else if(resourceGrid.getStatus() != null){
                msg = "资源grid状态不能为空";
            }else if(resourceGrid.getResId() != null){
                msg = "资源grid资源id不能为空";
            }else if(StringUtils.isBlank(resourceGrid.getDisplayName())){
                msg = "资源grid 显示名称不能为空";
            }else if(resourceGrid.getDisplayName().length() > 32){
                msg = "资源grid 显示名称长度不可超过32";
            }else if(StringUtils.isBlank(resourceGrid.getColId())){
                msg = "资源gridgrid列id不能为空";
            }else if(resourceGrid.getColId().length() > 32){
                msg = "资源gridgrid列id长度不可超过32";
            }else if(resourceGrid.getOrderNum() != null){
                msg = "资源grid顺序号不能为空";
            }else if(resourceGrid.getWidth() != null){
                msg = "资源grid显示的宽度不能为空";
            }else if(StringUtils.isBlank(resourceGrid.getEditable())){
                msg = "资源grid是否可编辑|false,编辑页面不显示不能为空";
            }else if(resourceGrid.getEditable().length() > 8){
                msg = "资源grid是否可编辑|false,编辑页面不显示长度不可超过8";
            }else if(StringUtils.isBlank(resourceGrid.getEditoptions())){
                msg = "资源gridjson不能为空";
            }else if(resourceGrid.getEditoptions().length() > 256){
                msg = "资源gridjson长度不可超过256";
            }else if(StringUtils.isBlank(resourceGrid.getEditrules())){
                msg = "资源grid校验规则|提交到服务器前的有效性校验不能为空";
            }else if(resourceGrid.getEditrules().length() > 256){
                msg = "资源grid校验规则|提交到服务器前的有效性校验长度不可超过256";
            }else if(StringUtils.isBlank(resourceGrid.getDescription())){
                msg = "资源grid描述不能为空";
            }else if(resourceGrid.getDescription().length() > 64){
                msg = "资源grid描述长度不可超过64";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=resourceGridService.add(resourceGrid);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(resourceGrid.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源grid失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源grid异常");
        }
    }


    /**
     * 删除 资源grid
     *
     * @param {resourceGridId} 资源gridID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/resourcegrid/{resourceGridId}" ,method = RequestMethod.DELETE)
    public Object delResourceGrid(@PathVariable String resourceGridId) {
        try {
            if(StringUtils.isBlank(resourceGridId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源grid失败，参数不正确");
            }
            int row=resourceGridService.deleteByProperty("id", resourceGridId);
            if(row > 0) {
                return new StringWrapper( "删除资源grid成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源grid失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源grid异常");
        }
    }


    /**
     * 修改资源grid数据
     * @param resourceGrid 提交上来的资源gridJSON数据
     * @param resourceGridId  资源gridID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/resourcegrid/{resourceGridId}", method = RequestMethod.PATCH)
    public StringWrapper editResourceGrid(@RequestBody ResourceGrid resourceGrid, @PathVariable String resourceGridId) {
        try {
            String msg = "";
            if(resourceGrid==null) {
                msg = "添加资源grid参数不正确";
            }else if(resourceGrid.getCreator() != null){
                msg = "资源grid创建人不能为空";
            }else if(resourceGrid.getCreateDate() != null){
                msg = "资源grid创建时间不能为空";
            }else if(resourceGrid.getLastModifier() != null){
                msg = "资源grid修改人不能为空";
            }else if(resourceGrid.getLastModDate() != null){
                msg = "资源grid修改时间不能为空";
            }else if(resourceGrid.getStatus() != null){
                msg = "资源grid状态不能为空";
            }else if(resourceGrid.getResId() != null){
                msg = "资源grid资源id不能为空";
            }else if(StringUtils.isBlank(resourceGrid.getDisplayName())){
                msg = "资源grid 显示名称不能为空";
            }else if(resourceGrid.getDisplayName().length() > 32){
                msg = "资源grid 显示名称长度不可超过32";
            }else if(StringUtils.isBlank(resourceGrid.getColId())){
                msg = "资源gridgrid列id不能为空";
            }else if(resourceGrid.getColId().length() > 32){
                msg = "资源gridgrid列id长度不可超过32";
            }else if(resourceGrid.getOrderNum() != null){
                msg = "资源grid顺序号不能为空";
            }else if(resourceGrid.getWidth() != null){
                msg = "资源grid显示的宽度不能为空";
            }else if(StringUtils.isBlank(resourceGrid.getEditable())){
                msg = "资源grid是否可编辑|false,编辑页面不显示不能为空";
            }else if(resourceGrid.getEditable().length() > 8){
                msg = "资源grid是否可编辑|false,编辑页面不显示长度不可超过8";
            }else if(StringUtils.isBlank(resourceGrid.getEditoptions())){
                msg = "资源gridjson不能为空";
            }else if(resourceGrid.getEditoptions().length() > 256){
                msg = "资源gridjson长度不可超过256";
            }else if(StringUtils.isBlank(resourceGrid.getEditrules())){
                msg = "资源grid校验规则|提交到服务器前的有效性校验不能为空";
            }else if(resourceGrid.getEditrules().length() > 256){
                msg = "资源grid校验规则|提交到服务器前的有效性校验长度不可超过256";
            }else if(StringUtils.isBlank(resourceGrid.getDescription())){
                msg = "资源grid描述不能为空";
            }else if(resourceGrid.getDescription().length() > 64){
                msg = "资源grid描述长度不可超过64";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            ResourceGrid resourceGrid_old = (ResourceGrid) resourceGridService.findOne("id",resourceGridId);
            if(resourceGrid==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(resourceGrid.getId() != null){
                resourceGrid_old.setId(resourceGrid.getId());
            }
            if(resourceGrid.getCreator() != null){
                resourceGrid_old.setCreator(resourceGrid.getCreator());
            }
            if(resourceGrid.getCreateDate() != null){
                resourceGrid_old.setCreateDate(resourceGrid.getCreateDate());
            }
            if(resourceGrid.getLastModifier() != null){
                resourceGrid_old.setLastModifier(resourceGrid.getLastModifier());
            }
            if(resourceGrid.getLastModDate() != null){
                resourceGrid_old.setLastModDate(resourceGrid.getLastModDate());
            }
            if(resourceGrid.getStatus() != null){
                resourceGrid_old.setStatus(resourceGrid.getStatus());
            }
            if(resourceGrid.getResId() != null){
                resourceGrid_old.setResId(resourceGrid.getResId());
            }
            if(!StringUtils.isBlank(resourceGrid.getDisplayName())){
                resourceGrid_old.setDisplayName(resourceGrid.getDisplayName());
            }
            if(!StringUtils.isBlank(resourceGrid.getColId())){
                resourceGrid_old.setColId(resourceGrid.getColId());
            }
            if(resourceGrid.getOrderNum() != null){
                resourceGrid_old.setOrderNum(resourceGrid.getOrderNum());
            }
            if(resourceGrid.getWidth() != null){
                resourceGrid_old.setWidth(resourceGrid.getWidth());
            }
            if(!StringUtils.isBlank(resourceGrid.getEdittype())){
                resourceGrid_old.setEdittype(resourceGrid.getEdittype());
            }
            if(!StringUtils.isBlank(resourceGrid.getEditable())){
                resourceGrid_old.setEditable(resourceGrid.getEditable());
            }
            if(!StringUtils.isBlank(resourceGrid.getEditoptions())){
                resourceGrid_old.setEditoptions(resourceGrid.getEditoptions());
            }
            if(!StringUtils.isBlank(resourceGrid.getEditrules())){
                resourceGrid_old.setEditrules(resourceGrid.getEditrules());
            }
            if(!StringUtils.isBlank(resourceGrid.getFormatter())){
                resourceGrid_old.setFormatter(resourceGrid.getFormatter());
            }
            if(!StringUtils.isBlank(resourceGrid.getFormatoptions())){
                resourceGrid_old.setFormatoptions(resourceGrid.getFormatoptions());
            }
            if(!StringUtils.isBlank(resourceGrid.getUnformat())){
                resourceGrid_old.setUnformat(resourceGrid.getUnformat());
            }
            if(resourceGrid.getHide() != null){
                resourceGrid_old.setHide(resourceGrid.getHide());
            }
            if(resourceGrid.getUnedit() != null){
                resourceGrid_old.setUnedit(resourceGrid.getUnedit());
            }
            if(!StringUtils.isBlank(resourceGrid.getDescription())){
                resourceGrid_old.setDescription(resourceGrid.getDescription());
            }
            if(!StringUtils.isBlank(resourceGrid.getModuleName())){
                resourceGrid_old.setModuleName(resourceGrid.getModuleName());
            }


            int row=resourceGridService.edit(resourceGrid_old);
            if(row > 0) {
                return new StringWrapper("修改资源grid成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源grid失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源grid数据异常");
        }
    }


    /**
     * 获取单资源grid实体
     *
     * @param resourceGridId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/resourcegrid/{resourceGridId}", method = RequestMethod.GET)
    public ResourceGrid getResourceGrid(@PathVariable String resourceGridId) {
        try {
            if(StringUtils.isBlank(resourceGridId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", resourceGridId);
            ResourceGrid resourceGrid= (ResourceGrid) resourceGridService.queryOne(whereParams);
            if(null == resourceGrid){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源grid相关数据！");
            }
            return resourceGrid;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单资源grid实体异常");
        }
    }


    /**
     * 资源grid数据输出 带分页
     *
     * @param resourceGrid 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/resourcegridlist", method = RequestMethod.POST)
    public BizData4Page resourceGridlist(ResourceGrid resourceGrid, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(resourceGrid.getId() != null){
                whereParams.put("id", new SearchField("id", "=", resourceGrid.getId()));
            }
            if(resourceGrid.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", resourceGrid.getCreator()));
            }
            if(resourceGrid.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", resourceGrid.getCreateDate()));
            }
            if(resourceGrid.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", resourceGrid.getLastModifier()));
            }
            if(resourceGrid.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", resourceGrid.getLastModDate()));
            }
            if(resourceGrid.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", resourceGrid.getStatus()));
            }
            if(resourceGrid.getResId() != null){
                whereParams.put("resId", new SearchField("resId", "=", resourceGrid.getResId()));
            }
            if(!StringUtils.isBlank(resourceGrid.getDisplayName())){
                whereParams.put("displayName", new SearchField("displayName", "like", "%" + resourceGrid.getDisplayName() + "%"));
            }
            if(!StringUtils.isBlank(resourceGrid.getColId())){
                whereParams.put("colId", new SearchField("colId", "like", "%" + resourceGrid.getColId() + "%"));
            }
            if(resourceGrid.getOrderNum() != null){
                whereParams.put("orderNum", new SearchField("orderNum", "=", resourceGrid.getOrderNum()));
            }
            if(resourceGrid.getWidth() != null){
                whereParams.put("width", new SearchField("width", "=", resourceGrid.getWidth()));
            }
            if(!StringUtils.isBlank(resourceGrid.getEdittype())){
                whereParams.put("edittype", new SearchField("edittype", "like", "%" + resourceGrid.getEdittype() + "%"));
            }
            if(!StringUtils.isBlank(resourceGrid.getEditable())){
                whereParams.put("editable", new SearchField("editable", "like", "%" + resourceGrid.getEditable() + "%"));
            }
            if(!StringUtils.isBlank(resourceGrid.getEditoptions())){
                whereParams.put("editoptions", new SearchField("editoptions", "like", "%" + resourceGrid.getEditoptions() + "%"));
            }
            if(!StringUtils.isBlank(resourceGrid.getEditrules())){
                whereParams.put("editrules", new SearchField("editrules", "like", "%" + resourceGrid.getEditrules() + "%"));
            }
            if(!StringUtils.isBlank(resourceGrid.getFormatter())){
                whereParams.put("formatter", new SearchField("formatter", "like", "%" + resourceGrid.getFormatter() + "%"));
            }
            if(!StringUtils.isBlank(resourceGrid.getFormatoptions())){
                whereParams.put("formatoptions", new SearchField("formatoptions", "like", "%" + resourceGrid.getFormatoptions() + "%"));
            }
            if(!StringUtils.isBlank(resourceGrid.getUnformat())){
                whereParams.put("unformat", new SearchField("unformat", "like", "%" + resourceGrid.getUnformat() + "%"));
            }
            if(resourceGrid.getHide() != null){
                whereParams.put("hide", new SearchField("hide", "=", resourceGrid.getHide()));
            }
            if(resourceGrid.getUnedit() != null){
                whereParams.put("unedit", new SearchField("unedit", "=", resourceGrid.getUnedit()));
            }
            if(!StringUtils.isBlank(resourceGrid.getDescription())){
                whereParams.put("description", new SearchField("description", "like", "%" + resourceGrid.getDescription() + "%"));
            }
            if(!StringUtils.isBlank(resourceGrid.getModuleName())){
                whereParams.put("moduleName", new SearchField("moduleName", "like", "%" + resourceGrid.getModuleName() + "%"));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            resourceGridService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源grid数据异常");
        }
    }
}
