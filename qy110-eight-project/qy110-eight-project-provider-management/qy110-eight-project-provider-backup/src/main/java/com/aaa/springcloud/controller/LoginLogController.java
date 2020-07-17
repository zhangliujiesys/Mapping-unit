package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.model.LoginLog;
import com.aaa.springcloud.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginLogController extends CommonController<LoginLog> {

    @Autowired
    private LoginLogService loginLogService;

    public BaseService<LoginLog> getBaseService() {
        return loginLogService;
    }

    /**
     *@Description
     *   新增日志
     * @Param: [loginLog]
     * @Return: java.lang.Integer
     * @Author: ysj
     * @Date: 2020/7/15 19:28
     */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog) {
        return getBaseService().add(loginLog);
    }
}
