package com.accenture.photos.handler.interfaces;

import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.error.ApiResponse;

public interface AlbumHandler {
     ApiResponse splitDtoByEntity(AlbumWithPermissionDTO albumWithPermissionDTO);
}
