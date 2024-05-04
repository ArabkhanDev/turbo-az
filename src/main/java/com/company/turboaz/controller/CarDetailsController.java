package com.company.turboaz.controller;

import com.company.turboaz.dto.request.CarDetailsRequestDTO;
import com.company.turboaz.model.CarDetailsEntity;
import com.company.turboaz.service.CarDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car-details")
public class CarDetailsController {

    private final CarDetailsService carDetailsService;


    @GetMapping("/get/{id}")
    public CarDetailsEntity getDetails(@PathVariable Long id) {
        return carDetailsService.getCarDetails(id);
    }

    @PostMapping("/add")
    public CarDetailsEntity addDetails(@RequestBody CarDetailsRequestDTO carDetailsRequestDTO) {
        return carDetailsService.addCarDetails(carDetailsRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDetails(@PathVariable Long id) {
        carDetailsService.deleteCarDetails(id);
    }

    @PutMapping("/update/{id}")
    public CarDetailsEntity updateDetails(@RequestBody CarDetailsRequestDTO carDetailsRequestDTO,
                                     @PathVariable("id") Long id) {
        return carDetailsService.updateCarDetails(carDetailsRequestDTO, id);
    }


}
