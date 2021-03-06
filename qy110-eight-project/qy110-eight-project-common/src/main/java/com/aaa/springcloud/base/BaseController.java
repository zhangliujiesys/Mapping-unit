package com.aaa.springcloud.base;



import org.objenesis.Objenesis;

import javax.jws.Oneway;

import static com.aaa.springcloud.status.LoginStatus.*;
import static com.aaa.springcloud.status.OperationStatus.*;
import static com.aaa.springcloud.status.OperationStatus.*;

/**
 *      统一controller
 *      也就是说所有的controller都需要继承这个controller，进行统一返回
 *
 *      eg:
 *          登录成功和失败
 *          code:200 msg:登录成功
 *          code:400 msg:登录失败，系统异常
 *          code:201 msg:用户已经存在
 *          code:401 msg:用户不存在
 *          code:402 msg:密码错误
 *          code:405 msg:用户退出异常
 */

public class BaseController {
    /**
     * 登陆成功
     * 使用系统消息
     * @return
     */
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 登陆成功
     * 自定义返回消息
     * @return
     */
    protected ResultData loginSuccess(String code,String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 登陆成功
     * 返回数据信息，使用系统消息
     * @return
     */
    protected ResultData loginSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登陆失败
     * 使用系统消息
     * @return
     */
    protected ResultData loginFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * 登陆失败
     * 使用系统消息 详细解释说明
     * @return
     */
    protected ResultData loginFailed(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     *@Description
     *  用户已经存在 使用系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:29
     */
    protected ResultData userExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   用户不存在
     *   使用系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:30
     */
    protected ResultData userNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   密码错误
     *   使用系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:31
     */
    protected ResultData passwordWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   用户退出异常
     *   使用系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:33
     */
    protected ResultData logoutWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        return resultData;
    }

    /**
     *@Description
     *      操作成功，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:02
     */
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     *@Description
     *      操作成功，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:02
     */
    protected ResultData operationSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     *@Description
     *      操作失败，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:02
     */
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     *@Description
     *      操作失败，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:02
     */
    protected ResultData operationFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *@Description
     *   删除操作，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:35
     */
    protected ResultData deleteOperation() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION.getCode());
        resultData.setMsg(DELETE_OPERATION.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   修改操作，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:36
     */
    protected ResultData updateOperation() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION.getCode());
        resultData.setMsg(UPDATE_OPERATION.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   新增操作，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:37
     */
    protected ResultData insertOperation() {
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_OPERATION.getCode());
        resultData.setMsg(INSERT_OPERATION.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   路由过滤成功，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:38
     */
    protected ResultData zuulFilterSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   路由过滤失败，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:39
     */
    protected ResultData zuulFilterFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_FAILED.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   token值存在，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:41
     */
    protected ResultData zuulFilterTokenSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   token值不存在，返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:42
     */
    protected ResultData zuulFilterTokenFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_FAILED.getMsg());
        return resultData;
    }

    /**
     *@Description
     *   request对象为null,返回系统消息
     * @Param: []
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:43
     */
    protected ResultData requestIsNull() {
        ResultData resultData = new ResultData();
        resultData.setCode(REQUEST_IS_NULL.getCode());
        resultData.setMsg(REQUEST_IS_NULL.getMsg());
        return resultData;
    }

}
