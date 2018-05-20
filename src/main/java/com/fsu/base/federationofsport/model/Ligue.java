package com.fsu.base.federationofsport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ligue {

    @Id
    @Getter
    private long id;

    private String name;

    @OneToMany(mappedBy = "ligue")
    private List<Command> commands;
}
