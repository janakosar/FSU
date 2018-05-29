package com.fsu.base.federationofsport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by yana on 12.04.18.
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue
    private long id;

    private String href;

    @Column(length = 3000)
    private String description;

    @Enumerated(EnumType.STRING)
    private VideoCategory category;
}
