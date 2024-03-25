package com.company.turboaz.service;

import com.company.turboaz.dto.request.SellerRequestDTO;
import com.company.turboaz.model.SellerEntity;

import java.util.List;

public interface SellerService {

    SellerEntity addSeller(SellerRequestDTO sellerRequestDTO);

    void deleteSeller(Long id);

    SellerEntity updateSeller(SellerRequestDTO sellerRequestDTO, Long id);

    SellerEntity getSeller(Long id);

    List<SellerEntity> getAllSellers();

}
