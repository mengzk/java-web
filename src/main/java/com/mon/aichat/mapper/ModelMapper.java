package com.mon.aichat.mapper;

import com.mon.aichat.model.body.ModelBody;
import com.mon.aichat.model.dto.ModelDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

public interface ModelMapper {
    /**
     * 添加设备
     */
    int onCreate(@Param("body") ModelBody body);

    /**
     * 查询设备
     */
    List<ModelDTO> onQuery(@Param("size") int size, @Param("page") int page);

    /**
     * 更新设备
     */
    int onUpdate(@Param("body") ModelBody body);

    /**
     * 删除设备
     */
    int onDelete(@Param("id") int id);
}
