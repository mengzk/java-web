package com.mon.aichat.model.body;

import java.util.Date;

/**
 * Author: Meng
 * Date: 2024-08-19
 * Desc:
 */
public class CompanyBody {
    public Integer id;
    public Integer status;
    public Integer uid;
    public Integer level; // 0普通 1VIP
    public Date time = new Date();
    public String name;
    public String logo;
    public String memo;
}
