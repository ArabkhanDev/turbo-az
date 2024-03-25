package com.company.turboaz.service.impl;

import com.company.turboaz.dto.request.CarRequestDTO;
import com.company.turboaz.dto.request.CarSearchDTO;
import com.company.turboaz.dto.response.CarResponseDTO;
import com.company.turboaz.model.CarEntity;
import com.company.turboaz.model.SellerEntity;
import com.company.turboaz.repository.CarRepository;
import com.company.turboaz.repository.SellerRepository;
import com.company.turboaz.service.CarService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;

    @Override
    public CarEntity addCar(CarRequestDTO carRequestDTO) {
        CarEntity carEntity = new CarEntity();
//        modelMapper.map(carRequestDTO, carEntity); didnt work
        carEntity.setCreated(carRequestDTO.getCreated());
        carEntity.setImage(carRequestDTO.getImage());
        carEntity.setManufactureYear(carRequestDTO.getManufactureYear());
        carEntity.setMileage(carRequestDTO.getMileage());
        carEntity.setModel(carRequestDTO.getModel());
        carEntity.setName(carRequestDTO.getName());
        carEntity.setPrice(carRequestDTO.getPrice());
        carEntity.setEngineVolume(carRequestDTO.getEngineVolume());

        Long sellerId = carRequestDTO.getSellerId();
        if (sellerId != null){
            SellerEntity seller = sellerRepository.getReferenceById(sellerId);
            carEntity.setSellers(seller);
        }
        return carRepository.save(carEntity);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarEntity updateCar(CarRequestDTO carRequestDTO, Long id) {
        CarEntity carEntity = getCar(id);
//        modelMapper.map(carRequestDTO, carEntity); didnt work
        carEntity.setId(id);
        carEntity.setCreated(carRequestDTO.getCreated());
        carEntity.setImage(carRequestDTO.getImage());
        carEntity.setManufactureYear(carRequestDTO.getManufactureYear());
        carEntity.setMileage(carRequestDTO.getMileage());
        carEntity.setModel(carRequestDTO.getModel());
        carEntity.setName(carRequestDTO.getName());
        carEntity.setPrice(carRequestDTO.getPrice());
        carEntity.setEngineVolume(carRequestDTO.getEngineVolume());

        Long sellerId = carRequestDTO.getSellerId();
        if (sellerId != null){
            SellerEntity seller = sellerRepository.getReferenceById(sellerId);
            carEntity.setSellers(seller);
        }
        return carRepository.save(carEntity);
    }

    @Override
    public CarEntity getCar(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }


    @Override
    public Page<CarResponseDTO> getAllCarsByParams(Pageable pageable, CarSearchDTO car) {
        Specification<CarEntity> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (car.getName() != null && !car.getName().isEmpty()) {
                predicates.add(cb.equal(root.get("name"), car.getName()));
            }
            if (car.getModel() != null && !car.getModel().isEmpty()) {
                predicates.add(cb.equal(root.get("model"), car.getModel()));
            }
            if (car.getImage() != null && !car.getImage().isEmpty()) {
                predicates.add(cb.equal(root.get("image"), car.getImage()));
            }
            if (car.getManufactureYear() != null) {
                predicates.add(cb.equal(root.get("manufactureYear"), car.getManufactureYear()));
            }
            if (car.getEngineVolume() != null) {
                predicates.add(cb.equal(root.get("engineVolume"), car.getEngineVolume()));
            }
            if (car.getPrice() != null) {
                predicates.add(cb.equal(root.get("price"), car.getPrice()));
            }
            if (car.getMileage() != null) {
                predicates.add(cb.equal(root.get("mileage"), car.getMileage()));
            }
            if (car.getCreated() != null) {
                predicates.add(cb.equal(root.get("created"), car.getCreated()));
            }
            // Add predicates for other parameters similarly

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<CarEntity> cars = carRepository.findAll(spec, pageable);
        return cars.map((carEntity) -> {
            CarResponseDTO carResponseDTO = new CarResponseDTO();
            modelMapper.map(carEntity, carResponseDTO);
            return carResponseDTO;
        });
    }


}
