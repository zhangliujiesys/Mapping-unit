package com.aaa.springcloud.mapper;

import com.aaa.springcloud.model.Tscore;

import java.util.List;

/**
 * @author: ldy
 * @date: 2020/7/17
 * description
 */
public interface TscoreMapper {
    /**
     * 根据项目的id进行查找评分记录
     * @param unit_id
     * @return
     */
    public List<Tscore> selectAllTscore(Long unit_id);
    /**
     * 添加评分记录
     */
    public Integer addTscore(Tscore tscore);

}
