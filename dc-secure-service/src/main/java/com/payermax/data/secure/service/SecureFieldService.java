package com.payermax.data.secure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.dao.pojo.SecureField;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureFieldDTO;
import com.payermax.data.secure.domain.vo.SecureFieldVO;

import java.util.Map;

/**
 * <p>
 * 数据安全字段表 服务类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
public interface SecureFieldService extends IService<SecureField> {
    /**
     * 分页查询
     *
     * @param pageNum  当前页
     * @param pageSize 分页条数
     * @return @link{ com.payermax.common.lang.model.dto.Result,com.payermax.data.secure.domain.base.PageInfo}
     */
    Result<PageInfo<SecureFieldVO>> queryForPage(Long pageNum, Long pageSize, Map<String,Object> params);

    /**
     * 根据id查询单条记录
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result, com.payermax.data.secure.domain.entity.SecureField }
     */
    Result<SecureFieldVO> queryById(Long id);

    /**
     * 添加数据
     *
     * @param secureFieldDTO @link{ com.payermax.data.secure.domain.dto.SecureFieldDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Long> saveRecord(SecureFieldDTO secureFieldDTO);

    /**
     * 修改数据
     *
     * @param secureFieldDTO @link{ com.payermax.data.secure.domain.dto.SecureFieldDTO }
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> updateRecord(SecureFieldDTO secureFieldDTO);

    /**
     * 根据id删除数据
     *
     * @param id 主键
     * @return @link{ com.payermax.common.lang.model.dto.Result }
     */
    Result<Boolean> deleteRecordById(Long id);
}
