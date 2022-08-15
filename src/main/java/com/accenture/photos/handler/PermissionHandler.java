package com.accenture.photos.handler;

import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.error.ApiResponse;

public interface PermissionHandler {

    ApiResponse CallRepositoryToUpdatePermission(PermissionDTO permissionDTO);
    ApiResponse CallRepositoryToGetUsersByTpe(PermissionDTO permissionDTO);
}
