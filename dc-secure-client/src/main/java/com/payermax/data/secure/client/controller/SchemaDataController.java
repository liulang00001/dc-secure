package com.payermax.data.secure.client.controller;


import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.dao.pojo.SchemaData;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.PageRequestDTO;
import com.payermax.data.secure.domain.dto.SecureFieldDTO;
import com.payermax.data.secure.domain.vo.SchemaDataVO;
import com.payermax.data.secure.domain.vo.SecureFieldVO;
import com.payermax.data.secure.service.SchemaDataService;
import com.payermax.data.secure.service.SecureFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 数据安全字段表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Api(tags = "数据库对象")
@RestController
@RequestMapping("/information_schema")
public class SchemaDataController {
    @Autowired
    private SchemaDataService schemaDataService;

    @ApiOperation("查询数据库名称列表")
    @GetMapping("/query/tableSchema")
    public Result<List<String>> queryForSchema() {
        return schemaDataService.queryForSchema();
    }

    @ApiOperation("查询表名名称列表")
    @GetMapping("/query/tableSchema/{tableSchema}")
    public Result<List<String>> queryForTableName(
            @ApiParam(value = "tableSchema", required = true, example = "omc_crm")
            @PathVariable("tableSchema") String tableSchema
    ) {
        return schemaDataService.queryForTableName(tableSchema);
    }

    @ApiOperation("根据库名表名查询字段")
    @GetMapping("/query/columns/{tableSchema}/{tableName}")
    public Result<List<String>> queryForColumns(
            @ApiParam(value = "tableSchema,tableName", required = true, example = "omc")
            @PathVariable("tableSchema") String tableSchema,
            @PathVariable("tableName") String tableName
    ){
        return schemaDataService.queryForColumns(tableSchema,tableName);
    }


    @ApiOperation("根据库名表名查询字段描述")
    @GetMapping("/query/columns/{tableSchema}/{tableName}/{columnName}")
    public Result<List<String>> queryForColumnComment(
            @ApiParam(value = "tableSchema,tableName", required = true, example = "omc")
            @PathVariable("tableSchema") String tableSchema,
            @PathVariable("tableName") String tableName,
            @PathVariable("columnName") String columnName
    ){
        return schemaDataService.queryForColumnComment(tableSchema,tableName,columnName);
    }



}
