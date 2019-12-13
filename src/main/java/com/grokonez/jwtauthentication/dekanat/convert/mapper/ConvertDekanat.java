package com.grokonez.jwtauthentication.dekanat.convert.mapper;

import com.grokonez.jwtauthentication.dekanat.convert.dto.DekanatDTO;
import com.grokonez.jwtauthentication.dekanat.model.Dekanat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConvertDekanat {

    public List<DekanatDTO> toDTO(List<Dekanat> dekanats){
        List<DekanatDTO> dekanatDTOS = new ArrayList<>();
        for (Dekanat dekanat : dekanats){
            DekanatDTO dekanatDTO = new DekanatDTO();
            dekanatDTO.setId(dekanat.getId());
            dekanatDTO.setName(dekanat.getName());
            dekanatDTOS.add(dekanatDTO);
        }
        return dekanatDTOS;
    }

    public Dekanat toEntity(DekanatDTO dekanatDTO){
        Dekanat dekanat = new Dekanat();
        dekanat.setId(dekanatDTO.getId());
        dekanat.setName(dekanatDTO.getName());

        return dekanat;
    }

}
