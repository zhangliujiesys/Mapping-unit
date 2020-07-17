package com.aaa.springcloud.mapper;

import com.aaa.springcloud.model.LoginLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface LoginLogMapper extends Mapper<LoginLog> {

}
