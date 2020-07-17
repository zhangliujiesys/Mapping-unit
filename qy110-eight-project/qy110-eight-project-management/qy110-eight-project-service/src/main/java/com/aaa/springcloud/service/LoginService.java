package com.aaa.springcloud.service;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.model.User;
import com.aaa.springcloud.vo.TokenVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService extends BaseService<User> {

    /**
     * @Description 执行登录操作
     * <p>
     * pojo：实体类
     * povo:封装类型(当在实际开发中，会有很多种情况导致多表联查的时候无法装载数据--->我就根据返回前端的数据自己
     * 去封装一个对象出来---->view object)
     * @Param: [user]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/15 15:39
     */
    public TokenVo doLogin(User user) {
        TokenVo tokenVo = new TokenVo();
        User user1 = new User();
        //判断user 是否为空
        if(null != user){
            user1.setUsername(user.getUsername());
            User user2 = selectOne(user1);
            //判断user2 是否为空
            if(null != user2){
                user1.setPassword(user.getPassword());
                User user3 = selectOne(user1);
                if(user3 != null){
                    //登录成功
                    //mybatis 会对连接符进行转义，所以把连接符替换掉
                    String token = UUID.randomUUID().toString().replaceAll("-","");
                    user3.setToken(token);
                    Integer updateResult = update(user3);
                    if(updateResult > 0){
                        tokenVo.setIfSuccess(true);
                        tokenVo.setToken(token);

                    }else {
                        tokenVo.setIfSuccess(false);
                        tokenVo.setType(4);
                        return tokenVo;
                    }

                }else {
                    tokenVo.setIfSuccess(false);
                    tokenVo.setType(2);
                    return tokenVo;
                }
            }else {
                tokenVo.setIfSuccess(false);
                tokenVo.setType(1);
                return tokenVo;
            }
        }else {
            tokenVo.setIfSuccess(false);
            tokenVo.setType(2);
            return tokenVo;
        }
        return tokenVo;
        }


}