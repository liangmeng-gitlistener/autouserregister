package com.gtzz.autouserregister.controller;

import com.gtzz.autouserregister.bean.Result;
import com.gtzz.autouserregister.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRegister")
@Slf4j
public class UserRegisterController {

    @GetMapping("/userRegister")
    public Result userRegister() {
        return ResultUtil.success();
    }
}
