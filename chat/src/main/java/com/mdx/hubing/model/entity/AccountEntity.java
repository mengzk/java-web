package com.mdx.hubing.model.entity;

import com.mdx.hubing.utils.DateTools;

/**
 * Author: Meng
 * Date: 2023-03-24
 * Desc:
 */
public class AccountEntity {
    public String uid;
    public String pwd;
    public String icon;
    public String nickname;
    public String phone;
    public String email;
    public int channel = 0; //
    public String shareCode; //
    public String createDate;
    public String channelSign;

    public AccountEntity(String phone, String email, String pwd) {
        this();
        this.phone = phone;
        this.email = email;
        this.pwd = pwd;
        this.uid = "241232";
    }

    public AccountEntity() {
        createDate = DateTools.currentDate();
        shareCode = Integer.toString((int) (100000 * Math.random()) + 100000);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                ", phone='" + phone +
                ", email='" + email +
                ", pwd='" + pwd +
                ", channelSign='" + channelSign +
                ", nickname='" + nickname +
                ", icon='" + icon +
                ", shareCode=" + shareCode +
                ", createDate='" + createDate +
                '}';
    }

}
