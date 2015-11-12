/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: managerui-biz-startup
 * $Id:  DataModel2.java 2015-11-12 16:18:23 $
 */





package cn.thinkjoy.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.CreateBaseDomain;

import java.util.*;

public class DataModel2 extends CreateBaseDomain<Integer>{
    /** 优先级 */
    private Integer priority;
    /** 其对应的模型主体id */
    private Integer modelId;
    /** 分配的url */
    private String assignUrl;
    /** 追加数据权限的sql */
    private String whereSql;
    /** 按**维度设置 */
    private String name;

	public DataModel2(){
	}
    public void setPriority(Integer value) {
        this.priority = value;
    }

    public Integer getPriority() {
        return this.priority;
    }
    public void setModelId(Integer value) {
        this.modelId = value;
    }

    public Integer getModelId() {
        return this.modelId;
    }
    public void setAssignUrl(String value) {
        this.assignUrl = value;
    }

    public String getAssignUrl() {
        return this.assignUrl;
    }
    public void setWhereSql(String value) {
        this.whereSql = value;
    }

    public String getWhereSql() {
        return this.whereSql;
    }
    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Creator",getCreator())
			.append("CreateDate",getCreateDate())
			.append("LastModifier",getLastModifier())
			.append("LastModDate",getLastModDate())
			.append("Status",getStatus())
			.append("Priority",getPriority())
			.append("ModelId",getModelId())
			.append("AssignUrl",getAssignUrl())
			.append("WhereSql",getWhereSql())
			.append("Name",getName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof DataModel2 == false) return false;
		if(this == obj) return true;
		DataModel2 other = (DataModel2)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

