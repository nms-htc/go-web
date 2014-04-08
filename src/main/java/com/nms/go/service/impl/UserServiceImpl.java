/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.UserDao;
import com.nms.go.model.User;
import com.nms.go.service.UserService;
import com.nms.go.util.AppException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

@Named
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.makePersistent(user);
    }

    @Override
    public List<User> getAllUser() {
        _logger.info("Call UserService.getAllUser()");
        List<User> users = new ArrayList<>();
        try {
            users = userDao.findAll();
        } catch (Exception ex) {
            _logger.log(Level.SEVERE, "Error when get all user from db!");
            throw new AppException("error-when-get-all-user-from-db");
        }

        return users;
    }

    @Override
    public User fetchUser(Long userId) {
        User user = null;
        try {
            user = userDao.findById(userId);
        } catch (Exception ex) {
            _logger.log(Level.SEVERE, "Cannot get user from id");
            throw new AppException("Cannot get user from id");
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
            return userDao.update(user);
        } catch (Exception ex) {
            throw new AppException(ex, "Cannot update user from id");
        }
    }

    // Logger
    private static final Logger _logger = Logger.getLogger(UserServiceImpl.class.getName());

}
