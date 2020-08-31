package com.example.community.rest;

import com.example.community.entity.User;
import com.example.community.service.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserRestController {

    private final IUserService userService;

    public UserRestController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(consumes = "application/json")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
