package com.ruoyi.health.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * intake对象 b_recommended_nutrition_in_take
 * 
 * @author David Antilles
 * @date 2024-03-04
 */
public class BRecommendedNutritionInTake extends BaseEntity
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

    /** 摄入项目 */
    @Excel(name = "摄入项目")
    private String inTakeCaseName;

    /** 建议摄入最小值 */
    @Excel(name = "建议摄入最小值")
    private BigDecimal recommendedLowerLimit;

    /** 建议摄入最大值 */
    @Excel(name = "建议摄入最大值")
    private BigDecimal recommendedUpperLimit;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String metric;

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
    public void setInTakeCaseName(String inTakeCaseName) 
    {
        this.inTakeCaseName = inTakeCaseName;
    }

    public String getInTakeCaseName() 
    {
        return inTakeCaseName;
    }
    public void setRecommendedLowerLimit(BigDecimal recommendedLowerLimit) 
    {
        this.recommendedLowerLimit = recommendedLowerLimit;
    }

    public BigDecimal getRecommendedLowerLimit() 
    {
        return recommendedLowerLimit;
    }
    public void setRecommendedUpperLimit(BigDecimal recommendedUpperLimit) 
    {
        this.recommendedUpperLimit = recommendedUpperLimit;
    }

    public BigDecimal getRecommendedUpperLimit() 
    {
        return recommendedUpperLimit;
    }
    public void setMetric(String metric) 
    {
        this.metric = metric;
    }

    public String getMetric() 
    {
        return metric;
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
            .append("inTakeCaseName", getInTakeCaseName())
            .append("recommendedLowerLimit", getRecommendedLowerLimit())
            .append("recommendedUpperLimit", getRecommendedUpperLimit())
            .append("metric", getMetric())
            .toString();
    }
}
