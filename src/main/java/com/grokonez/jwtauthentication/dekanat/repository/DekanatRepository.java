package com.grokonez.jwtauthentication.dekanat.repository;

import com.grokonez.jwtauthentication.dekanat.model.Dekanat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DekanatRepository extends CrudRepository<Dekanat, Long>{

    List<Dekanat> findAllByOrderByIdAsc();



    @Query(value = "SELECT * FROM dekanat WHERE id = id",nativeQuery = true)
    List<Dekanat> findByDekanat(@Param("id") Long id);


}
