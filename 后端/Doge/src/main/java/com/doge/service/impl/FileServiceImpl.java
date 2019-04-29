package com.doge.service.impl;

import com.doge.entity.Picture;
import com.doge.entity.PictureCategory;
import com.doge.mapper.PictureCategoryMapper;
import com.doge.mapper.PictureMapper;
import com.doge.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    @Override
    public void dogPicsUpload(MultipartFile file, Long foster) throws Exception {
        if (file.isEmpty()) {

        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 上传后的路径
        String filePath = "D://temp-rainy//";
        File dest = new File(filePath + fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //doge_picture_category表对应类型下图片数量+1
        PictureCategory pictureCategory = pictureCategoryMapper.selectByPrimaryKey((long) 2);
        pictureCategory.setPictureCategoryNumber((pictureCategory.getPictureCategoryNumber() + 1));
        pictureCategoryMapper.updateByPrimaryKeySelective(pictureCategory);

        //doge_picture表增加一条数据
        Picture picture = new Picture();
        picture.setCategory((long) 2);
        picture.setPicture(filePath + fileName);
        picture.setxId(foster);
        pictureMapper.insertSelective(picture);

    }
}
