package com.aaa.springcloud.base;

import com.aaa.springcloud.utils.Map2BeanUtils;
import com.aaa.springcloud.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.aaa.springcloud.staticproperties.OrderStatic.*;


/**
 * 通用service
 */

public abstract class BaseService<T> {
    // 全局变量，缓存子类的泛型类型
    private Class<T> cache = null;

    @Autowired
    private Mapper<T> mapper;

    /**
     * 获取子类泛型类型
     * @return
     */
    public Class<T> getTypeArguement(){
        if (null == cache){
            cache = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }

    /**
     * 实现查询通用
     *  不但可以作用域分页，还可以作用与排序，还可以作用于多条件查询
     *  orderByFiled:是所要排序的字段
     * @return
     */
    private List<T> selectByFileds(Integer pageNo, Integer pageSize, Sqls where, String orderByFiled, String orderWord, String... fileds){
        Example.Builder builder = null;
        if (null == fileds || fileds.length == 0) {
            //查询所有数据
            builder = Example.builder(getTypeArguement());
        } else {
            //说明需要进行条件查询
            builder = Example.builder(getTypeArguement()).select(fileds);
        }
        if (where != null) {
            //说明有用户自定义的where语句条件
            builder = builder.where(where);
        }
        if (orderByFiled != null) {
            if (DESC.equals(orderByFiled.toUpperCase())) {
                // 说明需要倒序
                builder = builder.orderByDesc(orderByFiled);
            } else if (ASC.equals(orderByFiled.toUpperCase())) {
                builder = builder.orderByAsc(orderByFiled);
            } else {
                //默认倒序
                builder = builder.orderByDesc(orderByFiled);
            }
        }
        Example example = builder.build();
        //实现分页
        if (pageNo != null & pageSize != null) {
            PageHelper.startPage(pageNo,pageSize);
        }
        return getMapper().selectByExample(example);
    }

    /**
     *@Description
     *  map转换实体类型
     * @Param: [map]
     * @Return: T
     * @Author: ysj
     * @Date: 2020/7/9 19:15
     */
    public T newIntance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map, getTypeArguement());
    }


    protected Mapper getMapper(){
        return mapper;
    }

    /**
     * 新增数据
     * @param t
     * @return
     */
    public Integer add(T t){
        return mapper.insert(t);
    }

    /**
     * 根据主键进行删除
     * @param t
     * @return
     */
    public Integer delete(T t){
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * 根据主键进行批量删除
     * @param ids
     * @return
     */
    public Integer deleteByIds(List<Integer> ids){
        /**
         * delete * from user where 1 = 1 and id in (1,2,3,4,5,6,7,8)
         * andIn("id")--->id就是数据库中的主键名称
         */
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id",ids)).build();
        return mapper.deleteByPrimaryKey(example);
    }

    /**
     * 更新操作
     * @param t
     * @return
     */
    public Integer update(T t){
        return mapper.updateByPrimaryKeySelective(t);
    }

    /**
     *  update username = ?  from user where id in (1,2,3,4,5,6,7)
     * @param t
     * @param ids
     * @return
     */
    public Integer bachUpdate(T t,Integer[] ids){
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }

    /**
     *  查询一条数据
     *  形参中的t所传递的数据--->主键，唯一键(username, phone number....)
     * @param t
     * @return
     */
    public T selectOne(T t){
        return mapper.selectOne(t);
    }

    /**
     * 查询一条数据
     * 可以排序(orderByFiled:ASC,DESC)
     * fileds:不只是代表唯一键
     *  password
     *  age
     *  address
     *  select * from user where password = xxxx and age = xx and address = xxx
     * @param wehre
     * @param orderByFiled
     * @param fileds
     * @return
     */
    public T selectOneByFiled(Sqls wehre,String orderByFiled,String... fileds){
        return (T)selectByFileds(null,null,wehre,orderByFiled,null,fileds).get(0);
    }

    /**
     * 通过条件查询一个列表
     * @param where
     * @param orderByFiled
     * @param fields
     * @return
     */
    public List<T> selectListByFiled(Sqls where,String orderByFiled,String... fields) {
        return selectByFileds(null,null,where,orderByFiled,null,fields);
    }

    /**
     * 实现条件查询的分页
     * @param pageNo
     * @param pageSize
     * @param where
     * @param orderFiled
     * @param fileds
     * @return
     */
    public PageInfo<T> selectListByPageAndFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return new PageInfo<T>(selectByFileds(pageNo,pageSize,where,orderFiled,null,fileds));
    }

    /**
     * 查询集合，条件查询
     * @param t
     * @return
     */
    public List<T> selectList(T t){
        return mapper.select(t);
    }

    /**
     * 查询集合，分页查询
     * @param t
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<T> selectListByPage(T t, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     *@Description
     *      获取spring容器/获取spring的上下文
     *      在项目开始运行的时候，会去加载spring配置，
     *      如果你们项目需要在项目启动的时候也加载自己的配置文件
     *      在spring的源码中有一个必须要看的方法(init())
     *      init()--->就是在项目启动的时候去加载spring的配置
     *       如果你的项目中也需要把某一些配置一开始就托管给spring
     *       需要获取到spring的上下文(ApplicationContext)
     * @Param: []
     * @Return: org.springframework.context.ApplicationContext
     * @Author: ysj
     * @Date: 2020/7/9 17:06
     */
    public ApplicationContext getApplicationContext() {
        return SpringContextUtils.getApplicationContext();
    }

}
