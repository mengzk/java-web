package com.mon.aichat.service;

import com.mon.aichat.mapper.DepartmentMapper;
import com.mon.aichat.model.body.DepartmentBody;
import com.mon.aichat.model.body.StaffBody;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CommonError;
import com.mon.aichat.modules.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 部门服务
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper mapper;

    //
    public int add(DepartmentBody body) throws AppException {
        return 0;
    }

    //
    public List<String> query() throws AppException {
        return new ArrayList<>();
    }

    //
    public int queryStaff(Integer dId) throws AppException {
        return 0;
    }

    //
    public int addStaff(StaffBody dId) throws AppException {
        return 0;
    }

    //
    public int count(Integer cId) throws AppException {
        return 0;
    }

    //
    public int delete(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

    //
    public int update(DepartmentBody body) throws AppException {
        if(body.id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }
}
