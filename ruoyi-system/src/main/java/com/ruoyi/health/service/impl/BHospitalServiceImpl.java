package com.ruoyi.health.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.health.mapper.BHospitalMapper;
import com.ruoyi.health.domain.BHospital;
import com.ruoyi.health.service.IBHospitalService;

/**
 * 医院Service业务层处理
 * 
 * @author da
 * @date 2024-03-04
 */
@Service
public class BHospitalServiceImpl implements IBHospitalService 
{
    @Autowired
    private BHospitalMapper bHospitalMapper;

    /**
     * 查询医院
     * 
     * @param id 医院主键
     * @return 医院
     */
    @Override
    public BHospital selectBHospitalById(String id)
    {
        return bHospitalMapper.selectBHospitalById(id);
    }

    /**
     * 查询医院列表
     * 
     * @param bHospital 医院
     * @return 医院
     */
    @Override
    public List<BHospital> selectBHospitalList(BHospital bHospital)
    {
        return bHospitalMapper.selectBHospitalList(bHospital);
    }

    /**
     * 新增医院
     * 
     * @param bHospital 医院
     * @return 结果
     */
    @Override
    public int insertBHospital(BHospital bHospital)
    {
        bHospital.setCreateTime(DateUtils.getNowDate());
        return bHospitalMapper.insertBHospital(bHospital);
    }

    /**
     * 修改医院
     * 
     * @param bHospital 医院
     * @return 结果
     */
    @Override
    public int updateBHospital(BHospital bHospital)
    {
        return bHospitalMapper.updateBHospital(bHospital);
    }

    /**
     * 批量删除医院
     * 
     * @param ids 需要删除的医院主键
     * @return 结果
     */
    @Override
    public int deleteBHospitalByIds(String[] ids)
    {
        return bHospitalMapper.deleteBHospitalByIds(ids);
    }

    /**
     * 删除医院信息
     * 
     * @param id 医院主键
     * @return 结果
     */
    @Override
    public int deleteBHospitalById(String id)
    {
        return bHospitalMapper.deleteBHospitalById(id);
    }
}
