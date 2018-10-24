package com.fsu.base.federationofsport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

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
    private String fatherName;
    private String position;
    private String number;
    private String city;
    private String commandName;

    @ManyToMany(mappedBy = "players")
    private Set<Command> commands;
}
