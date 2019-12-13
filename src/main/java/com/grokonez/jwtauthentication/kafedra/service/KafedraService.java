package com.grokonez.jwtauthentication.kafedra.service;

import com.grokonez.jwtauthentication.kafedra.model.Kafedra;

import java.util.List;

public interface KafedraService {


    Iterable<Kafedra> listKafedra();

    Kafedra saveKafedra(Kafedra kafedra);

    boolean deleteKafedra(Long id);

    Kafedra getById(Long id);

    List<Kafedra> getByName(String name);

}
