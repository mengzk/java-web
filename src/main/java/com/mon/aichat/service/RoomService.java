package com.mon.aichat.service;

import com.mon.aichat.mapper.RoomMapper;
import com.mon.aichat.model.body.RoomBody;
import com.mon.aichat.model.entity.RoomEntity;
import com.mon.aichat.model.result.ResultList;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CommonError;
import com.mon.aichat.modules.exception.CustomException;
import com.mon.aichat.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 会议室服务
 */
@Service
public class RoomService {
    @Autowired
    RoomMapper mapper;

    // 添加会议室
    public int add(RoomBody body) throws AppException {
        if (body == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        if (TextUtils.isEmpty(body.name)) {
            throw CustomException.create(CommonError.PARAM_Lack);
        }
        try {
            mapper.onInsert(body);
        } catch (Exception e) {
            throw CustomException.create(CommonError.DB_ERROR);
        }

        return 0;
    }

    // 查询会议室
    public ResultList<RoomEntity> query(int size, int page) throws AppException {
        System.out.println("查询设备: ");
        int start = (page - 1) * size;
        return ResultList.create(mapper.onQuery(start, size), mapper.onCount(), page, size);
    }

    // 删除会议室
    public int delete(Integer id) throws AppException {
        System.out.println("删除设备: " + id);
        if(id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        mapper.onDelete(id);
        return 0;
    }

    // 更新会议室
    public int update(RoomBody body) throws AppException {
        System.out.println("更新设备: " + body.toString());
        if(body.id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        mapper.onUpdate(body);
        return 0;
    }
}
