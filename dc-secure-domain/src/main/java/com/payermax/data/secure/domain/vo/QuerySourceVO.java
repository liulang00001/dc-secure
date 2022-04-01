package com.payermax.data.secure.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 数据查询资源表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuerySourceVO {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("数据源编号")
    private String sourceId;

    @ApiModelProperty("数据源类型(0:mysql,1:elasticsearch-sql,2:doris,3:clickhouse,4:elasticsearch-dsl)")
    private Integer sourceType;

    @ApiModelProperty("驱动包名")
    private String driverClassName;

    @ApiModelProperty("数据库链接")
    private String url;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除")
    private Byte testWhileIdle;

    @ApiModelProperty("验证连接是否可用的SQL语句")
    private String validationQuery;

    @ApiModelProperty("数据源是否在应用启动时进行初始化(0:否，1:是)")
    private Byte initOnStartup;

}
