package com.company.turboaz.service;

import com.company.turboaz.dto.request.CarRequestDTO;
import com.company.turboaz.dto.request.CarSearchDTO;
import com.company.turboaz.dto.response.CarResponseDTO;
import com.company.turboaz.model.CarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {

    CarEntity addCar(CarRequestDTO carRequestDTO);

    void deleteCar(Long id);

    CarEntity updateCar(CarRequestDTO carRequestDTO, Long id);

    CarEntity getCar(Long id);

    Page<CarResponseDTO> getAllCarsByParams(Pageable pageable, CarSearchDTO car);
}
