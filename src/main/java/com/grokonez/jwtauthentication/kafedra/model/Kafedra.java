package com.grokonez.jwtauthentication.kafedra.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class KafedraEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean holati
}
