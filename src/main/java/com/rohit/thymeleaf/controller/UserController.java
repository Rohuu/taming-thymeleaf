package com.rohit.thymeleaf.controller;

import com.rohit.thymeleaf.model.CreateUserFormData;
import com.rohit.thymeleaf.model.Gender;
import com.rohit.thymeleaf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @GetMapping("/create")
    public String createUserForm(Model model){
        model.addAttribute("user",new CreateUserFormData());
        model.addAttribute("genders", List.of(Gender.MALE,Gender.FEMALE,Gender.OTHERS));
        return "users/edit";
    }

    @PostMapping("/create")
    public String doCreateUser(@Valid @ModelAttribute("user") CreateUserFormData formData, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("genders",List.of(Gender.MALE,Gender.FEMALE,Gender.OTHERS));
            return "users/edit";
        }
        userService.createUser(formData.toParameters());
        return "redirect:/users";
    }
}
