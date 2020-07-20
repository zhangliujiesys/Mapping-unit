package com.aaa.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_news")
public class Tn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "digest")
    private String digest;

    @Column(name = "gmt_create")
    private Date gmt_create;

    @Column(name = "gmt_modified")
    private Date gmt_modified;

    @Column(name = "body")
    private String body;

}
