package com.mon.aichat.mapper;

import com.mon.aichat.model.entity.TokenEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 修改Token
 *
 */
public interface TmpMapper {

    TokenEntity query(@Param("id") int userId);

    int insert(@Param("id") int uid, @Param("value") String token);

    int update(@Param("id") int uid, @Param("value") String token);

    int delete(@Param("id") int userId);

}
