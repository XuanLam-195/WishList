package com.example.wishlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showContactPage(){
        return "contact";
    }

    @PostMapping("/submit-message")
    public String submitMessage(@RequestParam("message") String message){
        System.out.println("Recived message: " + message);
        return "redirect:/contact";
    }

}
