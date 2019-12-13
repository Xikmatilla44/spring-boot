package com.grokonez.jwtauthentication.model;

public enum ActivePassiv {

    ACTIVE ("Active"),
    PASSIV ("Passiv");

    private final String name;

    ActivePassiv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
