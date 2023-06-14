package com.BlogAppApis.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BlogAppApis.exception.ResourceNotFoundException;
import com.BlogAppApis.model.User;
import com.BlogAppApis.payload.UserDto;
import com.BlogAppApis.repo.RoleRepo;
import com.BlogAppApis.repo.UserRepo;
import com.BlogAppApis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    // @Autowired
    // private passwordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        return null;
        // User user = this.modelMapper.map(userDto, User.class);

        // // encoded the password
        // user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        // // roles
        // Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();

        // user.getRoles().add(role);

        // User newUser = this.userRepo.save(user);

        // return this.modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // To convert data DTO-TO-USER
        User user = this.dtoToEntity(userDto);
        // Run the save method
        User saveUser = this.userRepo.save(user);
        // To reConvert Entity-To-DTO and return it
        return this.entityToDto(saveUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        // database me user ka data nahi ho per ResourceNotFoundException chalegi
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        // change the user info code
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        // save update info
        User updateUser = this.userRepo.save(user);
        // Now Convert to update data User-To-Dto
        UserDto userDto1 = this.entityToDto(updateUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

        return this.entityToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // get the all users details
        List<User> users = this.userRepo.findAll();
        // to convert user-to-dto
        List<UserDto> userDtos = users.stream().map(user -> this.entityToDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        // get the user detail
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        // delete the fetch detail
        this.userRepo.delete(user);
    }

    // To convert UserDto to User (Entity-to-DTO) change method
    public User dtoToEntity(UserDto userDto) {
        // Automatic change Entity-to-DTO using ModelMapper
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    // To convert User to UserDto (DTO-to-Entity) change method
    public UserDto entityToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
