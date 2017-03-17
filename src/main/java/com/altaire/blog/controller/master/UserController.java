package com.altaire.blog.controller.master;

import com.altaire.blog.model.dto.UserDto;
import com.altaire.blog.model.enumeration.Actions;
import com.altaire.blog.model.master.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.altaire.blog.service.impl.master.UserServiceImpl;
import com.altaire.blog.service.master.UserService;
import com.altaire.blog.validator.UserValidator;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */

@RequestMapping(produces = "application/json")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public List<User> findAll() {
        logger.debug("get all user");
        return userService.findAll();
    }

    @RequestMapping(value = "/api/user/id/{id}", method = RequestMethod.GET)
    public UserDto findById(@PathVariable Long id) {
        logger.debug("get user with id " + id);
        return userService.findByDtoId(id);
    }

    @RequestMapping(value = "/api/user/name/{name}", method = RequestMethod.GET)
    public User findByName(@PathVariable String name) {
        logger.debug("get user by name " + name);
        return userService.findByUsername(name);
    }

    @RequestMapping(value = "/api/user/name/{name}/password/{password}", method = RequestMethod.GET)
    public User findByNameAndPassword(@PathVariable String name, @PathVariable String password) {
        logger.debug("get user by name " + name);
        return userService.findByUsernameAndPassword(name, password);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public void save(@RequestBody UserDto user) {
        logger.debug("post user");
        userService.create(userService.cloneValueFrom(user));
        //securityService.autologin(user.getUsername(), user.getPasswordConfirm());
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public User newUser() {
        return new User();
    }

    @RequestMapping(value = "/api/user/edit/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody UserDto user) {
        logger.debug("update user with id" + id);
        userService.create(userService.cloneValueFrom(user));
    }
}
