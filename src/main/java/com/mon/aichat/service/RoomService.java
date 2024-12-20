package com.mon.aichat.service;

import com.mon.aichat.mapper.RoomMapper;
import com.mon.aichat.model.body.DeviceBody;
import com.mon.aichat.model.dto.Device;
import com.mon.aichat.model.result.ResultList;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 设备服务
 */
@Service
public class RoomService {
    @Autowired
    RoomMapper mapper;

    /**
     * 添加设备
     */
    public int add(DeviceBody body) throws AppException {
        System.out.println("添加设备: " + body.toString());
        mapper.onCreate(body);
        return 0;
    }

    /**
     * 查询设备
     */
    public ResultList<Device> query(int size, int page) throws AppException {
        System.out.println("查询设备: ");
        int start = (page - 1) * size;
        return ResultList.create(mapper.onQuery(start, size), mapper.onCount(), page, size);
    }

    /**
     * 删除设备
     */
    public int delete(Integer id) throws AppException {
        System.out.println("删除设备: " + id);
        if(id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        mapper.onDelete(id);
        return 0;
    }

    /**
     * 更新设备
     */
    public int update(DeviceBody body) throws AppException {
        System.out.println("更新设备: " + body.toString());
        if(body.id == null) {
//            throw CommonException.create(CommonError.PARAM_EMPTY);
            throw CustomException.create(10011, "设备ID不能为空");
        }
        mapper.onUpdate(body);
        return 0;
    }
}
