package com.fusion.Digital.Customer.Onboarding.Controller;

import com.fusion.Digital.Customer.Onboarding.Entity.CountryEntity;
import com.fusion.Digital.Customer.Onboarding.Service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;




}
