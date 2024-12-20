package com.mon.aichat.mapper;

import com.mon.aichat.model.entity.TokenEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface TokenMapper {

    int exists(@Param("id") int uid);

    TokenEntity query(@Param("id") int userId);

    int insert(@Param("id") int uid, @Param("value") String token);

    int update(@Param("id") int uid, @Param("value") String token);

    void upsert(@Param("id") int uid, @Param("value") String token);

    int delete(@Param("id") int userId);

}
