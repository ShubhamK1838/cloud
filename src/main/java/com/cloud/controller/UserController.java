package com.cloud.controller;

import com.cloud.model.entity.User;
import com.cloud.model.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @ GetMapping("/auth/form")
    public String  showForm()
    {
        return "auth";
    }


    @PostMapping("/auth")
    public String auth(HttpServletRequest request, Model model, @RequestParam("email") String email, @RequestParam("password") String password)
    {
        User user=service.authenticate(email, password);
        if (user!=null)
        {
            request.getSession().setAttribute("user", user);
            model.addAttribute("user", user);

            return "redirect:/home";
        }
        else
            return "redirect:/auth/form";
    }

    @PostMapping("/user")
    public  String createUser(@ModelAttribute User user)
    {
        user= service.create(user);

        if(user==null)
            return "redirect:/auth/form";
        return "redirect:/home";
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id)
    {

        return null;

    }


}
