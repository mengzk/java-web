package com.mon.aichat.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 任务
 */
public interface TaskMapper {

    String onQuery(@Param("id") int id);

    int onInsert(@Param("uid") int uid, @Param("status") int status);

    int onUpdate(@Param("id") int id);

    int onDelete(@Param("id") int id);
}
