package com.mdx.hubing.model.dto;

/**
 * Author: Meng
 * Date: 2023-03-24
 * Desc:
 */
public class LoginDao {
    private int id;
    private String uid;
    private String token;
    private String phone;
    private String email;

    @Override
    public String toString() {
        return "LoginDao{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}
