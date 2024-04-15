package com.example.wishlist.controller;


import com.example.wishlist.model.Account;
import com.example.wishlist.model.Gift;
import com.example.wishlist.model.GiftType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.wishlist.service.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller// Thể hiện controller, hứng request
@RequestMapping("")// đánh dấu đường dẫn
public class WishListController {
    @Autowired
    private WishListService wishListService;


    @GetMapping("/home")// lấy thông tin, phương thức get
    public String getWishList(Model model) {
        List<Gift> giftList = wishListService.getAllGift();// Lấy danh sách gìt từ cơ sở dữ liệu
        if (giftList != null) {
            model.addAttribute("gifts", giftList);
        }
        model.addAttribute("title", "home");
        return "main";
    }


    @GetMapping("create")// lấy thông tin, phương thức get
    public String addWishList(Model model) {
        List<GiftType> giftList = wishListService.getAllGiftType();// Lấy danh sách gìt từ cơ sở dữ liệu
        if (giftList != null) {
            model.addAttribute("giftTypes", giftList);
        }
        model.addAttribute("title", "create");
        model.addAttribute("gift", new Gift());
        return "gift/create";
    }

    @PostMapping("create")// lấy thông tin, phương thức get
    public String saveWishList(Gift gift, RedirectAttributes model) {
        wishListService.addGift(gift);
        model.addFlashAttribute("message", "Create gift is success");
        return "redirect:/home";
    }


}
