package com.mon.aichat.service;

import com.mon.aichat.mapper.BookingMapper;
import com.mon.aichat.model.body.BookingBody;
import com.mon.aichat.model.entity.BookingEntity;
import com.mon.aichat.model.result.ResultList;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CustomException;
import com.mon.aichat.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ResultList<BookingEntity> query(int size, int page) throws AppException {
        System.out.println("查询设备: ");
        int start = (page - 1) * size;
        return null;
    }

    // 删除预约
    public int delete(Integer id) throws AppException {
        System.out.println("删除设备: " + id);
        if(id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        mapper.onDelete(id);
        return 0;
    }

    // 更新预约
    public int update(BookingBody body) throws AppException {
        System.out.println("更新设备: " + body.toString());
        if(body.id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        return 0;
    }
}
