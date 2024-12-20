package com.mon.aichat.controller;

import com.mon.aichat.model.body.AccountBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 账号管理
 */

@RestController
@RequestMapping("/account/v2")
public class AccountV2Controller {
    @Autowired
    AccountService service;

    /**
     * 登录账号
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultBody login(@RequestBody() AccountBody body) throws Exception {
        System.out.println("v2 login: "+body.toString());
        return ResultBody.success("");
    }

    /**
     * 注册账号
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultBody register(@RequestBody() AccountBody body) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 查询账号
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query(@RequestParam("size") int size, @RequestParam("page") int page) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 更新账号
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() AccountBody body) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 删除账号
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ResultBody logout(@RequestHeader(value = "token", required = true) String token) throws Exception {
        System.out.println("v2 logout: "+token);
        return ResultBody.success("");
    }

    /**
     * 重置密码
     */
    @RequestMapping(value = "reset", method = RequestMethod.PUT)
    public ResultBody reset(@RequestHeader("token") String token) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 查询账号数量
     */
    @RequestMapping(value = "total", method = RequestMethod.GET)
    public ResultBody total() throws Exception {
        return ResultBody.success("");
    }

    /**
     * 查询账号信息
     */
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public ResultBody info(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 找回账号/密码
     */
    @RequestMapping(value = "find", method = RequestMethod.POST)
    public ResultBody find(@RequestBody() AccountBody body) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 忘记密码/修改密码
     */
    @RequestMapping(value = "forget", method = RequestMethod.PUT)
    public ResultBody forget(@RequestBody() AccountBody body) throws Exception {
        return ResultBody.success("");
    }
}
