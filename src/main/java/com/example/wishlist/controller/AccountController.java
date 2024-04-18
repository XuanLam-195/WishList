package com.example.wishlist.controller;

import com.example.wishlist.model.Account;
import com.example.wishlist.model.Address;
import com.example.wishlist.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class AccountController {
    @Autowired
    private AccountService accountService;



    @GetMapping("createAccount")// lấy thông tin, phương thức get
    public String addAccountList(Model model) {
        List<Address> accountList = accountService.getAllAddress();// Lấy danh sách gìt từ cơ sở dữ liệu
        if (accountList != null) {
            model.addAttribute("addresses", accountList);
        }
        model.addAttribute("title", "createAccount");
        model.addAttribute("account", new Account());
        return "account/createAccount";
    }

    @PostMapping("createAccount")// lấy thông tin, phương thức get
    public String saveAccountList(Account account, RedirectAttributes model) {
        accountService.addAccount(account);
        model.addFlashAttribute("message", "Create account is success!");
        return "redirect:/home";
    }
}
