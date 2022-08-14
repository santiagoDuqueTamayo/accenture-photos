package com.accenture.photos.repositories.interfaces;

import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.model.Permission;

import java.util.List;

public interface ManagePermissionRepository {

    List<Permission> savePermissions(List<PermissionDTO> permissions);
}
