package com.ruoyi.health.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.health.domain.BKv;
import com.ruoyi.health.service.IBKvService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 静态键值对Controller
 * 
 * @author sa
 * @date 2024-03-04
 */
@RestController
@RequestMapping("/health/kv")
public class BKvController extends BaseController
{
    @Autowired
    private IBKvService bKvService;

    /**
     * 查询静态键值对列表
     */
    @PreAuthorize("@ss.hasPermi('health:kv:list')")
    @GetMapping("/list")
    public TableDataInfo list(BKv bKv)
    {
        startPage();
        List<BKv> list = bKvService.selectBKvList(bKv);
        return getDataTable(list);
    }

    /**
     * 导出静态键值对列表
     */
    @PreAuthorize("@ss.hasPermi('health:kv:export')")
    @Log(title = "静态键值对", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BKv bKv)
    {
        List<BKv> list = bKvService.selectBKvList(bKv);
        ExcelUtil<BKv> util = new ExcelUtil<BKv>(BKv.class);
        util.exportExcel(response, list, "静态键值对数据");
    }

    /**
     * 获取静态键值对详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:kv:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bKvService.selectBKvById(id));
    }

    /**
     * 新增静态键值对
     */
    @PreAuthorize("@ss.hasPermi('health:kv:add')")
    @Log(title = "静态键值对", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BKv bKv)
    {
        return toAjax(bKvService.insertBKv(bKv));
    }

    /**
     * 修改静态键值对
     */
    @PreAuthorize("@ss.hasPermi('health:kv:edit')")
    @Log(title = "静态键值对", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BKv bKv)
    {
        return toAjax(bKvService.updateBKv(bKv));
    }

    /**
     * 删除静态键值对
     */
    @PreAuthorize("@ss.hasPermi('health:kv:remove')")
    @Log(title = "静态键值对", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bKvService.deleteBKvByIds(ids));
    }
}
