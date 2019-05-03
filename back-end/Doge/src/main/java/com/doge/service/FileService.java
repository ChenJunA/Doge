package com.doge.service;

import com.doge.entity.Material;
import com.doge.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
     * @param dogId 动物ID
     */
    void dogPicsUpload(MultipartFile file, Long dogId) throws Exception;

    /**
     * 上传用户封面图片
     *
     * @param file 文件信息
     * @param userId 用户ID
     */
    User userPicUpload(MultipartFile file, Long userId) throws Exception;

    /**
     * 上传用户封面图片
     *
     * @param file 文件信息
     * @param userId 用户ID
     */
    User userAvatarUpload(MultipartFile file, Long userId) throws Exception;

    /**
     * 获取所有资料
     */
    List<Material> listAllMaterial() throws Exception;

    /**
     * 上传资料
     *
     * @param file 文件信息
     * @param userId 用户ID
     */
    List<Material> materialUpload(MultipartFile file, Long userId) throws Exception;

    /**
     * 上传资料
     *
     * @param material 文件信息
     */
    List<Material> materialDescribeUpload(Material material) throws Exception;

    /**
     * 下载资料
     *
     * @param materialId 文件信息
     */
    String materialDownload(Long materialId) throws Exception;
}
