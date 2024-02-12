package com.fusion.Digital.Customer.Onboarding.ServiceImpl;

import com.fusion.Digital.Customer.Onboarding.DTO.OneTimePasswordHelpService;
import com.fusion.Digital.Customer.Onboarding.Entity.OtpDetailsEntity;
import com.fusion.Digital.Customer.Onboarding.Repository.OtpDetailsRepository;
import com.fusion.Digital.Customer.Onboarding.Service.OtpDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtpDetailsServiceImpl implements OtpDetailsService {

    @Autowired
    private OtpDetailsRepository otpDetailsRepository;
    @Override
    public void saveOtp(OtpDetailsEntity otpDetails) {

        otpDetailsRepository.save(otpDetails);
    }

    @Override
    public String generateOTP() {
        // Generate a random 6-digit OTP
        Random random = new Random();
        int otpNumber = 100000 + random.nextInt(900000);
        return String.valueOf(otpNumber);
    }

    @Override
    public OtpDetailsEntity returnOneTimePassword() {
        OtpDetailsEntity otpDetailsEntity = new OtpDetailsEntity();

        otpDetailsEntity.setOtp(OneTimePasswordHelpService.createRandomOneTimePassword().get());
        otpDetailsRepository.save(otpDetailsEntity);
        return otpDetailsEntity;
    }


}
