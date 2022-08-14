package com.accenture.photos.handlers;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.handlers.interfaces.AlbumHandler;
import com.accenture.photos.model.Album;
import com.accenture.photos.model.Permission;
import com.accenture.photos.repositories.interfaces.ManageAlbumRepository;
import com.accenture.photos.repositories.interfaces.ManagePermissionRepository;
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
    public String splitDtoByEntity(AlbumWithPermissionDTO albumWithPermissionDTO) {
        AlbumDTO albumDTO = createAlbumDTO(albumWithPermissionDTO);
        List<PermissionDTO> permissions = createPermissions(albumWithPermissionDTO);
        Album albumWasSaved =  manageAlbumRepository.createAlbum(albumDTO);
        List<Permission> permissionsWereSaved = managePermissionRepository.savePermissions(permissions);
        return (albumWasSaved != null && permissionsWereSaved != null) ?
                "se pudo guardad" : "no se pudo guardar";
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
