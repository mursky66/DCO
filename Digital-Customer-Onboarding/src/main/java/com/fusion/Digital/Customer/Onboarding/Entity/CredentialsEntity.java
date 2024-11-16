package com.fusion.Digital.Customer.Onboarding.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_credentials")
public class CredentialsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    @Transient
    private String confirmPassword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cust_id")
    private CustomerDetailsEntity custDetails;
}
