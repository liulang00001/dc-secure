package com.payermax.data.secure.client.controller;


import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.PageRequestDTO;
import com.payermax.data.secure.domain.dto.SecureLevelDTO;
import com.payermax.data.secure.domain.vo.SecureLevelVO;
import com.payermax.data.secure.service.SecureLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 数据安全等级表 前端控制器
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Api(tags = "数据安全等级表")
@RestController
@RequestMapping("/secure-level")
public class SecureLevelController {
    @Autowired
    private SecureLevelService secureLevelService;

    @ApiOperation("分页获取表数据")
    @PostMapping("/page/list")
    public Result<PageInfo<SecureLevelVO>> queryPage(@RequestBody PageRequestDTO pageRequestDTO) {
        return secureLevelService.queryForPage(pageRequestDTO.getPageNum(), pageRequestDTO.getPageSize());
    }

    @ApiOperation("根据id获取单条数据")
    @GetMapping("/query/{id}")
    public Result<SecureLevelVO> queryById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureLevelService.queryById(id);
    }

    @ApiOperation("添加数据")
    @PostMapping("/save")
    public Result<Long> saveRecord(@RequestBody SecureLevelDTO secureLevelDTO) {
        return secureLevelService.saveRecord(secureLevelDTO);
    }

    @ApiOperation("修改数据")
    @PostMapping("/update")
    public Result<Boolean> updateRecord(@RequestBody SecureLevelDTO secureLevelDTO) {
        return secureLevelService.updateRecord(secureLevelDTO);
    }

    @ApiOperation("根据id删除数据")
    @GetMapping("/delete/{id}")
    public Result<Boolean> deleteRecordById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureLevelService.deleteRecordById(id);
    }
}
