package com.accenture.photos.repository;

import com.accenture.photos.model.Permission;

import java.util.List;

public interface ManagePermissionRepository {

    List<Permission> savePermissions(List<com.accenture.photos.DTO.PermissionDTO> permissions);

    Boolean updateUserPermission(com.accenture.photos.DTO.PermissionDTO permissionDTO);

    List<com.accenture.photos.DTO.PermissionDTO> getUserByTypePermission(com.accenture.photos.DTO.PermissionDTO permissionDTO);

    Boolean verifyPermissionUser(Long userId, Long albumId);
}
