<#assign className = table.classNameBo>
<#assign classNameLower = className?uncap_first>
<#assign classNameAllLower = table.classNameBo?lower_case>
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ${module}
 * $Id:  ${className}ServiceImpl.java ${now?string('yyyy-MM-dd HH:mm:ss')} $
 */
<#include "/macro.include"/>
package ${basepackage}.service.impl;

import cn.thinkjoy.common.domain.BaseDomain;
import ${basepackage}.BaseDAO;
import ${basepackage}.dao.${className}DAO;
import ${basepackage}.domain.${className};
import ${basepackage}.service.${className}Service;
import ${basepackage}.service.base.BizData4Page;
import ${basepackage}.service.base.impl.AbstractPageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("${className}ServiceImpl")
public class ${className}ServiceImpl extends AbstractPageService<${className}DAO, ${className}> implements ${className}Service {
    @Autowired
    private ${className}DAO ${classNameLower}DAO;

    @Override
    public void insert(BaseDomain entity) {

    }

    @Override
    public void update(BaseDomain entity) {

    }

    @Override
    public void updateNull(BaseDomain entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByProperty(String property, Object value) {

    }

    @Override
    public BaseDomain fetch(Long id) {
        return null;
    }

    @Override
    public BaseDomain findOne(@Param("property") String property, @Param("value") Object value) {
        return null;
    }

    @Override
    public List findList(String property, Object value) {
        return null;
    }

    @Override
    public void deleteByCondition(Map condition) {

    }

    @Override
    public void updateMap(@Param("map") Map entityMap) {

    }

    @Override
    public List<${className}> findAll() {
        return ${classNameLower}DAO.findAll();
    }

    @Override
    public List like(String property, Object value) {
        return null;
    }

    @Override
    public Long selectMaxId() {
        return null;
    }

    @Override
    public BaseDomain updateOrSave(BaseDomain baseDomain, Long id) {
        return null;
    }

    @Override
    public BaseDomain selectOne(String mapperId, Object obj) {
        return null;
    }

    @Override
    public List selectList(String mapperId, Object obj) {
        return null;
    }

    @Override
    public Class getEntityClass() {
        return null;
    }

    @Override
    public int count(Map condition) {
        return 0;
    }

    @Override
    public BaseDomain queryOne(Map condition) {
        return null;
    }

    @Override
    public List queryList(@Param("condition") Map condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy) {
        return null;
    }

    @Override
    public List queryPage(@Param("condition") Map condition, @Param("offset") int offset, @Param("rows") int rows) {
        return null;
    }

    @Override
    protected ${className}DAO getDao() {
        return ${classNameLower}DAO;
    }

    @Override
    public BizData4Page queryPageByDataPerm(String resUri, Map conditions, int curPage, int offset, int rows) {
        return super.doQueryPageByDataPerm(resUri, conditions, curPage, offset, rows);
    }


}
