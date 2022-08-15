package com.accenture.photos.handler;

import com.accenture.photos.DTO.PhotoDTO;
import com.accenture.photos.DTO.UserDTO;

import java.util.List;

public interface PhotoHandler {

    void savePhotos(List<PhotoDTO> photos);
}
