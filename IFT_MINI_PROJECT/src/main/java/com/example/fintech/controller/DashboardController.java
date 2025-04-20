package com.example.fintech.controller;

import com.example.fintech.entity.AccountType;
import com.example.fintech.entity.User;
import com.example.fintech.service.SessionService;
import com.example.fintech.service.TransactionService;
import com.example.fintech.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class DashboardController {

    @Autowired private UserService userService;
    @Autowired private TransactionService transactionService;
    @Autowired private SessionService sessionService;
    
    @GetMapping("/create-child")
    public String showCreateChildForm(Model model) {
        model.addAttribute("child", new User());
        return "create_child";
    }

    @PostMapping("/create-child")
    public String createChildAccount(@ModelAttribute("child") User child, HttpSession session) {
        User parent = sessionService.get(session);
        if (parent == null || parent.getAccountType() != AccountType.PARENT) {
            return "redirect:/login";
        }
        userService.createChild(child, parent);
        return "redirect:/dashboard/parent";
    }


    @GetMapping("/dashboard/parent")
    public String parentDashboard(HttpSession session, Model model) {
        User user = sessionService.get(session);
        if (user == null || !user.getAccountType().toString().equals("PARENT")) {
            return "redirect:/login";
        }

        model.addAttribute("user", user); // ✅ This line fixes the template error
        model.addAttribute("children", userService.findChildrenByParentId(user.getId()));
        return "parent_dashboard";
    }


    @GetMapping("/dashboard/child")
    public String childDashboard(HttpSession session, Model model) {
        User child = sessionService.get(session);
        if (child == null || child.getAccountType() == null || !child.getAccountType().toString().equals("CHILD"))
            return "redirect:/login";
        model.addAttribute("child", child);
        model.addAttribute("transactions", transactionService.findByUser(child.getId()));
        return "child_dashboard";
    }
    
    @GetMapping("/dashboard/child/{childId}")
    public String viewChildFromParent(@PathVariable Long childId, HttpSession session, Model model) {
        User parent = sessionService.get(session);
        if (parent == null || parent.getAccountType().toString().equals("CHILD")) {
            return "redirect:/login";
        }

        Optional<User> child = userService.findById(childId);
        if (child.isPresent() && child.get().getParent().getId().equals(parent.getId())) {
            model.addAttribute("child", child.get());
            model.addAttribute("transactions", transactionService.findByUser(childId));
            model.addAttribute("accountType", "CHILD"); // pass this too!
            return "child_dashboard";
        }

        return "redirect:/dashboard/parent";
    }

    

}
