/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.zgf.service;

import com.zgf.domain.User;

public interface UserService {
    /**
     * 根据ID获取用户信息
     */
    public User getUserById(String id);
}
