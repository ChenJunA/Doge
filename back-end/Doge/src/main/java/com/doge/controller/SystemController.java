package com.doge.controller;

import com.doge.entity.Log;
import com.doge.util.RespUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: 系统相关操作Controller
 * @Author: chenjun
 * @Date: 2018/04/12
 */
@RestController
public class SystemController extends BaseController {
    /**
     * 返回所有的日志信息
     *
     * @return 日志列表
     */
    @ApiOperation("返回所有的日志信息")
    @GetMapping("/listAllLog")
    public RespUtil<List<Log>> listAllLog() throws Exception {
        List<Log> logs = systemService.listAllLog();
        return RespUtil.success(logs);
    }
}
