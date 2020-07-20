package com.aaa.springcloud.controller;

import com.aaa.springcloud.model.Taudit;
import com.aaa.springcloud.service.TauditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ldy
 * @date: 2020/7/18
 * description
 */
@RestController
public class TauditController {
    @Autowired
    private TauditService tauditService;

    /**
     * 根据id查找审核信息
     * @param id
     * @param type
     * @return
     */
    @GetMapping("/selectTauditById")
    public List<Taudit> selectAllByIdTaudit(@RequestParam("id") Integer id,@RequestParam("type") Integer type){
        return tauditService.selectAllById(id,type);
    }

    /**
     * 添加审核记录
     * @param taudit
     * @return
     */
    @PostMapping("/addTaudit")
    public Integer add(@RequestBody Taudit taudit){
        return tauditService.add(taudit);
    }

    /**
     * 根据user_id字段查询审核信息
     * @param user_id
     * @param type
     * @return
     */
    @GetMapping("/selectTauditByUserId")
    public List<Taudit> selectAllByuserId(Integer user_id, Integer type){
        return tauditService.selectAllByUserId(user_id,type);
    }
}
