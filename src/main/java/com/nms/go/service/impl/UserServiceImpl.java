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
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    
   
    @Override
    @Transactional
    public User addUser(User user) {
        return userDao.makePersistent(user);
    }
    
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
