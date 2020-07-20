package com.aaa.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_technicist")
public class Tt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "major_type")
    private String major_type;

    @Column(name = "id_type")
    private String id_type;

    @Column(name = "id_number")
    private String id_number;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "work_year")
    private Integer work_year;

    @Column(name = "duty")
    private String duty;

    @Column(name = "title")
    private String title;

    @Column(name = "school")
    private String school;

    @Column(name = "graduation_date")
    private Date graduation_date;

    @Column(name = "degree")
    private String degree;

    @Column(name = "education_background")
    private String education_background;

    @Column(name = "major")
    private String major;

    @Column(name = "title_major")
    private String title_major;

    @Column(name = "start_time")
    private Date start_time;

    @Column(name = "title_time")
    private Date title_time;

    @Column(name = "start_contract")
    private Date start_contract;

    @Column(name = "end_contract")
    private Date end_contract;

    @Column(name = "post")
    private String post;

    @Column(name = "mapping_year")
    private Integer mapping_year;

    @Column(name = "special_post")
    private String special_post;

    @Column(name = "affirm")
    private String affirm;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "modify_time")
    private Date modify_time;
}
