package com.payermax.data.secure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.dao.pojo.SecureCategory;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureCategoryDTO;
import com.payermax.data.secure.domain.vo.SecureCategoryVO;

/**
 * <p>
 * 数据安全目录表 服务类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
public interface SecureCategoryService extends IService<SecureCategory> {
    /**
     * 分页查询
     *
     * @param pageNum  当前页
     * @param pageSize 分页条数
     * @return @link{ com.payermax.common.lang.model.dto.Result,com.payermax.data.secure.domain.base.PageInfo}
     */
    Result<PageInfo<SecureCategoryVO>> queryForPage(Long pageNum, Long pageSize);

    /**
     * 根据id查询单条记录
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result, com.payermax.data.secure.domain.entity.SecureCategory }
     */
    Result<SecureCategoryVO> queryById(Long id);

    /**
     * 添加数据
     *
     * @param secureCategoryDTO @link{ com.payermax.data.secure.domain.dto.SecureCategoryDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Long> saveRecord(SecureCategoryDTO secureCategoryDTO);

    /**
     * 修改数据
     *
     * @param secureCategoryDTO @link{ com.payermax.data.secure.domain.dto.SecureCategoryDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> updateRecord(SecureCategoryDTO secureCategoryDTO);

    /**
     * 根据id删除数据
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> deleteRecordById(Long id);
}
