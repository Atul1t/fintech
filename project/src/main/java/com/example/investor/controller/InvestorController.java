package com.example.investor.controller;

import com.example.investor.entity.Investor;
import com.example.investor.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvestorController {

    @Autowired
    private InvestorService investorService;

    @GetMapping("/generate")
    @ResponseBody
    public String generateInvestors() {
        investorService.generateDummyInvestors();
        return "50 Investors Generated!";
    }

    @GetMapping("/investors")
    public String viewInvestors(Model model, @RequestParam(value = "search", required = false) String search) {
        List<Investor> investors = (search == null || search.isEmpty())
                ? investorService.getAllInvestors()
                : investorService.searchInvestorsByName(search);
        model.addAttribute("investors", investors);
        model.addAttribute("search", search);
        return "investors";
    }
}
