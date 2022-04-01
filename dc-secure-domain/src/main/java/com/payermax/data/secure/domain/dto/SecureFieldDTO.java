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
public class SecureFieldDTO {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("数据源ID")
    private Long sourceId;

    @ApiModelProperty("合规示例表主键")
    private Long categoryId;

    @ApiModelProperty("数据库名称")
    private String tableSchema;

    @ApiModelProperty("数据表名称")
    private String tableName;

    @ApiModelProperty("字段名称")
    private String fieldName;

    @ApiModelProperty("字段描述")
    private String fieldDesc;

    @ApiModelProperty("权限等级")
    private Integer privilegeLevel;

    @ApiModelProperty("业务域")
    private Long domainId;

    @ApiModelProperty("采集方式")
    private Integer collectMode;

    @ApiModelProperty("使用场景")
    private String usageScenario;

}
