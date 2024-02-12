package com.fusion.Digital.Customer.Onboarding.Service;

import com.fusion.Digital.Customer.Onboarding.Entity.OtpDetailsEntity;
import org.springframework.stereotype.Service;

@Service
public interface OtpDetailsService {

    public void saveOtp(OtpDetailsEntity otpDetails);

    public String generateOTP();

    public OtpDetailsEntity returnOneTimePassword();



}
