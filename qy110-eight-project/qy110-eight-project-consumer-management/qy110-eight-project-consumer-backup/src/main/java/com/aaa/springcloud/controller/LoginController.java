package com.aaa.springcloud.controller;

import com.aaa.springcloud.annotation.LoginAnnotation;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.User;
import com.aaa.springcloud.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private IProjectService iProjectService;

    /**
     *@Description
     *   执行登录操作
     * @Param: [user]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/15 15:31
     */
    @PostMapping("/doLogin")
    @LoginAnnotation(opeationType = "登陆操作",opeationName = "管理员登录")
    public ResultData doLogin(@RequestBody User user) {
        return iProjectService.doLogin(user);
    }


}
