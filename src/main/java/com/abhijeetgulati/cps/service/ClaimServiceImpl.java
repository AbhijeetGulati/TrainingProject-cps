package com.abhijeetgulati.cps.service;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abhijeetgulati.cps.entity.Claim;
import com.abhijeetgulati.cps.repository.ClaimRepository;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class ClaimServiceImpl implements ClaimService {

    //now we will autowire the ClaimRepo
    @Autowired
    private ClaimRepository claimRepo;

    @Override
    public void registerClaim(Claim claim) {
        //here we will define the method that we declared in the ClaimSevice interface
        //this will take the claim data using the object of class Claim and then save it to the database


        // Handle file upload
        try {
//			claim.setImageData(ImageUtil.compressImage(file.getBytes()));

            MultipartFile multiPartFile = claim.getImageFile();

            if (multiPartFile.isEmpty()) {

            } else {

                log.info("{}", multiPartFile);
//				log.info("{}", claim.getImageData());

                String fileName = multiPartFile.getOriginalFilename();

                fileName = fileName.substring(fileName.length() - 4, fileName.length());//because we just want the extension

                String base64EncodedImageData = "";

                fileName = fileName.toLowerCase();
                if (fileName.contains("jpg") || fileName.contains("jpeg")) {
                    base64EncodedImageData = "data:image/jpeg;base64,";
                } else if (fileName.contains("png")) {
                    base64EncodedImageData = "data:image/png;base64,";
                } else {
                    log.info("Image type not supported - {}", fileName);
                }

                if (base64EncodedImageData.length() > 0) {
                    byte[] bytes = multiPartFile.getBytes();
                    String encoded = Base64.getEncoder().encodeToString(bytes);

                    base64EncodedImageData = base64EncodedImageData + encoded;

                    claim.setImageData(base64EncodedImageData);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        log.info("{}", claim);
        claimRepo.save(claim);//all the data regarding the claim gone to database
    }


    @Override
    public Claim getDetail(String claimNumber) {
        Optional<Claim> result = claimRepo.findById(claimNumber);//we will get all the details based on the claimNumber
        //because claimNumber is our primary key

        // Handle file download to show
        if (result.isPresent()) {
            Claim claimResult = result.get();

            return claimResult;
        }

        return null;
    }

}
