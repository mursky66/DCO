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

    @Column(name="mobileotp")
    private int mobileOtp;

    @Column(name="mobileotp_status")
    private boolean mobileOtpStatus;

    @Column(name="emailotp")
    private int emailOtp;

    @Column(name="emailotp_status")
    private boolean emailOtpStatus;

    //New Add Entity
    @Column(name = "mobilenumber")
    private  String mobileNumber;

    @ManyToOne
    @JoinColumn(name = "custDetails")
    private CustomerDetailsEntity customerDetailsEntity;
}
