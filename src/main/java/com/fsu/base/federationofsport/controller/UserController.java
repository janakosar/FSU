package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.User;
import com.fsu.base.federationofsport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yana on 04.04.18.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<User> listUsers(){
        return userService.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return "success";
    }

}
