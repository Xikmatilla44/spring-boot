package com.grokonez.jwtauthentication.bolim.service;

import com.grokonez.jwtauthentication.bolim.model.Education;

import java.util.List;

public interface EducationService {

    Iterable<Education> listEducation();

    boolean deleteEducation(Integer id);

    Education saveEducation(Education education);

    Education getById(Integer id);

//    List<Education> updateEducation(Integer id, Education educationId);

    List<Education> getByName(String name);




}
