package com.payermax.data.secure.client.controller;


import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.PageRequestDTO;
import com.payermax.data.secure.domain.dto.SecureFieldDTO;
import com.payermax.data.secure.domain.vo.SecureFieldVO;
import com.payermax.data.secure.service.SecureFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@Api(tags = "数据安全字段表")
@RestController
@RequestMapping("/secure-field")
public class SecureFieldController {
    @Autowired
    private SecureFieldService secureFieldService;

    @ApiOperation("分页获取表数据")
    @PostMapping("/page/list")
    public Result<PageInfo<SecureFieldVO>> queryPage(@RequestBody PageRequestDTO pageRequestDTO) {
        return secureFieldService.queryForPage(pageRequestDTO.getPageNum(), pageRequestDTO.getPageSize(),pageRequestDTO.getParams());
    }

    @ApiOperation("根据id获取单条数据")
    @GetMapping("/query/{id}")
    public Result<SecureFieldVO> queryById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureFieldService.queryById(id);
    }

    @ApiOperation("添加数据")
    @PostMapping("/save")
    @Transactional
    public Result<Long> saveRecord(@RequestBody List<SecureFieldDTO> secureFieldDTOs) {
        Result<Long> result=null;
        for (SecureFieldDTO secureFieldDTO : secureFieldDTOs) {
             result=secureFieldService.saveRecord(secureFieldDTO);
             if(result==null )
                 break;
        }
        return result;
    }

    @ApiOperation("修改数据")
    @PostMapping("/update")
    public Result<Boolean> updateRecord(@RequestBody SecureFieldDTO secureFieldDTO) {
        return secureFieldService.updateRecord(secureFieldDTO);
    }

    @ApiOperation("根据id删除数据")
    @GetMapping("/delete/{id}")
    public Result<Boolean> deleteRecordById(
            @ApiParam(value = "id", required = true, example = "1")
            @PathVariable Long id) {
        return secureFieldService.deleteRecordById(id);
    }
}
