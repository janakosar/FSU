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

    @OneToMany(mappedBy = "command")
    private List<Passport> passports = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    private League league;
}
