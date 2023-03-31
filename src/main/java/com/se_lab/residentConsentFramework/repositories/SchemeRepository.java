package com.se_lab.residentConsentFramework.repositories;

import com.se_lab.residentConsentFramework.models.Scheme;
import org.springframework.data.repository.CrudRepository;

public interface SchemeRepository extends CrudRepository<Scheme,Integer> {
    public Scheme findSchemeById(Integer schemeId);
}
