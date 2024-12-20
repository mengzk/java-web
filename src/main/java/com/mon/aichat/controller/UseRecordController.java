package com.mon.aichat.controller;

import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.ModelService;
import com.mon.aichat.service.UseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 使用记录管理
 */

@RestController
@RequestMapping("/useRecord")
public class UseRecordController {
    @Autowired
    UseRecordService service;

    /**
     * 添加记录
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody add() throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 查询记录
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query(@RequestParam(value = "gid", required = false) Integer gid, @RequestParam("page") int page, @RequestParam("size") int size) throws Exception {
        return ResultBody.success(service.query(gid, size, page));
    }

    /**
     * 删除记录
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete() throws Exception {
        return ResultBody.success(0);
    }
}
