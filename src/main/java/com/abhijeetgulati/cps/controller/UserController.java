package com.abhijeetgulati.cps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhijeetgulati.cps.entity.Claim;
import com.abhijeetgulati.cps.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        //make new user object which will accept information
        Claim claim = new Claim();
        model.addAttribute("claim", claim);
        return "login";
    }

    @GetMapping("/userLogin") //this controller is to handle the input data that was entered by the user
    public String loginUser(@RequestParam String claimNumber, @RequestParam String dlNumber, @ModelAttribute("claim") Claim claim, Model model) {
        Claim newClaim = userService.getUser(claimNumber);
        System.out.println(newClaim);
        if (newClaim != null) {
            if (newClaim.getDlNumber().equals(dlNumber)) {
                model.addAttribute("claim", newClaim);
                return "details";
            } else {
                // wrong dl number
                return "error";
            }
        } else {
            // wrong claim number
            return "error";
            //if you enter invalid or wrong Claim Number or wrong DL Number error page will pop up
        }
    }

}
