package com.abhijeetgulati.cps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhijeetgulati.cps.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, String> {
    //this will provide us basic crud functionalities

}
