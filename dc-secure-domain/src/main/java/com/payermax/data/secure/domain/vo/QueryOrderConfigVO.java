package com.payermax.data.secure.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * <p>
 * 数据查询订单配置表
 * </p>
 *
 * @author cyy
 * @since 2022-02-24 16:57:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryOrderConfigVO {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("订单号类型")
    private String orderType;

    @ApiModelProperty("订单号描述")
    private String orderDesc;

    @ApiModelProperty("订单排序")
    private Integer orderSeq;
}
