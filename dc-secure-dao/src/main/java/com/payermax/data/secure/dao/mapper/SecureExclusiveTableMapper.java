package com.payermax.data.secure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payermax.data.secure.dao.pojo.SecureExclusiveTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 数据安全待排除表 Mapper 接口
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Mapper
public interface SecureExclusiveTableMapper extends BaseMapper<SecureExclusiveTable> {

    /**
     * 查询数据库名称列表
     *
     * @return @link { com.payermax.common.lang.model.dto.Result, java.util.List }
     */
    List<String> queryTableSchema();

    List<String> queryTableName();
}
