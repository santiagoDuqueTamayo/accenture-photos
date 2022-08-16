package com.accenture.photos.repository.impl;

import com.accenture.photos.model.Permission;
import com.accenture.photos.model.enums.TypePermission;
import com.accenture.photos.repository.ManagePermissionRepository;
import com.accenture.photos.repository.JPARepository.PermissionReposiory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagePermissionRepositoryImpl implements ManagePermissionRepository {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    PermissionReposiory permissionReposiory;

    private static final Boolean USER_AND_ALBUM_NOT_FOUND = Boolean.FALSE;
    private static final Boolean USER_PERMISSION_UPDATE = Boolean.TRUE;




    @Override
    public List<Permission> savePermissions(List<com.accenture.photos.DTO.PermissionDTO> permissionsDTO) {
        List<Permission> permissionsToSave = new ArrayList<>();
        mapPermissionsToPermissionsDTO(permissionsDTO, permissionsToSave);
        //TODO  validar los retornos
        return permissionReposiory.saveAll(permissionsToSave);
    }

    @Override
    public Boolean updateUserPermission(com.accenture.photos.DTO.PermissionDTO permissionDTO) {
        Permission permission = permissionReposiory.
                findPermissionByAlbumIdAndUserId(permissionDTO.getUserId(),
                        permissionDTO.getAlbumId());
        return permission != null ? isSetTypePermission(permissionDTO, permission) : USER_AND_ALBUM_NOT_FOUND;

    }

    @Override
    public List<com.accenture.photos.DTO.PermissionDTO> getUserByTypePermission(com.accenture.photos.DTO.PermissionDTO permissionDTO) {

        List<Permission> gotPermissionsList = permissionReposiory.
                getUsersByTypePermission(TypePermission.valueOf(permissionDTO.getTypePermission()),
                        permissionDTO.getAlbumId());

        return mapListPermissionToPermissionDTO(gotPermissionsList, permissionDTO);
    }

    @Override
    public Boolean verifyPermissionUser(Long userId, Long albumId) {
        Permission UserPermission = permissionReposiory.verifyPermissionUser(userId, albumId);
        Boolean hasPermission = Boolean.TRUE;
        return UserPermission != null ? hasPermission : !hasPermission;
    }

    private List<com.accenture.photos.DTO.PermissionDTO> mapListPermissionToPermissionDTO(List<Permission> gotPermissionsList,
                                                                                          com.accenture.photos.DTO.PermissionDTO permissionDTO) {
        List<com.accenture.photos.DTO.PermissionDTO> permissionDTOSToReturn = new ArrayList<>();
        gotPermissionsList.forEach(permission -> {
            permissionDTOSToReturn.add(modelMapper.map(permission, com.accenture.photos.DTO.PermissionDTO.class));
        });
        return permissionDTOSToReturn;
    }

    private Boolean isSetTypePermission(com.accenture.photos.DTO.PermissionDTO permissionDTO, Permission permission) {
        permission.setTypePermission(TypePermission.valueOf(permissionDTO.getTypePermission()));
        permissionReposiory.save(permission);
        return USER_PERMISSION_UPDATE;
    }

    private void mapPermissionsToPermissionsDTO(List<com.accenture.photos.DTO.PermissionDTO> permissionsDTO, List<Permission> permissionsToSave) {
        permissionsDTO.forEach(permissionDTO -> {
            permissionsToSave.add(modelMapper.map(permissionDTO, Permission.class));
        });
    }
}
