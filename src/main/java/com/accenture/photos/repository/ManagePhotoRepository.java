package com.accenture.photos.repository;

import com.accenture.photos.DTO.PhotoDTO;
import com.accenture.photos.DTO.UserDTO;

import java.util.List;

public interface ManagePhotoRepository {

    void savePhotos (List<PhotoDTO> listPhotosToSave);
}
