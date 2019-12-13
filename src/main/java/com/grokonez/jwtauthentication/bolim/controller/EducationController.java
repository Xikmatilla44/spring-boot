package com.grokonez.jwtauthentication.bolim.controller;

import com.grokonez.jwtauthentication.bolim.exception.ResourceNotFoundException;
import com.grokonez.jwtauthentication.bolim.model.Education;
import com.grokonez.jwtauthentication.bolim.repository.EducationRepository;
import com.grokonez.jwtauthentication.bolim.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class EducationController {

    private EducationService educationService;
    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    public void setEducationService(EducationService educationService) {
        this.educationService = educationService;
    }


    @GetMapping("/education")
    public List<Education> getEducation(Model model) {
        List<Education> list = (List<Education>) educationService.listEducation();

        return list;

    }

    @PostMapping("/saveEducation")
    public ResponseEntity save(@Valid @RequestBody Education education) {
        return ResponseEntity.ok(educationService.saveEducation(education));
    }


    @GetMapping("education/{id}")
    public Education findOne(@PathVariable Integer id) {
        Education education = educationService.getById(id);

        return education;

    }

    @PutMapping("/educationPut/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable(value = "id") Integer educationId,
                                                     @Valid @RequestBody Education educationDetails) throws ResourceNotFoundException {
        Education education = educationRepository.findById(educationId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + educationId));
        education.setFirstName(educationDetails.getFirstName());
        education.setLastName(educationDetails.getLastName());
        education.setEmail(educationDetails.getEmail());
        education.setPhone(educationDetails.getEmail());
        final Education updatedEducation = educationRepository.save(education);
        return ResponseEntity.ok(updatedEducation);

    }


    @DeleteMapping("/delete/{id}")
    public boolean deleteEducation(@PathVariable Integer id) {
        boolean res;
        res = educationService.deleteEducation(id);
        if (res == true) {
            return true;
        } else {
            return false;
        }

    }


    @GetMapping("/name/{name}")
    public List<Education> getByName(@PathVariable String name) {
        List<Education> list = educationService.getByName(name);

        return list;

    }




}
