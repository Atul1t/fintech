package com.example.fintech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String landingPage() {
        return "landing";
    }

    @GetMapping("/details")
    public String detailsPage() {
        return "details";
    }

    @GetMapping("/namecomponents")
    public String namePage() {
        return "namecomponents";
    }

    @GetMapping("/proofofidentity")
    public String proofPage() {
        return "proofofidentity";
    }

    @GetMapping("/identification")
    public String idPage() {
        return "identification";
    }

    @GetMapping("/addresscomponents")
    public String addressPage() {
        return "addresscomponents";
    }
}