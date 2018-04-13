package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.User;
import com.fsu.base.federationofsport.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yana on 04.04.18.
 */

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private IUserService userService;

    @Autowired
    UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping(path="/{id}")
    public User get(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
