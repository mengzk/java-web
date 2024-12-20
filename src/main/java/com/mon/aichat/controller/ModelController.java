package com.mon.aichat.controller;

import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 模型管理
 */

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    ModelService service;

    /**
     * 添加模型
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody add() throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 查询模型
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query() throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 删除模型
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete() throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 更新模型
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update() throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 绑定设备
     */
    @RequestMapping(value = "bind", method = RequestMethod.POST)
    public ResultBody bind() throws Exception {
        return ResultBody.success(0);
    }
}
