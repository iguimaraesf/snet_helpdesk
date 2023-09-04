package com.schoolofnet.helpdesk.controllers;

import com.schoolofnet.helpdesk.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String index(Model model) {
        return "users/index";
    }

    @GetMapping("new")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }

    @GetMapping("{id}")
    public String edit(@PathVariable Long id, Model model) {
        return "users/edit";
    }
}
