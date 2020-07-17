package com.aaa.springcloud.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *@Description
 *
 * @Param:
 * @Return:
 * @Author: ysj
 * @Date: 2020/7/9 18:57
 */
public abstract class CommonController<T> extends BaseController {

    /**
     *@Description
     * 钩子函数
     * 在新增之前去执行某些操作
     *      下单操作:
     *          需求
     *              在购物车中当点击立即下单按钮的时候--->跳转下单页面(选择地址，选择优惠券...)
     *              把购物车中的这个商品删除
     *              deleteCart(List<Integer> id);--->是优先于insertOrder前置执行
     *
     *          insertOrder(Order oder);
     * @Param: [map]
     * @Return: void
     * @Author: ysj
     * @Date: 2020/7/9 18:56
     */
    protected void beforeAdd(Map map) {
        T intance = getBaseService().newIntance(map);

        // TODO AddMethod Before to do something
    }

    /**
     *@Description
     *   钩子函数
     *      是在新增之后去执行
     *
     *      int result = insertOrder(Order order)
     *      if(result > 0) {
     *          insertOrderDetail(OrderDetail orderDetail);
     *      }
     *
     * @Param: [map]
     * @Return: void
     * @Author: ysj
     * @Date: 2020/7/9 19:01
     */
    protected void afterAdd(Map map) {
        // TODO AddMethod After to do something
    }

    public abstract BaseService<T> getBaseService();

    /**
     *@Description
     *  通用的新增方法
     *  因为咱们目前市面上所有的公司实现的全是异步了
     *  也就是说前端向后端所传递的数据都是json格式
     *  之前在controller的方法中接收固定的实体类，是因为你知道前端给你传递的类型就是这个实体类
     *  但是既然要做通用，前端所传递的类型就不会固定了--->所以使用Map类型来统一接收
     * @Param: [map]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 19:08
     */
    public ResultData add(@RequestBody Map map) {
        // 因为根据咱们的封装规则，在service中是需要传递泛型的，就意味着service需要接收固定的实体类
        // 但是controller是一个Map类型
        beforeAdd(map);
        // 1.Map转实体类
        T intance = getBaseService().newIntance(map);
        // 2.通用service
        Integer addResult = getBaseService().add(intance);
        if (addResult > 0) {
            afterAdd(map);
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    public ResultData addByT(@RequestBody T t) {
        Integer addResult = getBaseService().add(t);
        if (addResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     *@Description
     *  删除操作
     * @Param: [map]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:12
     */
    public ResultData delete(@RequestBody Map map) {
        T intance = getBaseService().newIntance(map);
        Integer deleteResult = getBaseService().delete(intance);
        if (deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    public ResultData delByT(@RequestBody T t) {
        Integer deleteResult = getBaseService().delete(t);
        if (deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     *@Description
     *      批量删除
     * @Param: [ids]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 20:16
     */
    public ResultData batchDelete(@RequestParam("ids[]") Integer[] ids) {
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if (deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     *@Description
     *   修改操作
     * @Param: [map]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 21:17
     */
    public ResultData update(@RequestBody Map map) {
        T intance = getBaseService().newIntance(map);
        Integer updateResult = getBaseService().update(intance);
        if (updateResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    public ResultData upByT(@RequestBody T t) {
        Integer updateResult = getBaseService().update(t);
        if (updateResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     *@Description
     *   批量修改
     * @Param: [map, ids]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 21:21
     */
    public ResultData bachUpdate(@RequestBody Map map,@RequestParam("ids[]") Integer[] ids) {
        T intance = getBaseService().newIntance(map);
        Integer bachUpdate = getBaseService().bachUpdate(intance,ids);
        if (bachUpdate > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     *@Description
     *   查询一条数据
     * @Param: [map]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 21:24
     */
    public ResultData getOne(@RequestBody Map map) {
        T intance = getBaseService().newIntance(map);
        T selectOne = getBaseService().selectOne(intance);
        if (selectOne != null) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    public ResultData getOneByT(@RequestBody T t) {
        T selectOne = getBaseService().selectOne(t);
        if (selectOne != null) {
            return super.operationSuccess(selectOne);
        }
        return super.operationFailed();
    }

    /**
     *@Description
     *   条件查询多条结果
     * @Param: [orderFiled, fields]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/9 21:28
     */
    public ResultData getList(@RequestBody Map map) {
        T intance = getBaseService().newIntance(map);
        List<T> resultT = getBaseService().selectList(intance);
        if(resultT.size() > 0) {
            return operationSuccess(resultT);
        }
        return operationFailed("未找到查询结果");
    }

    /**
     *@Description
     *   带条件的分页查询
     * @Param: [map, pageNo, pageSize]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/10 14:45
     */
    public ResultData getListByPage(@RequestBody Map map, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        T t = getBaseService().newIntance(map);
        PageInfo<T> pageInfo = getBaseService().selectListByPage(t,pageNo,pageSize);
        List<T> resultList = pageInfo.getList();
        if(resultList.size() > 0) {
            return operationSuccess(pageInfo);
        }
        return operationFailed("未找到查询结果");
    }

    /**
     *@Description
     *   不带条件的分页查询
     * @Param: [pageNo, pageSize]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/10 14:45
     */
    public ResultData getListByPage( @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        PageInfo<T> pageInfo =getBaseService().selectListByPage(null,pageNo,pageSize);
        List<T> resultList = pageInfo.getList();
        if(resultList.size() > 0) {
            return operationSuccess(pageInfo);
        }
        return operationFailed("未找到查询结果");
    }

    /**
     *@Description
     *   从本地当前线程中获取request对象
     * @Param: []
     * @Return: javax.servlet.http.HttpServletRequest
     * @Author: ysj
     * @Date: 2020/7/10 14:46
     */
    public HttpServletRequest getServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if (requestAttributes instanceof ServletRequestAttributes) {
            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }

    /**
     *@Description
     *   获取当前客户端session对象(如果没有则创建一个新的session)
     * @Param: []
     * @Return: javax.servlet.http.HttpSession
     * @Author: ysj
     * @Date: 2020/7/10 14:47
     */
    public HttpSession getSession() {
        return getServletRequest().getSession();
    }

    /**
     *@Description
     *   获取当前客户端session对象(如果没有则直接返回null)
     * @Param: []
     * @Return: javax.servlet.http.HttpSession
     * @Author: ysj
     * @Date: 2020/7/10 14:47
     */
    public HttpSession getExistSession() {
        return getServletRequest().getSession(false);
    }

}
