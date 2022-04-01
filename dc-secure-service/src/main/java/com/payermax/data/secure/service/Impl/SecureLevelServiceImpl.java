package com.payermax.data.secure.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.common.lang.util.ResultUtil;
import com.payermax.data.secure.dao.mapper.SecureLevelMapper;
import com.payermax.data.secure.dao.pojo.SecureLevel;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureLevelDTO;
import com.payermax.data.secure.domain.vo.SecureLevelVO;
import com.payermax.data.secure.service.SecureLevelService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据安全等级表 服务实现类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Service
public class SecureLevelServiceImpl extends ServiceImpl<SecureLevelMapper, SecureLevel> implements SecureLevelService {
    @Override
    public Result<PageInfo<SecureLevelVO>> queryForPage(Long pageNum, Long pageSize) {
        IPage<SecureLevel> page = new Page<>(pageNum, pageSize);
        IPage<SecureLevel> secureLevelIPage = baseMapper.selectPage(page, null);

        List<SecureLevelVO> secureLevelVOList = secureLevelIPage.getRecords().stream()
                .map(e -> new SecureLevelVO(e.getId(), e.getSecureLevel(), e.getTransmissionMode(), e.getStorageMode(), e.getDisplayMode()))
                .collect(Collectors.toList());

        PageInfo<SecureLevelVO> pageInfo = new PageInfo<SecureLevelVO>()
                .setPageNum(pageNum)
                .setPageSize(pageSize)
                .setTotalCount(secureLevelIPage.getTotal())
                .setData(secureLevelVOList);

        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result<SecureLevelVO> queryById(Long id) {
        SecureLevel secureLevel = baseMapper.selectById(id);
        SecureLevelVO secureLevelVO = new SecureLevelVO();
        BeanUtils.copyProperties(secureLevel, secureLevelVO);
        return ResultUtil.success(secureLevelVO);
    }

    @Override
    public Result<Long> saveRecord(SecureLevelDTO secureLevelDTO) {
        SecureLevel secureLevel = new SecureLevel();
        BeanUtils.copyProperties(secureLevelDTO, secureLevel);
        baseMapper.insert(secureLevel);
        return ResultUtil.success(secureLevel.getId());
    }

    @Override
    public Result<Boolean> updateRecord(SecureLevelDTO secureLevelDTO) {
        SecureLevel secureLevel = new SecureLevel();
        BeanUtils.copyProperties(secureLevelDTO, secureLevel);
        return ResultUtil.success(baseMapper.updateById(secureLevel) > 0);
    }

    @Override
    public Result<Boolean> deleteRecordById(Long id) {
        return ResultUtil.success(baseMapper.deleteById(id) > 0);
    }
}
