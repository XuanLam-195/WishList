package com.example.wishlist.controller;

import com.example.wishlist.model.Account;
import com.example.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("addAccount")
public class AccountController {
    @Autowired
    private WishListService wishListService;

    @GetMapping("")
    public String getAll(Model model) {
        List<Account> accountsList = wishListService.getAllAccount();
        if (accountsList != null) {
            model.addAttribute("accounts", accountsList);
        }
        return "login";
    }
}
