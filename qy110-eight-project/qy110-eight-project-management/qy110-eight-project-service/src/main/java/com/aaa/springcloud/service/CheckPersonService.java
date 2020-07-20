package com.aaa.springcloud.service;

import com.aaa.springcloud.mapper.CheckPersonMapper;
import com.aaa.springcloud.vo.CheckPerson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ldy
 * @date: 2020/7/17
 * description
 */
@Service
public class CheckPersonService {
    @Autowired
    private CheckPersonMapper checkPersonMapper;

    /**
     * 根据id查询单个数据
     * @param id
     * @return
     */
    public CheckPerson selectOne(Long id){
        CheckPerson checkPerson = checkPersonMapper.selectOne(id);
        return  checkPerson;
    }

    /**
     * 分页查找
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo selectAllCheckPerson(Integer pageNo, Integer pageSize ){
        PageHelper.startPage(pageNo,pageSize);
        List<CheckPerson> checkPeople = checkPersonMapper.selectAll();
        PageInfo<CheckPerson> pageInfo=new PageInfo<CheckPerson>(checkPeople);
        return  pageInfo;
    }

    /**
     * 添加操作
     * @param checkPerson
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer insertCheckPerson(CheckPerson checkPerson){
        Integer integer = checkPersonMapper.insertOneM(checkPerson);
        Integer integer1 = checkPersonMapper.insertOneP(checkPerson);
        Integer result=integer+integer1;
        return result;
//        if(result>1){
//            return  result;
//        }else {
//            throw new  RuntimeException("添加失败");
//        }
    }
    /**
     * 更新操作
     * @param checkPerson
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateCheckPerson(CheckPerson checkPerson){
        Integer integer = checkPersonMapper.updateOneM(checkPerson);
        Integer integer1 = checkPersonMapper.updateOneP(checkPerson);
        Integer result=integer+integer1;
        return result;
//        if(result>1){
//            return  result;
//        }else {
//            throw new RuntimeException("修改失败");
//        }
    }

    /**
     *
     * 删除操作
     * @param checkPerson
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteCheckPerson(CheckPerson checkPerson){
        Integer integer = checkPersonMapper.deleteOneM(checkPerson);
        Integer integer1 = checkPersonMapper.deleteOneP(checkPerson);
        Integer result=integer+integer1;
        return result;
//        if(result>1){
//            return  result;
//        }else {
//            throw new RuntimeException("删除失败");
//        }
    }
}
