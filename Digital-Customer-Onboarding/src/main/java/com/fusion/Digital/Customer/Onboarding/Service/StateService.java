package com.fusion.Digital.Customer.Onboarding.Service;

import com.fusion.Digital.Customer.Onboarding.Entity.StateEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StateService {
    public void saveState(StateEntity state);

    public List<StateEntity> getStateDetails();

    public void deleteState(long id);

    public void updateState(StateEntity stateEntity);
}
