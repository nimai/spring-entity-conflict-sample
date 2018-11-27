package com.example.demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Nicolas Maitre
 * @since 23/11/18.
 */
@Repository
public interface EntityRepository extends JpaRepository<AnEntity, Long> {

    @Query(value = "select e from AnEntity e join e.anotherEntity a where e.id = :search")
    Page<AnEntity> query(@Param("search") Long search, Pageable pageable);
}
