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
import com.ruoyi.health.domain.BRecommendedNutritionInTake;
import com.ruoyi.health.service.IBRecommendedNutritionInTakeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * intakeController
 * 
 * @author David Antilles
 * @date 2024-03-04
 */
@RestController
@RequestMapping("/health/intake")
public class BRecommendedNutritionInTakeController extends BaseController
{
    @Autowired
    private IBRecommendedNutritionInTakeService bRecommendedNutritionInTakeService;

    /**
     * 查询intake列表
     */
    @PreAuthorize("@ss.hasPermi('health:intake:list')")
    @GetMapping("/list")
    public TableDataInfo list(BRecommendedNutritionInTake bRecommendedNutritionInTake)
    {
        startPage();
        List<BRecommendedNutritionInTake> list = bRecommendedNutritionInTakeService.selectBRecommendedNutritionInTakeList(bRecommendedNutritionInTake);
        return getDataTable(list);
    }

    /**
     * 导出intake列表
     */
    @PreAuthorize("@ss.hasPermi('health:intake:export')")
    @Log(title = "intake", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BRecommendedNutritionInTake bRecommendedNutritionInTake)
    {
        List<BRecommendedNutritionInTake> list = bRecommendedNutritionInTakeService.selectBRecommendedNutritionInTakeList(bRecommendedNutritionInTake);
        ExcelUtil<BRecommendedNutritionInTake> util = new ExcelUtil<BRecommendedNutritionInTake>(BRecommendedNutritionInTake.class);
        util.exportExcel(response, list, "intake数据");
    }

    /**
     * 获取intake详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:intake:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(bRecommendedNutritionInTakeService.selectBRecommendedNutritionInTakeById(id));
    }

    /**
     * 新增intake
     */
    @PreAuthorize("@ss.hasPermi('health:intake:add')")
    @Log(title = "intake", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BRecommendedNutritionInTake bRecommendedNutritionInTake)
    {
        return toAjax(bRecommendedNutritionInTakeService.insertBRecommendedNutritionInTake(bRecommendedNutritionInTake));
    }

    /**
     * 修改intake
     */
    @PreAuthorize("@ss.hasPermi('health:intake:edit')")
    @Log(title = "intake", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BRecommendedNutritionInTake bRecommendedNutritionInTake)
    {
        return toAjax(bRecommendedNutritionInTakeService.updateBRecommendedNutritionInTake(bRecommendedNutritionInTake));
    }

    /**
     * 删除intake
     */
    @PreAuthorize("@ss.hasPermi('health:intake:remove')")
    @Log(title = "intake", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(bRecommendedNutritionInTakeService.deleteBRecommendedNutritionInTakeByIds(ids));
    }
}
