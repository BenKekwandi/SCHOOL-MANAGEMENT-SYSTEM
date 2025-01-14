package com.system.User_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.User_service.dto.UserRequest;
import com.system.User_service.dto.UserResponse;
import com.system.User_service.model.User;
import com.system.User_service.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService{

    private final UserRepository UserRepository;

    public List<UserResponse> getAllUsers(){

        List<User> users = UserRepository.findAll();
        return users.stream().map(this::mapToUserResponse).toList();
        
    }

    public void getUser(){

    }


    public User createUser(UserRequest request){
        User user = User.builder()
            .username(request.getUsername())
            .password(request.getPassword())
            .build();
        UserRepository.save(user);
        return user;
    }

    public void editUser(UserRequest request){

    }

    public void deleteUser(){
        
    }

    public UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
        .id(user.getId())
        .username(user.getUsername())
        .password(user.getPassword())
        .build();
    }
}