package com.payermax.data.secure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.dao.pojo.SchemaData;
import com.payermax.data.secure.dao.pojo.SecureField;
import com.payermax.data.secure.domain.base.PageInfo;
import com.payermax.data.secure.domain.dto.SecureFieldDTO;
import com.payermax.data.secure.domain.vo.SchemaDataVO;
import com.payermax.data.secure.domain.vo.SecureFieldVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据安全字段表 服务类
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
public interface SchemaDataService extends IService<SchemaData> {
    /**
     * 查找所有的数据库
     *
     * @return
     */
    Result<List<String>> queryForSchema();

    /**
     * 根据数据库查询表名
     *
     * @param Schema 数据库名
     * @return
     */
    Result<List<String>> queryForTableName(String Schema);


    /**
     *
     * @param TableName 表名
     * @return
     */
    Result<List<String>> queryForColumns(String Schema,String TableName);

    /**
     *
     * @param TableName 表名
     * @return
     */
    Result<List<String>> queryForColumnComment(String Schema,String TableName,String ColumnName);
}
