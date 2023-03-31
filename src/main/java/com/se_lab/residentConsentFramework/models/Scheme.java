package com.se_lab.residentConsentFramework.models;

import com.se_lab.residentConsentFramework.controllers.SchemeController;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Scheme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "scheme_name")
    private String schemeName;
    @Column(name = "scheme_code")
    private String schemeCode;
    @Column(name = "ministry_id")
    private Integer ministryId;
    @Column(name = "aadhaar_card_required")
    private Boolean aadhaarCardRequired;
    @Column(name = "pan_card_required")
    private Boolean panCardRequired;

    public Scheme(SchemeController.SchemeData schemeData){
        this.schemeName = schemeData.getSchemeName();
        this.schemeCode = schemeData.getSchemeCode();
        this.ministryId = schemeData.getMinistryId();
        this.aadhaarCardRequired = schemeData.getAadhaarCardRequired();
        this.panCardRequired = schemeData.getPanCardRequired();
    }


    public Scheme() {

    }
}
