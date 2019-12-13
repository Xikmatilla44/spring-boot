package com.grokonez.jwtauthentication.kafedra.convert.dto;

public class KafedraDTO {

    private Long id;

    private String name;

    private Boolean holati;

    private Long dekanatId;

    private String dekanatName;

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

    public Long getDekanatId() {
        return dekanatId;
    }

    public void setDekanatId(Long dekanatId) {
        this.dekanatId = dekanatId;
    }

    public String getDekanatName() {
        return dekanatName;
    }

    public void setDekanatName(String dekanatName) {
        this.dekanatName = dekanatName;
    }
}
