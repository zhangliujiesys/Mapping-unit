package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.TDict;
import com.aaa.springcloud.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class TDictController {
    @Autowired
    private IProjectService iProjectService;

    /**
     *@Description
     *   查询字典信息
     * @Param: [currentPage, pageSize]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 10:46
     */
    @GetMapping("/allTDict")
    public ResultData allTDict(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        return iProjectService.allTDict(pageNo,pageSize);
    }

    /**
     *@Description
     *  新增
     * @Param: [map]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 11:13
     */
    @PostMapping("/addTDict")
    public ResultData addTDict(@RequestBody TDict tDict) {

        return iProjectService.addTDict(tDict);
    }

    /**
     *@Description
     *   修改
     * @Param: [tDict]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 14:39
     */
    @PostMapping("/upTDict")
    public ResultData upTDict(@RequestBody TDict tDict) {
        return  iProjectService.upTDict(tDict);
    }

    /**
     *@Description
     *  删除
     * @Param: [id]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 11:12
     */
    @PostMapping("/delTDict")
    public ResultData delTDict(@RequestBody TDict tDict) {
        return iProjectService.delTDict(tDict);
    }

}
