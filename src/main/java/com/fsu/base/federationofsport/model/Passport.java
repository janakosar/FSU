package com.fsu.base.federationofsport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    private double weight;
    private double height;

    @JsonIgnore
    @ManyToMany(mappedBy = "passports")
    private Set<Command> teams = new HashSet<>();
}
