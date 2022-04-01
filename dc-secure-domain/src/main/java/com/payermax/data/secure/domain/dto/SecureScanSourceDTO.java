package com.payermax.data.secure.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 数据安全扫描数据源
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Data
public class SecureScanSourceDTO {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("驱动包类名")
    private String driverClassName;

    @ApiModelProperty("数据库连接")
    private String url;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除")
    private Integer testWhileIdle;

    @ApiModelProperty("验证连接是否可用的SQL语句")
    private String validationQuery;

    @ApiModelProperty("待排除的数据库名称集合")
    private String exclusiveSchema;

}
