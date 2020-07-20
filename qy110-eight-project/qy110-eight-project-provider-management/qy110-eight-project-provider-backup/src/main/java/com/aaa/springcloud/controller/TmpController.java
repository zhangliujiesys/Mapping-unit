package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.model.Tmn;
import com.aaa.springcloud.model.Tmp;
import com.aaa.springcloud.service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TmpController extends CommonController {
    @Autowired
    private TmpService tmpService;

    @Override
    public BaseService getBaseService() {
        return tmpService;
    }
    /**
     * 根据输入的页码获取数据
     */
    @GetMapping("/allTmp")
    public ResultData allTmp(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
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
    @PostMapping("/upTmp")
    public ResultData upTmn(@RequestBody Tmp tmp) {
        return  super.upByT(tmp);
    }

    /**
     * 添加项目
     * @param tmp
     * @return
     */
    @PostMapping("/addTmp")
    public ResultData addTmp(@RequestBody Tmp tmp){
        return  super.addByT(tmp);
    }

    /**
     * 删除项目
     */
    @PostMapping("/delTmp")
    public ResultData delTmp(@RequestBody Tmp tmp){
        return super.delByT(tmp);
    }

    /**
     * 批量删除项目
     */
    @PostMapping("/batchDelTmp")
    public ResultData batchDelTmp(@RequestParam("ids[]") Integer[] ids){
        return super.batchDelete(ids);
    }

    /**
     * 查询一个项目
     */
    @PostMapping("/selectOneTmp")
    public ResultData selectOneTmp(@RequestBody Tmp tmp){
        return super.getOneByT(tmp);
    }

    /**
     * 根据类型进行查询
     */
    @GetMapping("/getListByPage")
    public ResultData getListByType( Map map, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        return super.getListByPage(map,pageNo,pageSize);
    }

}
