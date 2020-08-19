package com.example.community.dao;

import com.example.community.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDAO extends CrudRepository<User, Long> {
}
