package com.aaa.springcloud.controller;

import com.aaa.springcloud.model.Tscore;
import com.aaa.springcloud.service.TscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ldy
 * @date: 2020/7/17
 * description
 */
@RestController
public class TscoreController {
    @Autowired
    private TscoreService tscoreService;

    /**
     * 根据项目id去查询评分记录表
     * @param unit_id
     * @return
     */
    @GetMapping("/allTscore")
    public List<Tscore> select(@RequestParam("unit_id") Long unit_id){
        return tscoreService.select(unit_id);
    }
    /**
     * 添加项目评分记录表
     */
    @PostMapping("/addTscore")
    public Integer add(@RequestBody Tscore tscore){
       return tscoreService.addTscore(tscore);
    }
}
