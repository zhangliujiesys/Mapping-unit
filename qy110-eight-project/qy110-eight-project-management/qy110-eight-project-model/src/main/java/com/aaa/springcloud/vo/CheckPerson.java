package com.aaa.springcloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: ldy
 * @date: 2020/7/17
 * description
 * 抽查人员vo类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CheckPerson implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 单位名称
     */
    private String unit_name;
    /**
     * 职务
     */
    private  String duty;
    /**
     * 联系电话
     */
    private  String contact_way;
    /**
     * 法人
     */
    private  String corporation;
}
