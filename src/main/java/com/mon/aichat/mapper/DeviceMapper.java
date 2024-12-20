package com.mon.aichat.mapper;

import com.mon.aichat.model.body.DeviceBody;
import com.mon.aichat.model.dto.Device;
import com.mon.aichat.model.dto.ModelDTO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

public interface DeviceMapper {

    /**
     * 添加设备
     */
     int onCreate(@Param("body") DeviceBody body);

    /**
     * 查询设备
     */
     List<Device> onQuery(@Param("start") int start, @Param("size") int size);

     int onCount();

    /**
     * 更新设备
     */
    int onUpdate(@Param("body") DeviceBody body);

    /**
     * 删除设备
     */
     int onDelete(@Param("id") Integer id);

}
