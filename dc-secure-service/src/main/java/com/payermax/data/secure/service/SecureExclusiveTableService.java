package com.payermax.data.secure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.dao.pojo.SecureExclusiveTable;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureExclusiveTableDTO;
import com.payermax.data.secure.domain.vo.SecureExclusiveTableVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据安全待排除表 服务类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
public interface SecureExclusiveTableService extends IService<SecureExclusiveTable> {
    /**
     * 分页查询
     *
     * @param pageNum  当前页
     * @param pageSize 分页条数
     * @param params 查询条件
     *
     * @return @link{ com.payermax.common.lang.model.dto.Result,com.payermax.data.secure.domain.base.PageInfo}
     */
    Result<PageInfo<SecureExclusiveTableVO>> queryForPage(Long pageNum, Long pageSize, Map<String, Object> params);

    /**
     * 根据id查询单条记录
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result, com.payermax.data.secure.domain.entity.SecureExclusiveTable }
     */
    Result<SecureExclusiveTableVO> queryById(Long id);

    /**
     * 查询数据库名称列表
     *
     * @return @link { com.payermax.common.lang.model.dto.Result, java.util.List }
     */
    Result<List<String>> queryTableSchema();

    /**
     * 查询数表名名称列表
     *
     * @return @link { com.payermax.common.lang.model.dto.Result, java.util.List }
     */
    Result<List<String>> queryTableName(String tableSchema);

    /**
     * 添加数据
     *
     * @param secureExclusiveTableDTO @link{ com.payermax.data.secure.domain.dto.SecureExclusiveTableDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Long> saveRecord(SecureExclusiveTableDTO secureExclusiveTableDTO);

    /**
     * 修改数据
     *
     * @param secureExclusiveTableDTO @link{ com.payermax.data.secure.domain.dto.SecureExclusiveTableDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> updateRecord(SecureExclusiveTableDTO secureExclusiveTableDTO);

    /**
     * 根据id删除数据
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> deleteRecordById(Long id);

}
