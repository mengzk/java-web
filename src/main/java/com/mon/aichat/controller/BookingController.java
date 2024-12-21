package com.mon.aichat.controller;

import com.mon.aichat.model.body.BookingBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 会议预定管理
 */

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService service;

    /**
     * 添加预约
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() BookingBody body) throws Exception {
        return ResultBody.success(service.add(body));
    }

    /**
     * 查询预约
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query(@RequestParam("size") Integer size, @RequestParam("page") Integer page) throws Exception {
        return ResultBody.success(service.query(size, page));
    }

    /**
     * 更新预约
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() BookingBody body) throws Exception {
        return ResultBody.success(service.update(body));
    }

    /**
     * 删除预约
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.delete(id));
    }
}
