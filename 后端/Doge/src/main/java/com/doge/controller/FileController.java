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
     * @param file ID 发布人ID
     * @return 状态信息
     */
    @ApiOperation("上传动物图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件内容", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "foster", value = "发布人ID", required = true, dataType = "Long")
    })
    @PostMapping("/dogPicsUpload")
    public RespUtil<User> dogPicsUpload(MultipartFile file, Long foster) throws Exception {
        fileService.dogPicsUpload(file, foster);
        return RespUtil.success();
    }
}
