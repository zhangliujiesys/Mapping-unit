package com.aaa.springcloud.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: ldy
 * @date: 2020/7/18
 * description
 */
@Data
public class Taudit implements Serializable {
    private Long id;
    private String name;
    private Integer type;
    private Long user_id;
    private  Integer status;
    private Date submit_time;
    private  Date audit_time;
    private  String momo;
    private  Long ref_id;
    private  Date create_time;
}
