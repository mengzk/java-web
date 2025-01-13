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
 * 功能描述: 会议室预订及取消，可以通过二维码扫描进行操作
 * 注意事项:
 *          1. 预订需要提前1小时，取消需要提前半小时
 *          2. 预订需要提供会议主题，会议内容，会议时间，会议地点等信息
 *          3. 预订成功后会发送邮件通知
 *          4. 预订成功后会在会议室门口贴上二维码，扫描二维码可以查看会议详情
 *          5. 预订不能重复，会议室只能被一个会议占用
 *          6. 创建人不能同时预订多个会议室
 *          7. 参会人员不能同时参加多个会议
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
    public ResultBody create(@RequestBody() BookingBody body, @RequestHeader("token") String token) throws Exception {
        return ResultBody.success(service.add(body));
    }

    /**
     * 查询预约
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query(@RequestParam(value = "size", defaultValue = "10") Integer size, @RequestParam("page") Integer page, @RequestParam("tag") Integer tag) throws Exception {
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