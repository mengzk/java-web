package com.mon.aichat.service;

import com.mon.aichat.mapper.UseRecordMapper;
import com.mon.aichat.model.body.UseRecordBody;
import com.mon.aichat.model.dto.ModelDTO;
import com.mon.aichat.model.dto.UseRecord;
import com.mon.aichat.modules.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 使用记录服务
 */
@Service
public class UseRecordService {
    @Autowired
    UseRecordMapper mapper;

    /**
     * 添加记录
     */
    public int add(UseRecordBody body) throws AppException {

        return mapper.onCreate(body);
    }

    /**
     * 查询记录
     */
    public List<UseRecord> query(Integer gid, int size, int page) throws AppException {
        int start = (page - 1) * size;
        return mapper.onQuery(gid, size, start);
    }

    /**
     * 删除记录
     */
    public int delete() throws AppException {
        return 0;
    }
}
