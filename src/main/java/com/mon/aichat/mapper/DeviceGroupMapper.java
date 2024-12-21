package com.mon.aichat.mapper;

import com.mon.aichat.model.body.DeviceGroupBody;
import com.mon.aichat.model.dto.DeviceGroup;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

public interface DeviceGroupMapper {
    /**
     * 查询设备组
     */
    List<DeviceGroup> onQuery(@Param("start") int start, @Param("size") int size);

    /**
     * 添加设备组
     */
    int onInsert(@Param("body") DeviceGroupBody body);

    /**
     * 更新设备组
     */
    int onUpdate(@Param("body") DeviceGroupBody body);

    /**
     * 删除设备组
     */
    int onDelete(@Param("id") int id);

    /**
     * 查询设备组数量
     */
    int onCount();
}
