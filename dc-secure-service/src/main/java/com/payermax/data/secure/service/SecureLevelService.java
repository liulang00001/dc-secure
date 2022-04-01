package com.payermax.data.secure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.dao.pojo.SecureLevel;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureLevelDTO;
import com.payermax.data.secure.domain.vo.SecureLevelVO;

/**
 * <p>
 * 数据安全等级表 服务类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
public interface SecureLevelService extends IService<SecureLevel> {
    /**
     * 分页查询
     *
     * @param pageNum  当前页
     * @param pageSize 分页条数
     * @return @link{ com.payermax.common.lang.model.dto.Result,com.payermax.data.secure.domain.base.PageInfo}
     */
    Result<PageInfo<SecureLevelVO>> queryForPage(Long pageNum, Long pageSize);

    /**
     * 根据id查询单条记录
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result, com.payermax.data.secure.domain.entity.FintechDomain }
     */
    Result<SecureLevelVO> queryById(Long id);

    /**
     * 添加数据
     *
     * @param secureLevelDTO @link{ com.payermax.data.secure.domain.dto.SecureLevelDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Long> saveRecord(SecureLevelDTO secureLevelDTO);

    /**
     * 修改数据
     *
     * @param secureLevelDTO @link{ com.payermax.data.secure.domain.dto.SecureLevelDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> updateRecord(SecureLevelDTO secureLevelDTO);

    /**
     * 根据id删除数据
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> deleteRecordById(Long id);
}
