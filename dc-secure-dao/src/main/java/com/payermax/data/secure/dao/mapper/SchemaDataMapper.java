package com.payermax.data.secure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payermax.data.secure.dao.pojo.SchemaData;
import com.payermax.data.secure.dao.pojo.SecureField;
import com.payermax.data.secure.domain.vo.SchemaDataVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 数据安全字段表 Mapper 接口
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Mapper
public interface SchemaDataMapper extends BaseMapper<SchemaData> {
    /**
     * 查询数据库列表
     * @return
     */
    List<String> queryForTableSchema();

    /**
     * 查询表名列表
     * @return
     */
    List<String> queryForTableName(String tableSchema);

    /**
     * 查询字段名
     * @return
     */
    List<String> queryForColumns(String tableSchema,String tableName );

    /**
     * 查询字段描述
     * @return
     */
    List<String> queryForColumnComment(String tableSchema,String tableName,String columnName );
}
