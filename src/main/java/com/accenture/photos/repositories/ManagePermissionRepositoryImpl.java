package com.accenture.photos.repositories;

import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.model.Permission;
import com.accenture.photos.repositories.interfaces.ManagePermissionRepository;
import com.accenture.photos.repositories.interfaces.PermissionReposiory;
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

    private void mapPermissionsToPermissionsDTO(List<PermissionDTO> permissionsDTO, List<Permission> permissionsToSave) {
        permissionsDTO.forEach(permissionDTO -> {
            permissionsToSave.add(modelMapper.map(permissionDTO, Permission.class));
        });
    }
}
