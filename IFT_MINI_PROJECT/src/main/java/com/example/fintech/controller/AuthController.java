package com.example.fintech.controller;

import com.example.fintech.entity.User;
import com.example.fintech.service.SessionService;
import com.example.fintech.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired private UserService userService;
    @Autowired private SessionService sessionService;

    @GetMapping("/login")
    public String loginForm() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        var user = userService.authenticate(email, password);
        if (user.isPresent()) {
            sessionService.login(session, user.get());
            return user.get().getAccountType().toString().equals("PARENT") ? "redirect:/dashboard/parent" : "redirect:/dashboard/child";
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // or use sessionService.logout(session);
        return "redirect:/login";
    }
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String registerParent(@ModelAttribute User user) {
        userService.registerParent(user);
        return "redirect:/login";
    }

}
