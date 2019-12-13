package com.grokonez.jwtauthentication.students.respository;

import com.grokonez.jwtauthentication.dekanat.model.Dekanat;
import com.grokonez.jwtauthentication.students.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findAllByOrderByIdAsc();


    @Query(value = "select id, first_name, last_name, phone, email, dekanat_id from students where first_name ilike %:name%", nativeQuery = true)
    List<Student> getByName(String name);



}
