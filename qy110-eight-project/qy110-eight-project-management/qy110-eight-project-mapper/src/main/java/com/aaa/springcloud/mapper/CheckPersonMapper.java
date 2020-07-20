package com.aaa.springcloud.mapper;

import com.aaa.springcloud.vo.CheckPerson;

import java.util.List;

/**
 * checkperson的mapper
 */
public interface CheckPersonMapper {
    /**
     * 查询所有
     * @return
     */
    public List<CheckPerson> selectAll();

    /**
     * 查询单个
     * @param id
     * @return
     */
    public CheckPerson selectOne(Long id);

    /**
     * 修改单个t_principal
     * @param checkPerson
     * @return
     */
    public Integer updateOneP(CheckPerson checkPerson);

    /**
     * 修改单个t_mappingunit
     * @param checkPerson
     * @return
     */
    public Integer updateOneM(CheckPerson checkPerson);
    /**
     * 添加单个t_principal
     * @param checkPerson
     * @return
     */
    public  Integer insertOneP(CheckPerson checkPerson);

    /**
     * 添加单个t_mappingunit
     * @param checkPerson
     * @return
     */
    public  Integer insertOneM(CheckPerson checkPerson);

    /**
     * 删除单个t_principal
     * @param id
     * @return
     */
    public  Integer deleteOneP(CheckPerson checkPerson);

    /**
     * 删除单个t_mapping_unit
     * @param checkPerson
     * @return
     */
    public Integer deleteOneM(CheckPerson checkPerson);




}
