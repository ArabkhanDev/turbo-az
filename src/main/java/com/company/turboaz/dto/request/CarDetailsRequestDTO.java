package com.company.turboaz.dto.request;

import lombok.Data;

@Data
public class CarDetailsRequestDTO {

    private String ban;
    private String color;
    private String fuel;
    private Integer transmission;
    private Integer power;
    private String carCondition;
    private Integer seats;
    private String vin;
    private String description;
    private Long carId;

}
