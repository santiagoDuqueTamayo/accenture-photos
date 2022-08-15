package com.accenture.photos.handler;

import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.utility.ApiResponse;

public interface PermissionHandler {

    ApiResponse CallRepositoryToUpdatePermission(PermissionDTO permissionDTO);
    ApiResponse CallRepositoryToGetUsersByTpe(PermissionDTO permissionDTO);
}
