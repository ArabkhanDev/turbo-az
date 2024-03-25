package com.company.turboaz.repository;

import com.company.turboaz.model.CarDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailsRepository extends JpaRepository<CarDetailsEntity, Long> {
}
