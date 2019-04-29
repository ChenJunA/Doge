package com.doge.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 文件上传Service
 * @Author: chenjun
 * @Date: 2019/4/26 22:48
 */
public interface FileService {
    /**
     * 上传动物图片
     *
     * @param file 文件信息
     * @param foster 发布人ID
     */
    void dogPicsUpload(MultipartFile file, Long foster) throws Exception;
}
