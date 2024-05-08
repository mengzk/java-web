package com.mdx.hubing.service;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.dto.AccountDao;
import com.mdx.hubing.model.entity.AccountEntity;
import java.util.ArrayList;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface ChatService {
    AccountEntity register();
    AccountDao login();
    AccountDao wxLogin() throws CustomException;
    int update();
    int reset();
    int logout();
    int delete();
}
