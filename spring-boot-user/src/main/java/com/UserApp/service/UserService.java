package com.UserApp.service;

import com.UserApp.dto.UserDto;
import com.UserApp.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getUserData();

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
}
