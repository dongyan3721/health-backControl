package com.ruoyi.health.service;

import java.util.List;
import com.ruoyi.health.domain.BKv;

/**
 * 静态键值对Service接口
 * 
 * @author sa
 * @date 2024-03-04
 */
public interface IBKvService 
{
    /**
     * 查询静态键值对
     * 
     * @param id 静态键值对主键
     * @return 静态键值对
     */
    public BKv selectBKvById(Long id);

    /**
     * 查询静态键值对列表
     * 
     * @param bKv 静态键值对
     * @return 静态键值对集合
     */
    public List<BKv> selectBKvList(BKv bKv);

    /**
     * 新增静态键值对
     * 
     * @param bKv 静态键值对
     * @return 结果
     */
    public int insertBKv(BKv bKv);

    /**
     * 修改静态键值对
     * 
     * @param bKv 静态键值对
     * @return 结果
     */
    public int updateBKv(BKv bKv);

    /**
     * 批量删除静态键值对
     * 
     * @param ids 需要删除的静态键值对主键集合
     * @return 结果
     */
    public int deleteBKvByIds(Long[] ids);

    /**
     * 删除静态键值对信息
     * 
     * @param id 静态键值对主键
     * @return 结果
     */
    public int deleteBKvById(Long id);
}
