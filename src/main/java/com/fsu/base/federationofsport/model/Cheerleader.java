package com.fsu.base.federationofsport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by yana on 12.04.18.
 */

@Entity
@Getter @Setter @NoArgsConstructor
public class Cheerleader {

    @Id
    @GeneratedValue
    private long id;

    private String image;
}
