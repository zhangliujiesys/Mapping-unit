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
@Table(name = "t_mapping_unit")
public class Tmn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "modify_time")
    private Date modify_time;

    @Column(name = "memo")
    private String memo;

    @Column(name = "unit_name")
    private String unit_name;

    @Column(name = "register_address")
    private String register_address;

    @Column(name = "register_time")
    private Date register_time;

    @Column(name = "oa")
    private String oa;

    @Column(name = "corporation")
    private String corporation;

    @Column(name = "linkman")
    private String linkman;

    @Column(name = "owned_district")
    private String owned_district;

    @Column(name = "register_fund")
    private Double register_fund;

    @Column(name = "social_credit_code")
    private String social_credit_code;

    @Column(name = "qualification_level")
    private String qualification_level;

    @Column(name = "phone")
    private String phone;

    @Column(name = "contact_way")
    private String contact_way;

    @Column(name = "used_name")
    private String used_name;

    @Column(name = "register_address_lon")
    private String register_address_lon;

    @Column(name = "register_address_lat")
    private String register_address_lat;

    @Column(name = "register_address_postcode")
    private String register_address_postcode;

    @Column(name = "oa_postcode")
    private String oa_postcode;

    @Column(name = "oa_area")
    private Double oa_area;

    @Column(name = "establish_time")
    private Date establish_time;

    @Column(name = "mobile_phone")
    private String mobile_phone;

    @Column(name = "fax_num")
    private String fax_num;

    @Column(name = "email")
    private String email;

    @Column(name = "surveying_num")
    private Integer surveying_num;

    @Column(name = "staff_num")
    private Integer staff_num;

    @Column(name = "unit_nature")
    private String unit_nature;

    @Column(name = "belong_industry")
    private String belong_industry;

    @Column(name = "certificate_code")
    private String certificate_code;

    @Column(name = "certificate_send_date")
    private Date certificate_send_date;

    @Column(name = "company_type")
    private String company_type;

    @Column(name = "stock_details")
    private String stock_details;

    @Column(name = "joint_venture")
    private String joint_venture;

    @Column(name = "joint_ch_p")
    private Integer joint_ch_p;

    @Column(name = "joint_ratify_code")
    private String joint_ratify_code;

    @Column(name = "competent_depart")
    private String competent_depart;

    @Column(name = "first_qualification_level")
    private String first_qualification_level;

    @Column(name = "first_qualification_date")
    private Date first_qualification_date;

    @Column(name = "qualification_process")
    private String qualification_process;

    @Column(name = "organization_code")
    private String organization_code;

    @Column(name = "unit_type")
    private String unit_type;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "audit_status")
    private Integer audit_status;

    @Column(name = "unit_code")
    private String unit_code;

    @Column(name = "unit_status")
    private Integer unit_status;

    @Column(name = "synchronization_status")
    private Integer synchronization_status;

    @Column(name = "score")
    private Integer score;

    @Column(name = "filing_business")
    private String filing_business;

    @Column(name = "business_scope")
    private String business_scope;

    @Column(name = "unit_intro")
    private String unit_intro;

    @Column(name = "coordinate")
    private String coordinate;


}