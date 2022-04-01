package com.payermax.data.secure.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 数据查询模板表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryTemplateVO {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("数据源编号")
    private String sourceId;

    @ApiModelProperty("分类名称")
    private Long categoryId;

    @ApiModelProperty("模板编号")
    private String templateId;

    @ApiModelProperty("模板描述")
    private String templateDesc;

    @ApiModelProperty("脚本模板")
    private String scriptTemplate;

    @ApiModelProperty("附加信息（当 source_type = 4时，字段值为es索引名称）")
    private String additional;

}
