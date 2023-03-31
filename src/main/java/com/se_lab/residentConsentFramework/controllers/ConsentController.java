package com.se_lab.residentConsentFramework.controllers;


import com.se_lab.residentConsentFramework.models.Consent;
import com.se_lab.residentConsentFramework.models.Resident;
import com.se_lab.residentConsentFramework.models.Scheme;
import com.se_lab.residentConsentFramework.repositories.ConsentRepository;
import com.se_lab.residentConsentFramework.repositories.ResidentRepository;
import com.se_lab.residentConsentFramework.repositories.SchemeRepository;
import com.se_lab.residentConsentFramework.utils.CoreResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consent")
public class ConsentController {
    @Autowired
    private ConsentRepository consentRepository;
    @Autowired
    private SchemeRepository schemeRepository;
    @Autowired
    private ResidentRepository residentRepository;

    @PostMapping(path = "/give-consent")
    public @ResponseBody ResponseEntity<CoreResponse<Object>> giveConsent(@RequestBody ConsentData consentData){
        Consent oldConsent = consentRepository.findConsentBySchemeIdAndResidentId(consentData.getSchemeId(), consentData.getResidentId());
        if(oldConsent != null){
            oldConsent.setConsentValue(consentData.getConsentValue());
            consentRepository.save(oldConsent);
        }else {
            Consent newConsent = new Consent(consentData.getResidentId(), consentData.getSchemeId(), consentData.getConsentValue());
            consentRepository.save(newConsent);
        }
        return CoreResponse.buildSuccessResponse();
    }

//    @GetMapping(path = "/verify-eligibility")
//    public @ResponseBody Boolean verifyEligibility(@RequestParam Integer schemeId,@RequestParam Integer residentId){
//        Scheme scheme = schemeRepository.findSchemeById(schemeId);
//        Resident resident = residentRepository.findResidentById(residentId);
//
//    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ConsentData{
        private Integer residentId;
        private Integer schemeId;
        private Boolean consentValue;
    }
}
