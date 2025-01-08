package com.mon.aichat.controller;

import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.CompanyService;
import com.mon.aichat.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 公司管理
 */

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService service;

    /**
     * 重置token
     */
    @RequestMapping(value = "reset", method = RequestMethod.GET)
    public ResultBody resetToken() {
        return ResultBody.success(true);
    }

}
