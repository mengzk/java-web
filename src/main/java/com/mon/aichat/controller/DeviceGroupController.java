package com.mon.aichat.controller;

import com.mon.aichat.model.body.DeviceGroupBody;
import com.mon.aichat.model.body.DeviceLinkGroup;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.DeviceGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 设备分组
 */

@RestController
@RequestMapping("/deviceGroup")
public class DeviceGroupController {
    @Autowired
    DeviceGroupService service;

    /**
     * 添加分组
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody add(@RequestBody() DeviceGroupBody body) throws Exception {
        return ResultBody.success(service.add(body));
    }

    /**
     * 查询分组
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query(@RequestParam("page") int page, @RequestParam("size") int size) throws Exception {
        return ResultBody.success(service.query(page, size));
    }

    /**
     * 删除分组
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") int id) throws Exception {
        return ResultBody.success(service.delete(id));
    }

    /**
     * 更新分组
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() DeviceGroupBody body) throws Exception {
        return ResultBody.success(service.update(body));
    }

    /**
     * 查询分组
     */
    @RequestMapping(value = "queryDevices", method = RequestMethod.GET)
    public ResultBody queryDevice(@RequestParam(value = "gid", required = false) Integer gid,@RequestParam("page") int page, @RequestParam("size") int size) throws Exception {
        return ResultBody.success(service.queryDevice(gid, page, size));
    }
    /**
     * 绑定设备
     */
    @RequestMapping(value = "bind", method = RequestMethod.POST)
    public ResultBody bind(@RequestBody() DeviceLinkGroup body) throws Exception {
        service.bind(body);
        return ResultBody.success(0);
    }
}
