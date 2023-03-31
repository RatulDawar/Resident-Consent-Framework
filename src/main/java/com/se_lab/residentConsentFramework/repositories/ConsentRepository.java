package com.se_lab.residentConsentFramework.repositories;

import com.se_lab.residentConsentFramework.models.Consent;
import org.springframework.data.repository.CrudRepository;

public interface ConsentRepository extends CrudRepository<Consent,Integer> {
    public Consent findConsentBySchemeIdAndResidentId(Integer schemeId,Integer residentId);
}
