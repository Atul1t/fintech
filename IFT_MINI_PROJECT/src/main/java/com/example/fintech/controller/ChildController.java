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
public class ChildController {

    @Autowired private UserService userService;
    @Autowired private SessionService sessionService;

    @GetMapping("/child/create")
    public String createChildForm(Model model) {
        model.addAttribute("child", new User());
        return "create_child";
    }

    @PostMapping("/child/create")
    public String createChild(@ModelAttribute User child, HttpSession session) {
        User parent = sessionService.get(session);
        if (parent == null || !parent.getAccountType().toString().equals("PARENT"))
            return "redirect:/login";
        userService.createChild(child, parent);
        return "redirect:/dashboard/parent";
    }
}
