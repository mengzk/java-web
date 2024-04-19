package com.mdx.hubing.config;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class AppConfig {
    // 阿里云存储
    public final static String OSS_REGION = "oss-cn-hangzhou";
    public final static String OSS_ACCESS = "";
    public final static String OSS_SECRET = "";
    public final static String OSS_BUCKET = "appstore"; // oss仓库根目录名称

    // 微信 配置
    public final static String WX_APPID = "12312312313";
    public final static String WX_SECRET = "1232123123";

    // WebSocket 配置
    public final static String WS_PATH = "link";
    public final static int PING_Interval = 1000 * 60; // 心跳间隔
}
