package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.TDept;
import com.aaa.springcloud.service.TDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TDeptController extends CommonController<TDept> {

    @Autowired
    private TDeptService tDeptService;

    public BaseService<TDept> getBaseService() {
        return tDeptService;
    }

    /**
     *@Description
     *  部门查询
     * @Param: [pageNo, pageSize]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 15:41
     */
    @GetMapping("/allTDept")
    public ResultData allTDept(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        return super.getListByPage(pageNo,pageSize);
    }
}
