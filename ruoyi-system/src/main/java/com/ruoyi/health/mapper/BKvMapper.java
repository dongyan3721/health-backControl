package com.ruoyi.health.mapper;

import java.util.List;
import com.ruoyi.health.domain.BKv;

/**
 * 静态键值对Mapper接口
 * 
 * @author sa
 * @date 2024-03-04
 */
public interface BKvMapper 
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
     * 删除静态键值对
     * 
     * @param id 静态键值对主键
     * @return 结果
     */
    public int deleteBKvById(Long id);

    /**
     * 批量删除静态键值对
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBKvByIds(Long[] ids);
}
