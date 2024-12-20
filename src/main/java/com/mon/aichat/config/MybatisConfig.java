package com.mon.aichat.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: MyBatis相关配置
 */

@Configuration
@EnableTransactionManagement
@MapperScan({"com.mon.aichat.mapper"})
//@MapperScan({"com.mon.aichat.mapper", "com.mon.aichat.model.mapper"})
public class MybatisConfig { }
