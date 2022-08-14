package com.accenture.photos.repositories;

import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.model.Permission;
import com.accenture.photos.repositories.interfaces.ManagePermissionRepository;
import com.accenture.photos.repositories.interfaces.PermissionReposiory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ManagePermissionRepositoryImpl implements ManagePermissionRepository {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PermissionReposiory permissionReposiory;

    @Override
    public List<Permission> savePermissions(List<PermissionDTO> permissionsDTO) {
        List<Permission> permissionsToSave = new ArrayList<>();
        mapPermissionsToPermissionsDTO(permissionsDTO, permissionsToSave);
        //TODO  validar los retornos
        return  permissionReposiory.saveAll(permissionsToSave);
    }

    private void mapPermissionsToPermissionsDTO(List<PermissionDTO> permissionsDTO, List<Permission> permissionsToSave) {
        permissionsDTO.forEach(permissionDTO -> {
            permissionsToSave.add(modelMapper.map(permissionDTO, Permission.class));
        });
    }
}
