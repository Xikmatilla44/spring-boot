package com.grokonez.jwtauthentication.dekanat.service;

import com.grokonez.jwtauthentication.dekanat.model.Dekanat;
import com.grokonez.jwtauthentication.dekanat.repository.DekanatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DekanatServiceImpl implements DekanatService {

    private DekanatRepository dekanatRepository;

    @Autowired
    public void setDekanatRepository(DekanatRepository dekanatRepository) {
        this.dekanatRepository = dekanatRepository;
    }

    @Override
    public Iterable<Dekanat> ListAllDekanat() {
        return dekanatRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Dekanat saveDekanat(Dekanat dekanat) {

        return dekanatRepository.save(dekanat);
    }


    @Override
    public boolean deleteDekanat(Long id) {
        dekanatRepository.deleteById(id);

        return false;
    }

    @Override
    public Dekanat getByIdDekanat(Long id) {
        return dekanatRepository.findById(id).get();
    }

    @Override
    public List<Dekanat> getByName(String name) {
        List<Dekanat> list = dekanatRepository.getByName(name);

        return list;
    }
}
