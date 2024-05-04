package com.company.turboaz.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class CarRequestDTO {

    private String name;
    private String model;
    private String image;
    private Integer manufactureYear;
    private Integer engineVolume;
    private Integer price;
    private Integer mileage;
    private Date created;
    private Long userId;
}
