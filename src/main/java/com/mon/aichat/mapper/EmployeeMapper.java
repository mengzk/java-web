package com.mon.aichat.mapper;

import com.mon.aichat.model.body.EmployeeBody;
import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface EmployeeMapper {

    int onQuery(@Param("cId") int cId, @Param("dId") int dId);

    int onInsert(@Param("body") EmployeeBody body, @Param("memo") String memo);

    int onDelete(@Param("body") EmployeeBody body);

    int onMove(@Param("body") EmployeeBody body);
}
