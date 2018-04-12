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
@RequestMapping("api/v1/users/")
public class UserController {

    private IUserService userService;

    @Autowired
    UserController(IUserService userService){
        this.userService = userService;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<User> listUsers(){
        return userService.findAll();
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return "success";
    }

}
