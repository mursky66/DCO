package com.fusion.Digital.Customer.Onboarding.ServiceImpl;

import com.fusion.Digital.Customer.Onboarding.Entity.StateEntity;
import com.fusion.Digital.Customer.Onboarding.Repository.StateRepository;
import com.fusion.Digital.Customer.Onboarding.Service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StateServiceImpl implements StateService {
    @Autowired
    private StateRepository stateRepository;
    @Override
    public void saveState(StateEntity state) {
        stateRepository.save(state);
    }

    @Override
    public List<StateEntity> getStateDetails() {
        return stateRepository.findAll();
    }

    @Override
    public void deleteState(long id) {

        stateRepository.deleteById(id);
    }

    @Override
    public void updateState(StateEntity stateEntity) {

        stateRepository.save(stateEntity);
    }
}
