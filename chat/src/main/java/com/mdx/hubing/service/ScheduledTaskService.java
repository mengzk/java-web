package com.mdx.hubing.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Author: Meng
 * Date: 2024-06-25
 * Desc:
 */
@Service
public class ScheduledTaskService {
    /**
     * fixedRate属性设置每隔固定时间执行
     */
//    @Scheduled(fixedRateString = "10000")
    public void reportCurrentTime() {
        System.out.println("每隔五秒执行一次");
    }

    /**
     * cron属性可以设置指定时间执行，cron表达式跟linux一样
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void fixTimeExecution() {
        System.out.println("指定时间 0 0 0 * * ? 执行");
    }

    /**
     * 上一次任务执行完成之后10秒后在执行
     */
//    @Scheduled(fixedDelayString = "10000")
    public void runWithFixedDelay() {
        System.out.println("指定时间 执行");
    }

    /**
     * 初始延迟1秒后开始，然后每10秒执行一次
     */
//    @Scheduled(initialDelayString = "10000", fixedDelayString = "10000")
    public void executeWithInitialAndFixedDelay() {
        System.out.println("指定时间 initialDelay 执行");
    }
}
