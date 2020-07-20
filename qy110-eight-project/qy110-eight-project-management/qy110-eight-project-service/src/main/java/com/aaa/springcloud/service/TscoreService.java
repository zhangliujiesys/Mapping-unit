package com.aaa.springcloud.service;

import com.aaa.springcloud.mapper.TscoreMapper;
import com.aaa.springcloud.model.Tscore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: ldy
 * @date: 2020/7/17
 * description
 */
@Service
public class TscoreService {
    @Autowired
    private TscoreMapper tscoreMapper;

    /**
     * 根据项目di去查询评分记录
     * @param unit_id
     * @return
     */
    public List<Tscore> select(Long unit_id){
        return tscoreMapper.selectAllTscore(unit_id);
    }

    /**
     * 添加评分记录表
     * @param tscore
     * @return
     */
    public Integer addTscore(Tscore tscore){
        Date date=new Date();
        tscore.setCreate_time(date);
        return tscoreMapper.addTscore(tscore);
    }

}
