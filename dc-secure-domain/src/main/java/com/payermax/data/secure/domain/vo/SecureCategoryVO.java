package com.payermax.data.secure.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 数据安全目录表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecureCategoryVO {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("安全级别")
    private String secureLevel;

    @ApiModelProperty("归类名称")
    private String name;

    @ApiModelProperty("实例")
    private String example;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("建议")
    private String suggestion;

}
