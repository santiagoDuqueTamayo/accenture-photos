package com.accenture.photos.handler;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.DTO.UserDTO;
import com.accenture.photos.utility.ApiResponse;

import java.util.List;

public interface AlbumHandler {
     ApiResponse splitDtoByEntity(AlbumWithPermissionDTO albumWithPermissionDTO);
     ApiResponse getAlbumsAccordingPermissions(Long userId, Long albumId);

     void saveAlbums(List<AlbumDTO> albums);
}
