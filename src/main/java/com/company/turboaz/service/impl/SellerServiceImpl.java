package com.company.turboaz.service.impl;

import com.company.turboaz.dto.request.SellerRequestDTO;
import com.company.turboaz.model.SellerEntity;
import com.company.turboaz.repository.SellerRepository;
import com.company.turboaz.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;


    @Override
    public SellerEntity addSeller(SellerRequestDTO sellerRequestDTO) {
        SellerEntity sellerEntity = new SellerEntity();
        modelMapper.map(sellerRequestDTO, sellerEntity);
        return sellerRepository.save(sellerEntity);
    }

    @Override
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public SellerEntity updateSeller(SellerRequestDTO sellerRequestDTO, Long id) {
        SellerEntity sellerEntity = getSeller(id);
        modelMapper.map(sellerRequestDTO, sellerEntity);
        sellerRepository.save(sellerEntity);
        return sellerEntity;
    }

    @Override
    public SellerEntity getSeller(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Seller not found with id: " + id));
    }

    @Override
    public List<SellerEntity> getAllSellers() {
        return sellerRepository.findAll();
    }
}
