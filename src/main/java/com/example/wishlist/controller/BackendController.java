package com.example.wishlist.controller;

import com.example.wishlist.model.Gift;
import com.example.wishlist.model.GiftType;
import com.example.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller// Thể hiện controller, hứng request
@RequestMapping("backend")// đánh dấu đường dẫn
public class BackendController {

    @Autowired
    private WishListService wishListService;

    @GetMapping("list")// lấy thông tin, phương thức get
    public String listGift(Model model) {
        List<Gift> giftList = wishListService.getAllGift();// Lấy danh sách gìt từ cơ sở dữ liệu
        model.addAttribute("gifts", giftList);
        model.addAttribute("title", "list");
        return "gift/list";
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

    @GetMapping("gift/update/{id}")
    public String updateWishList(Model model, @PathVariable Integer id) {
        List<GiftType> giftList = wishListService.getAllGiftType();// Lấy danh sách gìt từ cơ sở dữ liệu
        if (giftList != null) {
            model.addAttribute("giftTypes", giftList);
        }
        model.addAttribute("title", "update");
        model.addAttribute("gift", wishListService.findById(id));
        return "gift/update";
    }

    @PostMapping("gift/update")// lấy thông tin, phương thức get
    public String saveUpdateWishList(Gift gift, RedirectAttributes model) {
        wishListService.addGift(gift);
        model.addFlashAttribute("message", "Update gift is success!");
        return "redirect:/backend/list";
    }

    @PostMapping("create")// lấy thông tin, phương thức get
    public String saveWishList(Gift gift, RedirectAttributes model) {
        wishListService.addGift(gift);
        model.addFlashAttribute("message", "Create gift is success!");
        return "redirect:/home";
    }
    @GetMapping("gift/delete/{id}")
    public String deleteWishList(RedirectAttributes model, @PathVariable Integer id) {
        wishListService.deleteGift(id);
        model.addFlashAttribute("message", "Delete gift is success!");
        return "redirect:/backend/list";
    }

}
