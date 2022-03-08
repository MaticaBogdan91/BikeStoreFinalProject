package com.example.BikeStore.repository;

import com.example.BikeStore.entity.SportBike;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SportBikesRepository extends CrudRepository<SportBike, Long> {
    @Transactional
    @Modifying
    @Query("update SportBike s set s.name = ?1 where s.id = ?2")

    void update(String name, Long id);
}
