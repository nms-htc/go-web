/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service;

import com.nms.go.model.User;
import java.util.List;

public interface UserService {
    public User addUser(User user);
    
    public List<User> getAllUser();
    
    public User fetchUser(Long userId);
    
    public User update(User user);
}
