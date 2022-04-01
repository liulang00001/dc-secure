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
@TableName("information_schema.COLUMNS")
@ApiModel(value = "SchemaData对象", description = "数据库字段表")
public class SchemaData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("库名")
    @TableField(value = "TABLE_SCHEMA")
    private String tableSchema;

    @ApiModelProperty("表名")
    @TableField(value = "TABLE_NAME")
    private String tableName;

    @ApiModelProperty("字段名")
    @TableField(value = "COLUMN_NAME")
    private String columnName;

    @ApiModelProperty("字段描述")
    @TableField(value = "COLUMN_COMMENT")
    private String columnComment;


}
