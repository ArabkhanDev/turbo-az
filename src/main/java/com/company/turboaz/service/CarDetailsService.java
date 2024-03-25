package com.company.turboaz.service;

import com.company.turboaz.dto.request.CarDetailsRequestDTO;
import com.company.turboaz.dto.request.CarSearchDTO;
import com.company.turboaz.dto.response.CarResponseDTO;
import com.company.turboaz.model.CarDetailsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarDetailsService {

    CarDetailsEntity addCarDetails(CarDetailsRequestDTO carDetailsRequestDTO);

    void deleteCarDetails(Long id);

    CarDetailsEntity updateCarDetails(CarDetailsRequestDTO carDetailsRequestDTO, Long id);

    CarDetailsEntity getCarDetails(Long id);



}
