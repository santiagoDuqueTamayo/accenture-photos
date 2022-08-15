package com.accenture.photos.repository;

import com.accenture.photos.DTO.AlbumDTO;

import java.util.List;

public interface ManageAlbumRepository {

    AlbumDTO createAlbum (AlbumDTO albumDTO);

    AlbumDTO getAlbumsAccordingPermission(Long albumId) throws Exception;
}
