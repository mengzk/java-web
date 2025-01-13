package com.mon.aichat.service;

import com.mon.aichat.mapper.BookingMapper;
import com.mon.aichat.model.body.BookingBody;
import com.mon.aichat.model.entity.BookingEntity;
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
 * Desc: 预定会议服务
 */
@Service
public class BookingService {
    @Autowired
    BookingMapper mapper;

    // 添加预约
    public int add(BookingBody body) throws AppException {
        body.start = DateTools.getDate(body.startDate);
        body.end = DateTools.getDate(body.endDate);
        mapper.onInsert(body);
        return 0;
    }

    // 查询预约
    public List<BookingEntity> queryList(int size, int page, Integer tag, Integer status) throws AppException {
        int start = (page - 1) * size;
        return mapper.onQuery(tag, status, size, start);
    }

    public int count(Integer tag, Integer status, String start, String end) throws AppException {
//        System.out.println("查询设备数量: " + tag + " - " + status + " - " + start + " - " + end);
        return mapper.onCount(DateTools.getDate(start), DateTools.getDate(end), tag, status);
    }

    // 删除预约
    public int delete(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return mapper.onDelete(id);
    }

    // 更新预约
    public int update(BookingBody body) throws AppException {
        if(body.id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return mapper.onUpdate(body);
    }
}
