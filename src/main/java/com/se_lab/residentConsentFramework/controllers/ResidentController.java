package com.se_lab.residentConsentFramework.controllers;

import com.se_lab.residentConsentFramework.enums.ResponseCodes;
import com.se_lab.residentConsentFramework.exception.RSCMException;
import com.se_lab.residentConsentFramework.models.Resident;
import com.se_lab.residentConsentFramework.repositories.ResidentRepository;
import com.se_lab.residentConsentFramework.utils.CoreResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/resident")

public class ResidentController {
    @Autowired
    private ResidentRepository residentRepository;

    @PostMapping(path = "/signup")
    public @ResponseBody ResponseEntity<CoreResponse<Object>> signUp(@RequestBody SignUpForm signUpForm){
        if(residentRepository.findResidentByEmail(signUpForm.getEmail()) != null) throw new RSCMException(ResponseCodes.EMAIL_ID_ALREADY_REGISTERED);
        Resident newResident = new Resident(signUpForm.getName(),signUpForm.getEmail(),signUpForm.getPassword());
        residentRepository.save(newResident);
        return CoreResponse.buildSuccessResponse();
    }
    @GetMapping(path = "/login")
    public @ResponseBody ResponseEntity<CoreResponse<Object>> login(@RequestParam String email, @RequestParam String password){

        Resident resident = residentRepository.findResidentByEmail(email);
        if(resident == null) throw new RSCMException(ResponseCodes.USER_NOT_FOUND);
        if(!resident.getPassword().equals(password))throw new RSCMException(ResponseCodes.INVALID_LOGIN_CREDENTIALS);
        return CoreResponse.buildSuccessResponseWithData(resident);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class SignUpForm{
        private String name;
        private String email;
        private String password;
    }
}
