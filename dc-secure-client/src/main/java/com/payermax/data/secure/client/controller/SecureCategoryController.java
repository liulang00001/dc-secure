package com.payermax.data.secure.client.controller;


import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.dao.pojo.SecureCategory;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.PageRequestDTO;
import com.payermax.data.secure.domain.dto.SecureCategoryDTO;
import com.payermax.data.secure.domain.vo.SecureCategoryVO;
import com.payermax.data.secure.service.SecureCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 数据安全目录表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Api(tags = "数据安全目录表")
@RestController
@RequestMapping("/secure-category")
public class SecureCategoryController {
    @Autowired
    private SecureCategoryService secureCategoryService;

    @ApiOperation("分页获取表数据")
    @PostMapping("/page/list")
    public Result<PageInfo<SecureCategoryVO>> queryPage(@RequestBody PageRequestDTO pageRequestDTO) {
        return secureCategoryService.queryForPage(pageRequestDTO.getPageNum(), pageRequestDTO.getPageSize());
    }

    @ApiOperation("根据id获取单条数据")
    @GetMapping("/query/{id}")
    public Result<SecureCategoryVO> queryById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureCategoryService.queryById(id);
    }

    @ApiOperation("添加数据")
    @PostMapping("/save")
    public Result<Long> saveRecord(@RequestBody SecureCategoryDTO secureCategoryDTO) {
        return secureCategoryService.saveRecord(secureCategoryDTO);
    }

    @ApiOperation("修改数据")
    @PostMapping("/update")
    public Result<Boolean> updateRecord(@RequestBody SecureCategoryDTO secureCategoryDTO) {
        return secureCategoryService.updateRecord(secureCategoryDTO);
    }

    @ApiOperation("根据id删除数据")
    @GetMapping("/delete/{id}")
    public Result<Boolean> deleteRecordById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureCategoryService.deleteRecordById(id);
    }
}
