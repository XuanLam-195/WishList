package com.example.wishlist.controller;



import com.example.wishlist.model.Gift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.wishlist.service.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller// Thể hiện controller, hứng request
@RequestMapping("")// đánh dấu đường dẫn
public class WishListController {
    @Autowired
    private WishListService wishListService;

    @GetMapping("login")// lấy thông tin, phương thức get
    public String loginPage() {
        return "login";
    }


    @GetMapping("home")// lấy thông tin, phương thức get
    public String getWishList(Model model) {
        List<Gift> giftList = wishListService.getAllGift();// Lấy danh sách gìt từ cơ sở dữ liệu
        if (giftList != null) {
            model.addAttribute("gifts", giftList);
        }
        model.addAttribute("title", "home");
        return "main";
    }


}
