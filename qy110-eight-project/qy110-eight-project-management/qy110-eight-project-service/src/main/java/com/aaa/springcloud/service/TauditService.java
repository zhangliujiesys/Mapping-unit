package com.aaa.springcloud.service;

import com.aaa.springcloud.mapper.TauditMapper;
import com.aaa.springcloud.model.Taudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ldy
 * @date: 2020/7/18
 * description
 */
@Service
public class TauditService {
    @Autowired
    private TauditMapper tauditMapper;

    /**
     * 根据id查找审核信息
     * @param id
     * @param type
     * @return
     */
    public List<Taudit> selectAllById(Integer id, Integer type){
       return tauditMapper.selectById(id,type);
    }

    /**
     * 添加审核信息
     * @param taudit
     * @return
     */
    public Integer add(Taudit taudit){
        return tauditMapper.add(taudit);
    }

    /**
     * 根据user_id查找审核信息
     * @param user_id
     * @param type
     * @return
     */
    public List<Taudit> selectAllByUserId(Integer user_id, Integer type){
        return  tauditMapper.selectByIdu(user_id,type);
    }
 }
