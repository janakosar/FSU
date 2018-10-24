package com.fsu.base.federationofsport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Command {

    @Id
    @GeneratedValue
    private long id;

    private String name;

//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "Employee_Project",
//            joinColumns = { @JoinColumn(name = "employee_id") },
//            inverseJoinColumns = { @JoinColumn(name = "project_id") }
//    )
//
    @ManyToMany
    @JoinTable(
            name = "Command_Player",
            joinColumns = {@JoinColumn(name = "command_id")},
            inverseJoinColumns = {@JoinColumn(name = "player_id")}
    )
    private List<Player> players = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    private League league;
}
