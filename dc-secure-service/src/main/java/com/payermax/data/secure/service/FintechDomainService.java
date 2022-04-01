package com.payermax.data.secure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.dao.pojo.FintechDomain;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.FintechDomainDTO;
import com.payermax.data.secure.domain.vo.FintechDomainVO;

/**
 * <p>
 * 互金业务域表 服务类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
public interface FintechDomainService extends IService<FintechDomain> {
    /**
     * 分页查询
     *
     * @param pageNum  当前页
     * @param pageSize 分页条数
     * @return @link{ com.payermax.common.lang.model.dto.Result,com.payermax.data.secure.domain.base.PageInfo}
     */
    Result<PageInfo<FintechDomainVO>> queryForPage(Long pageNum, Long pageSize);

    /**
     * 根据id查询单条记录
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result, com.payermax.data.secure.domain.entity.FintechDomain }
     */
    Result<FintechDomainVO> queryById(Long id);

    /**
     * 添加数据
     *
     * @param fintechDomainDTO @link{ com.payermax.data.secure.domain.dto.FintechDomainDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Long> saveRecord(FintechDomainDTO fintechDomainDTO);

    /**
     * 修改数据
     *
     * @param fintechDomainDTO @link{ com.payermax.data.secure.domain.dto.FintechDomainDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> updateRecord(FintechDomainDTO fintechDomainDTO);

    /**
     * 根据id删除数据
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> deleteRecordById(Long id);

}
