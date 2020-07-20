package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.Tt;
import com.aaa.springcloud.service.TtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TtController extends CommonController {
    @Autowired
    private TtService ttService;
    @Override
    public BaseService getBaseService() {
        return ttService;
    }
    @GetMapping("/allTt")
    public ResultData allTt(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
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
    @PostMapping("/upTt")
    public ResultData upTt(@RequestBody Tt tt) {
        return  super.upByT(tt);
    }

    /**
     * 删除项目
     */
    @PostMapping("/delTt")
    public ResultData delTt(@RequestBody Tt tt){
        return super.delByT(tt);
    }
}
