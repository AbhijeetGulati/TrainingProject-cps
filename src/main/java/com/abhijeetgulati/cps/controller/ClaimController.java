package com.abhijeetgulati.cps.controller;

import com.abhijeetgulati.cps.entity.Claim;
import com.abhijeetgulati.cps.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/register") // default mapping
    public String register(Model model) {
        Claim claim = new Claim();
        model.addAttribute("claim", claim);
        return "register";// this is the page that will be displayed
    }


    //now to add the data to the database we will create a post mapping
    @PostMapping("/registerDetails")
    public String registerDetails(@ModelAttribute("claim") Claim claim, Model model) {
        model.addAttribute("claim", claim);

        claimService.registerClaim(claim);//saving all the details to the database

        return "details";//for details.html
        //to show all the details regarding our Claim
    }

}
