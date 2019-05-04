package com.doge.controller;

import com.doge.service.*;
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
    @Autowired
    DogCommentService dogCommentService;
    @Autowired
    ArticleService articleService;
}
