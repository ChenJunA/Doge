package com.doge.controller;

import com.doge.entity.Material;
import com.doge.entity.User;
import com.doge.util.RespUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Description: 文件上传Controller
 * @Author: chenjun
 * @Date: 2019/4/26 22:35
 */
@RestController
public class FileController extends BaseController {
    /**
     * 上传动物图片
     *
     * @param file file 文件内容
     * @param file dogId 动物ID
     * @return 状态信息
     */
    @ApiOperation("上传动物图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件内容", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "dogId", value = "动物ID", required = true, dataType = "Long")
    })
    @PostMapping("/dogPicsUpload")
    public RespUtil<User> dogPicsUpload(MultipartFile file, Long articleId) throws Exception {
        fileService.dogPicsUpload(file, articleId);
        return RespUtil.success();
    }

    /**
     * 上传论坛图片
     *
     * @param file file 文件内容
     * @param file userId 用户ID
     * @return 状态信息
     */
    @ApiOperation("上传论坛图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件内容", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long")
    })
    @PostMapping("/forumPicsUpload")
    public RespUtil<User> forumPicsUpload(MultipartFile file, Long articleId) throws Exception {
        fileService.forumPicsUpload(file, articleId);
        return RespUtil.success();
    }

    /**
     * 上传用户封面图片
     *
     * @param file file 文件内容
     * @param file userId 用户ID
     * @return 状态信息
     */
    @ApiOperation("上传用户封面图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件内容", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long")
    })
    @PostMapping("/userPicUpload")
    public RespUtil<User> userPicUpload(MultipartFile file, Long userId) throws Exception {
        User user = fileService.userPicUpload(file, userId);
        return RespUtil.success(user);
    }

    /**
     * 上传用户头像
     *
     * @param file file 文件内容
     * @param file userId 用户ID
     * @return 状态信息
     */
    @ApiOperation("上传用户头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件内容", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long")
    })
    @PostMapping("/userAvatarUpload")
    public RespUtil<User> userAvatarUpload(MultipartFile file, Long userId) throws Exception {
        User user = fileService.userAvatarUpload(file, userId);
        return RespUtil.success(user);
    }

    /**
     * 获取所有资料
     *
     * @return 状态信息
     */
    @ApiOperation("获取所有资料")
    @GetMapping("/listAllMaterial")
    public RespUtil<List<Material>> listAllMaterial() throws Exception {
        List<Material> materials = fileService.listAllMaterial();
        return RespUtil.success(materials);
    }


    /**
     * 上传资料
     *
     * @param file file 文件内容
     * @param file userId 用户ID
     * @return 状态信息
     */
    @ApiOperation("上传资料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件内容", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long")
    })
    @PostMapping("/materialUpload")
    public RespUtil<List<Material>> materialUpload(MultipartFile file, Long userId) throws Exception {
        List<Material> materials = fileService.materialUpload(file, userId);
        return RespUtil.success(materials);
    }

    /**
     * 上传资料描述
     *
     * @param material 资料
     * @return 状态信息
     */
    @ApiOperation("上传资料")
    @ApiImplicitParam(name = "material", value = "资料", required = true, dataType = "Material")
    @PutMapping("/materialDescribeUpload")
    public RespUtil<List<Material>> materialDescribeUpload(@RequestBody Material material) throws Exception {
        List<Material> materials = fileService.materialDescribeUpload(material);
        return RespUtil.success(materials);
    }


    /**
     * 下载资料
     *
     * @param materialId 资料ID
     * @return 状态信息
     */
    @ApiOperation("下载资料")
    @ApiImplicitParam(name = "materialId", value = "资料ID", required = true, dataType = "Long")
    @GetMapping("/materialDownload")
    public RespUtil<Material> materialDownload(Long materialId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = fileService.materialDownload(materialId);// 文件名
        String filePath = "E:\\Idea\\Repository\\Doge\\back-end\\Doge\\target\\classes\\static\\" + fileName;
        if (filePath != null) {
            //设置文件路径
            File file = new File(filePath);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("成功");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
