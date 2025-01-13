package com.mon.aichat.config;

import com.mon.aichat.utils.DateHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Date;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: MyBatis相关配置
 */

@Configuration
@EnableTransactionManagement
@MapperScan({"com.mon.aichat.mapper"})
//@MapperScan({"com.mon.aichat.mapper", "com.mon.aichat.model.mapper"})
public class MybatisConfig {

//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
//
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        configuration.getTypeHandlerRegistry().register(Date.class, new DateHandler());
//        sessionFactory.setConfiguration(configuration);
//
//        return sessionFactory.getObject();
//    }
}
