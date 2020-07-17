package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.Tmn;
import com.aaa.springcloud.service.TmnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TmnController extends CommonController<Tmn> {
    @Autowired
    private TmnService tmnService;
    @Override
    public BaseService getBaseService() {
        return tmnService;
    }

    /**
     * 根据页数搜索数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/allTmn")
    public ResultData allTmn(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
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
    @PostMapping("/addTmn")
    public ResultData addTmn(@RequestBody Tmn tmn) {
        return super.addByT(tmn);
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
        return  super.upByT(tmn);
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
        return super.delByT(tmn);
    }
    /**
     * 批量删除
     */
    @PostMapping("/batchDelTmn")
    public ResultData batchDelTmn(@RequestParam("ids[]") Integer[] ids) {
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
    @PostMapping("/selectOneTmn")
    public ResultData selectOneTmn(@RequestBody Tmn tmn) {
        System.out.println(tmn);
        return super.getOneByT(tmn);
    }
}
