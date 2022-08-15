package com.accenture.photos.controller;

import com.accenture.photos.DTO.PhotoDTO;
import com.accenture.photos.proxy.CallToPhotsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoController {
    @Autowired
    private CallToPhotsInfoService callToPhotsInfoService;


    public List<PhotoDTO> getPhotos() {return callToPhotsInfoService.getPhotos();}
}
