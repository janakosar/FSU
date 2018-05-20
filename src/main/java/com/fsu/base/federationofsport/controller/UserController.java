package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.User;
import com.fsu.base.federationofsport.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by yana on 04.04.18.
 */

@RestController
@RequestMapping("api/users")
public class UserController {

    private IUserService userService;

    @Autowired
    UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> getAll(){
        return userService.findAll();
    }

    @GetMapping(path="/me")
    public User getMe(Principal principal){
        return userService.findByUsername(principal.getName());
    }


    @GetMapping(path="/{username}")
    public User get(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping(path = "/{username}")
    public void delete(@PathVariable String username){
        userService.delete(username);
    }

}
