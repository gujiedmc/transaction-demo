package com.gujiedmc.tx.single.spring.controller;

import com.gujiedmc.tx.common.entity.AccountEntity;
import com.gujiedmc.tx.single.spring.serivce.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gujiedmc
 * @date 2021-08-20
 */
@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping
    public String add(@RequestBody AccountEntity accountEntity) {
        accountService.add(accountEntity);
        return "ok";
    }
}
