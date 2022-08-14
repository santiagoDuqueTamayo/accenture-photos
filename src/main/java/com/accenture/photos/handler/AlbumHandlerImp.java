package com.accenture.photos.handler;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.error.ApiResponse;
import com.accenture.photos.error.HttpStatusResponse;
import com.accenture.photos.handler.interfaces.AlbumHandler;
import com.accenture.photos.model.Permission;
import com.accenture.photos.repository.interfaces.ManageAlbumRepository;
import com.accenture.photos.repository.interfaces.ManagePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumHandlerImp implements AlbumHandler {

    @Autowired
    ManageAlbumRepository manageAlbumRepository;

    @Autowired
    ManagePermissionRepository managePermissionRepository;

    @Override
    public ApiResponse splitDtoByEntity(AlbumWithPermissionDTO albumWithPermissionDTO) {
        AlbumDTO albumDTO = createAlbumDTO(albumWithPermissionDTO);
        List<PermissionDTO> permissions = createPermissions(albumWithPermissionDTO);
        AlbumDTO albumWasSaved =  manageAlbumRepository.createAlbum(albumDTO);
        List<Permission> permissionsWereSaved = managePermissionRepository.savePermissions(permissions);
        return createResponse(albumWasSaved);
    }

    private ApiResponse createResponse(AlbumDTO albumWasSaved) {
        ApiResponse apiToReturn = ApiResponse.builder().
                response(albumWasSaved).
                httpStatusResponse(HttpStatusResponse.CREATED).
                build();
        return apiToReturn;
    }

    private List<PermissionDTO> createPermissions(AlbumWithPermissionDTO albumWithPermissionDTO) {
       List<PermissionDTO> permissionDTOS = albumWithPermissionDTO.getPermissions();
       return permissionDTOS;
    }

    private AlbumDTO createAlbumDTO(AlbumWithPermissionDTO albumWithPermissionDTO) {
        AlbumDTO albumToSend = AlbumDTO.builder().
                id(albumWithPermissionDTO.getId()).
                userId(albumWithPermissionDTO.getUserId()).
                title(albumWithPermissionDTO.getTitle()).
                build();
        return albumToSend;
    }
}
