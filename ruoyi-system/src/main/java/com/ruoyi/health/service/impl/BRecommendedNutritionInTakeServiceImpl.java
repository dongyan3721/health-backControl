package com.ruoyi.health.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.health.mapper.BRecommendedNutritionInTakeMapper;
import com.ruoyi.health.domain.BRecommendedNutritionInTake;
import com.ruoyi.health.service.IBRecommendedNutritionInTakeService;

/**
 * intakeService业务层处理
 * 
 * @author David Antilles
 * @date 2024-03-04
 */
@Service
public class BRecommendedNutritionInTakeServiceImpl implements IBRecommendedNutritionInTakeService 
{
    @Autowired
    private BRecommendedNutritionInTakeMapper bRecommendedNutritionInTakeMapper;

    /**
     * 查询intake
     * 
     * @param id intake主键
     * @return intake
     */
    @Override
    public BRecommendedNutritionInTake selectBRecommendedNutritionInTakeById(String id)
    {
        return bRecommendedNutritionInTakeMapper.selectBRecommendedNutritionInTakeById(id);
    }

    /**
     * 查询intake列表
     * 
     * @param bRecommendedNutritionInTake intake
     * @return intake
     */
    @Override
    public List<BRecommendedNutritionInTake> selectBRecommendedNutritionInTakeList(BRecommendedNutritionInTake bRecommendedNutritionInTake)
    {
        return bRecommendedNutritionInTakeMapper.selectBRecommendedNutritionInTakeList(bRecommendedNutritionInTake);
    }

    /**
     * 新增intake
     * 
     * @param bRecommendedNutritionInTake intake
     * @return 结果
     */
    @Override
    public int insertBRecommendedNutritionInTake(BRecommendedNutritionInTake bRecommendedNutritionInTake)
    {
        bRecommendedNutritionInTake.setCreateTime(DateUtils.getNowDate());
        return bRecommendedNutritionInTakeMapper.insertBRecommendedNutritionInTake(bRecommendedNutritionInTake);
    }

    /**
     * 修改intake
     * 
     * @param bRecommendedNutritionInTake intake
     * @return 结果
     */
    @Override
    public int updateBRecommendedNutritionInTake(BRecommendedNutritionInTake bRecommendedNutritionInTake)
    {
        return bRecommendedNutritionInTakeMapper.updateBRecommendedNutritionInTake(bRecommendedNutritionInTake);
    }

    /**
     * 批量删除intake
     * 
     * @param ids 需要删除的intake主键
     * @return 结果
     */
    @Override
    public int deleteBRecommendedNutritionInTakeByIds(String[] ids)
    {
        return bRecommendedNutritionInTakeMapper.deleteBRecommendedNutritionInTakeByIds(ids);
    }

    /**
     * 删除intake信息
     * 
     * @param id intake主键
     * @return 结果
     */
    @Override
    public int deleteBRecommendedNutritionInTakeById(String id)
    {
        return bRecommendedNutritionInTakeMapper.deleteBRecommendedNutritionInTakeById(id);
    }
}
