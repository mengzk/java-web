package com.mon.aichat.controller;

import com.mon.aichat.model.body.DepartmentBody;
import com.mon.aichat.model.body.StaffBody;
import com.mon.aichat.model.result.ResultBody;
import com.mon.aichat.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 部门管理
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService service;

    //
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ResultBody create(@RequestBody() DepartmentBody body) throws Exception {
        return ResultBody.success(service.add(body));
    }

    /**
     * 查询
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultBody query() throws Exception {
        return ResultBody.success(service.query());
    }

    /**
     * 查询
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResultBody count(@RequestParam("cId") Integer cId) throws Exception {
        return ResultBody.success(service.count(cId));
    }

    /**
     * 查询
     */
    @RequestMapping(value = "staff", method = RequestMethod.GET)
    public ResultBody queryStaff(@RequestParam("dId") Integer dId) throws Exception {
        return ResultBody.success(service.queryStaff(dId));
    }

    /**
     * 查询
     */
    @RequestMapping(value = "addStaff", method = RequestMethod.POST)
    public ResultBody addStaff(@RequestBody StaffBody body) throws Exception {
        return ResultBody.success(service.addStaff(body));
    }

    /**
     * 更新
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() DepartmentBody body) throws Exception {
        return ResultBody.success(service.update(body));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.delete(id));
    }
}
