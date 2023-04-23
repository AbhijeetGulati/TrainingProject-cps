package com.abhijeetgulati.cps.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abhijeetgulati.cps.entity.Claim;

@Service
public interface ClaimService {

    // here we will just declare the methods that we will need
    // the implementation of these methods is inside ClaimServiceImpl class

    // to save the details into the database
    void registerClaim(Claim claim);

    Claim getDetail(String claimNumber);//to get all the details regarding the Claim


}
