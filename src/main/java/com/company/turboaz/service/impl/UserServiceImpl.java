package com.company.turboaz.service.impl;

import com.company.turboaz.dto.request.UserRequestDTO;
import com.company.turboaz.model.User;
import com.company.turboaz.repository.UserRepository;
import com.company.turboaz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Override
    public User addSeller(UserRequestDTO userRequestDTO) {
        User user = new User();
        modelMapper.map(userRequestDTO, user);
        return userRepository.save(user);
    }

    @Override
    public void deleteSeller(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateSeller(UserRequestDTO userRequestDTO, Long id) {
        User user = getSeller(id);
        modelMapper.map(userRequestDTO, user);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getSeller(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Seller not found with id: " + id));
    }

    @Override
    public List<User> getAllSellers() {
        return userRepository.findAll();
    }
}
