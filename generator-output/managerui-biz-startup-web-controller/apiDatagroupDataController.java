/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  DatagroupDataController.java 2015-11-12 16:18:26 $
 */

package cn.thinkjoy.controller.api;

import cn.thinkjoy.common.managerui.service.IDatagroupDataService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.util.StringUtil;

import cn.thinkjoy.domain.DatagroupData;
import cn.thinkjoy.common.managerui.service.IDatagroupDataService;

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
public class apiDatagroupDataController{
    private static final Logger logger = LoggerFactory.getLogger(apiDatagroupDataController.class);

    @Autowired
    private IDatagroupDataService datagroupDataService;

   /**
     * 新增 数据组数据
     * @param datagroupData
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/datagroupdata", method = RequestMethod.POST)
    public Object addDatagroupData(@RequestBody DatagroupData datagroupData) {
        try {
            String msg = "";

            if(datagroupData==null) {
                msg = "添加数据组数据参数不正确";
            }else if(datagroupData.getCreator() != null){
                msg = "数据组数据创建人不能为空";
            }else if(datagroupData.getCreateDate() != null){
                msg = "数据组数据创建时间不能为空";
            }else if(datagroupData.getLastModifier() != null){
                msg = "数据组数据修改人不能为空";
            }else if(datagroupData.getLastModDate() != null){
                msg = "数据组数据修改时间不能为空";
            }else if(datagroupData.getStatus() != null){
                msg = "数据组数据状态不能为空";
            }else if(datagroupData.getDataModelId() != null){
                msg = "数据组数据数据权限model id不能为空";
            }else if(datagroupData.getDataId() != null){
                msg = "数据组数据对应id不能为空";
            }else if(datagroupData.getGroupId() != null){
                msg = "数据组数据数据组id不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=datagroupDataService.add(datagroupData);
            if(row > 0) {
                return new StringWrapper( StringUtil.toString(datagroupData.getId()) );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增数据组数据失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增数据组数据异常");
        }
    }


    /**
     * 删除 数据组数据
     *
     * @param {datagroupDataId} 数据组数据ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/datagroupdata/{datagroupDataId}" ,method = RequestMethod.DELETE)
    public Object delDatagroupData(@PathVariable String datagroupDataId) {
        try {
            if(StringUtils.isBlank(datagroupDataId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据组数据失败，参数不正确");
            }
            int row=datagroupDataService.deleteByProperty("id", datagroupDataId);
            if(row > 0) {
                return new StringWrapper( "删除数据组数据成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据组数据失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除数据组数据异常");
        }
    }


    /**
     * 修改数据组数据数据
     * @param datagroupData 提交上来的数据组数据JSON数据
     * @param datagroupDataId  数据组数据ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/datagroupdata/{datagroupDataId}", method = RequestMethod.PATCH)
    public StringWrapper editDatagroupData(@RequestBody DatagroupData datagroupData, @PathVariable String datagroupDataId) {
        try {
            String msg = "";
            if(datagroupData==null) {
                msg = "添加数据组数据参数不正确";
            }else if(datagroupData.getCreator() != null){
                msg = "数据组数据创建人不能为空";
            }else if(datagroupData.getCreateDate() != null){
                msg = "数据组数据创建时间不能为空";
            }else if(datagroupData.getLastModifier() != null){
                msg = "数据组数据修改人不能为空";
            }else if(datagroupData.getLastModDate() != null){
                msg = "数据组数据修改时间不能为空";
            }else if(datagroupData.getStatus() != null){
                msg = "数据组数据状态不能为空";
            }else if(datagroupData.getDataModelId() != null){
                msg = "数据组数据数据权限model id不能为空";
            }else if(datagroupData.getDataId() != null){
                msg = "数据组数据对应id不能为空";
            }else if(datagroupData.getGroupId() != null){
                msg = "数据组数据数据组id不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            DatagroupData datagroupData_old = (DatagroupData) datagroupDataService.findOne("id",datagroupDataId);
            if(datagroupData==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(datagroupData.getId() != null){
                datagroupData_old.setId(datagroupData.getId());
            }
            if(datagroupData.getCreator() != null){
                datagroupData_old.setCreator(datagroupData.getCreator());
            }
            if(datagroupData.getCreateDate() != null){
                datagroupData_old.setCreateDate(datagroupData.getCreateDate());
            }
            if(datagroupData.getLastModifier() != null){
                datagroupData_old.setLastModifier(datagroupData.getLastModifier());
            }
            if(datagroupData.getLastModDate() != null){
                datagroupData_old.setLastModDate(datagroupData.getLastModDate());
            }
            if(datagroupData.getStatus() != null){
                datagroupData_old.setStatus(datagroupData.getStatus());
            }
            if(datagroupData.getDataModelId() != null){
                datagroupData_old.setDataModelId(datagroupData.getDataModelId());
            }
            if(datagroupData.getDataId() != null){
                datagroupData_old.setDataId(datagroupData.getDataId());
            }
            if(datagroupData.getGroupId() != null){
                datagroupData_old.setGroupId(datagroupData.getGroupId());
            }


            int row=datagroupDataService.edit(datagroupData_old);
            if(row > 0) {
                return new StringWrapper("修改数据组数据成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改数据组数据失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改数据组数据数据异常");
        }
    }


    /**
     * 获取单数据组数据实体
     *
     * @param datagroupDataId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/datagroupdata/{datagroupDataId}", method = RequestMethod.GET)
    public DatagroupData getDatagroupData(@PathVariable String datagroupDataId) {
        try {
            if(StringUtils.isBlank(datagroupDataId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", datagroupDataId);
            DatagroupData datagroupData= (DatagroupData) datagroupDataService.queryOne(whereParams);
            if(null == datagroupData){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到数据组数据相关数据！");
            }
            return datagroupData;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单数据组数据实体异常");
        }
    }


    /**
     * 数据组数据数据输出 带分页
     *
     * @param datagroupData 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/datagroupdatalist", method = RequestMethod.POST)
    public BizData4Page datagroupDatalist(DatagroupData datagroupData, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(datagroupData.getId() != null){
                whereParams.put("id", new SearchField("id", "=", datagroupData.getId()));
            }
            if(datagroupData.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", datagroupData.getCreator()));
            }
            if(datagroupData.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", datagroupData.getCreateDate()));
            }
            if(datagroupData.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", datagroupData.getLastModifier()));
            }
            if(datagroupData.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", datagroupData.getLastModDate()));
            }
            if(datagroupData.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", datagroupData.getStatus()));
            }
            if(datagroupData.getDataModelId() != null){
                whereParams.put("dataModelId", new SearchField("dataModelId", "=", datagroupData.getDataModelId()));
            }
            if(datagroupData.getDataId() != null){
                whereParams.put("dataId", new SearchField("dataId", "=", datagroupData.getDataId()));
            }
            if(datagroupData.getGroupId() != null){
                whereParams.put("groupId", new SearchField("groupId", "=", datagroupData.getGroupId()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            datagroupDataService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询数据组数据数据异常");
        }
    }
}
