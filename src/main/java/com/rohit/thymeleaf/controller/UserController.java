package com.rohit.thymeleaf.controller;

import com.rohit.thymeleaf.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model, @SortDefault.SortDefaults({@SortDefault("userName.lastName"),@SortDefault("userName.firstName")}) Pageable pageable){
        model.addAttribute("users",userService.findAll(pageable));
        return "users/list";
    }
}
