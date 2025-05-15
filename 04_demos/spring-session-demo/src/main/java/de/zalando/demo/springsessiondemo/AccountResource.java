package de.zalando.demo.springsessiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {

    @Autowired
    public Account account;

    @GetMapping("/account/{id}")
    public Account getAccount() {
        return account;
    }

    @PostMapping("/account/{id}")
    public void setAccount(Account account) {
        this.account = account;
    }

}
