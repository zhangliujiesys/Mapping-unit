package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.Te;
import com.aaa.springcloud.service.TeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeController extends CommonController {
    @Autowired
    private TeService teService;
    @Override
    public BaseService getBaseService() {
        return teService;
    }
    @GetMapping("/allTe")
    public ResultData allTe(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        return super.getListByPage(pageNo,pageSize);
    }
    /**
     *@Description
     *   修改
     * @Param: [tDict]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 14:39
     */
    @PostMapping("/upTe")
    public ResultData upTe(@RequestBody Te te) {
        return  super.upByT(te);
    }

    /**
     * 删除项目
     */
    @PostMapping("/delTe")
    public ResultData delTe(@RequestBody Te te){
        return super.delByT(te);
    }
}
