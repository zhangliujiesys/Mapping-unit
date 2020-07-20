package com.aaa.springcloud.mapper;

import com.aaa.springcloud.model.Taudit;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TauditMapper {
    /**
     * 根据项目表的user_id和审核类型进行查询审核信息
     * 审核类型有四种：
     * 审核类别 1:单位信息审核 2:项目登记审核 3:项目上交审核 4:成果汇交审核
     * @param id
     * @return
     */
    public List<Taudit> selectByIdu(@Param("id") Integer id,@Param("type") Integer type);
    /**
     *添加审核信息
     */
    public Integer add(Taudit taudit);
    /**
     * 根据id和审核类型进行查找审核信息
     */
    public List<Taudit> selectById(@Param("id") Integer id, @Param("type") Integer type);

}
