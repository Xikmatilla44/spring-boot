package com.grokonez.jwtauthentication.kafedra.controller;


import com.grokonez.jwtauthentication.kafedra.convert.dto.KafedraDTO;
import com.grokonez.jwtauthentication.kafedra.convert.mapper.ConvertKafedra;
import com.grokonez.jwtauthentication.kafedra.model.Kafedra;
import com.grokonez.jwtauthentication.kafedra.service.KafedraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class KafedraController {

    @Autowired
    private ConvertKafedra convertKafedra;

    private KafedraService kafedraService;

    @Autowired
    public void setKafedraService(KafedraService kafedraService) {
        this.kafedraService = kafedraService;
    }

    @GetMapping(value = "/AllKafedra")
    public List<KafedraDTO> listAllKafedra(){
        List<Kafedra> kafedras = (List<Kafedra>) kafedraService.listKafedra();

        return convertKafedra.toDTO(kafedras);

    }

    @PostMapping(value = "/saveKafedra")
    public ResponseEntity saveKafedra(@RequestBody KafedraDTO kafedraDTO) {

        Kafedra kafedra = convertKafedra.toEntity(kafedraDTO);

        return ResponseEntity.ok(kafedraService.saveKafedra(kafedra));
    }


}
