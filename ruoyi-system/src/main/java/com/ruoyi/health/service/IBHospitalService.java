package com.ruoyi.health.service;

import java.util.List;
import com.ruoyi.health.domain.BHospital;

/**
 * 医院Service接口
 * 
 * @author da
 * @date 2024-03-04
 */
public interface IBHospitalService 
{
    /**
     * 查询医院
     * 
     * @param id 医院主键
     * @return 医院
     */
    public BHospital selectBHospitalById(String id);

    /**
     * 查询医院列表
     * 
     * @param bHospital 医院
     * @return 医院集合
     */
    public List<BHospital> selectBHospitalList(BHospital bHospital);

    /**
     * 新增医院
     * 
     * @param bHospital 医院
     * @return 结果
     */
    public int insertBHospital(BHospital bHospital);

    /**
     * 修改医院
     * 
     * @param bHospital 医院
     * @return 结果
     */
    public int updateBHospital(BHospital bHospital);

    /**
     * 批量删除医院
     * 
     * @param ids 需要删除的医院主键集合
     * @return 结果
     */
    public int deleteBHospitalByIds(String[] ids);

    /**
     * 删除医院信息
     * 
     * @param id 医院主键
     * @return 结果
     */
    public int deleteBHospitalById(String id);
}
