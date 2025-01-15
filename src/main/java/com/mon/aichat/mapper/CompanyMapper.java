package com.mon.aichat.mapper;

import com.mon.aichat.model.body.CompanyBody;
import com.mon.aichat.model.entity.CompanyEntity;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface CompanyMapper {

    // 注册公司
    int onInsert(@Param("body") CompanyBody body);

    // 查询公司
    List<CompanyEntity> onQuery(@Param("size") int size, @Param("position") int position, @Param("level") Integer level, @Param("key") String key);

    // 查询公司数量
    int onCount(@Param("level") int level, @Param("key") String key);

    // 更新公司
    int onUpdate(@Param("body") CompanyBody body);

    // 删除公司
    int onDelete(@Param("id") int id);
}
