package com.mon.aichat.mapper;

import com.mon.aichat.model.body.UseRecordBody;
import com.mon.aichat.model.dto.UseRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 
 */

public interface UseRecordMapper {
    /**
     * 添加设备
     */
    int onCreate(@Param("body") UseRecordBody body);

    /**
     * 查询设备
     */
    List<UseRecord> onQuery(@Param("gid") int gid, @Param("size") int size, @Param("start") int start);

    /**
     * 删除设备
     */
    int onDelete(@Param("id") int id);
}
