package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.Tmp;
import com.aaa.springcloud.model.Tp;
import com.aaa.springcloud.service.TpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TpController extends CommonController {
    @Autowired
    private TpService tpService;
    @Override
    public BaseService getBaseService() {
        return tpService;
    }
@GetMapping("/allTp")
    public ResultData allTp(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
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
    @PostMapping("/upTp")
    public ResultData upTp(@RequestBody Tp tp) {
        return  super.upByT(tp);
    }

    /**
     * 删除项目
     */
    @PostMapping("/delTp")
    public ResultData delTp(@RequestBody Tp tp){
        return super.delByT(tp);
    }
}
