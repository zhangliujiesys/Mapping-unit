package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TDeptController {

    @Autowired
    private IProjectService iProjectService;

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
        return iProjectService.allTDept(pageNo, pageSize);
    }

}
