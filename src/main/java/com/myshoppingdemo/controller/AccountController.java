package com.myshoppingdemo.controller;

import com.myshoppingdemo.entity.User;
import com.myshoppingdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AccountController {
    private UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/account/delete")
    public String delete(@RequestParam("userId") Long theId) {
        userService.deleteById(theId);
        return "redirect:/showMyLoginPage";
    }
}
