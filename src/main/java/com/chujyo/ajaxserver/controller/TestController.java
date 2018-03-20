package com.chujyo.ajaxserver.controller;

import com.chujyo.ajaxserver.bean.ResultBean;
import org.springframework.web.bind.annotation.*;

/**
 * Created by qidd on 2018-3-19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get")
    public ResultBean get() {
        System.out.println("进入get方法");
        return new ResultBean("yes");

    }

    @PostMapping("/postJson")
    public ResultBean post(@RequestBody Useruser user) {

        return new ResultBean("postJson " + user.getName());

    }

    @GetMapping("/getCookie")
    public ResultBean getCookie(@CookieValue("cookie1") String cookie1) {

        return new ResultBean("getCookie " + cookie1);

    }

    @GetMapping("/getHeader")
    public ResultBean getHeader(@RequestHeader("x-header1") String xheader1,
                                @RequestHeader("x-header2") String xheader2) {
        return new ResultBean("getHeader " + xheader1 + " " + xheader2);
    }
}
