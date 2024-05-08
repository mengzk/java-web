package com.mdx.hubing.service.impl;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.dto.AccountDao;
import com.mdx.hubing.model.entity.AccountEntity;
import com.mdx.hubing.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 账号服务
 */
@Service
public class ChatServiceImpl implements ChatService {

    /**
     * 注册
     */
    @Override
    public AccountEntity register() {

        return null;
    }

    @Override
    public AccountDao login() {
        return new AccountDao();
    }

    /**
     * 微信注册
     */
    @Override
    public AccountDao wxLogin() throws CustomException {

        // 获取账号
        AccountDao account = null;

        return account;
    }

    @Override
    public int update() {
        int code = 0;

        return code;
    }

    @Override
    public int reset() {
        return 0;
    }

    @Override
    public int logout() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

}
