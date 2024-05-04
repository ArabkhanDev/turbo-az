package com.company.turboaz.service;

import com.company.turboaz.dto.request.UserRequestDTO;
import com.company.turboaz.model.User;

import java.util.List;

public interface UserService {

    User addSeller(UserRequestDTO userRequestDTO);

    void deleteSeller(Long id);

    User updateSeller(UserRequestDTO userRequestDTO, Long id);

    User getSeller(Long id);

    List<User> getAllSellers();

}
