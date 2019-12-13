package com.grokonez.jwtauthentication.kafedra.service;

import com.grokonez.jwtauthentication.kafedra.model.Kafedra;
import com.grokonez.jwtauthentication.kafedra.repository.KafedraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafedraServiceImpl implements KafedraService {

    private KafedraRepository kafedraRepository;

    @Autowired
    public void setKafedraRepository(KafedraRepository kafedraRepository) {
        this.kafedraRepository = kafedraRepository;
    }

    @Override
    public Iterable<Kafedra> listKafedra() {
        return kafedraRepository.findAll();
    }

    @Override
    public Kafedra saveKafedra(Kafedra kafedra) {
        return kafedraRepository.save(kafedra);
    }

    @Override
    public boolean deleteKafedra(Long id) {
        return false;
    }

    @Override
    public Kafedra getById(Long id) {
        return null;
    }

    @Override
    public List<Kafedra> getByName(String name) {
        return null;
    }
}
