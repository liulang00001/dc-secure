package com.payermax.data.secure.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 数据安全待排除表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Data
public class SecureExclusiveTableDTO {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("数据源ID")
    private Long sourceId;

    @ApiModelProperty("数据库名称")
    private String tableSchema;

    @ApiModelProperty("数据表名称")
    private String tableName;

}
