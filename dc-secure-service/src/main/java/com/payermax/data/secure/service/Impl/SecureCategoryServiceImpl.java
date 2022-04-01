package com.payermax.data.secure.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.common.lang.util.ResultUtil;
import com.payermax.data.secure.dao.mapper.SecureCategoryMapper;
import com.payermax.data.secure.dao.pojo.SecureCategory;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureCategoryDTO;
import com.payermax.data.secure.domain.vo.SecureCategoryVO;
import com.payermax.data.secure.service.SecureCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据安全目录表 服务实现类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Service
public class SecureCategoryServiceImpl extends ServiceImpl<SecureCategoryMapper, SecureCategory> implements SecureCategoryService {
    @Override
    public Result<PageInfo<SecureCategoryVO>> queryForPage(Long pageNum, Long pageSize) {
        IPage<SecureCategory> page = new Page<>(pageNum, pageSize);
        IPage<SecureCategory> secureCategoryIPage = baseMapper.selectPage(page, null);

        List<SecureCategoryVO> secureCategoryVOList = secureCategoryIPage.getRecords().stream()
                .map(e -> new SecureCategoryVO(e.getId(), e.getSecureLevel(), e.getName(), e.getExample(),
                        e.getDescription(), e.getSuggestion()))
                .collect(Collectors.toList());

        PageInfo<SecureCategoryVO> pageInfo = new PageInfo<SecureCategoryVO>()
                .setPageNum(pageNum)
                .setPageSize(pageSize)
                .setTotalCount(secureCategoryIPage.getTotal())
                .setData(secureCategoryVOList);

        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result<SecureCategoryVO> queryById(Long id) {
        SecureCategory secureCategory = baseMapper.selectById(id);
        SecureCategoryVO secureCategoryVO = new SecureCategoryVO();
        BeanUtils.copyProperties(secureCategory, secureCategoryVO);
        return ResultUtil.success(secureCategoryVO);
    }

    @Override
    public Result<Long> saveRecord(SecureCategoryDTO secureCategoryDTO) {
        SecureCategory secureCategory = new SecureCategory();
        BeanUtils.copyProperties(secureCategoryDTO, secureCategory);
        baseMapper.insert(secureCategory);
        return ResultUtil.success(secureCategory.getId());
    }

    @Override
    public Result<Boolean> updateRecord(SecureCategoryDTO secureCategoryDTO) {
        SecureCategory secureCategory = new SecureCategory();
        BeanUtils.copyProperties(secureCategoryDTO, secureCategory);
        return ResultUtil.success(baseMapper.updateById(secureCategory) > 0);
    }

    @Override
    public Result<Boolean> deleteRecordById(Long id) {
        return ResultUtil.success(baseMapper.deleteById(id) > 0);
    }
}
