package com.grokonez.jwtauthentication.dekanat.service;

import com.grokonez.jwtauthentication.dekanat.model.Dekanat;

import java.util.List;
import java.util.Optional;

public interface DekanatService {

    Iterable<Dekanat> ListAllDekanat();


    boolean deleteDekanat(Long id);

    Dekanat saveDekanat(Dekanat dekanat);

    Dekanat getByIdDekanat(Long id);

    List<Dekanat> getByName(String name);





}
