package com.payermax.data.secure.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 数据安全扫描数据源
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Getter
@Setter
@TableName("dc_meta.dc_secure_scan_source")
@ApiModel(value = "SecureScanSource对象", description = "数据安全扫描数据源")
public class SecureScanSource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("驱动包类名")
    @TableField("driver_class_name")
    private String driverClassName;

    @ApiModelProperty("数据库连接")
    @TableField("url")
    private String url;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除")
    @TableField("test_while_idle")
    private Integer testWhileIdle;

    @ApiModelProperty("验证连接是否可用的SQL语句")
    @TableField("validation_query")
    private String validationQuery;

    @ApiModelProperty("待排除的数据库名称集合")
    @TableField("exclusive_schema")
    private String exclusiveSchema;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("modified_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedTime;


}
