package com.fusion.Digital.Customer.Onboarding.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="address")
    private String address;

    @Column(name = "addresstype")
    private String addresstype;

    @Column(name = "pincode")
    private long pincode;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private CountyEntity county;

    @ManyToOne
    @JoinColumn(name = "stateId")
    private StateEntity state;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private CityEntity city;

    @ManyToOne
    @JoinColumn(name = "custId")
    private CustomerDetailsEntity customerDetails;


}
