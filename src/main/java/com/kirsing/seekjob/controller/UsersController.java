package com.kirsing.seekjob.controller;

import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.entity.UsersType;
import com.kirsing.seekjob.service.UsersService;
import com.kirsing.seekjob.service.UsersTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

//    @Autowired
//    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
//        this.usersTypeService = usersTypeService;
//        this.usersService = usersService;
//    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users) {
        usersService.addNewUser(users);
        return "dashboard";
    }
}