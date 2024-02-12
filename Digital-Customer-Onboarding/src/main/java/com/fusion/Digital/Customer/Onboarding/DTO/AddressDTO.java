package com.fusion.Digital.Customer.Onboarding.DTO;

import lombok.Data;

@Data
public class AddressDTO {
    private long id;
    private String currentAddress;
    private String permanaentAddress;
    private long pincode;
}
