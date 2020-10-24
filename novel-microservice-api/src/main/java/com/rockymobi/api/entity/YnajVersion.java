package com.rockymobi.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author UserZrq
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="YnajVersion对象", description="")
public class YnajVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "appId")
    private Integer appId;

    @ApiModelProperty(value = "app类型:1001-IOS终端,1002-Android终端")
    private Integer clientPhoneType;

    @ApiModelProperty(value = "上传时间，精确到年月日")
    private String uploadDate;

    @ApiModelProperty(value = "app版本号")
    private Integer appVersion;

    @ApiModelProperty(value = "版本更新内容")
    private String updateContent;

    @ApiModelProperty(value = "是否强制更新 : 0不强制 1强制")
    private Integer forcedUpdate;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否被删除 0 删除 1未删除")
    @TableLogic
    private Integer isDeleted;


}
