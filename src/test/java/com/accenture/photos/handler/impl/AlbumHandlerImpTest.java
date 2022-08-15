package com.accenture.photos.handler.impl;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.model.Permission;
import com.accenture.photos.model.enums.TypePermission;
import com.accenture.photos.repository.ManageAlbumRepository;
import com.accenture.photos.repository.ManagePermissionRepository;
import com.accenture.photos.utility.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlbumHandlerImpTest {

    @InjectMocks
    private AlbumHandlerImp albumHandlerImp;

    @Mock
    private ManageAlbumRepository manageAlbumRepository;

    @Mock
    private ManagePermissionRepository managePermissionRepository;


    @BeforeEach
    void setUp() {

    }

    @Test
    void given_AlbumWithOnePermission_when_tryCreatePermission_then_albumWasCreated() {
        when(manageAlbumRepository.createAlbum(any())).thenReturn(AlbumCreatedDTO());
        when(managePermissionRepository.savePermissions(any())).thenReturn(permissionWasCreated());
        Long idAlbumToCreate = 1L;
        ApiResponse responseAlbumWasCreated = albumHandlerImp.splitDtoByEntity(createAlbumWithPermissionsDTO());
        AlbumDTO albumWasCreated = (AlbumDTO) responseAlbumWasCreated.getResponse();
        assertEquals(albumWasCreated.getId(), idAlbumToCreate);

    }


    @Test
    void given_AlbumWithManyPermission_when_tryCreatePermission_then_albumWasCreated() {
        when(manageAlbumRepository.createAlbum(any())).thenReturn(AlbumCreatedDTO());
        when(managePermissionRepository.savePermissions(any())).thenReturn(permissionWasCreated());
        Long idAlbumToCreate = 1L;
        ApiResponse responseAlbumWasCreated = albumHandlerImp.splitDtoByEntity(createAlbumWithManyPermissionsDTO());
        AlbumDTO albumWasCreated = (AlbumDTO) responseAlbumWasCreated.getResponse();
        assertEquals(albumWasCreated.getId(), idAlbumToCreate);
    }

    private AlbumWithPermissionDTO createAlbumWithManyPermissionsDTO() {

        List<PermissionDTO> listPermissionToSave = new ArrayList<>();
        PermissionDTO permissionToSaveUser1 = PermissionDTO.builder().
                userId(1l).
                albumId(1l).
                typePermission("WRITE").
                build();
        PermissionDTO permissionToSaveUser2 = PermissionDTO.builder().
                userId(2l).
                albumId(1l).
                typePermission("WRITE").
                build();
        listPermissionToSave.add(permissionToSaveUser1);
        listPermissionToSave.add(permissionToSaveUser2);
        AlbumWithPermissionDTO albumWithPermissionDTO = AlbumWithPermissionDTO.builder().
                userId(1l).
                id(1l).
                title("prueba de album").
                permissions(listPermissionToSave).
                build();

        return albumWithPermissionDTO;
    }

    private AlbumWithPermissionDTO createAlbumWithPermissionsDTO() {

        List<PermissionDTO> listPermissionToSave = new ArrayList<>();
        PermissionDTO permissionToSave = PermissionDTO.builder().
                userId(1l).
                albumId(1l).
                typePermission("WRITE").
                build();
        listPermissionToSave.add(permissionToSave);
        AlbumWithPermissionDTO albumWithPermissionDTO = AlbumWithPermissionDTO.builder().
                userId(1l).
                id(1l).
                title("prueba de album").
                permissions(listPermissionToSave).
                build();

        return albumWithPermissionDTO;
    }

    private List<Permission> permissionWasCreated() {
        List<Permission> listPermissionsToReturn = new ArrayList<>();
        Permission permissionToReturn = Permission.builder().
                id(1l).
                userId(1l).
                typePermission(TypePermission.READ).
                build();
        listPermissionsToReturn.add(permissionToReturn);
        return listPermissionsToReturn;
    }

    private AlbumDTO AlbumCreatedDTO() {
        AlbumDTO albumToReturn = AlbumDTO.builder().
                id(1l).
                userId(2l).
                title("album de prueba").
                build();
        return albumToReturn;
    }



}