package com.doge.controller;

import com.doge.entity.User;
import com.doge.enums.StatusCode;
import com.doge.util.RespUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public RespUtil<User> dogPicsUpload(MultipartFile file, Long dogId) throws Exception {
        fileService.dogPicsUpload(file, dogId);
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
}
