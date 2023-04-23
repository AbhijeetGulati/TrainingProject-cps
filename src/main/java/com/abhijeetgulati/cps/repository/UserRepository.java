package com.abhijeetgulati.cps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhijeetgulati.cps.entity.Claim;

@Repository
public interface UserRepository extends JpaRepository<Claim, String> {
    //now we can utilise crud functionalities

}
