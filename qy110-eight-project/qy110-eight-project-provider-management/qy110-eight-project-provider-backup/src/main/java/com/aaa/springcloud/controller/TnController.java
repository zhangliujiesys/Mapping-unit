package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.Tmn;
import com.aaa.springcloud.model.Tn;
import com.aaa.springcloud.service.TnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class TnController extends CommonController {
    @Autowired
    private TnService tnService;
    @Override
    public BaseService getBaseService() {
        return tnService;
    }
    @GetMapping("/allTn")
    public ResultData allTn(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize){
        return super.getListByPage(pageNo,pageSize);
    }
    /**
     *@Description
     *  新增
     * @Param: [map]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 11:13
     */
    @PostMapping("/addTn")
    public ResultData addTn(@RequestBody Tn tn) {
        tn.setGmt_create(new Date());
        return super.addByT(tn);
    }

    /**
     *@Description
     *   修改
     * @Param: [tDict]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 14:39
     */
    @PostMapping("/upTn")
    public ResultData upTn(@RequestBody Tn tn) {
        return  super.upByT(tn);
    }

    /**
     *@Description
     *  删除
     * @Param: [id]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 11:12
     */
    @PostMapping("/delTn")
    public ResultData delTn(@RequestBody Tn tn) {
        return super.delByT(tn);
    }
    /**
     * 批量删除
     */
    @GetMapping("/batchDelTn")
    public ResultData batchDelTn(@RequestParam("ids[]") Integer[] ids) {
        return super.batchDelete(ids);
    }

    /**
     *@Description
     *   查询一条
     * @Param: [tDict]
     * @Return: com.aaa.springcloud.base.ResultData
     * @Author: ysj
     * @Date: 2020/7/16 19:19
     */
    @PostMapping("/selectOneTn")
    public ResultData selectOneTn(@RequestBody Tn tn) {
        return super.getOneByT(tn);
    }
}
