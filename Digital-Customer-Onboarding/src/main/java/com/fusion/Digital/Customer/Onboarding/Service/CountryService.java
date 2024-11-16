package com.fusion.Digital.Customer.Onboarding.Service;

import com.fusion.Digital.Customer.Onboarding.Entity.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    public void saveDetails(CountryEntity countryEntity);

    public List<CountryEntity> getCountryDetails();

    public CountryEntity getCountryEntityByID(long id);

    public void updateCountry(CountryEntity countryEntity);

    public void  deleteCountry(long id);

    public void UpdateCountryNative(String countryName,long id);

}
