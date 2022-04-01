package com.payermax.data.secure.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 数据查询订单关联表
 * </p>
 *
 * @author cyy
 * @since 2022-02-24 16:57:11
 */
@Data
public class QueryOrderRelevanceVO {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("当前订单号类型")
    private String curOrderType;

    @ApiModelProperty("关联订单号类型")
    private String relOrderType;

    @ApiModelProperty("关联订单字段")
    private String relOrderField;

    @ApiModelProperty("依赖订单类型")
    private String depOrderType;

    @ApiModelProperty("执行顺序")
    private Integer execSeq;

    @ApiModelProperty("模板编号")
    private String templateId;

    @ApiModelProperty("子节点")
    private List<QueryOrderRelevanceVO> children;

}
