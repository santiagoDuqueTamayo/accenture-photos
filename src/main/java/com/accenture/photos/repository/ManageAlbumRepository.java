package com.accenture.photos.repository;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.DTO.UserDTO;

import java.util.List;

public interface ManageAlbumRepository {

    AlbumDTO createAlbum (AlbumDTO albumDTO);

    AlbumDTO getAlbumsAccordingPermission(Long albumId) throws Exception;

    void saveAlbums(List<AlbumDTO> albums);
}
