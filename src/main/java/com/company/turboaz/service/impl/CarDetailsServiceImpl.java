package com.company.turboaz.service.impl;

import com.company.turboaz.dto.request.CarDetailsRequestDTO;
import com.company.turboaz.model.CarDetailsEntity;
import com.company.turboaz.model.CarEntity;
import com.company.turboaz.repository.CarDetailsRepository;
import com.company.turboaz.repository.CarRepository;
import com.company.turboaz.service.CarDetailsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarDetailsServiceImpl implements CarDetailsService {


    private final CarDetailsRepository carDetailsRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Override
    public CarDetailsEntity addCarDetails(CarDetailsRequestDTO carDetailsRequestDTO) {

        CarDetailsEntity carDetailsEntity = new CarDetailsEntity();
        modelMapper.map(carDetailsRequestDTO, carDetailsEntity);

        Long carId = carDetailsRequestDTO.getCarId();
        if (carId != null){
            CarEntity car = carRepository.findById(carId).get();
            carDetailsEntity.setCarEntity(car);
        }

        return carDetailsRepository.save(carDetailsEntity);
    }

    @Transactional
    @Override
    public void deleteCarDetails(Long id) {

        CarDetailsEntity carDetailsEntity = getCarDetails(id);
        carRepository.deleteById(carDetailsEntity.getCarEntity().getId());
        carDetailsRepository.deleteById(id);
    }

    @Override
    public CarDetailsEntity updateCarDetails(CarDetailsRequestDTO carDetailsRequestDTO, Long id) {
        CarDetailsEntity carDetailsEntity = getCarDetails(id);
        modelMapper.map(carDetailsRequestDTO, carDetailsEntity);
        return carDetailsRepository.save(carDetailsEntity);
    }

    @Override
    public CarDetailsEntity getCarDetails(Long id) {
        return carDetailsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("CarDetails not found with id: " + id));
    }


}
