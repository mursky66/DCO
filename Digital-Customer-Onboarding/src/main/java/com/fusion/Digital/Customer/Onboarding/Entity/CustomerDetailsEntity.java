package com.fusion.Digital.Customer.Onboarding.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_customerdetails")
public class CustomerDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length=100, nullable = false)
    private String name;
    @Column(name = "middlename",length = 100,nullable = false)
    private String middleName;
    @Column(name = "surname",length = 100,nullable = false)
    private String surName;
    @Column(name = "dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
    private Date dob;
    @Column(name = "mobilenumber",length = 10,nullable = false,unique = true)
    private String mobileNumber;
    @Column(name = "emailid",length = 50,nullable = false,unique = true)
    private String emailId;
    @Column(name = "pancardno",length = 10,nullable = false,unique = true)
    private String panCardNo;
    @Column(name = "status")
    private boolean status;
    @Column(name = "adharcarddocs")
    private String adharCardDocs;
    @Column(name = "pancarddocs")
    private String panCardDocs;
    @Column(name = "addressverificationdocs")
    private String addressVerificationDocs;
    @Column(name = "signature")
    private String signature;
    @Column(name = "ismobileotpvalidated")
    private boolean isMobileOtpValidated;
    @Column(name = "isemailotpv alidated")
    private boolean isEmailOtpValidated;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customerDetailsEntity")
    private List<OtpDetailsEntity> otpDetailsEntities;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customerDetails")
    private List<AddressEntity> addressEntities;


    /*

    Customer Registration POJO for Postman

    {
    "name": "Maulin",
    "middleName": "Jayeshbhai",
    "surName": "Acharya",
    "dob": "08-11-1993",
    "mobileNumber": "9558018266",
    "emailId": "maulilni66@gmail.com",
    "panCardNo": "DBBPS9809C",
    "status": 1,
    "adharCardDocs": "XYZ",
    "panCardDocs": "XYZ",
    "addressVerificationDocs": "yes",
    "signature": "yes",
    "isMobileOtpValidated": 0,
    "isEmailOtpValidated": 0
}


     */
}
