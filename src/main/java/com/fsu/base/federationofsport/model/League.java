package com.fsu.base.federationofsport.model;

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
public class League {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private TeamType type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "league")
    private List<Team> teams = new ArrayList<>();
}
