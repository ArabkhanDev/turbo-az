package com.company.turboaz.dto.response;

import com.company.turboaz.model.SellerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
//    private SellerEntity seller;
}
