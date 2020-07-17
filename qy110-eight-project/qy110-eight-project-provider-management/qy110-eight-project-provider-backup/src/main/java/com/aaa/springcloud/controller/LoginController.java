package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.User;
import com.aaa.springcloud.service.LoginService;
import com.aaa.springcloud.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.springcloud.status.LoginStatus.*;

@RestController
public class LoginController extends CommonController<User> {

    @Autowired
    private LoginService loginService;

    public BaseService<User> getBaseService() {
        return loginService;
    }

    /**
     *@Description
     *  执行登陆操作
     * @Param: [user]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/15 15:36
     */
    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody User user) {
        TokenVo tokenVo = loginService.doLogin(user);
        if (tokenVo.isIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        }else if (tokenVo.getType() == 1) {
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        }else if (tokenVo.getType() == 2) {
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        }else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }
    }


}
