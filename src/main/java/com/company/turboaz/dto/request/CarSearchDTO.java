package com.company.turboaz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSearchDTO {

    private String name;
    private String model;
    private String image;
    private Integer manufactureYear;
    private Integer engineVolume;
    private Integer price;
    private Integer mileage;
    private Date created;

}
