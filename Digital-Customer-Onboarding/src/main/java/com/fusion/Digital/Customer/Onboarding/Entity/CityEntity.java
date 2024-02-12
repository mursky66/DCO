package com.fusion.Digital.Customer.Onboarding.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tbl_city")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cityname",length = 100,nullable = false)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "stateId")
    private StateEntity stateEntity;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "city")
    private List<AddressEntity> addressEntity;

}
