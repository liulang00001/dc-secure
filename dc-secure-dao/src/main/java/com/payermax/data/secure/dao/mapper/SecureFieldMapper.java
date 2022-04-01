package com.payermax.data.secure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payermax.data.secure.dao.pojo.SecureField;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 数据安全字段表 Mapper 接口
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Mapper
public interface SecureFieldMapper extends BaseMapper<SecureField> {
}
