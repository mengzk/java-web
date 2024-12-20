package com.mon.aichat.service;

import com.mon.aichat.mapper.DeviceGroupMapper;
import com.mon.aichat.mapper.DeviceLinkGroupMapper;
import com.mon.aichat.model.body.DeviceGroupBody;
import com.mon.aichat.model.body.DeviceLinkGroup;
import com.mon.aichat.model.dto.DeviceGroup;
import com.mon.aichat.model.dto.DeviceLinkGroupDTO;
import com.mon.aichat.model.result.ResultList;
import com.mon.aichat.modules.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 设备组服务
 */
@Service
public class DeviceGroupService {
    @Autowired
    DeviceGroupMapper mapper;
    @Autowired
    DeviceLinkGroupMapper linkMapper;

    /**
     * 添加设备组
     */
    public int add(DeviceGroupBody body) throws AppException {
        return mapper.onCreate(body);
    }

    /**
     * 查询设备组
     */
    public ResultList<DeviceGroup> query(int page, int size) throws AppException {
        int start = (page - 1) * size;
        return ResultList.create(mapper.onQuery(start, size), mapper.onCount(), page, size);
    }

    /**
     * 删除设备组
     */
    public int delete(int id) throws AppException {
        return 0;
    }

    /**
     * 更新设备组
     */
    public int update(DeviceGroupBody body) throws AppException {
        return mapper.onUpdate(body);
    }

    /**
     * 查询设备组
     */
    public List<DeviceLinkGroupDTO> queryDevice(Integer gid, int page, int size) throws AppException {
        int start = (page - 1) * size;
        return linkMapper.onQuery(gid, start, size);
    }

    /**
     * 绑定设备组
     */
    public int bind(DeviceLinkGroup body) throws AppException {
        linkMapper.onBind(body.ids, body.gid, "2024-09-02");
        return 0;
    }
}
