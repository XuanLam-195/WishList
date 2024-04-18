package com.example.wishlist.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelpController {
    @GetMapping("/help")
    public String help(Model model) {
        model.addAttribute("pageTitle", "Help Page");
        model.addAttribute("helpContent", "This is the content of the help page.");
        return "help";
    }
    @PostMapping("/toggleHelpContent")
    @ResponseBody
    public String toggleHelpContent(@RequestParam String helpSectionId) {
        return "Toggle help content for section with ID: " + helpSectionId;
    }

}
