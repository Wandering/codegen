/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  ModelController.java 2015-11-12 16:18:26 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IModelService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.Model;
import cn.thinkjoy.common.managerui.service.IModelService;

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
public class apiModelController{
    private static final Logger logger = LoggerFactory.getLogger(apiModelController.class);

    @Autowired
    private IModelService modelService;

   /**
     * 新增 业务模型
     * @param model
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/model", method = RequestMethod.POST)
    public Object addModel(@RequestBody Model model) {
        try {
            String msg = "";

            if(model==null) {
                msg = "添加业务模型参数不正确";
            }else if(model.getCreator() != null){
                msg = "业务模型创建人不能为空";
            }else if(model.getCreateDate() != null){
                msg = "业务模型创建时间不能为空";
            }else if(model.getLastModifier() != null){
                msg = "业务模型修改人不能为空";
            }else if(model.getLastModDate() != null){
                msg = "业务模型修改时间不能为空";
            }else if(model.getStatus() != null){
                msg = "业务模型状态不能为空";
            }else if(StringUtils.isBlank(model.getName())){
                msg = "业务模型名称不能为空";
            }else if(model.getName().length() > 16){
                msg = "业务模型名称长度不可超过16";
            }else if(StringUtils.isBlank(model.getDescription())){
                msg = "业务模型描述不能为空";
            }else if(model.getDescription().length() > 64){
                msg = "业务模型描述长度不可超过64";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=modelService.add(model);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(model.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增业务模型失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增业务模型异常");
        }
    }


    /**
     * 删除 业务模型
     *
     * @param {modelId} 业务模型ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/model/{modelId}" ,method = RequestMethod.DELETE)
    public Object delModel(@PathVariable String modelId) {
        try {
            if(StringUtils.isBlank(modelId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除业务模型失败，参数不正确");
            }
            int row=modelService.deleteByProperty("id", modelId);
            if(row > 0) {
                return new StringWrapper( "删除业务模型成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除业务模型失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除业务模型异常");
        }
    }


    /**
     * 修改业务模型数据
     * @param model 提交上来的业务模型JSON数据
     * @param modelId  业务模型ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/model/{modelId}", method = RequestMethod.PATCH)
    public StringWrapper editModel(@RequestBody Model model, @PathVariable String modelId) {
        try {
            String msg = "";
            if(model==null) {
                msg = "添加业务模型参数不正确";
            }else if(model.getCreator() != null){
                msg = "业务模型创建人不能为空";
            }else if(model.getCreateDate() != null){
                msg = "业务模型创建时间不能为空";
            }else if(model.getLastModifier() != null){
                msg = "业务模型修改人不能为空";
            }else if(model.getLastModDate() != null){
                msg = "业务模型修改时间不能为空";
            }else if(model.getStatus() != null){
                msg = "业务模型状态不能为空";
            }else if(StringUtils.isBlank(model.getName())){
                msg = "业务模型名称不能为空";
            }else if(model.getName().length() > 16){
                msg = "业务模型名称长度不可超过16";
            }else if(StringUtils.isBlank(model.getDescription())){
                msg = "业务模型描述不能为空";
            }else if(model.getDescription().length() > 64){
                msg = "业务模型描述长度不可超过64";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Model model_old = (Model) modelService.findOne("id",modelId);
            if(model==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(model.getId() != null){
                model_old.setId(model.getId());
            }
            if(model.getCreator() != null){
                model_old.setCreator(model.getCreator());
            }
            if(model.getCreateDate() != null){
                model_old.setCreateDate(model.getCreateDate());
            }
            if(model.getLastModifier() != null){
                model_old.setLastModifier(model.getLastModifier());
            }
            if(model.getLastModDate() != null){
                model_old.setLastModDate(model.getLastModDate());
            }
            if(model.getStatus() != null){
                model_old.setStatus(model.getStatus());
            }
            if(!StringUtils.isBlank(model.getName())){
                model_old.setName(model.getName());
            }
            if(!StringUtils.isBlank(model.getTblName())){
                model_old.setTblName(model.getTblName());
            }
            if(!StringUtils.isBlank(model.getDescription())){
                model_old.setDescription(model.getDescription());
            }


            int row=modelService.edit(model_old);
            if(row > 0) {
                return new StringWrapper("修改业务模型成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改业务模型失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改业务模型数据异常");
        }
    }


    /**
     * 获取单业务模型实体
     *
     * @param modelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/model/{modelId}", method = RequestMethod.GET)
    public Model getModel(@PathVariable String modelId) {
        try {
            if(StringUtils.isBlank(modelId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", modelId);
            Model model= (Model) modelService.queryOne(whereParams);
            if(null == model){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到业务模型相关数据！");
            }
            return model;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单业务模型实体异常");
        }
    }


    /**
     * 业务模型数据输出 带分页
     *
     * @param model 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/modellist", method = RequestMethod.POST)
    public BizData4Page modellist(Model model, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(model.getId() != null){
                whereParams.put("id", new SearchField("id", "=", model.getId()));
            }
            if(model.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", model.getCreator()));
            }
            if(model.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", model.getCreateDate()));
            }
            if(model.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", model.getLastModifier()));
            }
            if(model.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", model.getLastModDate()));
            }
            if(model.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", model.getStatus()));
            }
            if(!StringUtils.isBlank(model.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + model.getName() + "%"));
            }
            if(!StringUtils.isBlank(model.getTblName())){
                whereParams.put("tblName", new SearchField("tblName", "like", "%" + model.getTblName() + "%"));
            }
            if(!StringUtils.isBlank(model.getDescription())){
                whereParams.put("description", new SearchField("description", "like", "%" + model.getDescription() + "%"));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            modelService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询业务模型数据异常");
        }
    }
}
