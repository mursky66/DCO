package com.fusion.Digital.Customer.Onboarding.Controller;

import com.fusion.Digital.Customer.Onboarding.DTO.ApiResponce;
import com.fusion.Digital.Customer.Onboarding.Entity.StateEntity;
import com.fusion.Digital.Customer.Onboarding.Service.StateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;
    @PostMapping("/save")
    public ResponseEntity<ApiResponce<StateEntity>> save(@RequestBody StateEntity state){
        log.info("inside state {} : ",state);
        stateService.saveState(state);
        ApiResponce<StateEntity> responce = ApiResponce.success("State saved successfully !!! ");
        return ResponseEntity.ok(responce);
    }

    @GetMapping("/all-state")
    public ResponseEntity<List<StateEntity>> getAllState(){
        log.info("Calling get all state details");
        List<StateEntity> stateDetails = stateService.getStateDetails();
        return new ResponseEntity<>(stateDetails, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ApiResponce<StateEntity>> update(@RequestBody StateEntity state){

        log.info("Calling update state {} :",state);
        stateService.updateState(state);
        ApiResponce<StateEntity> responce = ApiResponce.success("State update successfully !!!");
        return new ResponseEntity<>(responce,HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponce<StateEntity>> delete(@RequestParam long id){
        log.info("calling delete state by {} ",id);
        stateService.deleteState(id);
        ApiResponce<StateEntity> responce = ApiResponce.success("Deleted state successfully !!! ");
        return new ResponseEntity<>(responce,HttpStatus.OK);

    }
 }
