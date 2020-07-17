package com.aaa.springcloud.service;

import com.aaa.springcloud.properties.FtpProperties;
import com.aaa.springcloud.utils.FileNameUtils;
import com.aaa.springcloud.utils.FtpUtils;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.aaa.springcloud.staticproperties.RedisProperties.*;
import static com.aaa.springcloud.staticproperties.TimeForatProperties.*;

@Service
public class UploadService {
    @Autowired
    private FtpProperties ftpProperties;

    /**
     *@Description
     *   文件上传
     * @Param: [file]
     * @Return: java.lang.Boolean
     * @Author: ysj
     * @Date: 2020/7/10 19:13
     */
    public Boolean upload(MultipartFile file) {
        // 1.获取文件的远程名称(为了获取后缀名)
        String oleFileName = file.getOriginalFilename();
        // 2.生成新的文件名
        String newFileName = FileNameUtils.getFileName();
        // 3.截取后缀名，拼接到新的文件名上
        newFileName += oleFileName.substring(oleFileName.lastIndexOf(POINT));
        // 4.获取文件的上传路径(2020/07/10)
        // TODO 暂时没有完成，目前使用的是apache开源基金会的日期工具类，不符合咱们团队的技术水平，需要自己手动编写
        String filePath = DateUtil.formatDate(new Date(), DATE_FORMAT);
        // 5.调用文件上传工具类
        try {
            return FtpUtils.uploac(ftpProperties.getHost(), ftpProperties.getPort(), ftpProperties.getUsername(),
                    ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newFileName,file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
