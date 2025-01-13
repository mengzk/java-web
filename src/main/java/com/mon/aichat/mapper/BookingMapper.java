package com.mon.aichat.mapper;

import com.mon.aichat.model.body.BookingBody;
import com.mon.aichat.model.entity.BookingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 预定
 */

public interface BookingMapper {
    // 插入一条预定
    int onInsert(@Param("body") BookingBody body);

    // 查询预定
    List<BookingEntity> onQuery(@Param("tag") int tag, @Param("size") int size, @Param("position") int position);

    // 查询预定数量
    int onCount(@Param("start") Date start, @Param("end") Date end);

    int onCountByTag(@Param("tag") int tag);

    // 更新预定
    int onUpdate(@Param("body") BookingBody body);

    // 删除预定
    int onDelete(@Param("id") int id);
}
