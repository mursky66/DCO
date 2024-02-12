package com.fusion.Digital.Customer.Onboarding.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_otpdetails")
public class OtpDetailsEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private long id;

    @Column(name="otp")
    private long otp;

    @Column(name="status")
    private boolean status;


    @ManyToOne
    @JoinColumn(name = "custDetails")
    private CustomerDetailsEntity customerDetailsEntity;
}
