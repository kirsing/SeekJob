package com.kirsing.seekjob.controller;

import com.kirsing.seekjob.entity.Users;
import com.kirsing.seekjob.entity.UsersType;
import com.kirsing.seekjob.service.UsersTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private final UsersTypeService usersTypeService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService) {
        this.usersTypeService = usersTypeService;
    }



    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> userTypes = usersTypeService.getAll();
        model.addAttribute("getAllUserTypes", userTypes);
        model.addAttribute("user", new Users());
        return "register";
    }


}
