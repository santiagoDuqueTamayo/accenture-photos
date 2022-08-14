package com.accenture.photos.repositories.interfaces;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.model.Album;

public interface ManageAlbumRepository {

    Album createAlbum (AlbumDTO albumDTO);
}
