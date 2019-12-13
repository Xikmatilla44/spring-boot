package com.grokonez.jwtauthentication.kafedra.model;

import com.grokonez.jwtauthentication.dekanat.model.Dekanat;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Kafedra")
public class Kafedra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "holati")
    private Boolean holati;

    @ManyToOne
    private Dekanat dekanat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHolati() {
        return holati;
    }

    public void setHolati(Boolean holati) {
        this.holati = holati;
    }

    public Dekanat getDekanat() {
        return dekanat;
    }

    public void setDekanat(Dekanat dekanat) {
        this.dekanat = dekanat;
    }
}
