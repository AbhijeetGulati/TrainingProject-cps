package com.abhijeetgulati.cps.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "claim_details")
@ToString
public class Claim {
    //here we will define the reqd fields
    //using lombok getter setters and all other important methods have been automatically created

    @GeneratedValue(strategy = GenerationType.UUID, generator = "CUST_SEQ")
    @Id
    private String claimNumber;

    private String causeOfLoss;

    @NotBlank(message = "This is a required field")
    private String driverName;
    @NotBlank(message = "This is a required field")
    private String dlNumber;//primary key and String type because it is alphanumeric
    @NotBlank(message = "This is a required field")
    private String dlClass;
    @NotBlank(message = "This is a required field")

    private String dlType;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;

    private String location;

    @Column(columnDefinition = "LONGTEXT")
    @Basic(fetch = FetchType.LAZY)
    @ToString.Exclude
    private String imageData;

    @Transient
    MultipartFile imageFile;


//no need to create constructors and getter setters and toString methods because of lombok dependency

}
