package com.example.fintech.service;

import com.example.fintech.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    public void login(HttpSession session, User user) { session.setAttribute("user", user); }
    public User get(HttpSession session) { return (User) session.getAttribute("user"); }
    public void logout(HttpSession session) { session.invalidate(); }
}
