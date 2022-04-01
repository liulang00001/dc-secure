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
 * 数据安全字段表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Getter
@Setter
@TableName("dc_meta.dc_secure_field")
@ApiModel(value = "SecureField对象", description = "数据安全字段表")
public class SecureField implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("数据源ID")
    @TableField("source_id")
    private Long sourceId;

    @ApiModelProperty("合规示例表主键")
    @TableField("category_id")
    private Long categoryId;

    @ApiModelProperty("数据库名称")
    @TableField("table_schema")
    private String tableSchema;

    @ApiModelProperty("数据表名称")
    @TableField("table_name")
    private String tableName;

    @ApiModelProperty("字段名称")
    @TableField("field_name")
    private String fieldName;

    @ApiModelProperty("字段描述")
    @TableField("field_desc")
    private String fieldDesc;

    @ApiModelProperty("权限等级")
    @TableField("privilege_level")
    private Integer privilegeLevel;

    @ApiModelProperty("业务域")
    @TableField("domain_id")
    private Long domainId;

    @ApiModelProperty("采集方式")
    @TableField("collect_mode")
    private Integer collectMode;

    @ApiModelProperty("使用场景")
    @TableField("usage_scenario")
    private String usageScenario;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("modified_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedTime;


}
