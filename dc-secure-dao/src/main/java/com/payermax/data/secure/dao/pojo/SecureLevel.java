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
 * 数据安全等级表
 * </p>
 *
 * @author cyy
 * @since 2022-02-22 15:19:18
 */
@Getter
@Setter
@TableName("dc_meta.dc_secure_level")
@ApiModel(value = "SecureLevel对象", description = "数据安全等级表")
public class SecureLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("安全等级")
    @TableField("secure_level")
    private String secureLevel;

    @ApiModelProperty("传输模式(0: 不加密, 1:加密)")
    @TableField("transmission_mode")
    private Integer transmissionMode;

    @ApiModelProperty("存储模式(0: 不加密, 1: 加密)")
    @TableField("storage_mode")
    private Integer storageMode;

    @ApiModelProperty("展示模式(0: 不加密, 1: 加密)")
    @TableField("display_mode")
    private Integer displayMode;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("modified_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedTime;


}
