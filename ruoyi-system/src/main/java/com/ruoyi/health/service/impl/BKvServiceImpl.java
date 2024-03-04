package com.ruoyi.health.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.health.mapper.BKvMapper;
import com.ruoyi.health.domain.BKv;
import com.ruoyi.health.service.IBKvService;

/**
 * 静态键值对Service业务层处理
 * 
 * @author sa
 * @date 2024-03-04
 */
@Service
public class BKvServiceImpl implements IBKvService 
{
    @Autowired
    private BKvMapper bKvMapper;

    /**
     * 查询静态键值对
     * 
     * @param id 静态键值对主键
     * @return 静态键值对
     */
    @Override
    public BKv selectBKvById(Long id)
    {
        return bKvMapper.selectBKvById(id);
    }

    /**
     * 查询静态键值对列表
     * 
     * @param bKv 静态键值对
     * @return 静态键值对
     */
    @Override
    public List<BKv> selectBKvList(BKv bKv)
    {
        return bKvMapper.selectBKvList(bKv);
    }

    /**
     * 新增静态键值对
     * 
     * @param bKv 静态键值对
     * @return 结果
     */
    @Override
    public int insertBKv(BKv bKv)
    {
        bKv.setCreateTime(DateUtils.getNowDate());
        return bKvMapper.insertBKv(bKv);
    }

    /**
     * 修改静态键值对
     * 
     * @param bKv 静态键值对
     * @return 结果
     */
    @Override
    public int updateBKv(BKv bKv)
    {
        return bKvMapper.updateBKv(bKv);
    }

    /**
     * 批量删除静态键值对
     * 
     * @param ids 需要删除的静态键值对主键
     * @return 结果
     */
    @Override
    public int deleteBKvByIds(Long[] ids)
    {
        return bKvMapper.deleteBKvByIds(ids);
    }

    /**
     * 删除静态键值对信息
     * 
     * @param id 静态键值对主键
     * @return 结果
     */
    @Override
    public int deleteBKvById(Long id)
    {
        return bKvMapper.deleteBKvById(id);
    }
}
