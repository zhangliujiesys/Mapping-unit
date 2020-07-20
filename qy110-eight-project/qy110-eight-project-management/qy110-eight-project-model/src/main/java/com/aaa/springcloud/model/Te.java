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
@Table(name = "t_equipment")
public class Te implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "production_id")
    private String production_id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "check_date")
    private Date check_date;

    @Column(name = "effective_date")
    private Date effective_date;

    @Column(name = "invoice_code")
    private String invoice_code;

    @Column(name = "check_department")
    private String check_department;

    @Column(name = "check_certificate_id")
    private String check_certificate_id;

    @Column(name = "identified")
    private String identified;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "modify_time")
    private Date modify_time;
}