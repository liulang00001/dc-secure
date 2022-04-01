package com.payermax.data.secure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.dao.pojo.SecureScanSource;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureScanSourceDTO;
import com.payermax.data.secure.domain.vo.SecureScanSourceVO;

/**
 * <p>
 * 数据安全扫描数据源 服务类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
public interface SecureScanSourceService extends IService<SecureScanSource> {
    /**
     * 分页查询
     *
     * @param pageNum  当前页
     * @param pageSize 分页条数
     * @return @link{ com.payermax.common.lang.model.dto.Result,com.payermax.data.secure.domain.base.PageInfo}
     */
    Result<PageInfo<SecureScanSourceVO>> queryForPage(Long pageNum, Long pageSize);

    /**
     * 根据id查询单条记录
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result, com.payermax.data.secure.domain.entity.SecureScanSource }
     */
    Result<SecureScanSourceVO> queryById(Long id);

    /**
     * 添加数据
     *
     * @param secureScanSourceDTO @link{ com.payermax.data.secure.domain.dto.SecureScanSourceDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Long> saveRecord(SecureScanSourceDTO secureScanSourceDTO);

    /**
     * 修改数据
     *
     * @param secureScanSourceDTO @link{ com.payermax.data.secure.domain.dto.SecureScanSourceDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> updateRecord(SecureScanSourceDTO secureScanSourceDTO);

    /**
     * 根据id删除数据
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> deleteRecordById(Long id);
}
