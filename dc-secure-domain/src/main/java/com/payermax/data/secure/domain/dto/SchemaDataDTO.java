package com.payermax.data.secure.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 数据安全字段表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Data
public class SchemaDataDTO {

    @ApiModelProperty("数据库名称")
    private String tableSchema;

    @ApiModelProperty("数据表名称")
    private String tableName;

    @ApiModelProperty("字段名称")
    private String columnName;

    @ApiModelProperty("字段描述")
    private String columnComment;


}
