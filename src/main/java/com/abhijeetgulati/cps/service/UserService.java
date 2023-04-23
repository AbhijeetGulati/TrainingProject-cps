package com.abhijeetgulati.cps.service;

import org.springframework.stereotype.Service;

import com.abhijeetgulati.cps.entity.Claim;

@Service
public interface UserService {

    Claim getUser(String claimNumber);//using this we will register our user
}
