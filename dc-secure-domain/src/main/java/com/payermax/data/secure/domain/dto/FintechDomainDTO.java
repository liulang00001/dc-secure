package com.payermax.data.secure.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Date 2022/3/2
 * @Author cyy
 */
@Data
public class FintechDomainDTO {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("业务域名称")
    private String name;

    @ApiModelProperty("业务描述")
    private String description;
}
