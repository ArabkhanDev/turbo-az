package com.company.turboaz.controller;

import com.company.turboaz.dto.request.CarRequestDTO;
import com.company.turboaz.dto.request.CarSearchDTO;
import com.company.turboaz.dto.response.CarResponseDTO;
import com.company.turboaz.model.CarEntity;
import com.company.turboaz.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;


    @GetMapping("/get/{id}")
    public CarEntity getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }


    @GetMapping("/search")
    public ResponseEntity<Page<CarResponseDTO>> getVehicleByParams(@RequestParam(required = false) String name,
                                                                   @RequestParam(required = false) String model,
                                                                   @RequestParam(required = false) String image,
                                                                   @RequestParam(required = false) Integer manufactureYear,
                                                                   @RequestParam(required = false) Integer engineVolume,
                                                                   @RequestParam(required = false) Integer price,
                                                                   @RequestParam(required = false) Integer mileage,
                                                                   @RequestParam(required = false) Date created,
                                                                   @RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "10") int size) {

        CarSearchDTO cars = new CarSearchDTO();
        cars.setName(name);
        cars.setModel(model);
        cars.setImage(image);
        cars.setManufactureYear(manufactureYear);
        cars.setEngineVolume(engineVolume);
        cars.setPrice(price);
        cars.setMileage(mileage);
        cars.setCreated(created);

        Pageable pageable = PageRequest.of(page, size);
        Page<CarResponseDTO> result = carService.getAllCarsByParams(pageable, cars);
        return ResponseEntity.ok(result);
    }


    @PostMapping("/add")
    public CarEntity addCar(@RequestBody CarRequestDTO carRequestDTO) {
        return carService.addCar(carRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @PutMapping("/update/{id}")
    public CarEntity updateCar(@RequestBody CarRequestDTO carRequestDTO,
                               @PathVariable Long id) {
        return carService.updateCar(carRequestDTO, id);
    }


}
