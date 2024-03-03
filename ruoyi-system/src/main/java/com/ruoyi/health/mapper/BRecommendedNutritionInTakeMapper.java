package com.ruoyi.health.mapper;

import java.util.List;
import com.ruoyi.health.domain.BRecommendedNutritionInTake;

/**
 * intakeMapper接口
 * 
 * @author David Antilles
 * @date 2024-03-04
 */
public interface BRecommendedNutritionInTakeMapper 
{
    /**
     * 查询intake
     * 
     * @param id intake主键
     * @return intake
     */
    public BRecommendedNutritionInTake selectBRecommendedNutritionInTakeById(String id);

    /**
     * 查询intake列表
     * 
     * @param bRecommendedNutritionInTake intake
     * @return intake集合
     */
    public List<BRecommendedNutritionInTake> selectBRecommendedNutritionInTakeList(BRecommendedNutritionInTake bRecommendedNutritionInTake);

    /**
     * 新增intake
     * 
     * @param bRecommendedNutritionInTake intake
     * @return 结果
     */
    public int insertBRecommendedNutritionInTake(BRecommendedNutritionInTake bRecommendedNutritionInTake);

    /**
     * 修改intake
     * 
     * @param bRecommendedNutritionInTake intake
     * @return 结果
     */
    public int updateBRecommendedNutritionInTake(BRecommendedNutritionInTake bRecommendedNutritionInTake);

    /**
     * 删除intake
     * 
     * @param id intake主键
     * @return 结果
     */
    public int deleteBRecommendedNutritionInTakeById(String id);

    /**
     * 批量删除intake
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBRecommendedNutritionInTakeByIds(String[] ids);
}
