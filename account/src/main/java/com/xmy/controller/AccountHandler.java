package com.xmy.controller;

import com.xmy.entity.Account;
import com.xmy.repository.AdminRepository;
import com.xmy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Account account(@RequestBody Account account) {
        Account ac = null;
        switch (account.type) {
            case "user":
                ac = userRepository.login(account.getUsername(), account.getPassword());
                break;
            case "admin":
                ac = adminRepository.login(account.getUsername(), account.getPassword());
                break;
        }
        return ac;
    }
}
