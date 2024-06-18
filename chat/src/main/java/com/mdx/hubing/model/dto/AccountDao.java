package com.mdx.hubing.model.dto;

/**
 * Author: Meng
 * Date: 2023-03-24
 * Desc:
 */
public class AccountDao {
    private int id;
    private String uid;
//    private String pwd;
    private String icon;
    private String nickname;
    private String phone;
    private String email;
    private String about;
    private String birth;
    private String city;
    private int tag; //
    private int level;
    private int score;
    private int grade; //
    private int status;
    private int channel; //
    private String shareCode; //
    private String createDate;
    private String channelSign;

    @Override
    public String toString() {
        return "AccountDao{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", about='" + about + '\'' +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", shareCode='" + shareCode + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getChannelSign() {
        return channelSign;
    }

    public void setChannelSign(String channelSign) {
        this.channelSign = channelSign;
    }
}
