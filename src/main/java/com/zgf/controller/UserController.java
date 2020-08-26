/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.zgf.controller;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zgf.domain.User;
import com.zgf.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value="id",required=true) String id) throws Exception {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL,"t3://10.66.0.50:7001");

        // 初始化查找命名空间
        Context ctx = new InitialContext(env);
//        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/test");
//        // 获取数据库连接
//        Connection conn = ds.getConnection();
//        Statement stat = conn.createStatement();
//        stat.execute("INSERT into user VALUES ('666', 'user666')");
//        stat.close();
        User user = userService.getUserById(id);

        ModelAndView mav = new ModelAndView();
        if (user == null) {
            //跳转至失败页
            mav.setViewName("fail");
            return mav;
        } else {
            //跳转至成功页
            mav.addObject("id", user.getId());
            mav.addObject("name", user.getUserName());
            mav.addObject("gender", user.getUserGender());
            mav.addObject("birthday", user.getUserBirthday());
            mav.setViewName("success");
            return mav;
        }
    }
}
