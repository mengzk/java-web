package com.mon.aichat.service;

import com.mon.aichat.mapper.CompanyMapper;
import com.mon.aichat.model.body.CompanyBody;
import com.mon.aichat.model.entity.CompanyEntity;
import com.mon.aichat.model.result.ResultList;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CommonError;
import com.mon.aichat.modules.exception.CustomException;
import com.mon.aichat.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 公司服务
 */
@Service
public class CompanyService {
    @Autowired
    CompanyMapper mapper;

    // 添加预约
    public int create(CompanyBody body) throws AppException {
//        System.out.println("添加预约: " + body);
        mapper.onInsert(body);
        return 0;
    }

    // 查询预约
    public ResultList<CompanyEntity> queryList(int size, int page, Integer level, String key) throws AppException {
        int start = (page - 1) * size;
        List<CompanyEntity> list = mapper.onQuery(size, start, level, key);
        int total = count(level, key);
        return ResultList.create(list, total, page, size);
    }

    public int count(Integer level, String key) throws AppException {
//        System.out.println("查询: " + tag + " - " + status + " - " + start + " - " + end);
        return mapper.onCount(level, key);
    }

    // 删除预约
    public int delete(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return mapper.onDelete(id);
    }

    // 更新预约
    public int update(CompanyBody body) throws AppException {
        if(body.id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return mapper.onUpdate(body);
    }

}
