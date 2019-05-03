package com.doge.service.impl;

import com.doge.entity.*;
import com.doge.mapper.*;
import com.doge.service.FileService;
import com.doge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description: 文件上传Service
 * @Author: chenjun
 * @Date: 2019/4/26 22:51
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    PictureMapper pictureMapper;
    @Autowired
    PictureCategoryMapper pictureCategoryMapper;
    @Autowired
    DogMapper dogMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public void dogPicsUpload(MultipartFile file, Long dogId) throws Exception {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //保存文件
        fileUpload(file);

        //doge_picture_category表对应类型下图片数量+1
        PictureCategory pictureCategory = pictureCategoryMapper.selectByPrimaryKey((long) 2);
        pictureCategory.setPictureCategoryNumber((pictureCategory.getPictureCategoryNumber() + 1));
        pictureCategoryMapper.updateByPrimaryKeySelective(pictureCategory);

        //doge_picture表增加一条数据
        Picture picture = new Picture();
        picture.setCategory((long) 2);
        picture.setPicture("http://localhost/" + fileName);
        picture.setxId(dogId);
        pictureMapper.insertSelective(picture);

    }

    @Override
    public User userPicUpload(MultipartFile file, Long userId) throws Exception {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //保存文件
        fileUpload(file);
        User user = userService.getUserById(userId);
        user.setPicture("http://localhost/" + fileName);
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public User userAvatarUpload(MultipartFile file, Long userId) throws Exception {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //保存文件
        fileUpload(file);
        User user = userService.getUserById(userId);
        user.setAvatar("http://localhost/" + fileName);
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public List<Material> listAllMaterial() throws Exception {
        MaterialExample materialExample = new MaterialExample();
        materialExample.setOrderByClause("id desc");
        List<Material> materials = materialMapper.selectByExample(materialExample);
        return materials;
    }

    @Override
    public List<Material> materialUpload(MultipartFile file, Long userId) throws Exception {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //保存文件
        fileUpload(file);

        Material material = new Material();
        material.setMaterialName(fileName);
        material.setMaterial("http://localhost/" + fileName);
        material.setUserId(userId);
        materialMapper.insertSelective(material);

        //获取所有文件
        List<Material> materials = listAllMaterial();
        return materials;
    }

    @Override
    public List<Material> materialDescribeUpload(Material material) throws Exception {
        List<Material> materials = listAllMaterial();
        material.setId(materials.get(0).getId());
        materialMapper.updateByPrimaryKeySelective(material);
        List<Material> respMaterials = listAllMaterial();
        return respMaterials;
    }

    @Override
    public String materialDownload(Long materialId) throws Exception {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        return material.getMaterialName();

    }

    public void fileUpload(MultipartFile file) throws Exception {
        if (file.isEmpty()) {

        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 上传到static路径下
        String filePath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        File dest = new File(filePath + "static/" + fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
