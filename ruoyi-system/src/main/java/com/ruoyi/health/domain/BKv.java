package com.ruoyi.health.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 静态键值对对象 b_kv
 * 
 * @author sa
 * @date 2024-03-04
 */
public class BKv extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 删除标记0存在1删除 */
    private String delFlag;

    /** 修改人 */
    private String modifyBy;

    /** 修改时间 */
    private Date modifyTime;

    /** $column.columnComment */
    private Long id;

    /** 标签 */
    @Excel(name = "标签")
    private String label;

    /** 键，数字 */
    @Excel(name = "键，数字")
    private String key;

    /** 值，数字代表的含义 */
    @Excel(name = "值，数字代表的含义")
    private String value;

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setModifyBy(String modifyBy) 
    {
        this.modifyBy = modifyBy;
    }

    public String getModifyBy() 
    {
        return modifyBy;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLabel(String label) 
    {
        this.label = label;
    }

    public String getLabel() 
    {
        return label;
    }
    public void setKey(String key) 
    {
        this.key = key;
    }

    public String getKey() 
    {
        return key;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("modifyBy", getModifyBy())
            .append("modifyTime", getModifyTime())
            .append("remark", getRemark())
            .append("id", getId())
            .append("label", getLabel())
            .append("key", getKey())
            .append("value", getValue())
            .toString();
    }
}
