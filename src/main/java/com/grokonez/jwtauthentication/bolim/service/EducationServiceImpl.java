package com.grokonez.jwtauthentication.bolim.service;

import com.grokonez.jwtauthentication.bolim.model.Education;
import com.grokonez.jwtauthentication.bolim.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    private EducationRepository educationRepository;

    @Autowired
    public void setEducationRepository(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public Iterable<Education> listEducation() {
        return educationRepository.findAllByOrderByIdAsc();
    }

    @Override
    public boolean deleteEducation(Integer id) {
    educationRepository.deleteById(id);
        return false;
    }

    @Override
    public Education saveEducation(Education education) {
        return educationRepository.save(education);
    }


    @Override
    public Education getById(Integer id) {
        return educationRepository.findById(id).get();
    }

//    @Override
//    public List<Education> updateEducation(Integer id, Education educationId) {
//        ArrayList<Education> list = new ArrayList<>();
//        List<Education> list1 = educationRepository.findByIdAnd(id);
//        for (Education education : list1) {
//
//            education.setFirstName(educationId.getFirstName());
//            education.setLastName(educationId.getLastName());
//            education.setEmail(educationId.getEmail());
//            education.setPhone(educationId.getPhone());
//            list.add(education);
//        }
//            return list;
//
//    }



    @Override
    public List<Education> getByName(String name) {
        ArrayList<Education> list = new ArrayList<>();
        List<Education> list1 = educationRepository.getByName(name);
        for (Education num : list1) {
            Education education = new Education();
            education.setId(num.getId());
            education.setFirstName(num.getFirstName());
            education.setLastName(num.getLastName());
            education.setPhone(num.getPhone());
            education.setEmail(num.getEmail());
            list.add(education);
        }

        return list;
    }

    }

