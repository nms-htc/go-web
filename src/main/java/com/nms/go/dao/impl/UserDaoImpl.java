/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.dao.impl;

import com.nms.go.dao.UserDao;
import com.nms.go.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends DaoImpl<User, Long> implements UserDao {

}
