package com.mon.aichat.controller;

import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 部门管理
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService service;

    /**
     * 重置token
     */
    @RequestMapping(value = "reset", method = RequestMethod.GET)
    public ResultBody resetToken() {
        return ResultBody.success(true);
    }

}
