package com.fsu.base.federationofsport.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yana on 12.04.18.
 */
@Entity
public class News {

    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private NewsCategory newsCategory;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}
