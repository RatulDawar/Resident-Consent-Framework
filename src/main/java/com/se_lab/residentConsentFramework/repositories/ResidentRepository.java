package com.se_lab.residentConsentFramework.repositories;

import com.se_lab.residentConsentFramework.models.Resident;
import org.springframework.data.repository.CrudRepository;

public interface ResidentRepository extends CrudRepository<Resident,Integer> {
    public Resident findResidentByEmail(String email);
    public Resident findResidentById(Integer residentId);
}
