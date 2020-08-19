package com.example.community.service.impl;

import com.example.community.dao.IUserDAO;
import com.example.community.entity.User;
import com.example.community.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userDAO.findById(id);
        // TODO handle NULL values for User entity
        return user.get();
    }

    @Override
    public Iterable<User> getUsers() {
        return userDAO.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }
}
