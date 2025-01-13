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

    //
    int onInsert(@Param("body") RoomBody body);

    //
    List<RoomEntity> onQuery(@Param("start") int start, @Param("size") int size);

    //
    int onCount();

    //
    int onUpdate(@Param("body") RoomBody body);

    //
    int onDelete(@Param("id") Integer id);

}
