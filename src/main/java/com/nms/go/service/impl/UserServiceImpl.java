/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.UserDao;
import com.nms.go.model.User;
import com.nms.go.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserDao> implements UserService {

    @Override
    @Autowired
    public void setDao(UserDao userDao) {
        this.dao = userDao;
    }
}
