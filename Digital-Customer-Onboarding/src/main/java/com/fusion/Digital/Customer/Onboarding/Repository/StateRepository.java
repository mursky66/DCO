package com.fusion.Digital.Customer.Onboarding.Repository;

import com.fusion.Digital.Customer.Onboarding.Entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<StateEntity,Long> {


}
