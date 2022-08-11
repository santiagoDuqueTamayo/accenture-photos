package com.accenture.photos;

import com.accenture.photos.DTO.UserDTO;
import com.accenture.photos.proxy.CallToUsersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorPrueba {

    @Autowired
    private CallToUsersInfoService callToUsersInfoService;

    @GetMapping(value = "/getusers")
    public List<UserDTO> getUsers() {
        return callToUsersInfoService.getUsers();
    }
}
