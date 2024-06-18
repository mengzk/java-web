package com.mdx.hubing.mapper;

import com.mdx.hubing.model.body.*;
import com.mdx.hubing.model.dto.AccountDao;
import com.mdx.hubing.model.entity.AccountEntity;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */
public interface AccountMapper {

    //    int register(@Param("user") LoginBody account);
    int register(@Param("user") AccountEntity entity);

    AccountDao login(@Param("body") LoginBody body);

    AccountDao wxLogin(@Param("body") LoginBody body);

    Integer check(@Param("body") LoginBody body);

    Integer query(@Param("body") LoginBody body);

    AccountDao queryByUid(@Param("uid") String uid);

    int updateAccount(@Param("body") LoginBody body);

    int reset(@Param("id") int id, @Param("pwd") String pwd);

    int logout(int id);

    int accountNum();

    ArrayList<AccountDao> accountAll();
}
