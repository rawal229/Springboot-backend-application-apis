package com.BlogAppApis.service;

import java.util.List;
import com.BlogAppApis.payload.UserDto;

public interface UserService {

    UserDto registerNewUser(UserDto userDto);

    // create user info
    UserDto createUser(UserDto user);

    // update user info
    UserDto updateUser(UserDto user, Integer userId);

    // get single user info
    UserDto getUserById(Integer userId);

    // get all user info
    List<UserDto> getAllUsers();

    // delete user info
    void deleteUser(Integer userId);

}
