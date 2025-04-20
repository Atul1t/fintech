package com.example.fintech.controller;

import com.example.fintech.entity.Transaction;
import com.example.fintech.entity.User;
import com.example.fintech.service.SessionService;
import com.example.fintech.service.TransactionService;
import com.example.fintech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;

    // Logged-in user transaction view
    @GetMapping("/transactions")
    public String viewTransactions(HttpSession session, Model model) {
        User user = sessionService.get(session);
        if (user == null || user.getAccountType() == null) {
            return "redirect:/login";
        }

        model.addAttribute("transactions", transactionService.findByUser(user.getId()));
        model.addAttribute("accountType", user.getAccountType().toString());
        

        return "transactions";
    }

    // Logged-in user transaction submission
    @PostMapping("/transactions")
    public String addTransaction(@ModelAttribute Transaction transaction, HttpSession session) {
        User user = sessionService.get(session);
        if (user == null || user.getAccountType() == null) {
            return "redirect:/login";
        }

        transaction.setUser(user);
        transactionService.add(transaction);
        return "redirect:/transactions";
    }

    // Parent views specific child's transactions
    @GetMapping("/transactions/child/{childId}")
    public String viewChildTransactions(@PathVariable Long childId, HttpSession session, Model model) {
        User parent = sessionService.get(session);
        Optional<User> childOpt = userService.findById(childId);

        if (parent == null || childOpt.isEmpty() || !childOpt.get().getParent().getId().equals(parent.getId())) {
            return "redirect:/dashboard/parent";
        }

        User child = childOpt.get();
        System.out.println("Viewing child dashboard for child ID: " + childId);
        List<Transaction> txList = transactionService.findByUser(child.getId());
        System.out.println("Found " + txList.size() + " transactions for child");
        model.addAttribute("transactions", txList);
        model.addAttribute("child", child);
        model.addAttribute("accountType", "CHILD");
        model.addAttribute("accountType", parent.getAccountType().toString());

        return "transactions";
    }


    // Parent adds a transaction for specific child
    @PostMapping("/transactions/child/{childId}")
    public String addTransactionForChild(@PathVariable Long childId,
                                         @ModelAttribute Transaction transaction,
                                         HttpSession session) {
        User parent = sessionService.get(session);
        Optional<User> childOpt = userService.findById(childId);

        if (parent == null || childOpt.isEmpty() || !childOpt.get().getParent().getId().equals(parent.getId())) {
            return "redirect:/dashboard/parent";
        }

        transaction.setUser(childOpt.get());
        transactionService.add(transaction);
        return "redirect:/transactions/child/" + childId;
    }

}

