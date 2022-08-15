package com.accenture.photos.handler.impl;

import com.accenture.photos.DTO.PhotoDTO;
import com.accenture.photos.handler.PhotoHandler;
import com.accenture.photos.repository.ManagePhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoHandlerImpl implements PhotoHandler {

    @Autowired
    private ManagePhotoRepository managePhotoRepository;

    @Override
    public void savePhotos(List<PhotoDTO> photos) {
        managePhotoRepository.savePhotos(photos);
    }
}
