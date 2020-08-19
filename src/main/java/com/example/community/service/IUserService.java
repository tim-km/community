package com.example.community.service;

import com.example.community.entity.User;

public interface IUserService {
    
    User getUser(Long id);

    Iterable<User> getUsers();

    User saveUser(User user);
    
    void deleteUser(Long id);
}
