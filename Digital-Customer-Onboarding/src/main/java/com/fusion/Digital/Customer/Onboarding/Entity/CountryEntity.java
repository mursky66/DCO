package com.fusion.Digital.Customer.Onboarding.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tbl_country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "countryname")
    private String countryName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "countyEntity")
    private List<StateEntity> stateEntities;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "county")
    private List<AddressEntity> addressEntities;

}
