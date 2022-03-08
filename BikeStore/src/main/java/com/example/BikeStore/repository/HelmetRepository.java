package com.example.BikeStore.repository;

import com.example.BikeStore.entity.Helmet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HelmetRepository extends CrudRepository<Helmet, Long > {
    @Transactional
    @Modifying
    @Query("update Helmet h set h.name = ?1 where h.id = ?2")


    void update(String name, Long id);
}
