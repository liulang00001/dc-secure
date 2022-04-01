package com.payermax.data.secure.client.controller;


import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.PageRequestDTO;
import com.payermax.data.secure.domain.dto.SecureExclusiveTableDTO;
import com.payermax.data.secure.domain.vo.SecureExclusiveTableVO;
import com.payermax.data.secure.service.SecureExclusiveTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 数据安全待排除表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Api(tags = "数据安全待排除表")
@RestController
@Slf4j
@RequestMapping("/secure-exclusive-table")
public class SecureExclusiveTableController {
    @Autowired
    private SecureExclusiveTableService secureExclusiveTableService;

    @ApiOperation("分页获取表数据")
    @PostMapping("/page/list")
    public Result<PageInfo<SecureExclusiveTableVO>> queryPage(@RequestBody PageRequestDTO pageRequestDTO) {
        return secureExclusiveTableService.queryForPage(pageRequestDTO.getPageNum(), pageRequestDTO.getPageSize(), pageRequestDTO.getParams());
    }

    @ApiOperation("根据id获取单条数据")
    @GetMapping("/query/{id}")
    public Result<SecureExclusiveTableVO> queryById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureExclusiveTableService.queryById(id);
    }

    @ApiOperation("查询数据库名称列表")
    @GetMapping("/query/tableSchema")
    public Result<List<String>> queryTableSchema() {
        return secureExclusiveTableService.queryTableSchema();
    }

    @ApiOperation("查询表名名称列表")
    @GetMapping("/query/tableName/{tableSchema}")
    public Result<List<String>> queryTableName(
            @ApiParam(value = "tableSchema", required = true, example = "omc")
            @PathVariable String tableSchema
    ) {
        return secureExclusiveTableService.queryTableName(tableSchema);
    }

    @ApiOperation("添加数据")
    @PostMapping("/save")
    public Result<Long> saveRecord(@RequestBody SecureExclusiveTableDTO secureExclusiveTableDTO) {
        return secureExclusiveTableService.saveRecord(secureExclusiveTableDTO);
    }

    @ApiOperation("修改数据")
    @PostMapping("/update")
    public Result<Boolean> updateRecord(@RequestBody SecureExclusiveTableDTO secureExclusiveTableDTO) {
        return secureExclusiveTableService.updateRecord(secureExclusiveTableDTO);
    }

    @ApiOperation("根据id删除数据")
    @GetMapping("/delete/{id}")
    public Result<Boolean> deleteRecordById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureExclusiveTableService.deleteRecordById(id);
    }
}
