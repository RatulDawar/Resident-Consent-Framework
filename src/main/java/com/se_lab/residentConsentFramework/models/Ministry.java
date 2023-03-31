package com.se_lab.residentConsentFramework.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ministry {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name = "ministry_name")
    private String ministryName;
    @Column(name = "ministry_code")
    private String ministryCode;
    @Column(name = "password")
    private String password;

    public Ministry(String ministryName,String ministryCode,String password){
        this.ministryName = ministryName;
        this.ministryCode = ministryCode;
        this.password = password;
    }


    public Ministry() {

    }
}
