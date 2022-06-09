package com.example.demo.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    /**
     * 创建人
     */
    @TableField(value = "record_name", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人", hidden = true)
    @JsonIgnore
    private String recordName;

    /**
     * 创建人id
     */
    @TableField(value = "record_id", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人id", hidden = true)
    @JsonIgnore
    private String recordId;

    /**
     * 创建时间
     */
    @TableField(value = "record_date", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", hidden = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date recordDate;

    /**
     * 修改人姓名
     */
    @TableField(value = "modify_name", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改人姓名", hidden = true)
    @JsonIgnore
    private String modifyName;

    /**
     * 修改人id
     */
    @TableField(value = "modify_id", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改人id", hidden = true)
    @JsonIgnore
    private String modifyId;

    /**
     * 修改时间
     */
    @TableField(value = "modify_date", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改时间", hidden = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date modifyDate;

    /**
     * 0 = 不可见  1= 可见
     */
    @TableField(value = "enabled", fill = FieldFill.INSERT)
    @TableLogic(value = "1", delval = "0")
    @ApiModelProperty(value = "0 = 不可见  1= 可见", hidden = true)
    @JsonIgnore
    private Boolean enabled;

    /**
     * 删除人姓名
     */
    @TableField(value = "disabler_name")
    @ApiModelProperty(value = "删除人姓名", hidden = true)
    @JsonIgnore
    private String disablerName;

    /**
     * 删除人id
     */
    @TableField(value = "disabler_id")
    @ApiModelProperty(value = "删除人id", hidden = true)
    @JsonIgnore
    private String disablerId;

    /**
     * 删除时间
     */
    @TableField(value = "disabler_date")
    @ApiModelProperty(value = "删除时间", hidden = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date disablerDate;
}
