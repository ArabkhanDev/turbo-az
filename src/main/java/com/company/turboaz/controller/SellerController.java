package com.company.turboaz.controller;

import com.company.turboaz.dto.request.SellerRequestDTO;
import com.company.turboaz.model.SellerEntity;
import com.company.turboaz.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("/get/{id}")
    public SellerEntity getSeller(@PathVariable Long id) {
        return sellerService.getSeller(id);
    }

    @PostMapping("/add")
    public SellerEntity addSeller(@RequestBody SellerRequestDTO sellerRequestDTO) {
        return sellerService.addSeller(sellerRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
    }

    @PutMapping("/update/{id}")
    public SellerEntity updateSeller(@RequestBody SellerRequestDTO sellerRequestDTO,
                                     @PathVariable("id") Long id) {
        return sellerService.updateSeller(sellerRequestDTO, id);
    }


}
