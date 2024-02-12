package com.fusion.Digital.Customer.Onboarding.Controller;

import com.fusion.Digital.Customer.Onboarding.DTO.ApiResponce;
import com.fusion.Digital.Customer.Onboarding.Entity.OtpDetailsEntity;
import com.fusion.Digital.Customer.Onboarding.Service.OtpDetailsService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Data
@RequestMapping("/otpdetails")
public class OtpDetailsController {

    @Autowired
    public OtpDetailsController(OtpDetailsService otpDetailsService) {
        this.otpDetailsService = otpDetailsService;
    }

    @Autowired
    private OtpDetailsService otpDetailsService;

    @PostMapping("/save-otp")
    //Request Through @RequestBody
    public ResponseEntity<ApiResponce<OtpDetailsEntity>> saveOTP(
            @RequestBody OtpDetailsEntity otpDetails) { // As per document Post APi create

        String generateOTP = otpDetailsService.generateOTP();

        otpDetailsService.saveOtp(otpDetails);
        // service call to save data
        ApiResponce<OtpDetailsEntity> response = ApiResponce.success("OTP Saved Successfully");
        return ResponseEntity.ok(response);

    }


    @GetMapping("create-otp")
    public ResponseEntity<OtpDetailsEntity> createOTP(){
        try {
            return ResponseEntity.ok(otpDetailsService.returnOneTimePassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
