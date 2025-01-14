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

    /**
     * 添加预约
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() CompanyBody body, @RequestHeader("token") String token) throws Exception {
        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(service.create(body));
    }

    /**
     * 查询预约
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultBody queryList(@RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "level", defaultValue = "0", required = false) Integer level,
                                @RequestParam(value = "keyword", defaultValue = "", required = false) String tag) throws Exception {
        return ResultBody.success(service.queryList(size, page, level, tag));
    }

    /**
     * 查询
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResultBody count(@RequestParam(value = "level", defaultValue = "0", required = false) Integer level,
                            @RequestParam(value = "key", defaultValue = "", required = false) String key) throws Exception {
        return ResultBody.success(service.count(level, key));
    }

    /**
     * 更新预约
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() CompanyBody body) throws Exception {
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
