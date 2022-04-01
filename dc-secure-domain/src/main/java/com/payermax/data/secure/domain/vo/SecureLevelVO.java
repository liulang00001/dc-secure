package com.payermax.data.secure.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 数据安全等级表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecureLevelVO {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("安全等级")
    private String secureLevel;

    @ApiModelProperty("传输模式(0: 不加密, 1:加密)")
    private Integer transmissionMode;

    @ApiModelProperty("存储模式(0: 不加密, 1: 加密)")
    private Integer storageMode;

    @ApiModelProperty("展示模式(0: 不加密, 1: 加密)")
    private Integer displayMode;

}
