package com.payermax.data.secure.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.common.lang.util.ResultUtil;
import com.payermax.data.secure.dao.mapper.SecureFieldMapper;
import com.payermax.data.secure.dao.pojo.SecureExclusiveTable;
import com.payermax.data.secure.dao.pojo.SecureField;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureFieldDTO;
import com.payermax.data.secure.domain.vo.SecureFieldVO;
import com.payermax.data.secure.service.SecureFieldService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * <p>
 * 数据安全字段表 服务实现类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Service
public class SecureFieldServiceImpl extends ServiceImpl<SecureFieldMapper, SecureField> implements SecureFieldService {
    @Override
    public Result<PageInfo<SecureFieldVO>> queryForPage(Long pageNum, Long pageSize, Map<String, Object> params) {
        IPage<SecureField> page = new Page<>(pageNum, pageSize);

        IPage<SecureField> secureFieldIPage = null;

        // 参数条件为空时
        if (params == null) {
            secureFieldIPage = baseMapper.selectPage(page, null);
        } else {
            // 参数条件不为空时
            QueryWrapper<SecureField> SecureFieldQueryWrapper = new QueryWrapper<SecureField>();
            if (params.get("tableSchema") != null){
                SecureFieldQueryWrapper.eq("table_schema", params.get("tableSchema"));
            }
            if (params.get("tableName") != null){
                SecureFieldQueryWrapper.eq("table_name", params.get("tableName"));
            }
            if (params.get("fieldName") != null){
                SecureFieldQueryWrapper.eq("field_name", params.get("fieldName"));
            }

            secureFieldIPage = baseMapper.selectPage(page, SecureFieldQueryWrapper);
        }


        List<SecureFieldVO> secureFieldVOList = secureFieldIPage.getRecords().stream()
                .map(e -> new SecureFieldVO(e.getId(), e.getSourceId(), e.getCategoryId(), e.getTableSchema(), e.getTableName(), e.getFieldName(),
                        e.getFieldDesc(), e.getPrivilegeLevel(), e.getDomainId(), e.getCollectMode(), e.getUsageScenario()))
                .collect(Collectors.toList());

        PageInfo<SecureFieldVO> pageInfo = new PageInfo<SecureFieldVO>()
                .setPageNum(pageNum)
                .setPageSize(pageSize)
                .setTotalCount(secureFieldIPage.getTotal())
                .setData(secureFieldVOList);

        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result<SecureFieldVO> queryById(Long id) {
        SecureField secureField = baseMapper.selectById(id);
        SecureFieldVO secureFieldVO = new SecureFieldVO();
        BeanUtils.copyProperties(secureField, secureFieldVO);
        return ResultUtil.success(secureFieldVO);
    }

    @Override
    public Result<Long> saveRecord(SecureFieldDTO secureFieldDTO) {
        SecureField secureField = new SecureField();
        BeanUtils.copyProperties(secureFieldDTO, secureField);
        baseMapper.insert(secureField);
        return ResultUtil.success(secureField.getId());
    }

    @Override
    public Result<Boolean> updateRecord(SecureFieldDTO secureFieldDTO) {
        SecureField secureField = new SecureField();
        BeanUtils.copyProperties(secureFieldDTO, secureField);
        return ResultUtil.success(baseMapper.updateById(secureField) > 0);
    }

    @Override
    public Result<Boolean> deleteRecordById(Long id) {
        return ResultUtil.success(baseMapper.deleteById(id) > 0);
    }
}
