package com.grokonez.jwtauthentication.bolim.repository;

import com.grokonez.jwtauthentication.bolim.model.Education;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EducationRepository extends CrudRepository<Education, Integer> {

    List<Education> findAllByOrderByIdAsc();

    @Query(value = "select id, first_name, last_name, phone, email from education where first_name ilike %:name%", nativeQuery = true)
    List<Education> getByName(String name);






}
