package com.gtzz.autouserregister.utils;

import com.gtzz.autouserregister.bean.Result;
import org.springframework.util.StringUtils;

public class ResultUtil {
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }

    public static Result error(Integer code, String Msg) {
        Result result = new Result();
        result.setCode(code);
        if (!StringUtils.isEmpty(Msg)) {
            result.setMsg(Msg);
        } else {
            result.setMsg("失败");
        }
        return result;
    }
}
