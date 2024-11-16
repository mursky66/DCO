package com.fusion.Digital.Customer.Onboarding.ServiceImpl;

import com.fusion.Digital.Customer.Onboarding.Entity.CountryEntity;
import com.fusion.Digital.Customer.Onboarding.Repository.CountryRepository;
import com.fusion.Digital.Customer.Onboarding.Service.CountryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;
    @Override
    public void saveDetails(CountryEntity countryEntity) {

        countryRepository.save(countryEntity);
    }

    @Override
    public List<CountryEntity> getCountryDetails() {
        return countryRepository.findAll();
    }

    @Override
    public CountryEntity getCountryEntityByID(long id) {
        Optional<CountryEntity> byId = countryRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }else {
            return null;
        }
    }

    @Override
    public void updateCountry(CountryEntity countryEntity) {
        countryRepository.save(countryEntity);
    }

    @Override
    public void deleteCountry(long id) {
        countryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void UpdateCountryNative(String countryName, long id) {

        countryRepository.updateCountryData(countryName,id);
    }
}
