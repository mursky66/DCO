package com.fusion.Digital.Customer.Onboarding.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;

@Entity
@Data
@Table(name = "tbl_state")
public class StateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "statename",length = 100,nullable = false)
    private String stateName;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private CountyEntity countyEntity;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "stateEntity")
    private List<CityEntity> cityEntities;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "state")
    private List<AddressEntity> addressEntities;
}
