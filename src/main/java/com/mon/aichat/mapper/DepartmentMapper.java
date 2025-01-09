package com.mon.aichat.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface DepartmentMapper {

    int onUpdate(@Param("token") String token);

    int onInsert(@Param("token") String token);

    String onQuery();

    int onDelete();

    int onCount();
}
