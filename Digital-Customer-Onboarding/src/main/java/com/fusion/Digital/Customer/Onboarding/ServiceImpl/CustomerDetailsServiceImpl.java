package com.fusion.Digital.Customer.Onboarding.ServiceImpl;

import com.fusion.Digital.Customer.Onboarding.DTO.CustomerDetailsDTO;
import com.fusion.Digital.Customer.Onboarding.Entity.CustomerDetailsEntity;
import com.fusion.Digital.Customer.Onboarding.Entity.OtpDetailsEntity;
import com.fusion.Digital.Customer.Onboarding.Repository.CustomerDetailsRepository;
import com.fusion.Digital.Customer.Onboarding.Repository.OtpDetailsRepository;
import com.fusion.Digital.Customer.Onboarding.Service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

@Component
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    private OtpDetailsRepository otpDetailsRepository;


    @Override
    public String saveCustomerDetails(CustomerDetailsEntity customerDetails) {
        if (customerDetailsRepository.findByMobileNumber(customerDetails.getMobileNumber()) != null){
            return "User Already Registred";
        }else if (customerDetailsRepository.findByEmailId(customerDetails.getEmailId()) != null){
            return "User Already Registred";
        } else if (customerDetailsRepository.findBypanCardNo(customerDetails.getPanCardNo()) != null) {
            return "User Already Registred";
        }else {
            customerDetailsRepository.save(customerDetails);
            return "User registered successfully";
        }

    }

    @Override
    public boolean checkUser(CustomerDetailsEntity customerDetails) {
        boolean isUserExist = false;
        if (customerDetailsRepository.findByMobileNumber(customerDetails.getMobileNumber()) != null){
            isUserExist = true;
        }else if (customerDetailsRepository.findByEmailId(customerDetails.getEmailId()) != null){
            isUserExist = true;
        } else if (customerDetailsRepository.findBypanCardNo(customerDetails.getPanCardNo()) != null) {
            isUserExist = true;
        }
        return isUserExist;
    }

    @Override
    public void saveCust(CustomerDetailsEntity customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }

    @Override
    public void updateCust(CustomerDetailsEntity customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }

    @Override
    public boolean isCustomerExists(CustomerDetailsEntity customerDetails) {

        Optional<CustomerDetailsEntity> customer = customerDetailsRepository.findByMobileNumberOrEmailIdOrAndPanCardNo(
                customerDetails.getMobileNumber(),
                customerDetails.getEmailId(),
                customerDetails.getPanCardNo());
        return customer.isPresent();
    }

    @Override
    public CustomerDetailsEntity saveCustomer(CustomerDetailsEntity customerDetails) {

        CustomerDetailsEntity customer = new CustomerDetailsEntity();
        customer.setName(customerDetails.getName());
        customer.setMiddleName(customerDetails.getMiddleName());
        customer.setSurName(customerDetails.getSurName());
        customer.setDob(customerDetails.getDob());
        customer.setMobileNumber(customerDetails.getMobileNumber());
        customer.setEmailId(customerDetails.getEmailId());
        customer.setPanCardNo(customerDetails.getPanCardNo());
        customer.setStatus(customerDetails.isStatus());
        customer.setAdharCardDocs(customerDetails.getAdharCardDocs());
        customer.setPanCardDocs(customerDetails.getPanCardDocs());
        customer.setAddressVerificationDocs(customerDetails.getAddressVerificationDocs());
        customer.setSignature(customerDetails.getSignature());
        customer.setMobileOtpValidated(customerDetails.isMobileOtpValidated());
        customer.setEmailOtpValidated(customerDetails.isEmailOtpValidated());


        return customerDetailsRepository.save(customer) ;
    }

    @Override
    public int generateOtpForCust() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return otp;
    }

    @Override
    public OtpDetailsEntity saveOTP(String mobileNumber, long otp) {
        OtpDetailsEntity otpDetails = new OtpDetailsEntity();
        otpDetails.setMobileNumber(mobileNumber);
        otpDetails.setOtp(otp);
        return otpDetailsRepository.save(otpDetails) ;
    }

    @Override
    public void sendOtpToMobile(String mobilenumber, long otp) {
        // Logic to send OTP to the given mobile number


    }


}


