package com.fusion.Digital.Customer.Onboarding.Service;

import com.fusion.Digital.Customer.Onboarding.Entity.CustomerDetailsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerDetailsService {

    public String saveCustomerDetails(CustomerDetailsEntity customerDetails);

    public boolean checkUser(CustomerDetailsEntity customerDetails);

    public void saveCust(CustomerDetailsEntity customerDetails);

    public void updateCust(CustomerDetailsEntity customerDetails);







}
