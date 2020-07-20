package com.aaa.springcloud.controller;
import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.Tsp;
import com.aaa.springcloud.service.TspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TspController extends CommonController {
    @Autowired
    private TspService tspService;
    @Override
    public BaseService getBaseService() {
        return tspService;
    }

    @GetMapping("/allTsp")
    public ResultData allTsp(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize){
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
    @PostMapping("/upTsp")
    public ResultData upTsp(@RequestBody Tsp tsp) {
        return  super.upByT(tsp);
    }

    /**
     * 删除项目
     */
    @PostMapping("/delTsp")
    public ResultData delTsp(@RequestBody Tsp tsp){
        return super.delByT(tsp);
    }
}
