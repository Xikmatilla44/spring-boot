package com.grokonez.jwtauthentication.dekanat.controller;

import com.grokonez.jwtauthentication.bolim.exception.ResourceNotFoundException;
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


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class DekanatController {

    private DekanatService dekanatService;

    @Autowired
    private DekanatRepository dekanatRepository;

    @Autowired
    private ConvertDekanat convertDekanat;


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
        Dekanat dekanat = convertDekanat.toEntity(dekanatDTO);
        List<Dekanat> dekanats = (List<Dekanat>) dekanatService.saveDekanat(dekanat);
        DekanatDTO dekanatDTOS = (DekanatDTO) convertDekanat.toDTO(dekanats);

        return ResponseEntity.ok(dekanatDTOS);

    }


    @GetMapping(value = "/editeDekanat/{id}")
    public DekanatDTO getByIdDekanat(@PathVariable Long id){
        Dekanat dekanat = dekanatService.getByIdDekanat(id);

        return convertDekanat.toDTOS(dekanat);
    }


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


    @PutMapping("/dekanatPut/{id}")
    public ResponseEntity<Dekanat> updateStudent(@PathVariable(value = "id") Long dekanatId,
                                                 @Valid @RequestBody Dekanat dekanatDetails) throws ResourceNotFoundException {
        Dekanat dekanat = dekanatRepository.findById(dekanatId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + dekanatId));
        dekanat.setName(dekanatDetails.getName());

        final Dekanat updatedDekanat = dekanatRepository.save(dekanat);

        return ResponseEntity.ok(updatedDekanat);

    }

    @GetMapping("/dekanatByName/{name}")
    public List<Dekanat> getByName(@PathVariable String name) {
        List<Dekanat> list = dekanatService.getByName(name);

        return list;

    }












}
