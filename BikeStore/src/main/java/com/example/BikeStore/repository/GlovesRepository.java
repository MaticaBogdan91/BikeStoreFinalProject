package com.example.BikeStore.repository;

import com.example.BikeStore.entity.Gloves;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GlovesRepository  extends CrudRepository<Gloves ,Long> {
    @Transactional
    @Modifying
    @Query("update Gloves g set g.name = ?1 where g.id = ?2")

    void update(String mateiral, Long id);
}
