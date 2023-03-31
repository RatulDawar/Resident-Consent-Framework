package com.se_lab.residentConsentFramework.controllers;

import com.se_lab.residentConsentFramework.models.Scheme;
import com.se_lab.residentConsentFramework.repositories.SchemeRepository;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/scheme")
public class SchemeController {

    @Autowired
    private SchemeRepository schemeRepository;
    @PostMapping("/upload-scheme")
    @ResponseBody String uploadScheme(@RequestBody SchemeData schemeData){
        Scheme newScheme = new Scheme(schemeData);
        schemeRepository.save(newScheme);
        return "New scheme created Successfully";
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class SchemeData{
        private String schemeName;
        private String schemeCode;
        private Integer ministryId;
        private Boolean aadhaarCardRequired;
        private Boolean panCardRequired;

    }
}
