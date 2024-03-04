package com.ruoyi.health.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医院对象 b_hospital
 * 
 * @author da
 * @date 2024-03-04
 */
public class BHospital extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 删除标记0存在1删除 */
    private String delFlag;

    /** 修改人 */
    private String modifyBy;

    /** 修改时间 */
    private Date modifyTime;

    /** UUID */
    private String id;

    /** 医院名称 */
    @Excel(name = "医院名称")
    private String hospitalName;

    /** 医院地址 */
    @Excel(name = "医院地址")
    private String address;

    /** 大众对医院的热度 */
    @Excel(name = "大众对医院的热度")
    private BigDecimal herdTowardsEnthusiasm;

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
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setHospitalName(String hospitalName) 
    {
        this.hospitalName = hospitalName;
    }

    public String getHospitalName() 
    {
        return hospitalName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setHerdTowardsEnthusiasm(BigDecimal herdTowardsEnthusiasm) 
    {
        this.herdTowardsEnthusiasm = herdTowardsEnthusiasm;
    }

    public BigDecimal getHerdTowardsEnthusiasm() 
    {
        return herdTowardsEnthusiasm;
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
            .append("hospitalName", getHospitalName())
            .append("address", getAddress())
            .append("herdTowardsEnthusiasm", getHerdTowardsEnthusiasm())
            .toString();
    }
}
