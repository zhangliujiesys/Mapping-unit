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
@Table(name = "t_principal")
public class Tp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "id_type")
    private String id_type;

    @Column(name = "id_number")
    private String id_number;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "work_year")
    private Integer work_year;

    @Column(name = "duty")
    private String duty;

    @Column(name = "title")
    private String title;

    @Column(name = "mapping_year")
    private Integer mapping_year;

    @Column(name = "major")
    private String major;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "modify_time")
    private Date modify_time;


}
