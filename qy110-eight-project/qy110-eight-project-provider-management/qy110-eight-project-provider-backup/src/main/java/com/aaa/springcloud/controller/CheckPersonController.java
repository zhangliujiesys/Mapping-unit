package com.aaa.springcloud.controller;

import com.aaa.springcloud.base.BaseService;
import com.aaa.springcloud.base.CommonController;
import com.aaa.springcloud.base.ResultData;
import com.aaa.springcloud.service.CheckPersonService;
import com.aaa.springcloud.vo.CheckPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ldy
 * @date: 2020/7/17
 * description
 */
@RestController
public class CheckPersonController extends CommonController<CheckPerson> {
    @Autowired
    private CheckPersonService checkPersonService;
    @GetMapping("/selectAllCheckPerson")
    public ResultData selectAllCheckPerson(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
    ResultData resultData =new ResultData();;
    resultData.setData(checkPersonService.selectAllCheckPerson(pageNo,pageSize));
    return resultData;

    }
    @GetMapping("/selectOneCheckPerosn")
    public ResultData selectOneCheckPerson(@RequestParam("id") Long id){
        ResultData resultData =new ResultData();
        resultData.setData(checkPersonService.selectOne(id));
        return resultData;
    }
    @PostMapping("/updateOneCheckPerson")
    public ResultData updateOneCheckPerson(@RequestBody CheckPerson checkPerson){
        ResultData resultData =new ResultData();
        resultData.setData(checkPersonService.updateCheckPerson(checkPerson));
        return  resultData;
    }
    @PostMapping("/insertOneCheckPerson")
    public ResultData insertOnePerson(@RequestBody CheckPerson checkPerson){
        ResultData resultData =new ResultData();
        resultData.setData(checkPersonService.insertCheckPerson(checkPerson));
        return resultData;
    }
    @PostMapping("/deleteOneCheckPerson")
    public ResultData deleteOnePerson(@RequestBody CheckPerson checkPerson){
        ResultData resultData =new ResultData();
        resultData.setData(checkPersonService.deleteCheckPerson(checkPerson));
        return  resultData;
    }
    @Override
    public BaseService<CheckPerson> getBaseService() {
        return null;
    }
}
