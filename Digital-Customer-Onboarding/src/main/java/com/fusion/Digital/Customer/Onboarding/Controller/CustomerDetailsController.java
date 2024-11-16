package com.fusion.Digital.Customer.Onboarding.Controller;

import com.fusion.Digital.Customer.Onboarding.DTO.ApiResponce;
import com.fusion.Digital.Customer.Onboarding.Entity.CustomerDetailsEntity;
import com.fusion.Digital.Customer.Onboarding.Service.CustomerDetailsService;
import com.fusion.Digital.Customer.Onboarding.Service.OtpDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/customerdetails")
public class CustomerDetailsController {
    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private OtpDetailsService otpDetailsService;

    @PostMapping("customer-registration-one")
    public ResponseEntity<CustomerDetailsEntity> save(@RequestBody CustomerDetailsEntity customerDetails) {

        log.info("Calling Save Method For Customer Registration This is my approach to achieve functionality");
        String s = customerDetailsService.saveCustomerDetails(customerDetails);


        return new ResponseEntity(s, HttpStatus.OK);
    }

    @PostMapping("customer-registration-two")
    public ResponseEntity<CustomerDetailsEntity> saveUser(@RequestBody CustomerDetailsEntity customerDetails) {

        log.info("Calling Save Method For Customer Registration Using boolean return type This is Shubham Sir approach with is better then my approach ");
        // first actione
        boolean isUserAvailable = customerDetailsService.checkUser(customerDetails);


        // second action
        if (isUserAvailable) {
            return new ResponseEntity(isUserAvailable, HttpStatus.BAD_REQUEST);  // use ? type Responce and remove Constructor and simple msg print possible (.Body() tag.

        } else {
            customerDetailsService.saveCust(customerDetails);
            //Create OTP Save this otp in OTPDetaisl page with custId
        }
        return new ResponseEntity(isUserAvailable, HttpStatus.OK);
    }

    @PutMapping("customer/update")
    public ResponseEntity<ApiResponce<CustomerDetailsEntity>> updateCustmer(@RequestBody CustomerDetailsEntity customerDetails) {
        log.info("Registration Customer updated controller!!");

        customerDetailsService.updateCust(customerDetails);

        ApiResponce<Object> responce = ApiResponce.success("Update done Successfully !");
        return new ResponseEntity(responce, HttpStatus.OK);
    }

 /*
  Chat GPT Code create by me for DCO Document
   */

    @PostMapping("/customer-registration")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDetailsEntity customerDetailsEntity) {

        log.info("This is ChatGPT Approach to achieve customer registration which is ever green best ");
        if (customerDetailsService.isCustomerExists(customerDetailsEntity)) {
            return ResponseEntity.status(409).body("Customer already exists Sorry Boss");
        }

        customerDetailsService.saveCustomer(customerDetailsEntity);

        int generateOtpForCust = customerDetailsService.generateOtpForCust();

        customerDetailsService.saveOTP(customerDetailsEntity.getMobileNumber(), generateOtpForCust);

        customerDetailsService.sendOtpToMobile(customerDetailsEntity.getMobileNumber(), generateOtpForCust);

        return ResponseEntity.ok("Customer Register Successfully !");
    }
}
