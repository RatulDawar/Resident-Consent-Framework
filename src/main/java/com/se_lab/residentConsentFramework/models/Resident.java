package com.se_lab.residentConsentFramework.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Resident {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    @Column(name = "aadhar_number")
    private String aadhaarNumber;

    @Column(name = "pan_number")
    private String panNumber;

    @Column(name = "password")
    private String password;

    public Resident(String name,String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Resident() {

    }
}
