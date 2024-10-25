package org.ust.security_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ust.security_service.Service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user)
    {
        return userService.verify(user);
    }
}
