package com.se_lab.residentConsentFramework.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Consent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "resident_id")
    private Integer residentId;
    @Column(name = "scheme_id")
    private Integer schemeId;

    @Column(name = "consent_value")
    private Boolean consentValue;

    public Consent(Integer residentId,Integer schemeId,Boolean consentValue){
        this.residentId = residentId;
        this.schemeId = schemeId;
        this.consentValue = consentValue;
    }

    public Consent() {

    }
}
