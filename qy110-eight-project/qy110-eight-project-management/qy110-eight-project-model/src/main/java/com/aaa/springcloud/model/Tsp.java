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
@Table(name = "t_special_post")
public class Tsp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_number")
    private String id_number;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "work_year")
    private Integer work_year;

    @Column(name = "school")
    private String school;

    @Column(name = "major")
    private String major;

    @Column(name = "education_background")
    private String education_background;

    @Column(name = "degree")
    private String degree;

    @Column(name = "special_post")
    private String special_post;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "modify_time")
    private Date modify_time;
}
