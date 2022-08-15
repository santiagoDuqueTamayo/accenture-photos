package com.accenture.photos.repository.impl;

import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.model.Permission;
import com.accenture.photos.model.enums.TypePermission;
import com.accenture.photos.repository.ManagePermissionRepository;
import com.accenture.photos.repository.PermissionReposiory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagePermissionRepositoryImpl implements ManagePermissionRepository {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PermissionReposiory permissionReposiory;

    private static final Boolean USER_AND_ALBUM_NOT_FOUND = Boolean.FALSE;
    private static final Boolean USER_PERMISSION_UPDATE = Boolean.TRUE;


    @Bean
    ModelMapper modelMapperPermission() {
        return new ModelMapper();
    }

    @Override
    public List<Permission> savePermissions(List<PermissionDTO> permissionsDTO) {
        List<Permission> permissionsToSave = new ArrayList<>();
        mapPermissionsToPermissionsDTO(permissionsDTO, permissionsToSave);
        //TODO  validar los retornos
        return  permissionReposiory.saveAll(permissionsToSave);
    }

    @Override
    public Boolean updateUserPermission(PermissionDTO permissionDTO) {
        Permission permission = permissionReposiory.
                findPermissionByAlbumIdAndUserId(permissionDTO.getUserId(),
                        permissionDTO.getAlbumId());
        return permission != null ? isSetTypePermission(permissionDTO, permission) : USER_AND_ALBUM_NOT_FOUND;

    }

    private Boolean isSetTypePermission(PermissionDTO permissionDTO, Permission permission) {
        permission.setTypePermission(TypePermission.valueOf(permissionDTO.getTypePermission()));
        permissionReposiory.save(permission);
        return USER_PERMISSION_UPDATE;
    }

    private void mapPermissionsToPermissionsDTO(List<PermissionDTO> permissionsDTO, List<Permission> permissionsToSave) {
        permissionsDTO.forEach(permissionDTO -> {
            permissionsToSave.add(modelMapper.map(permissionDTO, Permission.class));
        });
    }
}
