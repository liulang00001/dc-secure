package com.payermax.data.secure.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.common.lang.util.ResultUtil;
import com.payermax.data.secure.dao.mapper.SecureScanSourceMapper;
import com.payermax.data.secure.dao.pojo.SecureScanSource;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureScanSourceDTO;
import com.payermax.data.secure.domain.vo.SecureScanSourceVO;
import com.payermax.data.secure.service.SecureScanSourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据安全扫描数据源 服务实现类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Service
public class SecureScanSourceServiceImpl extends ServiceImpl<SecureScanSourceMapper, SecureScanSource> implements SecureScanSourceService {
    @Override
    public Result<PageInfo<SecureScanSourceVO>> queryForPage(Long pageNum, Long pageSize) {
        IPage<SecureScanSource> page = new Page<>(pageNum, pageSize);
        IPage<SecureScanSource> secureScanSourceIPage = baseMapper.selectPage(page, null);

        List<SecureScanSourceVO> secureScanSourceVOList = secureScanSourceIPage.getRecords().stream()
                .map(e -> new SecureScanSourceVO(e.getId(), e.getDriverClassName(), e.getUrl(), e.getUsername(),
                        e.getTestWhileIdle(), e.getValidationQuery(), e.getExclusiveSchema()))
                .collect(Collectors.toList());

        PageInfo<SecureScanSourceVO> pageInfo = new PageInfo<SecureScanSourceVO>()
                .setPageNum(pageNum)
                .setPageSize(pageSize)
                .setTotalCount(secureScanSourceIPage.getTotal())
                .setData(secureScanSourceVOList);

        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result<SecureScanSourceVO> queryById(Long id) {
        SecureScanSource secureScanSource = baseMapper.selectById(id);
        SecureScanSourceVO secureScanSourceVO = new SecureScanSourceVO();
        BeanUtils.copyProperties(secureScanSource, secureScanSourceVO);
        return ResultUtil.success(secureScanSourceVO);
    }

    @Override
    public Result<Long> saveRecord(SecureScanSourceDTO secureScanSourceDTO) {
        SecureScanSource secureScanSource = new SecureScanSource();
        BeanUtils.copyProperties(secureScanSourceDTO, secureScanSource);
        baseMapper.insert(secureScanSource);
        return ResultUtil.success(secureScanSource.getId());
    }

    @Override
    public Result<Boolean> updateRecord(SecureScanSourceDTO secureScanSourceDTO) {
        SecureScanSource secureScanSource = new SecureScanSource();
        BeanUtils.copyProperties(secureScanSourceDTO, secureScanSource);
        return ResultUtil.success(baseMapper.updateById(secureScanSource) > 0);
    }

    @Override
    public Result<Boolean> deleteRecordById(Long id) {
        return ResultUtil.success(baseMapper.deleteById(id) > 0);
    }
}
