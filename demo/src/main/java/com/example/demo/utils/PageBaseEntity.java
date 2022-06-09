package com.example.demo.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageBaseEntity implements Serializable {

    /**
     * 当前页数
     */
    @ApiModelProperty(value = "当前页数")
    private Long current = 1L;

    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量")
    private Long size = 10L;

    public <T> Page<T> pageEntity() {
        return new Page<>(this.getCurrent(), this.getSize());
    }


}
