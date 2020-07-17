package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.Tmn;
import com.aaa.springcloud.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TmnController {
    @Autowired
    private IProjectService tmnService;

    @GetMapping("/allTmn")
    public ResultData allTmn(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        return tmnService.allTmn(pageNo,pageSize);
    }

    /**
     *@Description
     *  新增
     * @Param: [map]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 11:13
     */
    @GetMapping("/addTmn")
    public ResultData addTmn(@RequestBody Tmn tmn) {
        return tmnService.addTmn(tmn);
    }

    /**
     *@Description
     *   修改
     * @Param: [tDict]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 14:39
     */
    @PostMapping("/upTmn")
    public ResultData upTmn(@RequestBody Tmn tmn) {
        return  tmnService.upTmn(tmn);
    }

    /**
     *@Description
     *  删除
     * @Param: [id]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 11:12
     */
    @PostMapping("/delTmn")
    public ResultData delTmn(@RequestBody Tmn tmn) {
        return tmnService.delTmn(tmn);
    }

    /**
     * 批量删除
     */
    @PostMapping("/batchDelTmn")
    public ResultData batchDelTmn(@RequestParam("ids[]") Integer[] ids){
        return tmnService.batchDelTmn(ids);
    }

    /**
     *@Description
     *   查询一条
     * @Param: [tDict]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 19:19
     */
    @PostMapping("/selectOneTmn")
    public ResultData selectOneTmn(@RequestBody Tmn tmn) {
        System.out.println(tmn);
        return tmnService.selectOneTmn(tmn);
    }

}
