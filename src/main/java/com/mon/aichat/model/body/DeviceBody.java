package com.mon.aichat.model.body;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class DeviceBody {
    public Integer id;
    public String nickname;
    public String memo;
    public String sn;
    public int deviceType;
    public String createTime;

    public DeviceBody() {
        createTime = "2024-08-17";
    }
//    public int gid;

    @Override
    public String toString() {
        return "DeviceBody{" +
                "nickname='" + nickname + '\'' +
                ", memo='" + memo + '\'' +
                ", sn='" + sn + '\'' +
                ", deviceType=" + deviceType +
                '}';
    }
}
