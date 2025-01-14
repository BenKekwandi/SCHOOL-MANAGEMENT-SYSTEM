package com.system.User_service.controller;
import com.system.User_service.dto.UserRequest;
import com.system.User_service.dto.UserResponse;
// import com.system.User_service.dto.UserResponse;
import com.system.User_service.model.User;
import com.system.User_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController{

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> index(){
       return userService.getAllUsers();
    }

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public void show(){
    //     userService.getUser();
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User store(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UserRequest userRequest){
        userService.editUser(userRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void destroy(){
        userService.deleteUser();
    }

}