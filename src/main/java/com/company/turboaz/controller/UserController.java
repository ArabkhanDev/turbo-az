package com.company.turboaz.controller;

import com.company.turboaz.dto.request.UserRequestDTO;
import com.company.turboaz.model.User;
import com.company.turboaz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get/{id}")
    public User getSeller(@PathVariable Long id) {
        return userService.getSeller(id);
    }

    @PostMapping("/add")
    public User addSeller(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.addSeller(userRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeller(@PathVariable Long id) {
        userService.deleteSeller(id);
    }

    @PutMapping("/update/{id}")
    public User updateSeller(@RequestBody UserRequestDTO userRequestDTO,
                             @PathVariable("id") Long id) {
        return userService.updateSeller(userRequestDTO, id);
    }


}
