package com.fsu.base.federationofsport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue
    private long id;
    private int age;
    private String image;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String city;
    private String command;

    private double weight;
    private double height;

}
