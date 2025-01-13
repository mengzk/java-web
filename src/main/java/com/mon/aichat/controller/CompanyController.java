package com.mon.aichat.controller;

import com.mon.aichat.model.body.CompanyBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.CompanyService;
import com.mon.aichat.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /** 注册公司 */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() CompanyBody body, @RequestHeader("token") String token) throws Exception {
        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(service.add(body));
    }
}
