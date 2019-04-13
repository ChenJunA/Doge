package com.doge.controller;

import com.doge.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 基础Controller
 * @Author: chenjun
 * @Date: 2018/04/12
 */
public class BaseController {
    @Autowired
    SystemService systemService;
}
