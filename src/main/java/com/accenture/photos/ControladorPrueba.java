package com.accenture.photos;

import com.accenture.photos.DTO.PhotoDTO;
import com.accenture.photos.DTO.UserDTO;
import com.accenture.photos.proxy.CallToPhotsInfoService;
import com.accenture.photos.proxy.CallToUsersInfoService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorPrueba {

    @Autowired
    private CallToUsersInfoService callToUsersInfoService;

    @Autowired
    private CallToPhotsInfoService callToPhotsInfoService;

    @GetMapping(value = "/getusers")
    public List<UserDTO> getUsers() {
        return callToUsersInfoService.getUsers();
    }

    @GetMapping(value = "/getphotos")
    public List<PhotoDTO> getPhotos() {
        return callToPhotsInfoService.getPhotos();
    }
}
