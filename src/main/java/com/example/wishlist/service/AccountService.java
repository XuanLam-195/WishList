package com.example.wishlist.service;

import com.example.wishlist.model.Account;
import com.example.wishlist.model.Address;
import com.example.wishlist.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AccountRepository accountRepository;
    public Account addAccount(Account account){
        account.setPass_word(passwordEncoder.encode(account.getPass_word()));
        accountRepository.addAccount(account);
        return account;
    }

    public List<Account> getAllAccount(){
        return accountRepository.findAllAccount();
    }
    public List<Address> getAllAddress(){
        return accountRepository.findAllAddress();
    }
}
