package com.schoolofnet.helpdesk.controllers;

import com.schoolofnet.helpdesk.model.Role;
import com.schoolofnet.helpdesk.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService service;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", this.service.findAll());
        return "roles/index";
    }

    @GetMapping("new")
    public String newRole(Model model) {
        model.addAttribute("role", new Role());
        return "roles/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "roles/create";
        }
        service.create(role);
        return "redirect:/roles";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, Model model) {
        this.service.delete(id);
        return "redirect:/roles";
    }
}
