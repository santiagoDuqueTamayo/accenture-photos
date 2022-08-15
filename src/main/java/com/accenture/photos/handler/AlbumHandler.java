package com.accenture.photos.handler;

import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.utility.ApiResponse;

public interface AlbumHandler {
     ApiResponse splitDtoByEntity(AlbumWithPermissionDTO albumWithPermissionDTO);
     ApiResponse getAlbumsAccordingPermissions(Long userId, Long albumId);
}
