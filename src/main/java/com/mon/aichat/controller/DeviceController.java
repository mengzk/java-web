package com.mon.aichat.controller;

import com.mon.aichat.model.body.DeviceBody;
import com.mon.aichat.model.body.ListBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 设备管理
 * 设备绑定,解绑,查询,删除,更新
 */

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceService service;

    /**
     * 添加设备
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() DeviceBody body) throws Exception {
        return ResultBody.success(service.add(body));
    }

    /**
     * 查询设备
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query(@RequestParam("size") Integer size, @RequestParam("page") Integer page) throws Exception {
        return ResultBody.success(service.query(size, page));
    }

    /**
     * 查询组设备
     */
    @RequestMapping(value = "queryGroup", method = RequestMethod.GET)
    public ResultBody queryGroup(@RequestParam("size") Integer size, @RequestParam("page") Integer page, @RequestParam("groupId") int groupId) throws Exception {
        return ResultBody.success(service.queryOfGroup(size, page, groupId));
    }

    /**
     * 更新设备
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() DeviceBody body) throws Exception {
        return ResultBody.success(service.update(body));
    }

    /**
     * 删除设备
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.delete(id));
    }
}
