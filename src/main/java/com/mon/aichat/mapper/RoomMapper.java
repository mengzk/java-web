package com.mon.aichat.mapper;

import com.mon.aichat.model.body.RoomBody;
import com.mon.aichat.model.entity.RoomEntity;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

public interface RoomMapper {

    /**
     * 添加设备
     */
     int onInsert(@Param("body") RoomBody body);

    /**
     * 查询设备
     */
     List<RoomEntity> onQuery(@Param("start") int start, @Param("size") int size);

     int onCount();

    /**
     * 更新设备
     */
    int onUpdate(@Param("body") RoomBody body);

    /**
     * 删除设备
     */
     int onDelete(@Param("id") Integer id);

}
