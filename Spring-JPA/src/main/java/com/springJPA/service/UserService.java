package com.springJPA.service;

import com.springJPA.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUser();
    User getUserById(long id);

    User updateUser(long id,User user);
    String deleteUser(long id);
}
