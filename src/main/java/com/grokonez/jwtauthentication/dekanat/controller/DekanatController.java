package com.grokonez.jwtauthentication.dekanat.controller;

import com.grokonez.jwtauthentication.dekanat.convert.dto.DekanatDTO;
import com.grokonez.jwtauthentication.dekanat.convert.mapper.ConvertDekanat;
import com.grokonez.jwtauthentication.dekanat.model.Dekanat;
import com.grokonez.jwtauthentication.dekanat.repository.DekanatRepository;
import com.grokonez.jwtauthentication.dekanat.service.DekanatService;
import com.grokonez.jwtauthentication.dekanat.service.DekanatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class DekanatController {

    private DekanatService dekanatService;

    @Autowired
    private DekanatRepository dekanatRepository;


    @Autowired
    public void setDekanatService(DekanatService dekanatService) {
        this.dekanatService = dekanatService;
    }

    @GetMapping("/dekanat")
    public List<DekanatDTO> getEducation() {
        List<Dekanat> dekanats = (List<Dekanat>) dekanatService.ListAllDekanat();
        ConvertDekanat convertDekanat = new ConvertDekanat();
        return convertDekanat.toDTO(dekanats);

    }


    @PostMapping("/savedekanat")
    public ResponseEntity save(@Valid @RequestBody DekanatDTO dekanatDTO) {
       ConvertDekanat convertDekanat = new ConvertDekanat();
      return ResponseEntity.ok(dekanatService.saveDekanat(convertDekanat.toEntity(dekanatDTO)));

    }


//    @GetMapping(value = "/editeDekanat/{id}")
//    public List<Dekanat> getByIdDekanat(@PathVariable Long id){
//        ConvertDekanat convertDekanat = new ConvertDekanat();
//        Dekanat dekanat = dekanatService.getByIdDekanat(id);
//
//        return  dekanat;
//
//
//    }


    @DeleteMapping("/deleteDekanat/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        boolean res;
        res = dekanatService.deleteDekanat(id);
        if (res == true) {
            return true;
        } else {
            return false;
        }

    }











}
