package com.payermax.data.secure.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.common.lang.util.ResultUtil;
import com.payermax.data.secure.dao.mapper.SchemaDataMapper;
import com.payermax.data.secure.dao.mapper.SecureExclusiveTableMapper;
import com.payermax.data.secure.dao.pojo.SchemaData;
import com.payermax.data.secure.dao.pojo.SecureExclusiveTable;


import com.payermax.data.secure.domain.dto.SecureExclusiveTableDTO;
import com.payermax.data.secure.domain.vo.SchemaDataVO;
import com.payermax.data.secure.domain.vo.SecureExclusiveTableVO;
import com.payermax.data.secure.service.SchemaDataService;
import com.payermax.data.secure.service.SecureExclusiveTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据安全待排除表 服务实现类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Slf4j
@Service
public class SchemaDataServiceImpl extends ServiceImpl<SchemaDataMapper, SchemaData> implements SchemaDataService {
    @Override
    public Result<List<String>> queryForSchema() {
        return ResultUtil.success(baseMapper.queryForTableSchema());
    }

    @Override
    public Result<List<String>> queryForTableName(String tableSchema) {
        return ResultUtil.success(baseMapper.queryForTableName(tableSchema));
    }

    @Override
    public Result<List<String>> queryForColumns(String tableSchema, String TableName) {
        return ResultUtil.success(baseMapper.queryForColumns(tableSchema,TableName));
    }

    @Override
    public Result<List<String>> queryForColumnComment(String tableSchema, String TableName,String Column) {
        return ResultUtil.success(baseMapper.queryForColumnComment(tableSchema,TableName,Column));
    }


}
