package com.payermax.data.secure.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 数据安全待排除表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecureExclusiveTableVO {
    @ApiModelProperty
    private Long id;

    @ApiModelProperty("数据源ID")
    private Long sourceId;

    @ApiModelProperty("数据库名称")
    private String tableSchema;

    @ApiModelProperty("数据表名称")
    private String tableName;

}
