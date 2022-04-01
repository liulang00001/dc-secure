package com.payermax.data.secure.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.common.lang.util.ResultUtil;
import com.payermax.data.secure.dao.mapper.FintechDomainMapper;
import com.payermax.data.secure.dao.pojo.FintechDomain;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.FintechDomainDTO;
import com.payermax.data.secure.domain.vo.FintechDomainVO;
import com.payermax.data.secure.service.FintechDomainService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 互金业务域表 服务实现类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Service
public class FintechDomainServiceImpl extends ServiceImpl<FintechDomainMapper, FintechDomain> implements FintechDomainService {
    @Override
    public Result<PageInfo<FintechDomainVO>> queryForPage(Long pageNum, Long pageSize) {
        IPage<FintechDomain> page = new Page<>(pageNum, pageSize);
        IPage<FintechDomain> fintechDomainIPage = baseMapper.selectPage(page, null);

        List<FintechDomainVO> fintechDomainVOList = fintechDomainIPage.getRecords().stream()
                .map(e -> new FintechDomainVO(e.getId(), e.getName(), e.getDescription()))
                .collect(Collectors.toList());

        PageInfo<FintechDomainVO> pageInfo = new PageInfo<FintechDomainVO>()
                .setPageNum(pageNum)
                .setPageSize(pageSize)
                .setTotalCount(fintechDomainIPage.getTotal())
                .setData(fintechDomainVOList);

        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result<FintechDomainVO> queryById(Long id) {
        FintechDomain fintechDomain = baseMapper.selectById(id);

        FintechDomainVO fintechDomainVO = new FintechDomainVO();
        BeanUtils.copyProperties(fintechDomain, fintechDomainVO);

        return ResultUtil.success(fintechDomainVO);
    }

    @Override
    public Result<Long> saveRecord(FintechDomainDTO fintechDomainDTO) {
        FintechDomain fintechDomain = new FintechDomain();
        BeanUtils.copyProperties(fintechDomainDTO, fintechDomain);
        baseMapper.insert(fintechDomain);
        return ResultUtil.success(fintechDomain.getId());
    }

    @Override
    public Result<Boolean> updateRecord(FintechDomainDTO fintechDomainDTO) {
        FintechDomain fintechDomain = new FintechDomain();
        BeanUtils.copyProperties(fintechDomainDTO, fintechDomain);
        return ResultUtil.success(baseMapper.updateById(fintechDomain) > 0);
    }

    @Override
    public Result<Boolean> deleteRecordById(Long id) {
        return ResultUtil.success(baseMapper.deleteById(id) > 0);
    }
}
