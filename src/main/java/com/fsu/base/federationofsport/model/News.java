package com.fsu.base.federationofsport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yana on 12.04.18.
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class News {

    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private NewsCategory category;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;



}
