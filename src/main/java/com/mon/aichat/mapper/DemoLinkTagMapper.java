package com.mon.aichat.mapper;

import com.mon.aichat.model.dto.DeviceLinkGroupDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

public interface DemoLinkTagMapper {

    /**
     * 查询设备
     */
    List<DeviceLinkGroupDTO> onQuery(@Param("gid") Integer gid, @Param("start") int start, @Param("size") int size);

    /**
     * 删除设备
     */
    int onDelete(@Param("ids") List<Integer> ids, @Param("gid") int gid);

    /**
     * 绑定设备
     */
    int onBind(@Param("ids") List<Integer> ids, @Param("gid") int gid, @Param("time") String time);
}
