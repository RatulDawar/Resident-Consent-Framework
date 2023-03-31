package com.se_lab.residentConsentFramework.repositories;

import com.se_lab.residentConsentFramework.models.Ministry;
import org.springframework.data.repository.CrudRepository;

public interface MinistryRepository extends CrudRepository<Ministry,Integer> {
    public  Ministry findMinistryByMinistryCode(String ministryCode);
}
