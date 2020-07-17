package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.Tmp;
import com.aaa.springcloud.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TmpController {
    @Autowired
    private IProjectService tmpService;
    @GetMapping("/allTmp")
    public ResultData allTmp(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        return tmpService.allTmp(pageNo,pageSize);
    }
    /**
     *@Description
     *   修改
     * @Param: [tDict]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 14:39
     */
    @PostMapping("/upTmp")
    public ResultData upTmn(@RequestBody Tmp tmp){
        return tmpService.upTmp(tmp);
    }
    /**
     * 添加项目
     * @param tmp
     * @return
     */
    @PostMapping("/addTmp")
    public ResultData addTmp(@RequestBody Tmp tmp){
        return tmpService.addTmp(tmp);
    }
    /**
     * 删除项目
     */
    @PostMapping("/delTmp")
    public ResultData delTmp(@RequestBody Tmp tmp){
        return tmpService.delTmp(tmp);
    }
    /**
     * 批量删除项目
     */
    @PostMapping("/batchDelTmp")
    public ResultData batchDelTmp(@RequestParam("ids[]") Integer[] ids){
        return tmpService.batchDelTmp(ids);
    }
    /**
     * 查询一个项目
     */
    @PostMapping("/selectOneTmp")
    public ResultData selectOneTmp(@RequestBody Tmp tmp){
        return tmpService.selectOneTmp(tmp);
    }
}
