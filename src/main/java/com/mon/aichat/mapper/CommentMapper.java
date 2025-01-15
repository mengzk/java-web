package com.mon.aichat.mapper;

import com.mon.aichat.model.entity.CompanyEntity;
import com.mon.aichat.model.entity.TokenEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 评论
 */
public interface CommentMapper {

    CompanyEntity onQuery(@Param("id") int id);

    int onCount(@Param("id") int id);

    int onInsert(@Param("id") int uid);

    int onUpdate(@Param("id") int uid);

    int onDelete(@Param("id") int userId);

}
