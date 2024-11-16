package com.fusion.Digital.Customer.Onboarding.Controller;

import com.fusion.Digital.Customer.Onboarding.DTO.ApiResponce;
import com.fusion.Digital.Customer.Onboarding.Entity.CountryEntity;
import com.fusion.Digital.Customer.Onboarding.Service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/save-country")
    public ResponseEntity<ApiResponce<CountryEntity>> saveCountry(@RequestBody CountryEntity countryEntity){
        log.info("Inside Save Country {} : ",countryEntity);

        countryService.saveDetails(countryEntity);

        ApiResponce<CountryEntity> response = ApiResponce.success("Country Saved Successfully !!! ");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/country-details")
    public ResponseEntity<List<CountryEntity>> getCountryDetails(){
        log.info("Calling get Country Details");
        List<CountryEntity> countryDetails = countryService.getCountryDetails();
        return new ResponseEntity<>(countryDetails, HttpStatus.OK);
    }

    @GetMapping("country-by-id/{id}")
    public ResponseEntity<CountryEntity> getCountryById(@PathVariable long id){
            log.info("Calling get Country by id {} : ",id);
        CountryEntity entityByID = countryService.getCountryEntityByID(id);
        return new ResponseEntity<CountryEntity>(entityByID,HttpStatus.OK);

    }

    @PutMapping("update-country")
    public ResponseEntity<ApiResponce<CountryEntity>> updateCountry(@RequestBody CountryEntity countryEntity){
        log.info("Calling update Country {} : ",countryEntity);
            countryService.updateCountry(countryEntity);
        ApiResponce<CountryEntity> response = ApiResponce.success("Country Update Successfully ");
        return new ResponseEntity<ApiResponce<CountryEntity>>(response,HttpStatus.OK);
    }

    @DeleteMapping("delete-country")
    public ResponseEntity<ApiResponce<CountryEntity>> deleteCountry(@RequestParam long id){
        log.info("Calling deletet country by id {} : ",id);
        countryService.deleteCountry(id);
        ApiResponce<CountryEntity> responce = ApiResponce.success("Country deletet successfully !!!");
        return  new ResponseEntity<ApiResponce<CountryEntity>>(responce,HttpStatus.OK);
    }

    @PutMapping("update-country-by-id/{countryName}/{id}")
    public ResponseEntity<ApiResponce<CountryEntity>> updateCountryByNative(@PathVariable String countryName,@PathVariable long id){
        log.info("Calling Native Query for Country update  countryName:{} , id:{}: ",countryName,id);
        countryService.UpdateCountryNative(countryName,id);
        ApiResponce<CountryEntity> responce = ApiResponce.success("Country update successfully !!! ");
       return new ResponseEntity<ApiResponce<CountryEntity>>(responce,HttpStatus.OK);
    }

}
