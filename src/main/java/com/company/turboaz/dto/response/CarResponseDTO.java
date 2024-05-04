package com.company.turboaz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDTO {

    private String name;
    private String model;
    private String image;
    private Integer manufactureYear;
    private Integer engineVolume;
    private Integer price;
    private Integer mileage;
//    private User seller;
}
