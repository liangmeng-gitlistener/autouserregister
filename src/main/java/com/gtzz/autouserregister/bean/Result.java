package com.gtzz.autouserregister.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * http请求返回的最外层对象
 */
@Data
@NoArgsConstructor
@ApiModel
public class Result<T> {
    @ApiModelProperty(value = "错误码", name = "code", example = "0")
    private Integer code;
    @ApiModelProperty(value = "错误信息", name = "msg", example = "成功")
    private String msg;
    //  具体内容
    private T data;
}
