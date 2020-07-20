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
@Table(name = "t_mapping_project")
public class Tmp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_type")
    private String project_type;

    @Column(name = "project_name")
    private String project_name;

    @Column(name = "project_amount")
    private Double project_amount;

    @Column(name = "project_leader")
    private String project_leader;

    @Column(name = "start_date")
    private String start_date;

    @Column(name = "end_date")
    private String end_date;

    @Column(name = "complete_time")
    private String complete_time;

    @Column(name = "acceptance_department")
    private String acceptance_department;

    @Column(name = "acceptance_report")
    private String acceptance_report;

    @Column(name = "task_source")
    private String task_source;

    @Column(name = "project_area")
    private Double project_area;

    @Column(name = "scale")
    private String scale;

    @Column(name = "sheet_number")
    private String sheet_number;

    @Column(name = "awards_department")
    private String awards_department;

    @Column(name = "prize_level")
    private String prize_level;

    @Column(name = "project_quality_approval")
    private String project_quality_approval;

    @Column(name = "winning_time")
    private String winning_time;

    @Column(name = "acceptance_time")
    private String acceptance_time;

    @Column(name = "basic_content")
    private String basic_content;

    @Column(name = "credit_status")
    private String credit_status;

    @Column(name = "submit_status")
    private String submit_status;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "schedule")
    private Integer schedule;

    @Column(name = "create_time")
    private String create_time;

    @Column(name = "modify_time")
    private String modify_time;

    @Column(name = "memo")
    private String memo;

    @Column(name = "status")
    private Integer status;

    @Column(name = "audit_status")
    private Integer audit_status;

    @Column(name = "results_status")
    private Integer results_status;

    @Column(name = "meridian")
    private String meridian;

    @Column(name = "coordinate_system")
    private String coordinate_system;

    @Column(name = "management_level")
    private String management_level;

    @Column(name = "funding_source")
    private String funding_source;

    @Column(name = "entrust_unit")
    private String entrust_unit;

    @Column(name = "accept_unit")
    private String accept_unit;

    @Column(name = "mobile_phone")
    private String mobile_phone;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "center_point")
    private String center_point;

    @Column(name = "synchronization_status")
    private Integer synchronization_status;

    @Column(name = "contract_time")
    private String contract_time;

    @Column(name = "coordinate")
    private String coordinate;
}
