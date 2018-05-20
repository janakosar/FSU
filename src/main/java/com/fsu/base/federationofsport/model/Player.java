package com.fsu.base.federationofsport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue
    private long id;
    private int age;
    private String image;
    private String firstName;
    private String lastName;
    private String position;
    private String number;

    @JsonIgnore
    @ManyToOne
    private Command command;

}
