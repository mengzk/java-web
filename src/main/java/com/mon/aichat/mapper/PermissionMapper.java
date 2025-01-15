package com.mon.aichat.mapper;

import com.mon.aichat.model.entity.PermissionEntity;
import com.mon.aichat.model.entity.TokenEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 权限comment
 */
public interface PermissionMapper {

    List<PermissionEntity> onQuery(@Param("uid") int uid);

    int onInsert(@Param("body") PermissionEntity body);

    int onUpdate(@Param("body") PermissionEntity body);

    int onDelete(@Param("id") int id);

    // 授权 -批量
    int onAuthorize(@Param("uid") int uid, @Param("id") int id);

    // 撤销授权 -批量
    int onRevoke(@Param("uid") int uid, @Param("id") int id);
}
