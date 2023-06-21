package com.rohit.thymeleaf.controller;

import com.rohit.thymeleaf.handler.UserNotFoundException;
import com.rohit.thymeleaf.model.*;
import com.rohit.thymeleaf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

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
        model.addAttribute("editMode", EditMode.CREATE);
        return "users/edit";
    }

    @PostMapping("/create")
    public String doCreateUser(@Valid @ModelAttribute("user") CreateUserFormData formData, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("genders",List.of(Gender.MALE,Gender.FEMALE,Gender.OTHERS));
            model.addAttribute("editMode", EditMode.CREATE);
            return "users/edit";
        }
        userService.createUser(formData.toParameters());
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String editFormData(@PathVariable("id") UUID id,Model model){
        User user=userService.getUser(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        model.addAttribute("user", EditUserFormData.fromUser(user));
        model.addAttribute("genders",List.of(Gender.MALE,Gender.FEMALE,Gender.OTHERS));
        model.addAttribute("editMode", EditMode.UPDATE);
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String doEditUser(@PathVariable("id") UUID id,
                           @ModelAttribute("user") EditUserFormData editUserFormData,
                           BindingResult bindingResult, Model model) throws UserPrincipalNotFoundException {
        if(bindingResult.hasErrors()){
            model.addAttribute("genders",List.of(Gender.MALE,Gender.FEMALE,Gender.OTHERS));
            model.addAttribute("editMode",EditMode.UPDATE);
            return "user/edit";
        }
        userService.editUser(id,editUserFormData.toParameters());
        return "redirect:/users";
    }
}
