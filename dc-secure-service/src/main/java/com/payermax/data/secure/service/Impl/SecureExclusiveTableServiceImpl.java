package com.payermax.data.secure.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.common.lang.util.ResultUtil;
import com.payermax.data.secure.dao.mapper.SecureExclusiveTableMapper;
import com.payermax.data.secure.dao.pojo.SecureExclusiveTable;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureExclusiveTableDTO;
import com.payermax.data.secure.domain.vo.SecureExclusiveTableVO;
import com.payermax.data.secure.service.SecureExclusiveTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
public class SecureExclusiveTableServiceImpl extends ServiceImpl<SecureExclusiveTableMapper, SecureExclusiveTable> implements SecureExclusiveTableService {
    @Override
    public Result<PageInfo<SecureExclusiveTableVO>> queryForPage(Long pageNum, Long pageSize, Map<String, Object> params) {
        IPage<SecureExclusiveTable> page = new Page<>(pageNum, pageSize);

        IPage<SecureExclusiveTable> secureExclusiveTableIPage = null;

        // 条件为空时
        if (params == null) {
            secureExclusiveTableIPage = baseMapper.selectPage(page, null);
        } else {
            // 有选择的数据库时
            QueryWrapper<SecureExclusiveTable> queryWrapper = new QueryWrapper<SecureExclusiveTable>()
                    .eq("table_schema", params.get("tableSchema"));
//                    .eq("table_name",params.get("tableName"));
            secureExclusiveTableIPage = baseMapper.selectPage(page, queryWrapper);
        }

        List<SecureExclusiveTableVO> secureExclusiveTableVOList = secureExclusiveTableIPage.getRecords().stream()
                .map(e -> new SecureExclusiveTableVO(e.getId(), e.getSourceId(), e.getTableSchema(), e.getTableName()))
                .collect(Collectors.toList());

        PageInfo<SecureExclusiveTableVO> pageInfo = new PageInfo<SecureExclusiveTableVO>()
                .setPageNum(pageNum)
                .setPageSize(pageSize)
                .setTotalCount(secureExclusiveTableIPage.getTotal())
                .setData(secureExclusiveTableVOList);

        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result<SecureExclusiveTableVO> queryById(Long id) {
        SecureExclusiveTable secureExclusiveTable = baseMapper.selectById(id);
        SecureExclusiveTableVO secureExclusiveTableVO = new SecureExclusiveTableVO();
        BeanUtils.copyProperties(secureExclusiveTable, secureExclusiveTableVO);
        return ResultUtil.success(secureExclusiveTableVO);
    }

    @Override
    public Result<List<String>> queryTableSchema() {
        return ResultUtil.success(baseMapper.queryTableSchema());
    }

    @Override
    public Result<List<String>> queryTableName(String tableSchema) {
        return ResultUtil.success(baseMapper.queryTableName());
    }

    @Override
    public Result<Long> saveRecord(SecureExclusiveTableDTO secureExclusiveTableDTO) {
        SecureExclusiveTable secureExclusiveTable = new SecureExclusiveTable();
        BeanUtils.copyProperties(secureExclusiveTableDTO, secureExclusiveTable);
        baseMapper.insert(secureExclusiveTable);
        return ResultUtil.success(secureExclusiveTable.getId());
    }

    @Override
    public Result<Boolean> updateRecord(SecureExclusiveTableDTO secureExclusiveTableDTO) {
        SecureExclusiveTable secureExclusiveTable = new SecureExclusiveTable();
        BeanUtils.copyProperties(secureExclusiveTableDTO, secureExclusiveTable);
        return ResultUtil.success(baseMapper.updateById(secureExclusiveTable) > 0);
    }

    @Override
    public Result<Boolean> deleteRecordById(Long id) {
        return ResultUtil.success(baseMapper.deleteById(id) > 0);
    }
}
