package com.fsu.base.federationofsport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by yana on 12.04.18.
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue
    private long id;

    private String image;
    private String firstName;
    private String lastName;

    @Column(length = 3000)
    private String description;

}
