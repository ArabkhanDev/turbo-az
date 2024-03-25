package com.company.turboaz.repository;

import com.company.turboaz.model.CarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Page<CarEntity> findAll(Pageable pageable);
    Page<CarEntity> findAll(Specification<CarEntity> spec, Pageable pageable);
}
