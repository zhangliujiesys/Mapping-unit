package com.aaa.springcloud.model;

import lombok.Data;

import java.util.Date;

/**
 * @author: ldy
 * @date: 2020/7/17
 * description
 */
@Data
public class Tscore {
    /**
     * 编号
     */
    private Long id;
    /**
     * 增加的分值
     */
    private  Integer score_plus;
    /**
     * 减少的分值
     */
    private  Integer score_subtract;
    /**
     * 当前分值
     */
    private  Integer score;
    /**
     * 关联单位编号
     */
    private  Long unit_id;
    /**
     * 增减/减少分值的原因
     */
    private  String reason;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 修改时间
     */
    private  Date modify_time;



}
