package com.gtzz.autouserregister.controller;

import com.gtzz.autouserregister.bean.Result;
import com.gtzz.autouserregister.service.iservice.IUserRegisterService;
import com.gtzz.autouserregister.utils.AuthStringUtil;
import com.gtzz.autouserregister.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userRegister")
@Slf4j
public class UserRegisterController {

    @Autowired
    IUserRegisterService service;

    @PostMapping("/userRegister")
    @ApiOperation(value = "自动新增用户")
    public Result userRegister(@ApiParam(value = "电话号码", required = true)
                                   @RequestParam("phoneNumber") String phoneNumber) {
        if (!AuthStringUtil.checkPhoneFromat(phoneNumber)) {
            return ResultUtil.error(-1, "手机号不合法");
        }
        service.userRegister(phoneNumber);
        return ResultUtil.success();
    }
}
