package com.payermax.data.secure.client.controller;


import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.PageRequestDTO;
import com.payermax.data.secure.domain.dto.SecureScanSourceDTO;
import com.payermax.data.secure.domain.vo.SecureScanSourceVO;
import com.payermax.data.secure.service.SecureScanSourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 数据安全扫描数据源
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Api(tags = "数据安全扫描数据源")
@RestController
@RequestMapping("/secure-scan-source")
public class SecureScanSourceController {
    @Autowired
    private SecureScanSourceService secureScanSourceService;

    @ApiOperation("分页获取表数据")
    @PostMapping("/page/list")
    public Result<PageInfo<SecureScanSourceVO>> queryPage(@RequestBody PageRequestDTO pageRequestDTO) {
        return secureScanSourceService.queryForPage(pageRequestDTO.getPageNum(), pageRequestDTO.getPageSize());
    }

    @ApiOperation("根据id获取单条数据")
    @GetMapping("/query/{id}")
    public Result<SecureScanSourceVO> queryById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureScanSourceService.queryById(id);
    }

    @ApiOperation("添加数据")
    @PostMapping("/save")
    public Result<Long> saveRecord(@RequestBody SecureScanSourceDTO secureScanSourceDTO) {
        return secureScanSourceService.saveRecord(secureScanSourceDTO);
    }

    @ApiOperation("修改数据")
    @PostMapping("/update")
    public Result<Boolean> updateRecord(@RequestBody SecureScanSourceDTO secureScanSourceDTO) {
        return secureScanSourceService.updateRecord(secureScanSourceDTO);
    }

    @ApiOperation("根据id删除数据")
    @GetMapping("/delete/{id}")
    public Result<Boolean> deleteRecordById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureScanSourceService.deleteRecordById(id);
    }
}
