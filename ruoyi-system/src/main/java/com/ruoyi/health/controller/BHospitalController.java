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
import com.ruoyi.health.domain.BHospital;
import com.ruoyi.health.service.IBHospitalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医院Controller
 * 
 * @author da
 * @date 2024-03-04
 */
@RestController
@RequestMapping("/health/hospital")
public class BHospitalController extends BaseController
{
    @Autowired
    private IBHospitalService bHospitalService;

    /**
     * 查询医院列表
     */
    @PreAuthorize("@ss.hasPermi('health:hospital:list')")
    @GetMapping("/list")
    public TableDataInfo list(BHospital bHospital)
    {
        startPage();
        List<BHospital> list = bHospitalService.selectBHospitalList(bHospital);
        return getDataTable(list);
    }

    /**
     * 导出医院列表
     */
    @PreAuthorize("@ss.hasPermi('health:hospital:export')")
    @Log(title = "医院", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BHospital bHospital)
    {
        List<BHospital> list = bHospitalService.selectBHospitalList(bHospital);
        ExcelUtil<BHospital> util = new ExcelUtil<BHospital>(BHospital.class);
        util.exportExcel(response, list, "医院数据");
    }

    /**
     * 获取医院详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:hospital:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(bHospitalService.selectBHospitalById(id));
    }

    /**
     * 新增医院
     */
    @PreAuthorize("@ss.hasPermi('health:hospital:add')")
    @Log(title = "医院", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BHospital bHospital)
    {
        return toAjax(bHospitalService.insertBHospital(bHospital));
    }

    /**
     * 修改医院
     */
    @PreAuthorize("@ss.hasPermi('health:hospital:edit')")
    @Log(title = "医院", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BHospital bHospital)
    {
        return toAjax(bHospitalService.updateBHospital(bHospital));
    }

    /**
     * 删除医院
     */
    @PreAuthorize("@ss.hasPermi('health:hospital:remove')")
    @Log(title = "医院", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(bHospitalService.deleteBHospitalByIds(ids));
    }
}
