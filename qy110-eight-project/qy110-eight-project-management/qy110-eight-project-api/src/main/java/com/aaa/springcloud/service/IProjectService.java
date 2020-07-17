package com.aaa.springcloud.service;

import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@FeignClient(value = "project-provider-backup")
public interface IProjectService {

    /**
     *@Description
     *   执行登录操作
     * @Param: [user]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/15 15:34
     */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);

    /**
     *@Description
     *   新增日志
     * @Param: [loginLog]
     * @Return: java.lang.Integer
     * @Author: ysj
     * @Date: 2020/7/15 19:24
     */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);

    /**
     *@Description
     *   查询字典信息
     * @Param: [currentPage, pageSize]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 10:46
     */
    @GetMapping("/allTDict")
    ResultData allTDict(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);

    /**
     *@Description
     *  新增
     * @Param: [map]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 11:13
     */
    @PostMapping("/addTDict")
    ResultData addTDict(@RequestBody TDict tDict);

    /**
     *@Description
     *   修改
     * @Param: [tDict]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 14:39
     */
    @PostMapping("/upTDict")
    ResultData upTDict(@RequestBody TDict tDict);

    /**
     *@Description
     *  删除
     * @Param: [id]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 11:12
     */
    @PostMapping("/delTDict")
    ResultData delTDict(@RequestBody TDict tDict);

    /**
     *@Description
     *  部门查询
     * @Param: [pageNo, pageSize]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 15:41
     */
    @GetMapping("/allTDept")
    ResultData allTDept(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);

    @GetMapping("/allTmn")
    ResultData allTmn(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);
    @GetMapping("/addTmn")
    public ResultData addTmn(@RequestBody Tmn tmn);
    @PostMapping("/upTmn")
    public ResultData upTmn(@RequestBody Tmn tmn);
    @PostMapping("/delTmn")
    public ResultData delTmn(@RequestBody Tmn tmn);
    @PostMapping("/selectOneTmn")
    public ResultData selectOneTmn(@RequestBody Tmn tmn);
    /**
     * 批量删除
     */
    @PostMapping("/batchDelTmn")
    public ResultData batchDelTmn(@RequestParam("ids[]") Integer[] ids);

    @GetMapping("/allTmp")
    public ResultData allTmp(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);

    /**
     *@Description
     *   修改
     * @Param: [tDict]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 14:39
     */
    @PostMapping("/upTmp")
    public ResultData upTmp(@RequestBody Tmp tmp);
    /**
     * 添加项目
     * @param tmp
     * @return
     */
    @PostMapping("/addTmp")
    public ResultData addTmp(@RequestBody Tmp tmp);
    /**
     * 删除项目
     */
    @PostMapping("/delTmp")
    public ResultData delTmp(@RequestBody Tmp tmp);
    /**
     * 批量删除项目
     */
    @PostMapping("/batchDelTmp")
    public ResultData batchDelTmp(@RequestParam("ids[]") Integer[] ids);
    /**
     * 查询一个项目
     */
    @PostMapping("/selectOneTmp")
    public ResultData selectOneTmp(@RequestBody Tmp tmp);

}
