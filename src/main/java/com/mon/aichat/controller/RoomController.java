package com.mon.aichat.controller;

import com.mon.aichat.model.body.DeviceBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 设备管理
 */

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService service;

    /**
     * 添加设备
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() DeviceBody body) throws Exception {
        return ResultBody.success(service.add(body));
    }

    /**
     * 查询设备
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query(@RequestParam("size") int size, @RequestParam("page") int page) throws Exception {
        return ResultBody.success(service.query(size, page));
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
