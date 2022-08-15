package com.accenture.photos.controller;

import com.accenture.photos.DTO.UserDTO;
import com.accenture.photos.proxy.CallToUsersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class UserController {

    @Autowired
    private CallToUsersInfoService callToUsersInfoService;


    public List<UserDTO> getUsers() {return callToUsersInfoService.getUsers();}
}
