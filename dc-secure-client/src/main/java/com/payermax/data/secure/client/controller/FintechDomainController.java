package com.payermax.data.secure.client.controller;


import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.FintechDomainDTO;
import com.payermax.data.secure.domain.dto.PageRequestDTO;
import com.payermax.data.secure.domain.vo.FintechDomainVO;
import com.payermax.data.secure.service.FintechDomainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 互金业务域表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Api(tags = "互金业务域数据")
@RestController
@RequestMapping("/fintech-domain")
public class FintechDomainController {
    @Autowired
    private FintechDomainService fintechDomainService;

    @ApiOperation("分页获取表数据")
    @PostMapping("/page/list")
    public Result<PageInfo<FintechDomainVO>> queryPage(@RequestBody PageRequestDTO pageRequestDTO) {
        return fintechDomainService.queryForPage(pageRequestDTO.getPageNum(), pageRequestDTO.getPageSize());
    }

    @ApiOperation("根据id获取单条数据")
    @GetMapping("/query/{id}")
    public Result<FintechDomainVO> queryById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return fintechDomainService.queryById(id);
    }

    @ApiOperation("添加数据")
    @PostMapping("/save")
    public Result<Long> saveRecord(@RequestBody FintechDomainDTO fintechDomainDTO) {
        return fintechDomainService.saveRecord(fintechDomainDTO);
    }

    @ApiOperation("修改数据")
    @PostMapping("/update")
    public Result<Boolean> updateRecord(@RequestBody FintechDomainDTO fintechDomainDTO) {
        return fintechDomainService.updateRecord(fintechDomainDTO);
    }

    @ApiOperation("根据id删除数据")
    @GetMapping("/delete/{id}")
    public Result<Boolean> deleteRecordById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return fintechDomainService.deleteRecordById(id);
    }
}
