package com.payermax.data.secure.domain.err;

/**
 * @Date 2022/2/22
 * @Author cyy
 */
public enum ExceptionCode {
    /**
     * 系统错误
     */
    SYSTEM_ERROR,
    /**
     * 错误请求
     */
    BAD_REQUEST,
    /**
     * 查询失败
     */
    QUERY_FAILS,
    /**
     * 查无数据
     */
    NOT_FOUND_IN_DB,
    /**
     * (数据库,数据表,字段)唯一
     */
    SOURCE_ID_TABLE_SCHEMA_TABLE_NAME_FIELD_NAME_UNIQUE;
}
