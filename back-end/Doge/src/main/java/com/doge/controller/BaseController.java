package com.doge.controller;

import com.doge.service.DogService;
import com.doge.service.FileService;
import com.doge.service.SystemService;
import com.doge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 基础Controller
 * @Author: chenjun
 * @Date: 2018/04/12
 */
@RestController
public class BaseController {
    @Autowired
    SystemService systemService;
    @Autowired
    UserService userService;
    @Autowired
    DogService dogService;
    @Autowired
    FileService fileService;
}
