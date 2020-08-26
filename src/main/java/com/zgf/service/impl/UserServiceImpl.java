/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.zgf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgf.dao.UserDao;
import com.zgf.domain.User;
import com.zgf.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(String id) {
        return userDao.selectByPrimaryKey(id);
    }


}
