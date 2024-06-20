package com.mdx.hubing.service;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.LoginBody;
import com.mdx.hubing.model.body.RegisterBody;
import com.mdx.hubing.model.dto.AccountDao;
import com.mdx.hubing.model.dto.LoginDao;
import com.mdx.hubing.model.entity.AccountEntity;

import java.util.ArrayList;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface AccountService {
    LoginDao register(LoginBody body) throws CustomException;
    LoginDao login(LoginBody body) throws CustomException;
    LoginDao wxLogin(LoginBody body) throws CustomException;
    int update(LoginBody body);
    int reset(LoginBody body);
    int logout(String token);
    int delete(String token);
    int total();
    ArrayList<AccountDao> accountAll();
}
