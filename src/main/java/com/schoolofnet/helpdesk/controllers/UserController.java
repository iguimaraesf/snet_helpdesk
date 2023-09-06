package com.schoolofnet.helpdesk.controllers;

import com.schoolofnet.helpdesk.model.User;
import com.schoolofnet.helpdesk.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", service.findAll());
        return "users/index";
    }

    @GetMapping("new")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }

    @GetMapping("{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.show(id));
        return "users/edit";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "users/create";
        }
        service.create(user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, Model model) {
        service.delete(id);
        return "redirect:/users";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("user") User user,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        service.update(id, user);
        return "redirect:/users";
    }
}
