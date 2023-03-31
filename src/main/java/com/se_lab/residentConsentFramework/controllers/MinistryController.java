package com.se_lab.residentConsentFramework.controllers;

import com.se_lab.residentConsentFramework.enums.ResponseCodes;
import com.se_lab.residentConsentFramework.exception.RSCMException;
import com.se_lab.residentConsentFramework.models.Ministry;
import com.se_lab.residentConsentFramework.repositories.MinistryRepository;
import com.se_lab.residentConsentFramework.utils.CoreResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ministry")
public class MinistryController {

    @Autowired
    private MinistryRepository ministryRepository;
    @PostMapping(path = "/signup")
    public @ResponseBody ResponseEntity<CoreResponse<Object>> signUp(@RequestBody SignUpForm signUpForm){
        if(ministryRepository.findMinistryByMinistryCode(signUpForm.getMinistryCode()) != null) throw new RSCMException(ResponseCodes.MINISTRY_ALREADY_REGISTERED);
        Ministry newMinistry = new Ministry(signUpForm.getMinistryName(),signUpForm.getMinistryCode(),signUpForm.getPassword());
        ministryRepository.save(newMinistry);
        return CoreResponse.buildSuccessResponse();
    }

    @GetMapping(path = "/login")
    public @ResponseBody ResponseEntity<CoreResponse<Object>> login(@RequestParam String ministryCode, String password){
        Ministry ministry = ministryRepository.findMinistryByMinistryCode(ministryCode);
        if(ministry == null)throw new RSCMException(ResponseCodes.MINISTRY_NOT_REGISTERED);
        if(!ministry.getPassword().equals(password))throw new RSCMException(ResponseCodes.INVALID_LOGIN_CREDENTIALS);
        return CoreResponse.buildSuccessResponseWithData(ministry);

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class SignUpForm{
        private String ministryName;
        private String ministryCode;
        private String password;

    }
}
