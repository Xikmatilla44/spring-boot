package com.grokonez.jwtauthentication.kafedra.convert.mapper;

import com.grokonez.jwtauthentication.dekanat.model.Dekanat;
import com.grokonez.jwtauthentication.kafedra.convert.dto.KafedraDTO;
import com.grokonez.jwtauthentication.kafedra.model.Kafedra;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertKafedra {

    public Kafedra toEntity(KafedraDTO kafedraDTO) {
        Kafedra kafedra = new Kafedra();

        kafedra.setId(kafedraDTO.getId());
        kafedra.setName(kafedraDTO.getName());
        kafedra.setHolati(kafedraDTO.getHolati());
        Dekanat dekanat = new Dekanat();
        if (kafedraDTO.getDekanatName() == null) {
            kafedraDTO.setDekanatName("");
        }
        if (kafedraDTO.getDekanatId() == null) {
            kafedraDTO.setDekanatId((long) 1);
        }
        dekanat.setId(kafedraDTO.getDekanatId());
        kafedra.setDekanat(dekanat);

        return kafedra;

    }

    public List<KafedraDTO> toDTO(List<Kafedra> kafedras) {
        List<KafedraDTO> kafedraDTOS = new ArrayList<>();
        for (Kafedra kafedra : kafedras) {
            KafedraDTO kafedraDTO = new KafedraDTO();

            kafedraDTO.setName(kafedra.getName());
            kafedraDTO.setId(kafedra.getId());
            kafedraDTO.setHolati(kafedra.getHolati());

            if (kafedra.getDekanat() != null) {
                kafedraDTO.setDekanatId(kafedra.getDekanat().getId());
                kafedraDTO.setDekanatName(kafedra.getDekanat().getName());
            } else {
                kafedraDTO.setDekanatName("");
            }
            kafedraDTOS.add(kafedraDTO);

        }

        return kafedraDTOS;
    }


}
