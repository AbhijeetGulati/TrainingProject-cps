package com.abhijeetgulati.cps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhijeetgulati.cps.entity.Claim;
import com.abhijeetgulati.cps.repository.ClaimRepository;
import com.abhijeetgulati.cps.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    //we want to use userRepo here
    @Autowired
    private ClaimRepository claimRepo;

    @Override
    public Claim getUser(String claimNumber) {
        Optional<Claim> result = claimRepo.findById(claimNumber);

        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
    //using this we can save the login credentials to our database
}
