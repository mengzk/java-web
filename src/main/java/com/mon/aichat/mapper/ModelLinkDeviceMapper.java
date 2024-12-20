package com.mon.aichat.mapper;

import com.mon.aichat.model.body.DeviceBody;
import com.mon.aichat.model.dto.ModelLinkDevice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

public interface ModelLinkDeviceMapper {
    /**
     * 查询设备
     */
    List<ModelLinkDevice> onQuery(@Param("gid") Integer gid,@Param("did") Integer did,@Param("kid") Integer kid, @Param("size") int size, @Param("start") int start);

    /**
     * 删除设备
     */
    int onDelete(@Param("ids") List<Integer> ids, int kid);

    /**
     * 绑定设备
     */
    int onBind(@Param("ids") List<Integer> ids, @Param("kid") int kid, @Param("time") String time);
}
